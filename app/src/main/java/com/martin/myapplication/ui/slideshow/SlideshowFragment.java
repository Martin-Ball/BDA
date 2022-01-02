package com.martin.myapplication.ui.slideshow;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.martin.myapplication.R;
import com.martin.myapplication.carga;
import com.martin.myapplication.exportXLS;
import com.martin.myapplication.infoCliente;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    List<String> clientes = new ArrayList<String>();
    List<String> prodRec = new ArrayList<String>();
    String nombreCliente = "";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);


        View v = inflater.inflate(R.layout.fragment_slideshow,container,false);

        carga carga = new carga();
        clientes = carga.cargarClientes();

        infoCliente infoCliente = new infoCliente();

        TextView textProdRec1 = v.findViewById(R.id.textProdRec1);
        TextView textProdRec2 = v.findViewById(R.id.textProdRec2);

        Button exportarExcel = v.findViewById(R.id.exportarExcel);

        //spinner CLIENTES
        Spinner spinnerClientes = v.findViewById(R.id.spinnerClientesProdRec);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, clientes);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerClientes.setAdapter(dataAdapter);


        spinnerClientes.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @SuppressLint("SetTextI18n")
                    public void onItemSelected(AdapterView<?> spn, android.view.View v, int posicion, long id) {
                        Toast.makeText(spn.getContext(), "Has seleccionado " +
                                        spn.getItemAtPosition(posicion).toString(),
                                Toast.LENGTH_SHORT).show();

                        nombreCliente = spn.getItemAtPosition(posicion).toString();
                        textProdRec2.setText("");

                        textProdRec1.setText("En base a las compras del cliente " + nombreCliente + " puede interesarle los siguientes productos: ");

                        prodRec = infoCliente.prodRec(nombreCliente, v);

                        int j = 1;



                        for (int i = 0; i < prodRec.size(); i++) {

                            switch (j)
                            {
                                case 1: textProdRec2.append("De la categoria: "); break;
                                case 2: textProdRec2.append("El producto: "); break;
                            }

                                textProdRec2.append(prodRec.get(i));
                                textProdRec2.append("\n");
                                j++;

                                if(j==3)
                                {
                                    textProdRec2.append("\n");
                                    j=1;
                                }
                        }
                    }

                    public void onNothingSelected(AdapterView<?> spn) {
                    }
                });

        //Exportar excel
        exportXLS exportar = new exportXLS();

        exportarExcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exportar.guardar(nombreCliente, getContext(), v);
            }
        });

       return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}