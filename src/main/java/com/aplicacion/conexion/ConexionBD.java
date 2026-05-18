package com.aplicacion.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL =
            "jdbc:sqlserver://100.77.199.44:1433;"
                    + "databaseName=BD_de_playeras;"
                    + "failoverPartner=100.64.222.114;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true;";

    private static final String USER = "admin_playeras ";
    private static final String PASSWORD = "AdminPass123!";

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