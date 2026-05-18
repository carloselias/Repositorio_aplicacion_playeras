package com.aplicacion.dao;

import com.aplicacion.conexion.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

public class MaquinasDAO {

    // =========================================
    // LISTAR MAQUINAS
    // =========================================
    public void listarMaquinas() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Maquina";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("\n\n=== MAQUINAS REGISTRADAS ===");

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("Codigo maquina: "
                        + rs.getInt("id_maquina"));

                System.out.println("Codigo tipo maquina: "
                        + rs.getInt("id_tipomaquina"));

                System.out.println("Ubicacion: "
                        + rs.getString("ubicacion"));

                System.out.println("Estado: "
                        + rs.getString("estado"));
            }

        } catch (Exception e) {

            System.out.println("Error al obtener datos de maquinas.");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // INSERTAR MAQUINA
    // =========================================
    public void insertarMaquina(
            int id_maquina,
            int id_tipomaquina,
            String ubicacion,
            String estado
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarMaquina(?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_maquina);
            ps.setInt(2, id_tipomaquina);
            ps.setString(3, ubicacion);
            ps.setString(4, estado);

            boolean resultado = ps.execute();

            if(!resultado) {

                System.out.println("Maquina insertada con exito.");

            } else {

                System.out.println("No se ejecutó");

            }

        } catch (Exception e) {

            System.out.println("Error al insertar maquina.");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // ACTUALIZAR MAQUINA
    // =========================================
    public void actualizarMaquina(
            int id_maquina,
            String id_tipomaquina,
            String ubicacion,
            String estado
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarMaquina(?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_maquina);

            if(id_tipomaquina == null || id_tipomaquina.isBlank()){
                ps.setNull(2, Types.INTEGER);
            } else {
                ps.setInt(2, Integer.parseInt(id_tipomaquina));
            }

            if(ubicacion == null || ubicacion.isBlank()){
                ps.setNull(3, Types.VARCHAR);
            } else {
                ps.setString(3, ubicacion);
            }

            if(estado == null || estado.isBlank()){
                ps.setNull(4, Types.VARCHAR);
            } else {
                ps.setString(4, estado);
            }

            boolean resultado = ps.execute();

            if(!resultado){

                System.out.println("Maquina actualizada.");

            } else {

                System.out.println("No se actualizó.");
            }

        } catch (Exception e) {

            System.out.println("Error al actualizar maquina.");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // ELIMINAR MAQUINA
    // =========================================
    public void eliminarMaquina(int id_maquina) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_EliminarMaquina(?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_maquina);

            boolean resultado = ps.execute();

            if(!resultado){

                System.out.println("Maquina eliminada.");

            } else {

                System.out.println("No se eliminó.");
            }

        } catch (Exception e) {

            System.out.println("Error al eliminar maquina.");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // LISTAR TIPO MAQUINAS
    // =========================================
    public void listarTipoMaquinas() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Tipo_Maquina";

        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("\n\n=== TIPOS DE MAQUINA REGISTRADOS ===");

            while(rs.next()) {

                System.out.println("----------------------------");

                System.out.println("Codigo tipo maquina: "
                        + rs.getInt("id_tipomaquina"));

                System.out.println("Nombre: "
                        + rs.getString("nombre"));

                System.out.println("Descripcion: "
                        + rs.getString("desc"));

                System.out.println("Marca: "
                        + rs.getString("marca"));

                System.out.println("Modelo: "
                        + rs.getString("modelo"));

                System.out.println("Voltaje: "
                        + rs.getString("voltaje"));
            }

        } catch (Exception e) {

            System.out.println("Error al obtener datos de tipos de maquina.");
            e.printStackTrace();

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // INSERTAR TIPO MAQUINA
    // =========================================
    public void insertarTipoMaquina(
            int id_tipomaquina,
            String nombre,
            String desc,
            String marca,
            String modelo,
            String voltaje
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarTipoMaquina(?, ?, ?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_tipomaquina);
            ps.setString(2, nombre);
            ps.setString(3, desc);
            ps.setString(4, marca);
            ps.setString(5, modelo);
            ps.setString(6, voltaje);

            boolean resultado = ps.execute();

            if(!resultado) {

                System.out.println("Tipo de maquina insertado con exito.");

            } else {

                System.out.println("No se ejecutó");

            }

        } catch (Exception e) {

            System.out.println("Error al insertar tipo de maquina.");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }


    // =========================================
    // ACTUALIZAR TIPO MAQUINA
    // =========================================
    public void actualizarTipoMaquina(
            int id_tipomaquina,
            String nombre,
            String desc,
            String marca,
            String modelo,
            String voltaje
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarTipoMaquina(?, ?, ?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, id_tipomaquina);

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

            if(marca == null || marca.isBlank()){
                ps.setNull(4, Types.VARCHAR);
            } else {
                ps.setString(4, marca);
            }

            if(modelo == null || modelo.isBlank()){
                ps.setNull(5, Types.VARCHAR);
            } else {
                ps.setString(5, modelo);
            }

            if(voltaje == null || voltaje.isBlank()){
                ps.setNull(6, Types.VARCHAR);
            } else {
                ps.setString(6, voltaje);
            }

            boolean resultado = ps.execute();

            if(!resultado){

                System.out.println("Tipo de maquina actualizado.");

            } else {

                System.out.println("No se actualizó.");
            }

        } catch (Exception e) {

            System.out.println("Error al actualizar tipo de maquina.");
            e.printStackTrace();

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }
}