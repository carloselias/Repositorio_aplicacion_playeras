package com.aplicacion.dao;

import com.aplicacion.conexion.ConexionBD;

import java.sql.*;

public class InventarioProductoDAO {

    // =========================================
    // LISTAR INVENTARIO DE MATERIA PRIMA
    // =========================================
    public void listarProductos() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Inventario_producto";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("\n=== PRODUCTOS EN INVENTARIO ===");

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("ID: "
                        + rs.getInt("id_inventario"));

                System.out.println("ID de Producto: "
                        + rs.getInt("id_producto"));

                System.out.println("ID de almacen: "
                        + rs.getInt("id_almacen"));

                System.out.println("Stock: "
                        + rs.getInt("stock_actual"));
            }

        } catch (Exception e) {

            System.out.println("Error al listar inventario de productos");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // INSERTAR MATERIA PRIMA
    // =========================================
    public void insertarProductoInv(
            int id_inventario,
            int id_producto,
            int id_almacen,
            int stock
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarProductoInv(?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_inventario);
            ps.setInt(2, id_producto);
            ps.setInt(3, id_almacen);
            ps.setInt(4, stock);

            ps.execute();

            SQLWarning warning = ps.getWarnings();
            while (warning != null) {
                System.out.println(warning.getMessage());
                warning = warning.getNextWarning();
            }

        } catch (Exception e) {

            System.out.println("Error al productos");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // ACTUALIZAR INVENTARIO DE PRODUCTOS
    // =========================================
    public void actualizarProductoInv(
            int id_inventario,
            int id_almacen,
            int stock
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarProductoInv(?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            // ID obligatorio
            ps.setInt(1, id_inventario);
            ps.setInt(2, id_almacen);
            ps.setInt(3, stock);

            ps.execute();

            SQLWarning warning = ps.getWarnings();
            while (warning != null) {
                System.out.println(warning.getMessage());
                warning = warning.getNextWarning();
            }

        } catch (Exception e) {

            System.out.println("Error al actualizar producto");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // BUSCAR INVENTARIO DE PRODUCTOS
    // =========================================
    public void BuscarProductoInv(
            int id
    ) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Inventario_producto WHERE id_inventario = ?";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("ID: "
                        + rs.getInt("id_inventario"));

                System.out.println("ID de Producto: "
                        + rs.getInt("id_producto"));

                System.out.println("ID de almacen: "
                        + rs.getInt("id_almacen"));

                System.out.println("Stock: "
                        + rs.getInt("stock_actual"));
            }

        } catch (Exception e) {

            System.out.println("Error al buscar el producto");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

}
