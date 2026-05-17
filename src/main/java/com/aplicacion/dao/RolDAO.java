package com.aplicacion.dao;

import com.aplicacion.conexion.ConexionBD;

import javax.print.DocFlavor;
import java.sql.*;

public class RolDAO {

    // =========================================
    // LISTAR ROLES
    // =========================================
    public void listarRol() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Rol";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("\n=== ROLES REGISTRADOS  ===");

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("ID: "
                        + rs.getInt("id_rol"));

                System.out.println("Nombre: "
                        + rs.getString("nombre"));

                System.out.println("Descripcion: "
                        + rs.getString("descr"));
            }

        } catch (Exception e) {

            System.out.println("Error al listar roles");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // INSERTAR ROL
    // =========================================
    public void insertarRol(
            int id_rol,
            String nombre,
            String descr
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarRol(?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_rol);
            ps.setString(2, nombre);
            ps.setString(3, descr);

            ps.execute();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // ACTUALIZAR ROL
    // =========================================
    public void actualizarRol(
            int id_rol,
            String nombre,
            String descr
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarRol(?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            // ID obligatorio
            ps.setInt(1, id_rol);
            ps.setString(2, nombre);
            ps.setString(3, descr);

            ps.execute();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // BUSCAR ROL
    // =========================================
    public void BuscarRol(
            int id
    ) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Rol WHERE id_rol = ?";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("ID: "
                        + rs.getInt("id_rol"));

                System.out.println("Nombre: "
                        + rs.getString("nombre"));

                System.out.println("Descripcion: "
                        + rs.getString("descr"));

            }

        } catch (Exception e) {

            System.out.println("Error al buscar rol");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


}
