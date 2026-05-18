package com.aplicacion.menus;

import com.aplicacion.dao.ProduccionDAO;

import java.sql.Date;
import java.util.Scanner;

public class MenuProduccionLotes {
    Scanner sc = new Scanner(System.in);

    ProduccionDAO dao = new ProduccionDAO();

    public void menu() {

        int opcion;

        do {

            System.out.println("\n=== LOTE DE PRODUCCION ===");
            System.out.println("1. Listar lotes de produccion");
            System.out.println("2. Marcar produccion como terminada");
            System.out.println("0. Salir");

            opcion = Integer.parseInt(sc.nextLine());

            switch(opcion){

                // ==================================
                // LISTAR PRODUCCIONES
                // ==================================
                case 1:

                    dao.listarProducciones();

                    break;

                // ==================================
                // TERMINAR PRODUCCION
                // ==================================
                case 2:

                    System.out.print("Codigo produccion a terminar: ");
                    int idTerminar;
                    try{
                        idTerminar =
                                Integer.parseInt(sc.nextLine());
                    }catch(Exception e){
                        System.out.print("El ID no es valido");
                        break;
                    }

                    System.out.print("Fecha terminado (yyyy-MM-dd) o 'now': ");
                    String inputFechaFin = sc.nextLine().trim();
                    Date fechaTerminado = inputFechaFin.equalsIgnoreCase("now")
                            ? new Date(System.currentTimeMillis())
                            : Date.valueOf(inputFechaFin);

                    dao.terminarProduccion(
                            idTerminar,
                            fechaTerminado
                    );

                    break;

                case 0:

                    System.out.println("Fin");

                    break;
            }

        } while(opcion != 0);
    }
}