package com.aplicacion.dao;

import com.aplicacion.conexion.ConexionBD;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

public class ComprasDAO {

    // =========================================
    // LISTAR COMPRAS
    // =========================================
    public void listarCompras() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Compra";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("\n\n=== COMPRAS REGISTRADAS  ===");

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("Codigo compra: "
                        + rs.getInt("id_compra"));

                System.out.println("Codigo proveedor: "
                        + rs.getString("id_proveedor"));

                System.out.println("Estado: "
                        + rs.getString("estado"));

                System.out.println("Fecha solicitud: "
                        + rs.getString("fecha_compra"));

                System.out.println("Total: "
                        + rs.getString("total"));
            }

        } catch (Exception e) {

            System.out.println("Error al obtener datos de compra. ");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // INSERTAR COMPRA
    // =========================================
    public void insertarCompra(
            int id_compra,
            int id_proveedor
    ){
        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL SP_RegistrarCompra(?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_compra);
            ps.setInt(2, id_proveedor);

            boolean resultado = ps.execute();

            if(!resultado) {

                System.out.println("Compra insertada exitosamente.");

            } else {

                System.out.println("No se ejecutó.");

            }

        } catch (Exception e) {

            System.out.println("Error al insertar compra.");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    //ENTREGAR COMPRA
    public void entregarCompra(
            int id_compra

    ){
        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL SP_CompraEntregada(?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_compra);

            boolean resultado = ps.execute();

            if(!resultado) {

                System.out.println("Compra marcada como \"entregada\" exitosamente.");

            } else {

                System.out.println("No se ejecutó.");

            }

        } catch (Exception e) {

            System.out.println("Error al entregar compra.");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // INSERTAR DETALLE COMPRA
    // =========================================
    public void insertarDetalleCompra(
            int id_detalle_compra,
            int id_compra,
            int id_material,
            int cantidad,
            float precio_unitario
    ){
        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL SP_InsertarDetalleCompra(?, ?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_detalle_compra);
            ps.setInt(2, id_compra);
            ps.setInt(3, id_material);
            ps.setInt(4, cantidad);
            ps.setFloat(5, precio_unitario);

            boolean resultado = ps.execute();

            if(!resultado) {

                System.out.println("Detalle de compra insertado exitosamente.");

            } else {

                System.out.println("No se ejecutó.");

            }

        } catch (Exception e) {

            System.out.println("Error al insertar detalle de compra.");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }
}
