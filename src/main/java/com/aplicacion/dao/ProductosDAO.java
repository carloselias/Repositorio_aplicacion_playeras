package com.aplicacion.dao;

import com.aplicacion.conexion.ConexionBD;

import java.math.BigDecimal;
import java.sql.*;

public class ProductosDAO {
    // =========================================
    // INSERTAR PRODUCTO
    // =========================================
    public void insertarProducto(int idProducto, int idPlayera, int idDisenio) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarProducto(?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idProducto);

            ps.setInt(2, idPlayera);

            ps.setInt(3, idDisenio);

            ps.execute();

            System.out.println(
                    "Producto insertado correctamente"
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
    // CONSULTAR PRODUCTO
    // =========================================
    public void consultarProducto(Integer idProducto, String campos) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql =
                "{CALL sp_ConsultarProducto(?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            // ID PRODUCTO
            if(idProducto == null){

                ps.setNull(1, Types.INTEGER);

            } else {

                ps.setInt(1, idProducto);
            }

            // CAMPOS
            if(campos == null || campos.isBlank()){

                ps.setNull(2, Types.VARCHAR);

            } else {

                ps.setString(2, campos);
            }

            rs = ps.executeQuery();

            System.out.println(
                    "\n=== PRODUCTOS ==="
            );

            ResultSetMetaData meta =
                    rs.getMetaData();

            int columnas =
                    meta.getColumnCount();

            while(rs.next()){

                System.out.println(
                        "-------------------------"
                );

                for(int i = 1; i <= columnas; i++){

                    System.out.println(
                            meta.getColumnName(i)
                                    + ": "
                                    + rs.getString(i)
                    );
                }
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
    // ACTUALIZAR PRODUCTO
    // =========================================
    public void actualizarProducto(int idProducto, BigDecimal costo, BigDecimal precioVenta, BigDecimal precioEmpresa) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarProducto(?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idProducto);

            // COSTO
            if(costo == null){

                ps.setNull(2, Types.DECIMAL);

            } else {

                ps.setBigDecimal(2, costo);
            }

            // PRECIO VENTA
            if(precioVenta == null){

                ps.setNull(3, Types.DECIMAL);

            } else {

                ps.setBigDecimal(3, precioVenta);
            }

            // PRECIO EMPRESA
            if(precioEmpresa == null){

                ps.setNull(4, Types.DECIMAL);

            } else {

                ps.setBigDecimal(4, precioEmpresa);
            }

            ps.execute();

            System.out.println(
                    "Producto actualizado correctamente"
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
    // LISTAR RECETAS PRODUCTO
    // =========================================
    public void listarRecetasProducto() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql =
                "SELECT * FROM Receta_producto";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            System.out.println(
                    "\n=== RECETAS PRODUCTO ==="
            );

            while(rs.next()){

                System.out.println(
                        "--------------------------"
                );

                System.out.println(
                        "ID receta: "
                                + rs.getInt("id_receta")
                );

                System.out.println(
                        "ID producto: "
                                + rs.getInt("id_producto")
                );

                System.out.println(
                        "ID materia: "
                                + rs.getInt("id_materia")
                );

                System.out.println(
                        "Cantidad usada: "
                                + rs.getBigDecimal(
                                "cantidad_usada"
                        )
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
    // INSERTAR RECETA PRODUCTO
    // =========================================
    public void insertarRecetaProducto(int idReceta, int idProducto, int idMateria, BigDecimal cantidadUsada) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarRecetaProducto(?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idReceta);

            ps.setInt(2, idProducto);

            ps.setInt(3, idMateria);

            ps.setBigDecimal(4, cantidadUsada);

            ps.execute();

            System.out.println(
                    "Receta producto insertada correctamente"
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
    // ACTUALIZAR RECETA PRODUCTO
    // =========================================
    public void actualizarRecetaProducto(int idReceta, Integer idProducto, Integer idMateria, BigDecimal cantidadUsada
    ) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_ActualizarRecetaProducto(?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idReceta);

            // ID PRODUCTO
            if(idProducto == null){

                ps.setNull(2, Types.INTEGER);

            } else {

                ps.setInt(2, idProducto);
            }

            // ID MATERIA
            if(idMateria == null){

                ps.setNull(3, Types.INTEGER);

            } else {

                ps.setInt(3, idMateria);
            }

            // CANTIDAD USADA
            if(cantidadUsada == null){

                ps.setNull(4, Types.DECIMAL);

            } else {

                ps.setBigDecimal(4, cantidadUsada);
            }

            ps.execute();

            System.out.println(
                    "Receta producto actualizada correctamente"
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
