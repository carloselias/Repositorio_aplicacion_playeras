package com.aplicacion.dao;

import com.aplicacion.conexion.ConexionBD;

import java.math.BigDecimal;
import java.sql.*;

public class ProveedoresDAO {

    // =========================================
    // LISTAR PROVEEDORES
    // =========================================
    public void listarProveedores() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Proveedor";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("\n\n=== PROVEEDORES REGISTRADOS  ===");

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("Codigo proveedor: "
                        + rs.getInt("id_proveedor"));

                System.out.println("Nombre: "
                        + rs.getString("nombre"));

                System.out.println("Telefono: "
                        + rs.getString("telefono"));

                System.out.println("Email: "
                        + rs.getString("email"));

                System.out.println("Direccion: "
                        + rs.getString("direccion"));

                System.out.println("Activo: "
                        + rs.getBigDecimal("activo"));
            }

        } catch (Exception e) {

            System.out.println("Error al obtener datos de proveedores. ");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // INSERTAR EMPRESA
    // =========================================
    public void insertarProveedores(
            int id_proveedor,
            String nombre,
            String telefono,
            String email,
            String direccion,
            int activo
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarProveedor(?, ?, ?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_proveedor);
            ps.setString(2, nombre);
            ps.setString(3, telefono);
            ps.setString(4, email);
            ps.setString(5, direccion);
            ps.setInt(6, activo);

            boolean resultado = ps.execute();

            if(!resultado) {

                System.out.println("Proveedor insertado con exito.");

            } else {

                System.out.println("No se ejecutó");

            }

        } catch (Exception e) {

            System.out.println("Error al insertar empresa.");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // ACTUALIZAR PROVEEDOR
    // =========================================
    public void actualizarProveedor(
            int id_proveedor,
            String nombre,
            String telefono,
            String email,
            String direccion,
            String activo //no es string pero para que pueda ser vacio
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarProveedor(?, ?, ?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            // ID obligatorio
            ps.setInt(1, id_proveedor);

            // Campos opcionales
            if(nombre == null || nombre.isBlank()){
                ps.setNull(2, Types.VARCHAR);
            } else {
                ps.setString(2, nombre);
            }

            if(telefono == null || telefono.isBlank()){
                ps.setNull(3, Types.VARCHAR);
            } else {
                ps.setString(3, telefono);
            }

            if(email == null || email.isBlank()){
                ps.setNull(4, Types.VARCHAR);
            } else {
                ps.setString(4, email);
            }

            if(direccion == null || direccion.isBlank()){
                ps.setNull(5, Types.VARCHAR);
            } else {
                ps.setString(5, direccion);
            }

            if(activo.equals("1") || activo.equals("0")){
                int temp = Integer.parseInt(activo);
                ps.setInt(6, temp);
            } else {
                ps.setNull(6, Types.INTEGER);

            }

            boolean resultado = ps.execute();

            if(!resultado){

                System.out.println("Proveedor actualizado");

            } else {

                System.out.println("No se actualizó");
            }

        } catch (Exception e) {

            System.out.println("Error al actualizar proveedor");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }




}
