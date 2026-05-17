package com.aplicacion.dao;

import com.aplicacion.conexion.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

public class DisenioPlayeraDAO {

    // =========================================
    // LISTAR DISENIOS
    // =========================================
    public void listarDisenios() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Disenio_playera";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("\n\n=== DISEÑOS DE PLAYERA REGISTRADOS ===");

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("Codigo disenio: "
                        + rs.getInt("id_disenio"));

                System.out.println("Nombre: "
                        + rs.getString("nombre"));

                System.out.println("Descripcion: "
                        + rs.getString("desc"));

                System.out.println("Costo: "
                        + rs.getBigDecimal("costo"));

                System.out.println("Activo: "
                        + rs.getBoolean("activo"));
            }

        } catch (Exception e) {

            System.out.println("Error al obtener datos de diseños.");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // INSERTAR DISENIO
    // =========================================
    public void insertarDisenio(
            int id_disenio,
            String nombre,
            String desc,
            java.math.BigDecimal costo,
            boolean activo
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarDisenioPlayera(?, ?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_disenio);
            ps.setString(2, nombre);
            ps.setString(3, desc);
            ps.setBigDecimal(4, costo);
            ps.setBoolean(5, activo);

            boolean resultado = ps.execute();

            if(!resultado) {

                System.out.println("Diseño insertado con exito.");

            } else {

                System.out.println("No se ejecutó");

            }

        } catch (Exception e) {

            System.out.println("Error al insertar diseño.");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // ACTUALIZAR DISENIO
    // =========================================
    public void actualizarDisenio(
            int id_disenio,
            String nombre,
            String desc,
            String costo,
            String activo
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarDisenioPlayera(?, ?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            // ID obligatorio
            ps.setInt(1, id_disenio);

            if(nombre == null || nombre.isBlank()){
                ps.setNull(2, Types.VARCHAR);
            } else {
                ps.setString(2, nombre);
            }

            if(desc == null || desc.isBlank()){
                ps.setNull(3, Types.VARCHAR);
            } else {
                ps.setString(3, desc);
            }

            if(costo == null || costo.isBlank()){
                ps.setNull(4, Types.DECIMAL);
            } else {
                ps.setBigDecimal(4, new java.math.BigDecimal(costo));
            }

            if(activo == null || activo.isBlank()){
                ps.setNull(5, Types.BIT);
            } else {
                ps.setBoolean(5, activo.equals("1"));
            }

            boolean resultado = ps.execute();

            if(!resultado){

                System.out.println("Diseño actualizado");

            } else {

                System.out.println("No se actualizó");
            }

        } catch (Exception e) {

            System.out.println("Error al actualizar diseño");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }
}