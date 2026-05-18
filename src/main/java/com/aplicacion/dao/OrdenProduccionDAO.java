package com.aplicacion.dao;

import com.aplicacion.conexion.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
                        + rs.getInt("fecha_solicitud"));
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
    // LISTAR DETALLE ORDENES
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
                        + rs.getInt("cantidad"));
            }

        } catch (Exception e) {

            System.out.println("Error al obtener datos de detalle de ordenes.");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

}