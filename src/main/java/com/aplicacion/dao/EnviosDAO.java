package com.aplicacion.dao;

import com.aplicacion.conexion.ConexionBD;

import java.math.BigDecimal;
import java.sql.*;

public class EnviosDAO {

    // =========================================
    // LISTAR EMPRESAS REPARTIDORAS
    // =========================================
    public void listarEmpresasRepartidoras() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Empresa_repartidora";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            System.out.println("\n=== EMPRESAS REPARTIDORAS ===");

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("ID: "
                        + rs.getInt("id_empresa"));

                System.out.println("Nombre: "
                        + rs.getString("nombre"));

                System.out.println("Telefono: "
                        + rs.getString("telefono"));

                System.out.println("Email: "
                        + rs.getString("email"));

                System.out.println("Direccion: "
                        + rs.getString("direccion"));

                System.out.println("Cobro envio: "
                        + rs.getBigDecimal("cobro_envio"));

                System.out.println("Hora inicio: "
                        + rs.getTime("hora_inicio_horario"));

                System.out.println("Hora fin: "
                        + rs.getTime("hora_fin_horario"));

                System.out.println("Dia inicio: "
                        + rs.getString("dia_inicio_horario"));

                System.out.println("Dia fin: "
                        + rs.getString("dia_fin_horario"));
            }

        } catch (Exception e) {

            System.out.println("Error al listar empresas");
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
    public void insertarEmpresaRepartidora(
            int idEmpresa,
            String nombre,
            String telefono,
            String email,
            String direccion,
            BigDecimal cobroEnvio,
            Time horaInicio,
            Time horaFin,
            String diaInicio,
            String diaFin
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarEmpresaRepartidora(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idEmpresa);
            ps.setString(2, nombre);
            ps.setString(3, telefono);
            ps.setString(4, email);
            ps.setString(5, direccion);
            ps.setBigDecimal(6, cobroEnvio);
            ps.setTime(7, horaInicio);
            ps.setTime(8, horaFin);
            ps.setString(9, diaInicio);
            ps.setString(10, diaFin);

            boolean resultado = ps.execute();

            if(!resultado) {

                System.out.println("Empresa insertada");

            } else {

                System.out.println("No se ejecutó");

            }

        } catch (Exception e) {

            System.out.println("Error al insertar empresa");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // ACTUALIZAR EMPRESA
    // =========================================
    public void actualizarEmpresaRepartidora(
            int idEmpresa,
            String nombre,
            String telefono,
            String email,
            String direccion,
            BigDecimal cobroEnvio,
            Time horaInicio,
            Time horaFin,
            String diaInicio,
            String diaFin
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarEmpresaRepartidora(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            // ID obligatorio
            ps.setInt(1, idEmpresa);

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

            if(cobroEnvio == null){
                ps.setNull(6, Types.DECIMAL);
            } else {
                ps.setBigDecimal(6, cobroEnvio);
            }

            if(horaInicio == null){
                ps.setNull(7, Types.TIME);
            } else {
                ps.setTime(7, horaInicio);
            }

            if(horaFin == null){
                ps.setNull(8, Types.TIME);
            } else {
                ps.setTime(8, horaFin);
            }

            if(diaInicio == null || diaInicio.isBlank()){
                ps.setNull(9, Types.VARCHAR);
            } else {
                ps.setString(9, diaInicio);
            }

            if(diaFin == null || diaFin.isBlank()){
                ps.setNull(10, Types.VARCHAR);
            } else {
                ps.setString(10, diaFin);
            }

            boolean resultado = ps.execute();

            if(!resultado){

                System.out.println("Empresa actualizada");

            } else {

                System.out.println("No se actualizó");
            }

        } catch (Exception e) {

            System.out.println("Error al actualizar empresa");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

}
