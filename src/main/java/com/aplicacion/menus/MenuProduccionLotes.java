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
                // INSERTAR PRODUCCION
                // ==================================
                case 222:

                    System.out.print("Codigo produccion: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Codigo orden: ");
                    int idOrden = Integer.parseInt(sc.nextLine());

                    System.out.print("Costo: ");
                    java.math.BigDecimal costo = new java.math.BigDecimal(sc.nextLine());

                    System.out.print("Fecha iniciado (yyyy-MM-dd) o 'now': ");
                    String inputFechaInicio = sc.nextLine().trim();
                    Date fechaIniciado = inputFechaInicio.equalsIgnoreCase("now")
                            ? new Date(System.currentTimeMillis())
                            : Date.valueOf(inputFechaInicio);

                    dao.insertarProduccion(
                            id,
                            idOrden,
                            costo,
                            fechaIniciado
                    );

                    break;

                // ==================================
                // ACTUALIZAR PRODUCCION
                // ==================================
                case 333:

                    System.out.print("Codigo produccion a actualizar: ");
                    int idActualizar;
                    try{
                        idActualizar =
                                Integer.parseInt(sc.nextLine());
                    }catch(Exception e){
                        System.out.print("El ID no es valido");
                        break;
                    }

                    System.out.println("--- campos actualizables (Enter para no cambiar) ---");

                    System.out.print("Codigo orden: ");
                    String nuevoIdOrden = sc.nextLine();

                    System.out.print("Costo: ");
                    String nuevoCosto = sc.nextLine();

                    System.out.print("Fecha iniciado (yyyy-MM-dd) o 'now': ");
                    String nuevaFechaInicio = sc.nextLine().trim();
                    if(nuevaFechaInicio.equalsIgnoreCase("now")){
                        nuevaFechaInicio = new Date(System.currentTimeMillis()).toString();
                    }

                    dao.actualizarProduccion(
                            idActualizar,
                            nuevoIdOrden,
                            nuevoCosto,
                            nuevaFechaInicio
                    );

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