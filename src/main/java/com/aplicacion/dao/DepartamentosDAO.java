package com.aplicacion.dao;

import com.aplicacion.conexion.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

public class DepartamentosDAO {
    // =========================================
    // LISTAR EMPLEADOS
    // =========================================
    public void listarDepartamentos() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Departamento";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("\n\n=== DEPARTAMENTOS REGISTRADOS  ===");

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("Codigo Departamento: "
                        + rs.getInt("id_departamento"));

                System.out.println("Nombre departamento: "
                        + rs.getString("nombre"));

                System.out.println("Ubicacion fisica: "
                        + rs.getString("ubicacion"));

            }

        } catch (Exception e) {

            System.out.println("Error al obtener datos de Departamento. ");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }



    //==============================
    // INSERTAR DEPARTAMENTO
    // =========================================
    public void insertarDepartamento(
            int id_departamento,
            String nombre,
            String ubicacion

    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarDepartamento(?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_departamento);
            ps.setString(2, nombre);
            ps.setString(3, ubicacion);


            boolean resultado = ps.execute();

            if(!resultado) {

                System.out.println("Departamento insertado con exito.");

            } else {

                System.out.println("No se ejecutó");

            }

        } catch (Exception e) {

            System.out.println("Error al insertar Departamento.");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // ACTUALIZAR DEPARTAMENTO
    // =========================================
    public void actualizarDepartamento(
            int id_departamento,
            String nombre,
            String ubicacion
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarDepartamento(?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            // ID obligatorio
            ps.setInt(1, id_departamento);


            if(nombre == null || nombre.isBlank()){
                ps.setNull(2, Types.VARCHAR);
            } else {
                ps.setString(2, nombre);
            }

            if(ubicacion == null || ubicacion.isBlank()){
                ps.setNull(3, Types.VARCHAR);
            } else {
                ps.setString(3, ubicacion);
            }

            boolean resultado = ps.execute();

            if(!resultado){

                System.out.println("Departamento actualizado");

            } else {

                System.out.println("No se actualizó");
            }

        } catch (Exception e) {

            System.out.println("Error al actualizar departamento");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }
}
