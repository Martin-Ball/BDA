package com.martin.myapplication;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectSQL {

    Connection connection = null;

    public Connection ConexionBD()
    {
        try {
            StrictMode.ThreadPolicy a = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(a);
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String connectURL = "jdbc:jtds:sqlserver://192.168.0.82:1433/DBAI";
            connection = DriverManager.getConnection(connectURL, "Martin", "Martin1432");

        } catch (Exception e) {
            Log.e("Error is: ", e.getMessage());
        }
        return connection;
    }
}
