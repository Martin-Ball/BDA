package com.martin.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class infoCliente {

    Connection connection;

    public String detalleCliente(String cliente)
    {

        ConnectSQL c = new ConnectSQL();
        connection = c.ConexionBD();
        String compra_promedio = "";

        if (connection != null)
        {
            try {
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery(
                        "SELECT [PROMEDIO MENSUAL] " +
                            "FROM VentaMensual " +
                            "WHERE CLIENTE = '" + cliente +"'");

                if (connection != null)
                {
                    try {
                        if (rs.next())
                        {
                            compra_promedio = rs.getString(1);
                            compra_promedio = compra_promedio.substring(0, compra_promedio.length() - 2);
                        }
                    } catch (Exception e) { }
                }

            } catch (Exception e) { }
        }

        return compra_promedio;
    }

    public String compraMes(String cliente, String InfoMes)
    {
        ConnectSQL c = new ConnectSQL();
        connection = c.ConexionBD();
        String compra = "";

        if (connection != null)
        {
            try {
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT " + InfoMes + " FROM VentaMensual " + "WHERE CLIENTE = '"+ cliente +"'");

                if (connection != null)
                {
                    try {
                        if (rs.next())
                        {
                            compra = rs.getString(1);
                            compra = compra.substring(0, compra.length() - 2);
                        }
                    } catch (Exception e) { }
                }

            } catch (Exception e) { }
        }
        return compra;
    }

    public void detalleProductoComprado(TextView text, String cliente, String cat, String prod, String mes)
    {
        ConnectSQL c = new ConnectSQL();
        connection = c.ConexionBD();
        String compra = "";

        if (connection != null) {
            try {
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT CLIENTE = '" + cliente + "'," +
                                                    " CATEGORIAPRODUCTO = '" + cat +"'," +
                                                    " PRODUCTO = '" + prod + "', " +
                                                    " JUNIO = SUM(" + mes + ")" +
                                                    " FROM VentaPorProducto " +
                                                    " WHERE CLIENTE = '" + cliente + "' " +
                                                    "AND CATEGORIAPRODUCTO = '" + cat + "' " +
                                                    "AND PRODUCTO = '" + prod + "'");

                        while (rs.next())
                        {
                                compra = rs.getString(4);
                        }

                        if (compra == null || compra.equals("0.0"))
                        {
                            text.setText("El cliente: " + cliente + "\nNO registra compras de " + prod + "\nen el mes de " + mes);
                            text.setTextColor(Color.RED);
                        }
                        else
                        {
                            text.setText("El cliente compro: " + compra + " " + prod + " \nEn el mes de " + mes);
                            text.setTextColor(Color.BLACK);
                        }
                } catch (Exception e) {
            }
        }
    }

    public List<String> prodRec(String cliente, View v)
    {
        Connection connection;
        ConnectSQL c = new ConnectSQL();
        connection = c.ConexionBD();
        List<String> productosRec = new ArrayList<String>();

       String[] meses = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};

        //Mes actual
        Calendar calendar = Calendar.getInstance();

        int mes = calendar.get(Calendar.MONTH);

        String mesAct = meses[mes];

        if (connection != null)
        {
            try {
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT DISTINCT TOP 10 CATEGORIAPRODUCTO, " +
                                                    "PRODUCTO, " + mesAct + " " +
                                                    "FROM VentaPorProducto " +
                                                    "WHERE " + mesAct + " IS NOT NULL " +
                                                    "AND CLIENTE = '" + cliente + "' " +
                                                    "ORDER BY " + mesAct + " DESC");

                while (rs.next()) {
                    for(int i=1; i<=2; i++) {
                       productosRec.add(rs.getString(i));
                    }
                }

            } catch (Exception e) {
                productosRec.add(e.getMessage());
            }
        }
        return productosRec;
    }

    /*public Map<String, String> prodRec(String cliente, View v)
    {
        Connection connection;
        ConnectSQL c = new ConnectSQL();
        connection = c.ConexionBD();
        Map<String, String> productosRec = new HashMap<>();

        String[] meses = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};

        //Mes actual
        Calendar calendar = Calendar.getInstance();

        int mes = calendar.get(Calendar.MONTH);

        String mesAct = meses[mes];

        if (connection != null)
        {
            try {
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT DISTINCT TOP 10 CATEGORIAPRODUCTO, " +
                        "PRODUCTO, " + mesAct + " " +
                        "FROM VentaPorProducto " +
                        "WHERE " + mesAct + " IS NOT NULL " +
                        "AND CLIENTE = '" + cliente + "' " +
                        "ORDER BY " + mesAct + " DESC");

                while (rs.next()) {
                        productosRec.put(rs.getString(1), rs.getString(2));
                }

            } catch (Exception e) {
                productosRec.put("error", e.getMessage());
            }
        }
        return productosRec;
    }*/
}
