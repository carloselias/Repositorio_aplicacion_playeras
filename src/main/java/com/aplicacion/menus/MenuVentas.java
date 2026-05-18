package com.aplicacion.menus;

import com.aplicacion.dao.VentasDAO;

import java.util.Scanner;

public class MenuVentas {
    Scanner sc = new Scanner(System.in);

    VentasDAO dao = new VentasDAO();

    public void menu() {
        int opcion;

        do {

            System.out.println("\n=== MENU DE VENTAS ===");
            System.out.println("1. Insertar Detalle Factura");
            System.out.println("2. Listar Detalles Factura");
            System.out.println("3. Buscar Detalle Factura");
            System.out.println("4. Listar Facturas");
            System.out.println("5. Buscar Facturas");
            System.out.println("6. Aprobar Factura");
            System.out.println("0. Salir");

            opcion = Integer.parseInt(sc.nextLine());

            switch(opcion) {
                // ==================================
                // INSERTAR DETALLE FACTURA FACTURA
                // ==================================
                case 1:

                    System.out.print("ID factura: ");

                    int idFactura =
                            Integer.parseInt(sc.nextLine());

                    System.out.print(
                            "ID cliente (ENTER para dejar campo vacio si la factura ya existe): "
                    );

                    String clienteInput =
                            sc.nextLine();

                    Integer idCliente = null;

                    if(!clienteInput.isBlank()){

                        idCliente =
                                Integer.parseInt(clienteInput);
                    }

                    System.out.print(
                            "ID detalle factura: "
                    );

                    int idDetalle =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("ID producto: ");

                    int idProducto =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Cantidad: ");

                    int cantidad =
                            Integer.parseInt(sc.nextLine());

                    dao.insertarDetalleFacturaFactura(
                            idFactura,
                            idCliente,
                            idDetalle,
                            idProducto,
                            cantidad
                    );

                    break;

                // ==================================
                // LISTAR DETALLE FACTURA
                // ==================================
                case 2:

                    dao.listarDetalleFactura();

                    break;
                // ==================================
                // BUSCAR DETALLE FACTURA
                // ==================================
                case 3:

                    System.out.print(
                            "ID detalle factura: "
                    );

                    int idBuscarDetalle =
                            Integer.parseInt(sc.nextLine());

                    dao.buscarDetalleFactura(
                            idBuscarDetalle
                    );

                    break;
                // ==================================
                // LISTAR FACTURAS
                // ==================================
                case 4:

                    dao.listarFacturas();

                    break;
                // ==================================
                // BUSCAR FACTURA
                // ==================================
                case 5:

                    System.out.print("Codigo factura a buscar: ");

                    int idBuscarFactura =
                            Integer.parseInt(sc.nextLine());

                    dao.buscarFactura(
                            idBuscarFactura
                    );

                    break;

                case 6:
                    System.out.print("\nCodigo factura a pagar: ");
                    int id_pagar = Integer.parseInt(sc.nextLine());
                    dao.pagarFactura(id_pagar);
                    break;
                case 0:

                    System.out.println("Volviendo a menú principal");

                    break;
            }

        } while(opcion != 0);
    }
}
