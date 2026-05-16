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
            System.out.println("1. Envios");
            System.out.println("2. Clientes");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = leerEntero();

            switch(opcion){

                case 1:

                    MenuEnvios menuEnvios = new MenuEnvios();
                    menuEnvios.menu();

                    break;

                case 2:


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
