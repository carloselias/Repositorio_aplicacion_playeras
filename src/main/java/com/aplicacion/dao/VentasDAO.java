package com.aplicacion.dao;

import com.aplicacion.conexion.ConexionBD;

import java.sql.*;

public class VentasDAO {
    // =========================================
    // INSERTAR DETALLE FACTURA FACTURA
    // =========================================
    public void insertarDetalleFacturaFactura(int idFactura, Integer idCliente, int idDetalleFactura, int idProducto, int cantidad) {

        Connection con = null;
        PreparedStatement ps = null;

        String sql =
                "{CALL sp_InsertarDetalleFacturaFactura(?, ?, ?, ?, ?)}";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareCall(sql);

            ps.setInt(1, idFactura);

            // Puede ser NULL
            if(idCliente == null){

                ps.setNull(2, Types.INTEGER);

            } else {

                ps.setInt(2, idCliente);
            }

            ps.setInt(3, idDetalleFactura);

            ps.setInt(4, idProducto);

            ps.setInt(5, cantidad);

            ps.execute();

            System.out.println(
                    "Detalle factura insertado correctamente"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );

        } finally {

            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // LISTAR DETALLE FACTURA
    // =========================================
    public void listarDetalleFactura() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Detalle_Factura";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            System.out.println(
                    "\n=== DETALLE FACTURA ==="
            );

