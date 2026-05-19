package com.aplicacion.menus;

import com.aplicacion.dao.UnidadMedidaDAO;

import java.util.Scanner;

public class MenuUnidadMedida {
    Scanner sc = new Scanner(System.in);

    UnidadMedidaDAO dao = new UnidadMedidaDAO();

    public void menu() {

        int opcion;

        do {

            System.out.println("\n=== UNIDADES DE MEDIDA ===");
            System.out.println("1. Listar unidades de medida");
            System.out.println("2. Agregar unidad de medida");
            System.out.println("3. Modificar unidad de medida");
            System.out.println("4. Eliminar unidad de medida");
            System.out.println("0. Salir");

            opcion = Integer.parseInt(sc.nextLine());

            switch(opcion){

                // ==================================
                // LISTAR UNIDADES
                // ==================================
                case 1:

                    dao.listarUnidades();

                    break;

                // ==================================
                // INSERTAR UNIDAD
                // ==================================
                case 2:

                    System.out.print("ID unidad de medida: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Abreviatura: ");
                    String abreviatura = sc.nextLine();

                    dao.insertarUnidad(
                            id,
                            nombre,
                            abreviatura
                    );

                    break;

                // ==================================
                // ACTUALIZAR UNIDAD
                // ==================================
                case 3:

                    System.out.print("ID unidad de medida a modificar: ");
                    int idActualizar;
                    try{
                        idActualizar =
                                Integer.parseInt(sc.nextLine());
                    }catch(Exception e){
                        System.out.print("El ID no es valido");
                        break;
                    }

                    System.out.println("--- campos actualizables (Enter para no cambiar) ---");

                    System.out.print("Nombre: ");
                    String nuevoNombre = sc.nextLine();

                    System.out.print("Abreviatura: ");
                    String nuevaAbreviatura = sc.nextLine();

                    dao.actualizarUnidad(
                            idActualizar,
                            nuevoNombre,
                            nuevaAbreviatura
                    );

                    break;

                // ==================================
                // ELIMINAR UNIDAD
                // ==================================
                case 4:

                    System.out.print("ID unidad de medida a eliminar: ");
                    int idEliminar;
                    try{
                        idEliminar =
                                Integer.parseInt(sc.nextLine());
                    }catch(Exception e){
                        System.out.print("El ID no es valido");
                        break;
                    }

                    dao.eliminarUnidad(idEliminar);

                    break;

                case 0:

                    System.out.println("Fin");

                    break;
            }

        } while(opcion != 0);
    }
}