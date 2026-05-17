package com.aplicacion.menus;

import java.util.Scanner;

public class MenuPrincipal {

    Scanner sc = new Scanner(System.in);

    public void iniciar() {

        int opcion;

        do {

            System.out.println("\n====================");
            System.out.println("   MENU PRINCIPAL");
            System.out.println("====================");
            System.out.println("1. Playeras");
            System.out.println("2. Diseños");
            System.out.println("3. Productos");
            System.out.println("4. Materia prima");
            System.out.println("5. Clientes");
            System.out.println("6. Compra");
            System.out.println("7. Venta");
            System.out.println("8. Inventario");
            System.out.println("9. Producción");
            System.out.println("10. Envíos");
            System.out.println("11. Empleados");
            System.out.println("12. Usuarios");
            System.out.println("13. AUDITORIA");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = leerEntero();

            switch(opcion){


                case 2:
                    MenuDisenioPlayera MenuDisenioPlayera = new MenuDisenioPlayera();
                    MenuDisenioPlayera.menu();

                    break;

                case 5:

                    MenuClientes MenuClientes = new MenuClientes();
                    MenuClientes.menu();

                    break;

                case 6:

                    MenuCompras MenuCompras = new MenuCompras();
                    MenuCompras.menu();

                    break;

                case 7:

                    MenuVentas MenuVentas = new MenuVentas();
                    MenuVentas.menu();

                    break;

                case 8:
                    MenuInventario MenuInventario = new MenuInventario();
                    MenuInventario.menu();
                    break;

                case 9:

                    MenuProduccion MenuProduccion = new MenuProduccion();
                    MenuProduccion.menu();

                    break;

                case 10:

                    MenuEnvios menuEnvios = new MenuEnvios();
                    menuEnvios.menu();

                    break;

                case 11:

                    MenuEmpleados MenuEmpleados = new MenuEmpleados();
                    MenuEmpleados.menu();

                    break;
                case 12:

                    MenuUsuarios MenuUsuarios = new MenuUsuarios();
                    MenuUsuarios.menu();
                    break;

                case 0:

                    System.out.println("Fin del sistema");
                    break;

                default:

                    System.out.println("Opcion invalida");
            }

        } while(opcion != 0);
    }

    private int leerEntero(){

        while(!sc.hasNextInt()){

            System.out.println("Ingrese un numero valido");
            sc.next();

        }

        int numero = sc.nextInt();
        sc.nextLine();

        return numero;
    }
}
