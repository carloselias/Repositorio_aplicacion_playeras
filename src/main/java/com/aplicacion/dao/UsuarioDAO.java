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

                System.out.println("ID de empleado: "
                        + rs.getInt("id_empleado"));

                System.out.println("Usuario: "
                        + rs.getString("usuario"));

                System.out.println("Contraseña: "
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
    // INSERTAR USUARIO
    // =========================================
    public void insertarUsuario(
            int id_credencial,
            int id_empleado,
            String usuario,
            String contrasenia
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarCredencial(?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_credencial);
            ps.setInt(2, id_empleado);
            ps.setString(3, usuario);
            ps.setString(4, contrasenia);


            ps.execute();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // ACTUALIZAR USUARIO
    // =========================================
    public void actualizarPermiso(
            int id_credencial,
            int id_empleado,
            String usuario,
            String contrasenia
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarCredencial(?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            // ID obligatorio
            ps.setInt(1, id_credencial);
            ps.setInt(2, id_empleado);
            ps.setString(3, usuario);
            ps.setString(4, contrasenia);

            ps.execute();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // BUSCAR USUARIO
    // =========================================
    public void buscarUsuario(
            int id
    ) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Credencial WHERE id_credencial = ?";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("ID: "
                        + rs.getInt("id_credencial"));

                System.out.println("ID de empleado: "
                        + rs.getInt("id_empleado"));

                System.out.println("Usuario: "
                        + rs.getString("usuario"));

                System.out.println("Contraseña: "
                        + rs.getString("contrasenia"));
            }

            ps.execute();

        } catch (Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


}
