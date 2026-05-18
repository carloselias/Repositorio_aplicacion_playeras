package com.aplicacion.dao;

import com.aplicacion.conexion.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegistroProcesosDAO {

    // =========================================
    // LISTAR REGISTROS
    // =========================================
    public void listarProcesos() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Registro_proceso";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("\n\n=== REGISTROS DE PROCESO ===");

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("Codigo registro: "
                        + rs.getInt("id_registro_proceso"));

                System.out.println("Codigo detalle orden: "
                        + rs.getInt("id_detalle_orden"));

                System.out.println("Codigo proceso: "
                        + rs.getInt("id_proceso"));

                System.out.println("Fecha iniciado: "
                        + rs.getTimestamp("fecha_iniciado"));

                System.out.println("Fecha terminado: "
                        + rs.getTimestamp("fecha_terminado"));

                System.out.println("Observaciones: "
                        + rs.getString("observaciones"));

                System.out.println("Estado: "
                        + rs.getString("estado"));
            }

        } catch (Exception e) {

            System.out.println("Error al obtener registros de proceso.");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // INICIAR PROCESO
    // =========================================
    public void iniciarProceso(
            int id_registro_proceso,
            int id_detalle_orden,
            int id_proceso,
            java.sql.Timestamp fecha_iniciado,
            String observaciones
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_IniciarProceso(?, ?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_registro_proceso);
            ps.setInt(2, id_detalle_orden);
            ps.setInt(3, id_proceso);
            ps.setTimestamp(4, fecha_iniciado);
            ps.setString(5, observaciones);

            boolean resultado = ps.execute();

            if(!resultado) {

                System.out.println("Proceso iniciado con exito.");

            } else {

                System.out.println("No se ejecutó");

            }

        } catch (Exception e) {

            System.out.println("Error al iniciar proceso.");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // REGISTRAR EMPLEADO EN PROCESO
    // =========================================
    public void registrarEmpleado(
            int id_registro_proceso,
            int id_empleado
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "INSERT INTO Proceso_empleado (id_registro_proceso, id_empleado) VALUES (?, ?)";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareStatement(sql);

            ps.setInt(1, id_registro_proceso);
            ps.setInt(2, id_empleado);

            int filas = ps.executeUpdate();

            if(filas > 0) {

                System.out.println("Empleado registrado en proceso.");

            } else {

                System.out.println("No se registró el empleado.");

            }

        } catch (Exception e) {

            System.out.println("Error al registrar empleado en proceso.");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // TERMINAR PROCESO
    // =========================================
    public void terminarProceso(
            int id_registro_proceso,
            java.sql.Timestamp fecha_terminado
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_TerminarProceso(?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_registro_proceso);
            ps.setTimestamp(2, fecha_terminado);

            boolean resultado = ps.execute();

            if(!resultado){

                System.out.println("Proceso terminado.");

            } else {

                System.out.println("No se pudo terminar.");
            }

        } catch (Exception e) {

            System.out.println("Error al terminar proceso.");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // CANCELAR PROCESO
    // =========================================
    public void cancelarProceso(
            int id_registro_proceso,
            java.sql.Timestamp fecha_terminado
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_CancelarProceso(?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_registro_proceso);
            ps.setTimestamp(2, fecha_terminado);

            boolean resultado = ps.execute();

            if(!resultado){

                System.out.println("Proceso cancelado.");

            } else {

                System.out.println("No se pudo cancelar.");
            }

        } catch (Exception e) {

            System.out.println("Error al cancelar proceso.");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // CONSULTAR EMPLEADOS EN PROCESO
    // =========================================
    public void consultarEmpleados(int id_registro_proceso) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM fn_EmpleadosPorProceso(?)";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_registro_proceso);
            rs = ps.executeQuery();

            System.out.println("\n\n=== EMPLEADOS EN PROCESO #" + id_registro_proceso + " ===");

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("Codigo registro: "
                        + rs.getInt("id_registro_proceso"));

                System.out.println("Nombres: "
                        + rs.getString("nombres"));

                System.out.println("Apellidos: "
                        + rs.getString("apellidos"));

                System.out.println("Puesto: "
                        + rs.getString("puesto"));
            }

        } catch (Exception e) {

            System.out.println("Error al consultar empleados del proceso.");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }
}