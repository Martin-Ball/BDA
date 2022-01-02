package com.martin.myapplication.ui.home;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.martin.myapplication.R;
import com.martin.myapplication.carga;
import com.martin.myapplication.infoCliente;
import com.martin.myapplication.inicializarGrafico;
import java.util.ArrayList;
import java.util.List;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.view.LineChartView;


public class HomeFragment extends Fragment {

    List<String> clientes = new ArrayList<String>();
    List<String> mes = new ArrayList<String>();
    String nombreCliente = "";
    String infoclienteText = "";
    String infoMesText = "";
    String mesSeleccionado = "";
    int[] ejey = {0,0,0,0,0,0,0,0,0,0,0,0};

    private LineChartView lineChart;

    private List<AxisValue> ejex = new ArrayList<AxisValue>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home,container,false);

        carga clientes2 = new carga();
        clientes = clientes2.cargarClientes();
        TextView detalleCliente = v.findViewById(R.id.infoCliente);

        //Grafica
        lineChart = (LineChartView) v.findViewById(R.id.chart);
        infoCliente infocliente = new infoCliente();


        //spinner CLIENTES
        Spinner spinnerClientes = v.findViewById(R.id.spinnerClientes);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, clientes);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerClientes.setAdapter(dataAdapter);

        spinnerClientes.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @SuppressLint("SetTextI18n")
                    public void onItemSelected(AdapterView<?> spn, android.view.View v, int posicion, long id)
                    {
                        Toast.makeText(spn.getContext(), "Has seleccionado " +
                                        spn.getItemAtPosition(posicion).toString(),
                                Toast.LENGTH_SHORT).show();

                        nombreCliente = spn.getItemAtPosition(posicion).toString();
                        infoclienteText = infocliente.detalleCliente(nombreCliente);
                        detalleCliente.setTextColor(Color.BLACK);
                        detalleCliente.setText( "INFORMACION DEL CLIENTE:\n\n" +
                                                "Cliente: " + nombreCliente +
                                                " \n\nCompra promedio mensual: $" + infoclienteText);

                        ejey = clientes2.cargarComprasMensual(ejey, nombreCliente); //cargar en el ejeY el monto de compra mensual
                        inicializarGrafico grafico1 = new inicializarGrafico();
                        grafico1.inicializarGraficoLinea(lineChart, ejex, ejey); //Inicialización del grafico
                    }

                    public void onNothingSelected(AdapterView<?> spn) {
                    }
                });

        //spinner MES
        carga cargarMeses = new carga();
        mes = cargarMeses.cargarMeses();


        Spinner spinnerMes = v.findViewById(R.id.spinnerMes);
        ArrayAdapter<String> dataAdapterMes = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, mes);
        dataAdapterMes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMes.setAdapter(dataAdapterMes);

            spinnerMes.setOnItemSelectedListener(
                    new AdapterView.OnItemSelectedListener() {
                        public void onItemSelected(AdapterView<?> spn, android.view.View v, int posicion, long id) {

                            Toast.makeText(spn.getContext(), "Has seleccionado " +
                                            spn.getItemAtPosition(posicion).toString(),
                                    Toast.LENGTH_LONG).show();

                            mesSeleccionado = spn.getItemAtPosition(posicion).toString();
                            infoMesText = infocliente.compraMes(nombreCliente, mesSeleccionado);
                            detalleCliente.append("\n\nEn el mes " + mesSeleccionado +
                                   " compro: $" + infoMesText);
                        }


                        public void onNothingSelected(AdapterView<?> spn) {
                        }
                    });

        return v;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
    }

}