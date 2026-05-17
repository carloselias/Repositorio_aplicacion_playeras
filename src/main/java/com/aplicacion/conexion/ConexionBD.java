package com.aplicacion.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL =
            "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=playeras;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true;";

    private static final String USER = "sa";
    private static final String PASSWORD = "umg2026";

    public static Connection getConexion() {

        Connection con = null;

        try {

            con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

        } catch (SQLException e) {

            System.out.println("Error de conexión");
            e.printStackTrace();

        }

        return con;
    }

    public static void main(String[] args) {
        Connection conexion = getConexion();
        if (conexion != null)
            System.out.println("Conectado con la base de datos: "+conexion);
        else
            System.out.println("No Conectado con la base de datos");
    }
}