            while(rs.next()){

                System.out.println("---------------------");

                System.out.println(
                        "ID detalle: "
                                + rs.getInt("id_detalle_factura")
                );

                System.out.println(
                        "ID factura: "
                                + rs.getInt("id_factura")
                );

                System.out.println(
                        "ID producto: "
                                + rs.getInt("id_producto")
                );

                System.out.println(
                        "Cantidad: "
                                + rs.getInt("cantidad")
                );

                System.out.println(
                        "Precio unitario: "
                                + rs.getBigDecimal("precio_unitario")
                );

                System.out.println(
                        "Precio venta: "
                                + rs.getBigDecimal("precio_venta")
                );

                System.out.println(
                        "Subtotal: "
                                + rs.getBigDecimal("subtotal")
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // BUSCAR DETALLE FACTURA
    // =========================================
    public void buscarDetalleFactura(int idDetalleFactura) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql =
                "SELECT * FROM Detalle_Factura " +
                        "WHERE id_detalle_factura = ?";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareStatement(sql);

            ps.setInt(1, idDetalleFactura);

            rs = ps.executeQuery();

            if(rs.next()){

                System.out.println(
                        "\n=== DETALLE ENCONTRADO ==="
                );

                System.out.println(
                        "ID detalle: "
                                + rs.getInt("id_detalle_factura")
                );

                System.out.println(
                        "ID factura: "
                                + rs.getInt("id_factura")
                );

                System.out.println(
                        "ID producto: "
                                + rs.getInt("id_producto")
                );

                System.out.println(
                        "Cantidad: "
                                + rs.getInt("cantidad")
                );

                System.out.println(
                        "Precio unitario: "
                                + rs.getBigDecimal("precio_unitario")
                );

                System.out.println(
                        "Precio venta: "
                                + rs.getBigDecimal("precio_venta")
                );

                System.out.println(
                        "Subtotal: "
                                + rs.getBigDecimal("subtotal")
                );

            } else {

                System.out.println(
                        "Detalle factura no encontrado"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // LISTAR FACTURAS
    // =========================================
    public void listarFacturas() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Factura";

        try {

            con = ConexionBD.getConexion();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            System.out.println(
                    "\n=== FACTURAS ==="
            );

            while(rs.next()){

                System.out.println("---------------------");

                System.out.println(
                        "ID factura: "
                                + rs.getInt("id_factura")
                );

                System.out.println(
                        "ID cliente: "
                                + rs.getInt("id_cliente")
                );

                System.out.println(
                        "Estado: "
                                + rs.getString("estado")
                );

                System.out.println(
                        "Fecha: "
                                + rs.getDate("fecha")
                );

                System.out.println(
                        "Total: "
                                + rs.getBigDecimal("total")
                );

                System.out.println(
                        "Tipo venta: "
                                + rs.getString("tipo_venta")
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );

        } finally {

            try { if(rs != null) rs.close(); } catch(Exception e){}
            try { if(ps != null) ps.close(); } catch(Exception e){}
            try { if(con != null) con.close(); } catch(Exception e){}
        }
    }

    // =========================================
    // BUSCAR FACTURA + DETALLES
    // =========================================
    public void buscarFactura(int idFactura) {

        Connection con = null;

        PreparedStatement psFactura = null;
        PreparedStatement psDetalle = null;

        ResultSet rsFactura = null;
        ResultSet rsDetalle = null;

        String sqlFactura =
                "SELECT * FROM Factura " +
                        "WHERE id_factura = ?";

        String sqlDetalle =
                "SELECT * FROM Detalle_Factura " +
                        "WHERE id_factura = ?";

        try {

            con = ConexionBD.getConexion();

            // =====================================
            // BUSCAR FACTURA
            // =====================================
            psFactura = con.prepareStatement(sqlFactura);

            psFactura.setInt(1, idFactura);

            rsFactura = psFactura.executeQuery();

            if(rsFactura.next()){

                System.out.println(
                        "\n========== FACTURA =========="
                );

                System.out.println(
                        "ID factura: "
                                + rsFactura.getInt("id_factura")
                );

                System.out.println(
                        "ID cliente: "
                                + rsFactura.getInt("id_cliente")
                );

                System.out.println(
                        "Estado: "
                                + rsFactura.getString("estado")
                );

                System.out.println(
                        "Fecha: "
                                + rsFactura.getDate("fecha")
                );

                System.out.println(
                        "Total: "
                                + rsFactura.getBigDecimal("total")
                );

                System.out.println(
                        "Tipo venta: "
                                + rsFactura.getString("tipo_venta")
                );

                // =====================================
                // BUSCAR DETALLES
                // =====================================
                psDetalle =
                        con.prepareStatement(sqlDetalle);

                psDetalle.setInt(1, idFactura);

                rsDetalle =
                        psDetalle.executeQuery();

                System.out.println(
                        "\n====== DETALLES FACTURA ======"
                );

                boolean hayDetalles = false;

                while(rsDetalle.next()){

                    hayDetalles = true;

                    System.out.println(
                            "-------------------------"
                    );

                    System.out.println(
                            "ID detalle: "
                                    + rsDetalle.getInt(
                                    "id_detalle_factura"
                            )
                    );

                    System.out.println(
                            "ID producto: "
                                    + rsDetalle.getInt(
                                    "id_producto"
                            )
                    );

                    System.out.println(
                            "Cantidad: "
                                    + rsDetalle.getInt(
                                    "cantidad"
                            )
                    );

                    System.out.println(
                            "Precio unitario: "
                                    + rsDetalle.getBigDecimal(
                                    "precio_unitario"
                            )
                    );

                    System.out.println(
                            "Precio venta: "
                                    + rsDetalle.getBigDecimal(
                                    "precio_venta"
                            )
                    );

                    System.out.println(
                            "Subtotal: "
                                    + rsDetalle.getBigDecimal(
                                    "subtotal"
                            )
                    );
                }

                if(!hayDetalles){

                    System.out.println(
                            "La factura no tiene detalles."
                    );
                }

            } else {

                System.out.println(
                        "Factura no encontrada"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );

        } finally {

            try {
                if(rsFactura != null)
                    rsFactura.close();
            } catch(Exception e){}

            try {
                if(rsDetalle != null)
                    rsDetalle.close();
            } catch(Exception e){}

            try {
                if(psFactura != null)
                    psFactura.close();
            } catch(Exception e){}

            try {
                if(psDetalle != null)
                    psDetalle.close();
            } catch(Exception e){}

            try {
                if(con != null)
                    con.close();
            } catch(Exception e){}
        }
    }
}
