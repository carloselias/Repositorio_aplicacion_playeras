package com.aplicacion.dao;

import com.aplicacion.conexion.ConexionBD;

import java.math.BigDecimal;
import java.sql.*;

public class PlayerasDAO {

    // =========================================
    // LISTAR TALLAS
    // =========================================
    public void listarTallas() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Talla";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            System.out.println(
                    "\n=== TALLAS ==="
            );

            while(rs.next()){

                System.out.println(
                        rs.getInt("id_talla")
                                + " - "
                                + rs.getString("nombre")
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error: "
                            + e.getMessage()
            );

        } finally {

            try {
                if(rs != null)
                    rs.close();
            } catch(Exception e){}

            try {
                if(ps != null)
                    ps.close();
            } catch(Exception e){}

            try {
                if(con != null)
                    con.close();
            } catch(Exception e){}
        }
    }

    // =========================================
    // LISTAR COLORES
    // =========================================
    public void listarColores() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Color";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            System.out.println(
                    "\n=== COLORES ==="
            );

            while(rs.next()){

                System.out.println(
                        rs.getInt("id_color")
                                + " - "
                                + rs.getString("nombre")
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error: "
                            + e.getMessage()
            );

        } finally {

            try {
                if(rs != null)
                    rs.close();
            } catch(Exception e){}

            try {
                if(ps != null)
                    ps.close();
            } catch(Exception e){}

            try {
                if(con != null)
                    con.close();
            } catch(Exception e){}
        }
    }

    // =========================================
    // LISTAR MANGAS
    // =========================================
    public void listarMangas() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Manga";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            System.out.println(
                    "\n=== MANGAS ==="
            );

            while(rs.next()){

                System.out.println(
                        rs.getInt("id_manga")
                                + " - "
                                + rs.getString("nombre")
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error: "
                            + e.getMessage()
            );

        } finally {

            try {
                if(rs != null)
                    rs.close();
            } catch(Exception e){}

            try {
                if(ps != null)
                    ps.close();
            } catch(Exception e){}

            try {
                if(con != null)
                    con.close();
            } catch(Exception e){}
        }
    }

    // =========================================
    // LISTAR CUELLOS
    // =========================================
    public void listarCuellos() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Cuello";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            System.out.println(
                    "\n=== CUELLOS ==="
            );

            while(rs.next()){

                System.out.println(
                        rs.getInt("id_cuello")
                                + " - "
                                + rs.getString("nombre")
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error: "
                            + e.getMessage()
            );

        } finally {

            try {
                if(rs != null)
                    rs.close();
            } catch(Exception e){}

            try {
                if(ps != null)
                    ps.close();
            } catch(Exception e){}

            try {
                if(con != null)
                    con.close();
            } catch(Exception e){}
        }
    }

    // =========================================
    // LISTAR CORTES
    // =========================================
    public void listarCortes() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Corte";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            System.out.println(
                    "\n=== CORTES ==="
            );

            while(rs.next()){

                System.out.println(
                        rs.getInt("id_corte")
                                + " - "
                                + rs.getString("nombre")
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error: "
                            + e.getMessage()
            );

        } finally {

            try {
                if(rs != null)
                    rs.close();
            } catch(Exception e){}

            try {
                if(ps != null)
                    ps.close();
            } catch(Exception e){}

            try {
                if(con != null)
                    con.close();
            } catch(Exception e){}
        }
    }

    // =========================================
    // LISTAR PLAYERAS
    // =========================================
    public void listarPlayeras() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql =
                "SELECT " +
                        "p.id_playera, " +
                        "t.nombre AS talla, " +
                        "co.nombre AS color, " +
                        "m.nombre AS manga, " +
                        "cu.nombre AS cuello, " +
                        "cor.nombre AS corte, " +
                        "p.costo_base " +
                        "FROM Playera p " +

                        "INNER JOIN Talla t " +
                        "ON p.id_talla = t.id_talla " +

                        "INNER JOIN Color co " +
                        "ON p.id_color = co.id_color " +

                        "INNER JOIN Manga m " +
                        "ON p.id_manga = m.id_manga " +

                        "INNER JOIN Cuello cu " +
                        "ON p.id_cuello = cu.id_cuello " +

                        "INNER JOIN Corte cor " +
                        "ON p.id_corte = cor.id_corte";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            System.out.println(
                    "\n========== PLAYERAS =========="
            );

            while(rs.next()){

                System.out.println(
                        "-----------------------------"
                );

                System.out.println(
                        "ID Playera: "
                                + rs.getInt("id_playera")
                );

                System.out.println(
                        "Talla: "
                                + rs.getString("talla")
                );

                System.out.println(
                        "Color: "
                                + rs.getString("color")
                );

                System.out.println(
                        "Manga: "
                                + rs.getString("manga")
                );

                System.out.println(
                        "Cuello: "
                                + rs.getString("cuello")
                );

                System.out.println(
                        "Corte: "
                                + rs.getString("corte")
                );

                System.out.println(
                        "Costo base: "
                                + rs.getBigDecimal("costo_base")
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error: "
                            + e.getMessage()
            );

        } finally {

            try {
                if(rs != null)
                    rs.close();
            } catch(Exception e){}

            try {
                if(ps != null)
                    ps.close();
            } catch(Exception e){}

            try {
                if(con != null)
                    con.close();
            } catch(Exception e){}
        }
    }

    // =========================================
    // INSERTAR PLAYERA
    // =========================================
    public void insertarPlayera(int idPlayera, int idTalla, int idColor, int idManga, int idCuello, int idCorte, BigDecimal costoBase) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarPlayera(?, ?, ?, ?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idPlayera);

            ps.setInt(2, idTalla);

            ps.setInt(3, idColor);

            ps.setInt(4, idManga);

            ps.setInt(5, idCuello);

            ps.setInt(6, idCorte);

            ps.setBigDecimal(7, costoBase);

            ps.execute();

            System.out.println(
                    "Playera insertada correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error: "
                            + e.getMessage()
            );

        } finally {

            try {
                if(ps != null)
                    ps.close();
            } catch(Exception e){}

            try {
                if(con != null)
                    con.close();
            } catch(Exception e){}
        }
    }

    // =========================================
    // INSERTAR TALLA
    // =========================================
    public void insertarTalla(int idTalla, String nombre) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarTalla(?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idTalla);

            ps.setString(2, nombre);

            ps.execute();

            System.out.println(
                    "Talla insertada correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error: "
                            + e.getMessage()
            );

        } finally {

            try {
                if(ps != null)
                    ps.close();
            } catch(Exception e){}

            try {
                if(con != null)
                    con.close();
            } catch(Exception e){}
        }
    }

    // =========================================
    // INSERTAR COLOR
    // =========================================
    public void insertarColor(int idColor, String nombre) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarColor(?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idColor);

            ps.setString(2, nombre);

            ps.execute();

            System.out.println(
                    "Color insertado correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error: "
                            + e.getMessage()
            );

        } finally {

            try {
                if(ps != null)
                    ps.close();
            } catch(Exception e){}

            try {
                if(con != null)
                    con.close();
            } catch(Exception e){}
        }
    }

    // =========================================
    // INSERTAR MANGA
    // =========================================
    public void insertarManga(int idManga, String nombre) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarManga(?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idManga);

            ps.setString(2, nombre);

            ps.execute();

            System.out.println(
                    "Manga insertada correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error: "
                            + e.getMessage()
            );

        } finally {

            try {
                if(ps != null)
                    ps.close();
            } catch(Exception e){}

            try {
                if(con != null)
                    con.close();
            } catch(Exception e){}
        }
    }

    // =========================================
    // INSERTAR CUELLO
    // =========================================
    public void insertarCuello(int idCuello, String nombre) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarCuello(?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idCuello);

            ps.setString(2, nombre);

            ps.execute();

            System.out.println(
                    "Cuello insertado correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error: "
                            + e.getMessage()
            );

        } finally {

            try {
                if(ps != null)
                    ps.close();
            } catch(Exception e){}

            try {
                if(con != null)
                    con.close();
            } catch(Exception e){}
        }
    }

    // =========================================
    // INSERTAR CORTE
    // =========================================
    public void insertarCorte(int idCorte, String nombre) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarCorte(?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idCorte);

            ps.setString(2, nombre);

            ps.execute();

            System.out.println(
                    "Corte insertado correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error: "
                            + e.getMessage()
            );

        } finally {

            try {
                if(ps != null)
                    ps.close();
            } catch(Exception e){}

            try {
                if(con != null)
                    con.close();
            } catch(Exception e){}
        }
    }

    // =========================================
    // ACTUALIZAR PLAYERA
    // =========================================
    public void actualizarPlayera(int idPlayera, Integer idTalla, Integer idColor, Integer idManga, Integer idCuello, Integer idCorte, BigDecimal costoBase) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarPlayera(?, ?, ?, ?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idPlayera);

            // ID TALLA
            if(idTalla == null){

                ps.setNull(2, Types.INTEGER);

            } else {

                ps.setInt(2, idTalla);
            }

            // ID COLOR
            if(idColor == null){

                ps.setNull(3, Types.INTEGER);

            } else {

                ps.setInt(3, idColor);
            }

            // ID MANGA
            if(idManga == null){

                ps.setNull(4, Types.INTEGER);

            } else {

                ps.setInt(4, idManga);
            }

            // ID CUELLO
            if(idCuello == null){

                ps.setNull(5, Types.INTEGER);

            } else {

                ps.setInt(5, idCuello);
            }

            // ID CORTE
            if(idCorte == null){

                ps.setNull(6, Types.INTEGER);

            } else {

                ps.setInt(6, idCorte);
            }

            // COSTO BASE
            if(costoBase == null){

                ps.setNull(7, Types.DECIMAL);

            } else {

                ps.setBigDecimal(7, costoBase);
            }

            ps.execute();

            System.out.println(
                    "Playera actualizada correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error: "
                            + e.getMessage()
            );

        } finally {

            try {
                if(ps != null)
                    ps.close();
            } catch(Exception e){}

            try {
                if(con != null)
                    con.close();
            } catch(Exception e){}
        }
    }

    // =========================================
    // ACTUALIZAR TALLA
    // =========================================
    public void actualizarTalla(int idTalla, String nombre) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarTalla(?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idTalla);

            if(nombre == null || nombre.isBlank()){

                ps.setNull(2, Types.VARCHAR);

            } else {

                ps.setString(2, nombre);
            }

            ps.execute();

            System.out.println(
                    "Talla actualizada correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error: "
                            + e.getMessage()
            );

        } finally {

            try {
                if(ps != null)
                    ps.close();
            } catch(Exception e){}

            try {
                if(con != null)
                    con.close();
            } catch(Exception e){}
        }
    }

    // =========================================
    // ACTUALIZAR COLOR
    // =========================================
    public void actualizarColor(int idColor, String nombre) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarColor(?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idColor);

            if(nombre == null || nombre.isBlank()){

                ps.setNull(2, Types.VARCHAR);

            } else {

                ps.setString(2, nombre);
            }

            ps.execute();

            System.out.println(
                    "Color actualizado correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error: "
                            + e.getMessage()
            );

        } finally {

            try {
                if(ps != null)
                    ps.close();
            } catch(Exception e){}

            try {
                if(con != null)
                    con.close();
            } catch(Exception e){}
        }
    }

    // =========================================
    // ACTUALIZAR MANGA
    // =========================================
    public void actualizarManga(int idManga, String nombre) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarManga(?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idManga);

            if(nombre == null || nombre.isBlank()){

                ps.setNull(2, Types.VARCHAR);

            } else {

                ps.setString(2, nombre);
            }

            ps.execute();

            System.out.println(
                    "Manga actualizada correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error: "
                            + e.getMessage()
            );

        } finally {

            try {
                if(ps != null)
                    ps.close();
            } catch(Exception e){}

            try {
                if(con != null)
                    con.close();
            } catch(Exception e){}
        }
    }

    // =========================================
    // ACTUALIZAR CUELLO
    // =========================================
    public void actualizarCuello(int idCuello, String nombre) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarCuello(?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idCuello);

            if(nombre == null || nombre.isBlank()){

                ps.setNull(2, Types.VARCHAR);

            } else {

                ps.setString(2, nombre);
            }

            ps.execute();

            System.out.println(
                    "Cuello actualizado correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error: "
                            + e.getMessage()
            );

        } finally {

            try {
                if(ps != null)
                    ps.close();
            } catch(Exception e){}

            try {
                if(con != null)
                    con.close();
            } catch(Exception e){}
        }
    }

    // =========================================
    // ACTUALIZAR CORTE
    // =========================================
    public void actualizarCorte(int idCorte, String nombre) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarCorte(?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idCorte);

            if(nombre == null || nombre.isBlank()){

                ps.setNull(2, Types.VARCHAR);

            } else {

                ps.setString(2, nombre);
            }

            ps.execute();

            System.out.println(
                    "Corte actualizado correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error: "
                            + e.getMessage()
            );

        } finally {

            try {
                if(ps != null)
                    ps.close();
            } catch(Exception e){}

            try {
                if(con != null)
                    con.close();
            } catch(Exception e){}
        }
    }
}
