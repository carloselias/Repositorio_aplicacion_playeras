package com.aplicacion.dao;

import com.aplicacion.conexion.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

public class ProcesosDAO {

    // =========================================
    // LISTAR PROCESOS
    // =========================================
    public void listarProcesos() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Proceso";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("\n\n=== PROCESOS REGISTRADOS ===");

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("Codigo proceso: "
                        + rs.getInt("id_proceso"));

                System.out.println("Nombre proceso: "
                        + rs.getString("nombre_proceso"));

                System.out.println("Descripcion: "
                        + rs.getString("descripcion"));
            }

        } catch (Exception e) {

            System.out.println("Error al obtener datos de procesos.");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // INSERTAR PROCESO
    // =========================================
    public void insertarProceso(
            int id_proceso,
            String nombre_proceso,
            String descripcion
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarProceso(?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_proceso);
            ps.setString(2, nombre_proceso);
            ps.setString(3, descripcion);

            boolean resultado = ps.execute();

            if(!resultado) {

                System.out.println("Proceso insertado con exito.");

            } else {

                System.out.println("No se ejecutó");

            }

        } catch (Exception e) {

            System.out.println("Error al insertar proceso.");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // ACTUALIZAR PROCESO
    // =========================================
    public void actualizarProceso(
            int id_proceso,
            String nombre_proceso,
            String descripcion
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarProceso(?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            // ID obligatorio
            ps.setInt(1, id_proceso);

            if(nombre_proceso == null || nombre_proceso.isBlank()){
                ps.setNull(2, Types.VARCHAR);
            } else {
                ps.setString(2, nombre_proceso);
            }

            if(descripcion == null || descripcion.isBlank()){
                ps.setNull(3, Types.VARCHAR);
            } else {
                ps.setString(3, descripcion);
            }

            boolean resultado = ps.execute();

            if(!resultado){

                System.out.println("Proceso actualizado");

            } else {

                System.out.println("No se actualizó");
            }

        } catch (Exception e) {

            System.out.println("Error al actualizar proceso");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }
}