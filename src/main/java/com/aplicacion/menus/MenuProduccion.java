package com.aplicacion.menus;

import com.aplicacion.dao.ProveedoresDAO;

import java.util.Scanner;

public class MenuProduccion {
    Scanner sc = new Scanner(System.in);

    ProveedoresDAO dao = new ProveedoresDAO();

    public void menu() {

        int opcion;

        do {

            System.out.println("\n=== PRODUCCION ===");
            System.out.println("1. Catalogo procesos");
            System.out.println("2. Registro de ordenes de produccion (para lote)");
            System.out.println("3. Registro de producciones (lotes)");
            System.out.println("4. Registros de procesos (fases de cada lote)");
            System.out.println("5. Maquinas");
            System.out.println("6.Ver registro de empleados involucrados");
            System.out.println("0. Salir");

            opcion = Integer.parseInt(sc.nextLine());

            switch(opcion){

                case 1:
                    MenuProcesos MenuProcesos = new MenuProcesos();
                    MenuProcesos.menu();
                    break;

                case 2:
                    MenuOrdenProduccion MenuOrdenProduccion = new MenuOrdenProduccion();
                    MenuOrdenProduccion.menu();
                    break;

                case 0:

                    System.out.println("Fin");

                    break;
            }

        } while(opcion != 0);
    }

}
