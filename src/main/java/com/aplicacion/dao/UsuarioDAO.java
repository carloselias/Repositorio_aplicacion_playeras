package com.aplicacion.dao;

import com.aplicacion.conexion.ConexionBD;

import java.math.BigDecimal;
import javax.print.DocFlavor;
import java.sql.*;

public class UsuarioDAO {

    // =========================================
    // LISTAR USUARIOS
    // =========================================
    public void listarUsiario() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Credencial";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("\n=== USUARIOS REGISTRADOS  ===");

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("ID: "
                        + rs.getInt("id_credencial"));

                System.out.println("Usuario: "
                        + rs.getString("usuario"));

                System.out.println("Contrasenia: "
                        + rs.getString("contrasenia"));
            }

        } catch (Exception e) {

            System.out.println("Error al listar usuarios");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // INSERTAR PERMISO
    // =========================================
    public void insertarPermiso(
            int id_permiso,
            String desc_accion
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarPermiso(?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_permiso);
            ps.setString(2, desc_accion);


            SQLWarning warning = ps.getWarnings();
            while (warning != null) {
                System.out.println(warning.getMessage());
                warning = warning.getNextWarning();
            }

        } catch (Exception e) {

            System.out.println("Error al insertar permiso");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // ACTUALIZAR PERMISO
    // =========================================
    public void actualizarPermiso(
            int id_permiso,
            String desc_accion
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarPermiso(?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            // ID obligatorio
            ps.setInt(1, id_permiso);
            ps.setString(2, desc_accion);


            SQLWarning warning = ps.getWarnings();
            while (warning != null) {
                System.out.println(warning.getMessage());
                warning = warning.getNextWarning();
            }

        } catch (Exception e) {

            System.out.println("Error al actualizar permiso");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // BUSCAR PERMISO
    // =========================================
    public void BuscarPermiso(
            int id
    ) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Permiso WHERE id_permiso = ?";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("ID: "
                        + rs.getInt("id_permiso"));

                System.out.println("Descripcion: "
                        + rs.getString("desc_accion"));

            }

        } catch (Exception e) {

            System.out.println("Error al buscar permiso");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


}
