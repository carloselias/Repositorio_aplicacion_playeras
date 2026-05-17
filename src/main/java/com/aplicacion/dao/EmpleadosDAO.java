package com.aplicacion.dao;

import com.aplicacion.conexion.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

public class EmpleadosDAO {
    // =========================================
    // LISTAR PROVEEDORES
    // =========================================
    public void listarEmpleados() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Empleado";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("\n\n=== EMPLEADOS REGISTRADOS  ===");

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("Codigo Empleado: "
                        + rs.getInt("id_empelado"));

                System.out.println("Codigo departamento: "
                        + rs.getInt("id_departamento"));

                System.out.println("DPI: "
                        + rs.getInt("dpi"));

                System.out.println("Nombres: "
                        + rs.getString("nombres"));

                System.out.println("Apellidos: "
                        + rs.getString("apellidos"));

                System.out.println("Puesto/cargo: "
                        + rs.getString("puesto"));

                System.out.println("Direccion: "
                        + rs.getString("direccion"));

                System.out.println("Telefono: "
                        + rs.getString("telefono"));

                System.out.println("Correo electronico: "
                        + rs.getString("email"));
            }

        } catch (Exception e) {

            System.out.println("Error al obtener datos de empleados. ");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }



    //==============================
    // INSERTAR EMPLEADO
    // =========================================
    public void InsertarEmpleado(
            int id_empleado,
            int id_departamento,
            int dpi,
            String nombres,
            String apellidos,
            String puesto,
            String direccion,
            String telefono,
            String email
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarEmpleado(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_empleado);
            ps.setInt(2, id_departamento);
            ps.setInt(3, dpi);
            ps.setString(4, nombres);
            ps.setString(5, apellidos);
            ps.setString(6, puesto);
            ps.setString(7, direccion);
            ps.setString(8, telefono);
            ps.setString(9, email);


            boolean resultado = ps.execute();

            if(!resultado) {

                System.out.println("Empleado insertado con exito.");

            } else {

                System.out.println("No se ejecutó");

            }

        } catch (Exception e) {

            System.out.println("Error al insertar empleado.");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // ACTUALIZAR EMPLEADO
    // =========================================
    public void actualizarEmpleado(
            int id_empleado,
            int id_departamento,
            int dpi,
            String nombres,
            String apellidos,
            String puesto,
            String direccion,
            String telefono,
            String email
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarEmpleado(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            // ID obligatorio
            ps.setInt(1, id_empleado);

            // Campos opcionales
            if(id_departamento == 0){
                ps.setNull(2, Types.INTEGER);
            } else {
                ps.setInt(2, id_departamento);
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

            if(nombres == null || nombres.isBlank()){
                ps.setNull(6, Types.VARCHAR);
            } else {
                ps.setString(6, nombres);
            }

            if(apellidos == null || apellidos.isBlank()){
                ps.setNull(7, Types.VARCHAR);
            } else {
                ps.setString(7, apellidos);
            }

            if(puesto == null || puesto.isBlank()){
                ps.setNull(8, Types.VARCHAR);
            } else {
                ps.setString(8, puesto);
            }

            if(dpi == 0){
                ps.setNull(9, Types.INTEGER);
            } else {
                ps.setInt(9, dpi);
            }

            boolean resultado = ps.execute();

            if(!resultado){

                System.out.println("Empleado actualizado");

            } else {

                System.out.println("No se actualizó");
            }

        } catch (Exception e) {

            System.out.println("Error al actualizar empleado");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


}
