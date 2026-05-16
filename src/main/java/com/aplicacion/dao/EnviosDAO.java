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
            e.getMessage();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // INSERTAR EMPRESA
    // =========================================
    public void insertarEmpresaRepartidora(int idEmpresa, String nombre, String telefono, String email, String direccion, BigDecimal cobroEnvio, Time horaInicio, Time horaFin, String diaInicio, String diaFin) {

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
            e.getMessage();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // ACTUALIZAR EMPRESA
    // =========================================
    public void actualizarEmpresaRepartidora(int idEmpresa, String nombre, String telefono, String email, String direccion, BigDecimal cobroEnvio, Time horaInicio, Time horaFin, String diaInicio, String diaFin) {

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
            e.getMessage();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
// BUSCAR ENVIO POR ID
// =========================================
    public void buscarEnvioPorId(int idEnvio) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql =
                "SELECT * FROM Envio_producto WHERE id_envio = ?";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareStatement(sql);

            ps.setInt(1, idEnvio);

            rs = ps.executeQuery();

            if(rs.next()){

                System.out.println("\n=== ENVIO ENCONTRADO ===");

                System.out.println("ID envio: "
                        + rs.getInt("id_envio"));

                System.out.println("ID factura: "
                        + rs.getInt("id_factura"));

                System.out.println("ID empresa repartidora: "
                        + rs.getInt("id_empresa_repartidora"));

                System.out.println("Estado: "
                        + rs.getString("estado"));

                System.out.println("Fecha envio: "
                        + rs.getTimestamp("fecha_envio"));

                System.out.println("Fecha recepcion: "
                        + rs.getTimestamp("fecha_recepcion"));

            } else {

                System.out.println(
                        "No existe un envio con ID: "
                                + idEnvio
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // LISTAR ENVIOS
    // =========================================
    public void listarEnvios() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Envio_producto";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            System.out.println("\n=== LISTA DE ENVIOS ===");

            while(rs.next()){

                System.out.println("----------------------------");

                System.out.println("ID envio: "
                        + rs.getInt("id_envio"));

                System.out.println("ID factura: "
                        + rs.getInt("id_factura"));

                System.out.println("ID empresa repartidora: "
                        + rs.getInt("id_empresa_repartidora"));

                System.out.println("Estado: "
                        + rs.getString("estado"));

                System.out.println("Fecha envio: "
                        + rs.getTimestamp("fecha_envio"));

                System.out.println("Fecha recepcion: "
                        + rs.getTimestamp("fecha_recepcion"));
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // LISTAR EMPRESAS REPARTIDORAS COMPACTO
    // =========================================
    public void listarEmpresasRepartidorasCompacto() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql =
                "SELECT id_empresa, nombre " +
                        "FROM Empresa_repartidora";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            System.out.println(
                    "\n=== EMPRESAS REPARTIDORAS ==="
            );

            System.out.printf(
                    "%-10s %-30s%n",
                    "ID",
                    "NOMBRE"
            );

            System.out.println(
                    "-----------------------------------"
            );

            while(rs.next()){

                System.out.printf(
                        "%-10d %-30s%n",
                        rs.getInt("id_empresa"),
                        rs.getString("nombre")
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // INSERTAR ENVIO PRODUCTO
    // =========================================
    public void insertarEnvioProducto(int idEnvio, int idFactura, int idEmpresaRepartidora) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarEnvioProducto(?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idEnvio);

            ps.setInt(2, idFactura);

            ps.setInt(3, idEmpresaRepartidora);

            ps.execute();

            System.out.println(
                    "Envio insertado correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // INSERTAR DETALLE ENVIO
    // =========================================
    public void insertarDetalleEnvio(int idEnvio, int idDetalleFactura) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarDetalleEnvio(?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idEnvio);

            ps.setInt(2, idDetalleFactura);

            ps.execute();

            System.out.println(
                    "Detalle envio insertado correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // ACTUALIZAR ESTADO ENVIO
    // =========================================
    public void actualizarEstadoEnvio(int idEnvio, String estado) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarEstadoEnvioProducto(?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idEnvio);

            ps.setString(2, estado);

            ps.execute();

            System.out.println(
                    "Estado actualizado correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }
}
