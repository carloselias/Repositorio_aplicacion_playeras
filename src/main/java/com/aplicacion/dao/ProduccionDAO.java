package com.aplicacion.dao;

import com.aplicacion.conexion.ConexionBD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

public class ProduccionDAO {

    // =========================================
    // LISTAR PRODUCCIONES
    // =========================================
    public void listarProducciones() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Produccion";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("\n\n=== PRODUCCIONES REGISTRADAS ===");

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("Codigo produccion: "
                        + rs.getInt("id_produccion"));

                System.out.println("Codigo orden: "
                        + rs.getInt("id_orden"));

                System.out.println("Costo: "
                        + rs.getBigDecimal("costo"));

                System.out.println("Fecha iniciado: "
                        + rs.getDate("fecha_iniciado"));

                System.out.println("Fecha terminado: "
                        + rs.getDate("fecha_terminado"));
            }

        } catch (Exception e) {

            System.out.println("Error al obtener datos de producciones.");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // INSERTAR PRODUCCION
    // =========================================
    public void insertarProduccion(
            int id_produccion,
            int id_orden,
            java.math.BigDecimal costo,
            Date fecha_iniciado
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarProduccion(?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_produccion);
            ps.setInt(2, id_orden);
            ps.setBigDecimal(3, costo);
            ps.setDate(4, fecha_iniciado);

            boolean resultado = ps.execute();

            if(!resultado) {

                System.out.println("Produccion insertada con exito.");

            } else {

                System.out.println("No se ejecutó");

            }

        } catch (Exception e) {

            System.out.println("Error al insertar produccion.");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // ACTUALIZAR PRODUCCION
    // =========================================
    public void actualizarProduccion(
            int id_produccion,
            String id_orden,
            String costo,
            String fecha_iniciado
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarProduccion(?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            // ID obligatorio
            ps.setInt(1, id_produccion);

            if(id_orden == null || id_orden.isBlank()){
                ps.setNull(2, Types.INTEGER);
            } else {
                ps.setInt(2, Integer.parseInt(id_orden));
            }

            if(costo == null || costo.isBlank()){
                ps.setNull(3, Types.DECIMAL);
            } else {
                ps.setBigDecimal(3, new java.math.BigDecimal(costo));
            }

            if(fecha_iniciado == null || fecha_iniciado.isBlank()){
                ps.setNull(4, Types.DATE);
            } else {
                ps.setDate(4, Date.valueOf(fecha_iniciado));
            }

            boolean resultado = ps.execute();

            if(!resultado){

                System.out.println("Produccion actualizada");

            } else {

                System.out.println("No se actualizó");
            }

        } catch (Exception e) {

            System.out.println("Error al actualizar produccion");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // TERMINAR PRODUCCION
    // =========================================
    public void terminarProduccion(
            int id_produccion,
            Date fecha_terminado
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_TerminarProduccion(?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_produccion);
            ps.setDate(2, fecha_terminado);

            boolean resultado = ps.execute();

            if(!resultado){

                System.out.println("Produccion terminada");

            } else {

                System.out.println("No se pudo terminar");
            }

        } catch (Exception e) {

            System.out.println("Error al terminar produccion");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }
}