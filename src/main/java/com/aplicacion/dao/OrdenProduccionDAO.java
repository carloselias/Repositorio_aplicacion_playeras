package com.aplicacion.dao;

import com.aplicacion.conexion.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

public class OrdenProduccionDAO {

    // =========================================
    // LISTAR ORDENES
    // =========================================
    public void listarOrdenes() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Orden_produccion";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("\n\n=== ORDENES DE PRODUCCION REGISTRADAS ===");

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("Codigo orden: "
                        + rs.getInt("id_orden"));

                System.out.println("Codigo factura: "
                        + rs.getInt("id_factura"));

                System.out.println("Estado: "
                        + rs.getString("estado"));

                System.out.println("Fecha solicitud: "
                        + rs.getTimestamp("fecha_solicitud"));
            }

        } catch (Exception e) {

            System.out.println("Error al obtener datos de ordenes.");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // INSERTAR ORDEN
    // =========================================
    public void insertarOrden(
            int id_orden,
            int id_factura,
            String estado,
            java.sql.Timestamp fecha_solicitud
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarOrdenProduccion(?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_orden);
            ps.setInt(2, id_factura);
            ps.setString(3, estado);
            ps.setTimestamp(4, fecha_solicitud);

            boolean resultado = ps.execute();

            if(!resultado) {

                System.out.println("Orden insertada con exito.");

            } else {

                System.out.println("No se ejecutó");

            }

        } catch (Exception e) {

            System.out.println("Error al insertar orden.");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // ACTUALIZAR ORDEN
    // =========================================
    public void actualizarOrden(
            int id_orden,
            String id_factura,
            String estado,
            String fecha_solicitud
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarOrdenProduccion(?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            // ID obligatorio
            ps.setInt(1, id_orden);

            if(id_factura == null || id_factura.isBlank()){
                ps.setNull(2, Types.INTEGER);
            } else {
                ps.setInt(2, Integer.parseInt(id_factura));
            }

            if(estado == null || estado.isBlank()){
                ps.setNull(3, Types.VARCHAR);
            } else {
                ps.setString(3, estado);
            }

            if(fecha_solicitud == null || fecha_solicitud.isBlank()){
                ps.setNull(4, Types.TIMESTAMP);
            } else {
                ps.setTimestamp(4, java.sql.Timestamp.valueOf(fecha_solicitud));
            }

            boolean resultado = ps.execute();

            if(!resultado){

                System.out.println("Orden actualizada");

            } else {

                System.out.println("No se actualizó");
            }

        } catch (Exception e) {

            System.out.println("Error al actualizar orden");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // APROBAR ORDEN
    // =========================================
    public void aprobarOrden(
            int id_orden

    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_AutorizarOrdenProduccion(?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_orden);

            boolean resultado = ps.execute();

            if(!resultado) {

                System.out.println("Orden aprobada con exito.");

            } else {

                System.out.println("No se ejecutó");

            }

        } catch (Exception e) {

            System.out.println("Error al aprobar orden.");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }



    // =========================================
    // LISTAR ORDENES
    // =========================================
    public void listarDetalleOrdenes() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Detalle_orden";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("\n\n=== ORDENES DE PRODUCCION REGISTRADAS ===");

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("Codigo detalle orden: "
                        + rs.getInt("id_detalle_orden"));

                System.out.println("Codigo orden produccion: "
                        + rs.getInt("id_orden_produccion"));

                System.out.println("Codigo del producto: "
                        + rs.getString("id_producto"));

                System.out.println("Cantidad del producto: "
                        + rs.getTimestamp("cantidad"));
            }

        } catch (Exception e) {

            System.out.println("Error al obtener datos de ordenes.");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

}