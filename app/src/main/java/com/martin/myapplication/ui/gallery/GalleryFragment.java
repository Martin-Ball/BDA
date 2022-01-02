package com.martin.myapplication.ui.gallery;

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
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.martin.myapplication.CompraMensualData;
import com.martin.myapplication.R;
import com.martin.myapplication.carga;
import com.martin.myapplication.infoCliente;
import com.martin.myapplication.inicializarGrafico;
import java.util.ArrayList;
import java.util.List;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.view.LineChartView;


public class GalleryFragment extends Fragment {

    List<String> clientes = new ArrayList<String>();
    List<String> categorias = new ArrayList<String>();
    List<String> mes = new ArrayList<String>();
    List<String> producto = new ArrayList<String>();
    String nombreCliente = "";
    String infoclienteText = "";
    String clienteSeleccionado = "";
    String categoriaSeleccionada = "ACEITES Y VINAGRES";
    String productoSeleccionado = "";
    String mesSeleccionado = "";


    //bar chart
    BarChart barChart;
    ArrayList<BarEntry> valoresBarra;
    ArrayList<String > etiquetas;
    ArrayList<CompraMensualData> compraMes = new ArrayList<>();

    int[] ejey = {0,0,0,0,0,0,0,0,0,0,0,0};

    private LineChartView lineChart;

    private List<AxisValue> ejex = new ArrayList<AxisValue>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_gallery,container,false);

        carga clientes2 = new carga();
        clientes = clientes2.cargarClientes();
        TextView detalleCliente = v.findViewById(R.id.infoCliente);

        //Grafica lineas
        lineChart = (LineChartView) v.findViewById(R.id.chart);

        infoCliente infocliente = new infoCliente();
        carga carga = new carga();

        inicializarGrafico grafico = new inicializarGrafico();

        carga cargaCategorias = new carga();

        carga cargaProducto = new carga();

        categorias = cargaCategorias.cargarCategorias(clienteSeleccionado);

        producto = cargaProducto.cargarProductos(clienteSeleccionado, categoriaSeleccionada);

        //spinners

        Spinner spinnerCategoria = v.findViewById(R.id.spinnerCategoria);

        Spinner spinnerProducto = v.findViewById(R.id.spinnerProducto);

        //Grafica barras

        barChart = v.findViewById(R.id.barChart);
        valoresBarra = new ArrayList<>();
        etiquetas = new ArrayList<>();


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
                        clienteSeleccionado = nombreCliente;
                        infoclienteText = infocliente.detalleCliente(nombreCliente);
                        detalleCliente.setTextColor(Color.BLACK);

                        infocliente.detalleProductoComprado(detalleCliente, clienteSeleccionado, categoriaSeleccionada,
                                productoSeleccionado, mesSeleccionado);

                        ejey = carga.cargarSumaCategoriaMensual(ejey, nombreCliente, categoriaSeleccionada, detalleCliente); //cargar en el ejeY el monto de compra mensual

                        grafico.inicializarGraficoLinea(lineChart, ejex, ejey); //Inicialización del grafico

                        categorias = cargaCategorias.cargarCategorias(clienteSeleccionado);

                        //adapter spinner CATEGORIA
                        ArrayAdapter<String> dataAdapterCategorias = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categorias);
                        dataAdapterCategorias.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerCategoria.setAdapter(dataAdapterCategorias);

                        //debug.setText(clienteSeleccionado);

                        //Grafico de barras

                        carga.cargaGraficoBarra(v, compraMes, clienteSeleccionado, productoSeleccionado);


                        for (int i=0; i < compraMes.size();i++){

                            String month = compraMes.get(i).getMonth();
                            int sales = compraMes.get(i).getSales();
                            valoresBarra.add(new BarEntry(i,sales));
                            etiquetas.add(month);
                        }

                        grafico.inicializarGraficoBarras(valoresBarra, barChart, etiquetas);
                    }

                    public void onNothingSelected(AdapterView<?> spn) {
                    }
                });

        //spinner categorias
        spinnerCategoria.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> spn, android.view.View v, int posicion, long id) {

                        Toast.makeText(spn.getContext(), "Has seleccionado " +
                                        spn.getItemAtPosition(posicion).toString(),
                                Toast.LENGTH_LONG).show();

                        categoriaSeleccionada = spn.getItemAtPosition(posicion).toString();

                        infocliente.detalleProductoComprado(detalleCliente, clienteSeleccionado, categoriaSeleccionada,
                                productoSeleccionado, mesSeleccionado);

                        ejey = carga.cargarSumaCategoriaMensual(ejey, nombreCliente, categoriaSeleccionada, detalleCliente); //cargar en el ejeY el monto de compra mensual
                        grafico.inicializarGraficoLinea(lineChart, ejex, ejey); //Inicialización del grafico

                        producto = cargaProducto.cargarProductos(clienteSeleccionado, categoriaSeleccionada);

                        ArrayAdapter<String> dataAdapterProducto = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, producto);
                        dataAdapterProducto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerProducto.setAdapter(dataAdapterProducto);
                    }


                    public void onNothingSelected(AdapterView<?> spn) {
                    }
                });

        //spinner Producto

        spinnerProducto.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> spn, android.view.View v, int posicion, long id) {

                        Toast.makeText(spn.getContext(), "Has seleccionado " +
                                        spn.getItemAtPosition(posicion).toString(),
                                Toast.LENGTH_LONG).show();

                        productoSeleccionado = spn.getItemAtPosition(posicion).toString();
                        infocliente.detalleProductoComprado(detalleCliente, clienteSeleccionado, categoriaSeleccionada,
                                productoSeleccionado, mesSeleccionado);

                        //Grafico de barras

                        carga.cargaGraficoBarra(v, compraMes, clienteSeleccionado, productoSeleccionado);


                        for (int i=0; i < compraMes.size();i++){

                            String month = compraMes.get(i).getMonth();
                            int sales = compraMes.get(i).getSales();
                            valoresBarra.add(new BarEntry(i,sales));
                            etiquetas.add(month);
                        }

                        grafico.inicializarGraficoBarras(valoresBarra, barChart, etiquetas);
                    }

                    public void onNothingSelected(AdapterView<?> spn) {
                    }
                });

        //spinner MES
        carga cargaMes = new carga();
        mes = cargaMes.cargarMeses();

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

                        infocliente.detalleProductoComprado(detalleCliente, clienteSeleccionado, categoriaSeleccionada,
                                productoSeleccionado, mesSeleccionado);
                    }

                    public void onNothingSelected(AdapterView<?> spn) {
                    }
                });

        carga detalle = new carga();

        barChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                String detalleCompraTexto = "";
                int aux = 0;
                String aux2 = "";

                aux = (int) e.getX();
                aux2 = mes.get(aux);

                detalleCompraTexto = detalle.detalleOnClick(detalleCompraTexto, clienteSeleccionado, productoSeleccionado, aux2);

                int x = barChart.getData().getDataSetForEntry(e).getEntryIndex((BarEntry) e);
                int compra = compraMes.get(x).getSales();

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setCancelable(true);
                builder.setTitle("Compra del mes: " + aux2);
                builder.setMessage("En el mes: " + aux2 + "\nEl cliente: " + clienteSeleccionado + " compro: "
                                   + compra + " " + productoSeleccionado + " en total. \n\nDETALLE: \n\n" + detalleCompraTexto);

                    builder.setPositiveButton("Aceptar", null);

                    AlertDialog dialog = builder.create();
                    dialog.show();

            }

            @Override
            public void onNothingSelected() {

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