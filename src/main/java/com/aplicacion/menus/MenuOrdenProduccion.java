package com.aplicacion.menus;

import com.aplicacion.dao.OrdenProduccionDAO;

import java.util.Scanner;

public class MenuOrdenProduccion {
    Scanner sc = new Scanner(System.in);

    OrdenProduccionDAO dao = new OrdenProduccionDAO();

    public void menu() {

        int opcion;

        do {

            System.out.println("\n=== ORDENES DE PRODUCCION ===");
            System.out.println("ORDENES");
            System.out.println("1. Listar ordenes");
            System.out.println("2. Autorizar orden (generar produccion)");
            System.out.println("\nDETALLE ORDENES");
            System.out.println("3. Listar detalle de ordenes");
            System.out.println("0. Salir");

            opcion = Integer.parseInt(sc.nextLine());

            switch(opcion){

                // ==================================
                // LISTAR ORDENES
                // ==================================
                case 1:

                    dao.listarOrdenes();
                    break;


                case 2:
                    System.out.print("\nCodigo orden a autorizar: ");
                    int id_aprob = Integer.parseInt(sc.nextLine());
                    dao.aprobarOrden(id_aprob);

                    break;

                case 3:

                    dao.listarDetalleOrdenes();
                    break;

                case 0:

                    System.out.println("Fin");

                    break;
            }

        } while(opcion != 0);
    }
}