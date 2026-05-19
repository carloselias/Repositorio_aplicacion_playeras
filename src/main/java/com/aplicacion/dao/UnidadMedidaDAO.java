package com.aplicacion.dao;

import com.aplicacion.conexion.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

public class UnidadMedidaDAO {

    // =========================================
    // LISTAR UNIDADES DE MEDIDA
    // =========================================
    public void listarUnidades() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Unidad_medida";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("\n\n=== UNIDADES DE MEDIDA REGISTRADAS ===");

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("Codigo unidad: "
                        + rs.getInt("id_unidad_m"));

                System.out.println("Nombre: "
                        + rs.getString("nombre"));

                System.out.println("Abreviatura: "
                        + rs.getString("abreviatura"));
            }

        } catch (Exception e) {

            System.out.println("Error al obtener unidades de medida.");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // INSERTAR UNIDAD DE MEDIDA
    // =========================================
    public void insertarUnidad(
            int id_unidad_m,
            String nombre,
            String abreviatura
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarUnidadMedida(?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_unidad_m);
            ps.setString(2, nombre);
            ps.setString(3, abreviatura);

            boolean resultado = ps.execute();

            if(!resultado) {

                System.out.println("Unidad de medida insertada con exito.");

            } else {

                System.out.println("No se ejecutó");

            }

        } catch (Exception e) {

            System.out.println("Error al insertar unidad de medida.");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // ACTUALIZAR UNIDAD DE MEDIDA
    // =========================================
    public void actualizarUnidad(
            int id_unidad_m,
            String nombre,
            String abreviatura
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarUnidadMedida(?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_unidad_m);

            if(nombre == null || nombre.isBlank()){
                ps.setNull(2, Types.VARCHAR);
            } else {
                ps.setString(2, nombre);
            }

            if(abreviatura == null || abreviatura.isBlank()){
                ps.setNull(3, Types.VARCHAR);
            } else {
                ps.setString(3, abreviatura);
            }

            boolean resultado = ps.execute();

            if(!resultado){

                System.out.println("Unidad de medida actualizada.");

            } else {

                System.out.println("No se actualizó.");
            }

        } catch (Exception e) {

            System.out.println("Error al actualizar unidad de medida.");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // ELIMINAR UNIDAD DE MEDIDA
    // =========================================
    public void eliminarUnidad(int id_unidad_m) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_EliminarUnidadMedida(?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_unidad_m);

            boolean resultado = ps.execute();

            if(!resultado){

                System.out.println("Unidad de medida eliminada.");

            } else {

                System.out.println("No se eliminó.");
            }

        } catch (Exception e) {

            System.out.println("Error al eliminar unidad de medida.");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }
}