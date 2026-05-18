package com.aplicacion.dao;

import com.aplicacion.conexion.ConexionBD;

import java.sql.*;

public class InventarioMateriaDAO {

    // =========================================
    // LISTAR Inventario de materia prima
    // =========================================
    public void listarMateriaPrima() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Inv_materia_prima";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("\n=== MATERIA PRIMA REGISTRADA  ===");

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("ID: "
                        + rs.getInt("id_materia"));

                System.out.println("ID unidad de medida: "
                        + rs.getInt("id_unidad_m"));

                System.out.println("Nombre: "
                        + rs.getString("nombre"));

                System.out.println("Costo Unitario: "
                        + rs.getFloat("costo_unitario"));

                System.out.println("Stock: "
                        + rs.getInt("stock_actual"));
            }

        } catch (Exception e) {

            System.out.println("Error al listar inventario de materia prima");
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
    public void insertarMateria(
            int id_materia,
            int id_unidad_m,
            String nombre,
            float costo_unitario,
            int stock
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarMateriaInv(?, ?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_materia);
            ps.setInt(2, id_unidad_m);
            ps.setString(3, nombre);
            ps.setFloat(4, costo_unitario);
            ps.setInt(5, stock);

            ps.execute();

            SQLWarning warning = ps.getWarnings();
            while (warning != null) {
                System.out.println(warning.getMessage());
                warning = warning.getNextWarning();
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
    // ACTUALIZAR MATERIA PRIMA
    // =========================================
    public void actualizarMateria(
            int id_materia,
            float costo_unitario,
            int stock
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarMateriaInv(?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            // ID obligatorio
            ps.setInt(1, id_materia);
            ps.setFloat(2, costo_unitario);
            ps.setInt(3, stock);

            ps.execute();

            // Capturar mensajes PRINT del SP
            SQLWarning warning = ps.getWarnings();
            while (warning != null) {
                System.out.println(warning.getMessage());
                warning = warning.getNextWarning();
            }


        } catch (Exception e) {

            System.out.println("Error al actualizar materia prima");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // BUSCAR MATERIA PRIMA
    // =========================================
    public void BuscarMateriaPrima(
            int id
    ) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Inv_materia_prima WHERE id_materia = ?";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("ID: "
                        + rs.getInt("id_materia"));

                System.out.println("ID unidad de medida: "
                        + rs.getInt("id_unidad_m"));

                System.out.println("Nombre: "
                        + rs.getString("nombre"));

                System.out.println("Costo Unitario: "
                        + rs.getFloat("costo_unitario"));

                System.out.println("Stock: "
                        + rs.getInt("stock_actual"));
            }

        } catch (Exception e) {

            System.out.println("Error al buscar materia prima");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


}
