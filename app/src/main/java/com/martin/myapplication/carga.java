package com.martin.myapplication;

import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class carga {

    public List<String> cargarClientes()
    {
        Connection connection;
        ConnectSQL c = new ConnectSQL();
        connection = c.ConexionBD();
        List<String> clientes_cargados = new ArrayList<String>();

        if (connection != null)
        {
            try {
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT CLIENTE FROM VentaMensual");

                while (rs.next()) {
                    clientes_cargados.add(rs.getString(1));
                }

            } catch (Exception e) {
                clientes_cargados.add(e.getMessage());
            }
        }
        return clientes_cargados;
    }

    public int[] cargarComprasMensual(int[] ejey, String cliente) {

        Connection connection;
        ConnectSQL c = new ConnectSQL();
        connection = c.ConexionBD();

        if (connection != null) {
            try {
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM VentaMensual WHERE CLIENTE = '" + cliente + "'");

                while (rs.next()) {
                    for (int i = 1; i < 12; i++) {

                        ejey[i-1] = rs.getInt(i+1);

                    }
                }

            } catch (Exception e) {

            }
        }
        return ejey;
    }

    public List<String> cargarMeses()
    {

        List<String> meses_cargados = new ArrayList<String>();
        meses_cargados.add("ENERO");
        meses_cargados.add("FEBRERO");
        meses_cargados.add("MARZO");
        meses_cargados.add("ABRIL");
        meses_cargados.add("MAYO");
        meses_cargados.add("JUNIO");
        meses_cargados.add("JULIO");
        meses_cargados.add("AGOSTO");
        meses_cargados.add("SEPTIEMBRE");
        meses_cargados.add("OCTUBRE");
        meses_cargados.add("NOVIEMBRE");
        meses_cargados.add("DICIEMBRE");

        return meses_cargados;
    }

    public List<String> cargarCategorias(String cliente)
    {
        Connection connection;
        ConnectSQL c = new ConnectSQL();
        connection = c.ConexionBD();
        List<String> categorias_cargadas = new ArrayList<String>();

        if (connection != null)
        {
            try {
                Statement stm = connection.createStatement();

                ResultSet rs = stm.executeQuery("SELECT DISTINCT CATEGORIAPRODUCTO " +
                                                    "FROM VentaPorProducto " +
                                                    "WHERE CLIENTE = '" + cliente + "'");

                while (rs.next())
                {
                    categorias_cargadas.add(rs.getString(1));
                }


            } catch (Exception e) {
                categorias_cargadas.add(e.getMessage());
            }
        }
        return categorias_cargadas;
    }

    public List<String> cargarProductos(String cliente, String categoria)
    {
        Connection connection;
        ConnectSQL c = new ConnectSQL();
        connection = c.ConexionBD();
        List<String> productos_cargados = new ArrayList<String>();

        if (connection != null)
        {
            try {
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT DISTINCT PRODUCTO " +
                                                    "FROM VentaPorProducto " +
                                                    "WHERE CLIENTE = '" + cliente + "' " +
                                                    "AND CATEGORIAPRODUCTO = '" + categoria + "' " +
                                                    "ORDER BY PRODUCTO ASC");

                while (rs.next()) {
                    productos_cargados.add(rs.getString(1));
                }

            } catch (Exception e) {
                productos_cargados.add(e.getMessage());
            }
        }
        return productos_cargados;
    }

    public int[] cargarSumaCategoriaMensual(int[] ejey, String cliente, String categoria, TextView text) {

        Connection connection;
        ConnectSQL c = new ConnectSQL();
        connection = c.ConexionBD();

        if (connection != null) {
            try {
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT CLIENTE = '" + cliente + "' , " +
                                                    "CATEGORIAPRODUCTO = '" + categoria + "', " +
                                                    "ENERO = SUM(ENERO), FEBRERO = SUM(FEBRERO), MARZO = SUM(MARZO), " +
                                                    "ABRIL = SUM(ABRIL), MAYO = SUM(MAYO), JUNIO = SUM(JUNIO), " +
                                                    "JULIO = SUM(JULIO), AGOSTO = SUM(AGOSTO), SEPTIEMBRE = SUM(SEPTIEMBRE), " +
                                                    "OCTUBRE = SUM(OCTUBRE), NOVIEMBRE = SUM(NOVIEMBRE), " +
                                                    "DICIEMBRE = SUM(DICIEMBRE) " +
                                                    "FROM VentaPorProducto " +
                                                    "WHERE CLIENTE = '" + cliente + "' " +
                                                    "AND CATEGORIAPRODUCTO = '" + categoria + "' ");

                while (rs.next()) {
                    for (int i = 2; i < 14; i++)
                    {
                        ejey[i-2] = rs.getInt(i+1);
                    }
                }

                } catch (Exception e) {
                text.setText(e.getMessage());
                }
        }
        return ejey;
    }

    public ArrayList<CompraMensualData> cargaGraficoBarra(View v, ArrayList<CompraMensualData> compraMes, String cliente, String producto)
    {
        Connection connection;
        ConnectSQL c = new ConnectSQL();
        connection = c.ConexionBD();
        compraMes.clear();

        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}; //ejex
        //text.setText(cliente);

        if (connection != null) {
            try {
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT '" + cliente + "' , ENERO = SUM(ENERO), FEBRERO = SUM(FEBRERO), MARZO = SUM(MARZO), " +
                                                    "ABRIL = SUM(ABRIL), MAYO = SUM(MAYO), JUNIO = SUM(JUNIO), " +
                                                    "JULIO = SUM(JULIO), AGOSTO = SUM(AGOSTO), SEPTIEMBRE = SUM(SEPTIEMBRE), " +
                                                    "OCTUBRE = SUM(OCTUBRE), NOVIEMBRE = SUM(NOVIEMBRE), " +
                                                    "DICIEMBRE = SUM(DICIEMBRE) " +
                                                    "FROM VentaPorProducto " +
                                                    "WHERE CLIENTE = '" + cliente + "' AND PRODUCTO = '" + producto + "' " +
                                                    "GROUP BY CLIENTE");


                while (rs.next()) {
                    for (int i=0; i<12; i++)
                    {
                        compraMes.add(new CompraMensualData(meses[i], rs.getInt(i+2)));
                    }
                }

            } catch (Exception e) {
                //text.setText(e.getMessage());
            }
        }
        return compraMes;
    }

    public String detalleOnClick (String detalleProducto, String cliente, String producto, String mes)
    {
        Connection connection;
        ConnectSQL c = new ConnectSQL();
        connection = c.ConexionBD();

        String aux1 = "";
        String aux2 = "";

        if (connection != null) {
            try {
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT CLIENTE, PRODUCTO, PRECIO, " + mes + " " +
                                                    "FROM VentaPorProducto " +
                                                    "WHERE CLIENTE = '" + cliente + "' AND PRODUCTO = '" + producto + "' " +
                                                    "AND " + mes + " != 0");

                while (rs.next()) {

                        aux1 = rs.getString(3);

                        aux2 = rs.getString(4);

                        detalleProducto = detalleProducto + "Precio de compra: $" + aux1.substring(0, aux1.length() - 3)
                                                          + " Cantidad: " + aux2.substring(0, aux2.length() - 2) + "\n";

                }



            } catch (Exception e) {
                //text.setText(e.getMessage());
            }
        }
        return detalleProducto;
    }

}
