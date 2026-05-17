package com.aplicacion.dao;

import com.aplicacion.conexion.ConexionBD;

import java.sql.*;
import java.util.Scanner;

public class ClientesDAO {
    // =========================================
// INSERTAR CLIENTE
// =========================================
    public void insertarCliente(int idCliente, int idTipoCliente, String nombre, String telefono, String email, String direccion) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarCliente(?, ?, ?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idCliente);

            ps.setInt(2, idTipoCliente);

            ps.setString(3, nombre);

            ps.setString(4, telefono);

            ps.setString(5, email);

            ps.setString(6, direccion);

            ps.execute();

            System.out.println(
                    "Cliente insertado correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );

        } finally {

            try {
                if(ps != null)
                    ps.close();
            } catch(Exception e){}

            try {
                if(con != null)
                    con.close();
            } catch(Exception e){}
        }
    }

    // =========================================
    // ACTUALIZAR CLIENTE
    // =========================================
    public void actualizarCliente(int idCliente, String nombre, String telefono, String email, String direccion) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarCliente(?, ?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idCliente);

            // NOMBRE
            if(nombre == null || nombre.isBlank()){

                ps.setNull(2, Types.VARCHAR);

            } else {

                ps.setString(2, nombre);
            }

            // TELEFONO
            if(telefono == null || telefono.isBlank()){

                ps.setNull(3, Types.VARCHAR);

            } else {

                ps.setString(3, telefono);
            }

            // EMAIL
            if(email == null || email.isBlank()){

                ps.setNull(4, Types.VARCHAR);

            } else {

                ps.setString(4, email);
            }

            // DIRECCION
            if(direccion == null || direccion.isBlank()){

                ps.setNull(5, Types.VARCHAR);

            } else {

                ps.setString(5, direccion);
            }

            ps.execute();

            System.out.println(
                    "Cliente actualizado correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );

        } finally {

            try {
                if(ps != null)
                    ps.close();
            } catch(Exception e){}

            try {
                if(con != null)
                    con.close();
            } catch(Exception e){}
        }
    }

    // =========================================
    // CONSULTAR CLIENTE
    // =========================================
    public void consultarCliente(Integer idCliente, String campos) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql =
                "{CALL sp_ConsultarCliente(?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            // ID CLIENTE
            if(idCliente == null){

                ps.setNull(1, Types.INTEGER);

            } else {

                ps.setInt(1, idCliente);
            }

            // CAMPOS
            if(campos == null || campos.isBlank()){

                ps.setNull(2, Types.VARCHAR);

            } else {

                ps.setString(2, campos);
            }

            rs = ps.executeQuery();

            System.out.println(
                    "\n=== RESULTADO CONSULTA CLIENTES ==="
            );

            ResultSetMetaData meta =
                    rs.getMetaData();

            int columnas =
                    meta.getColumnCount();

            while(rs.next()){

                System.out.println(
                        "------------------------"
                );

                for(int i = 1; i <= columnas; i++){

                    System.out.println(
                            meta.getColumnName(i)
                                    + ": "
                                    + rs.getString(i)
                    );
                }
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );

        } finally {

            try {
                if(rs != null)
                    rs.close();
            } catch(Exception e){}

            try {
                if(ps != null)
                    ps.close();
            } catch(Exception e){}

            try {
                if(con != null)
                    con.close();
            } catch(Exception e){}
        }
    }

    // =========================================
    // ELIMINAR CLIENTE
    // =========================================
    public void eliminarCliente(int idCliente) {

        Scanner sc = new Scanner(System.in);

        System.out.print(
                "¿Seguro que desea eliminar el cliente? (S/N): "
        );

        String respuesta =
                sc.nextLine();

        if(!respuesta.equalsIgnoreCase("S")){

            System.out.println(
                    "Operacion cancelada"
            );

            return;
        }

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_EliminarCliente(?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idCliente);

            ps.execute();

            System.out.println(
                    "Cliente eliminado correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );

        } finally {

            try {
                if(ps != null)
                    ps.close();
            } catch(Exception e){}

            try {
                if(con != null)
                    con.close();
            } catch(Exception e){}
        }
    }
}
