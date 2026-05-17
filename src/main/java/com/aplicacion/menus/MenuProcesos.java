package com.aplicacion.menus;

import com.aplicacion.dao.ProcesosDAO;

import java.util.Scanner;

public class MenuProcesos {
    Scanner sc = new Scanner(System.in);

    ProcesosDAO dao = new ProcesosDAO();

    public void menu() {

        int opcion;

        do {

            System.out.println("\n=== PROCESOS ===");
            System.out.println("1. Listar procesos");
            System.out.println("2. Agregar proceso");
            System.out.println("3. Modificar proceso");
            System.out.println("0. Salir");

            opcion = Integer.parseInt(sc.nextLine());

            switch(opcion){

                // ==================================
                // LISTAR PROCESOS
                // ==================================
                case 1:

                    dao.listarProcesos();

                    break;

                // ==================================
                // INSERTAR PROCESO
                // ==================================
                case 2:

                    System.out.print("Codigo proceso: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Nombre proceso: ");
                    String nombre = sc.nextLine();

                    System.out.print("Descripcion: ");
                    String descripcion = sc.nextLine();

                    dao.insertarProceso(
                            id,
                            nombre,
                            descripcion
                    );

                    break;

                // ==================================
                // ACTUALIZAR PROCESO
                // ==================================
                case 3:

                    System.out.print("Codigo proceso a actualizar: ");
                    int idActualizar;
                    try{
                        idActualizar =
                                Integer.parseInt(sc.nextLine());
                    }catch(Exception e){
                        System.out.print("El ID no es valido");
                        break;
                    }

                    System.out.println("--- campos actualizables (Enter para no cambiar) ---");

                    System.out.print("Nombre proceso: ");
                    String nuevoNombre = sc.nextLine();

                    System.out.print("Descripcion: ");
                    String nuevaDescripcion = sc.nextLine();

                    dao.actualizarProceso(
                            idActualizar,
                            nuevoNombre,
                            nuevaDescripcion
                    );

                    break;

                case 0:

                    System.out.println("Fin");

                    break;
            }

        } while(opcion != 0);
    }
}