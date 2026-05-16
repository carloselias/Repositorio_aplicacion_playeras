package com.aplicacion.dao;

import com.aplicacion.conexion.ConexionBD;

import java.math.BigDecimal;
import java.sql.*;

public class MovimientoInvProductoDAO {

    // =========================================
    // LISTAR MOVIMIENTOS DE INVENTARIO DE MATERIA PRIMA
    // =========================================
    public void listarMateriaPrima() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Mov_Inv_Producto";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("\n=== MOVIMIENTOS DE PRODUCTOS REGISTRADOS  ===");

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("ID: "
                        + rs.getInt("id_historial"));

                System.out.println("ID de Inventario: "
                        + rs.getInt("id_inventario"));

                System.out.println("Fecha de Registro: "
                        + rs.getTimestamp("fecha_registro"));

                System.out.println("Cantidad Anterior: "
                        + rs.getInt("cantidad_anterior"));

                System.out.println("Cantidad Actual: "
                        + rs.getInt("cantidad_actual"));

                System.out.println("Es Salida: "
                        + rs.getBigDecimal("es_salida"));
            }

        } catch (Exception e) {

            System.out.println("Error al listar los movimientos de productos");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }
}
