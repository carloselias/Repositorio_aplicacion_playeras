package com.aplicacion.dao;

import com.aplicacion.conexion.ConexionBD;

import java.sql.*;

public class MovimientoInvMaterialDAO {

    // =========================================
    // LISTAR MOVIMIENTOS DE INVENTARIO DE MATERIA PRIMA
    // =========================================
    public void listarMateriaPrima() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Mov_Inv_Material";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("\n=== MOVIMIENTOS DE MATERIA PRIMA REGISTRADOS  ===");

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("ID: "
                        + rs.getInt("id_historial"));

                System.out.println("ID de Materia Prima: "
                        + rs.getInt("id_materia"));

                System.out.println("Fecha de Registro: "
                        + rs.getTimestamp("fecha_registro"));

                System.out.println("Cantidad Anterior: "
                        + rs.getInt("cantidad_anterior"));

                System.out.println("Cantidad Actual: "
                        + rs.getInt("cantidad_actual"));

                System.out.println("Entrada: "
                        + rs.getInt("entrada"));

                System.out.println("Salida: "
                        + rs.getInt("salida"));

                System.out.println("Tipo de Movimiento: "
                        + rs.getInt("tipo_movimiento"));

            }

        } catch (Exception e) {

            System.out.println("Error al listar los movimientos de materia prima");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }
}
