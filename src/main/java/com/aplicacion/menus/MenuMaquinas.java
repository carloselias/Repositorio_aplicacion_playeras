package com.aplicacion.menus;

import com.aplicacion.dao.MaquinasDAO;

import java.util.Scanner;

public class MenuMaquinas {
    Scanner sc = new Scanner(System.in);

    MaquinasDAO dao = new MaquinasDAO();

    public void menu() {

        int opcion;

        do {

            System.out.println("\n=== MAQUINAS ===");
            System.out.println("1. Listar maquinas fisicas");
            System.out.println("2. Agregar maquina fisica");
            System.out.println("3. Modificar maquina fisica");
            System.out.println("4. Eliminar maquina fisica");
            System.out.println("5. Listar tipos de maquina");
            System.out.println("6. Agregar tipo de maquina");
            System.out.println("7. Modificar tipo de maquina");
            System.out.println("0. Salir");

            opcion = Integer.parseInt(sc.nextLine());

            switch(opcion){

                // ==================================
                // LISTAR MAQUINAS
                // ==================================
                case 1:

                    dao.listarMaquinas();

                    break;

                // ==================================
                // INSERTAR MAQUINA
                // ==================================
                case 2:

                    System.out.print("ID maquina: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("ID tipo maquina: ");
                    int idTipo = Integer.parseInt(sc.nextLine());

                    System.out.print("Ubicacion: ");
                    String ubicacion = sc.nextLine();

                    System.out.print("Estado (activa/no activa): ");
                    String estado = sc.nextLine();

                    dao.insertarMaquina(
                            id,
                            idTipo,
                            ubicacion,
                            estado
                    );

                    break;

                // ==================================
                // ACTUALIZAR MAQUINA
                // ==================================
                case 3:

                    System.out.print("ID maquina a modificar: ");
                    int idActualizar;
                    try{
                        idActualizar =
                                Integer.parseInt(sc.nextLine());
                    }catch(Exception e){
                        System.out.print("El ID no es valido");
                        break;
                    }

                    System.out.println("--- campos actualizables (Enter para no cambiar) ---");

                    System.out.print("ID tipo maquina: ");
                    String nuevoIdTipo = sc.nextLine();

                    System.out.print("Ubicacion: ");
                    String nuevaUbicacion = sc.nextLine();

                    System.out.print("Estado (activa/no activa): ");
                    String nuevoEstado = sc.nextLine();

                    dao.actualizarMaquina(
                            idActualizar,
                            nuevoIdTipo,
                            nuevaUbicacion,
                            nuevoEstado
                    );

                    break;

                // ==================================
                // ELIMINAR MAQUINA
                // ==================================
                case 4:

                    System.out.print("ID maquina a eliminar: ");
                    int idEliminar;
                    try{
                        idEliminar =
                                Integer.parseInt(sc.nextLine());
                    }catch(Exception e){
                        System.out.print("El ID no es valido");
                        break;
                    }

                    dao.eliminarMaquina(idEliminar);

                    break;

                // ==================================
                // LISTAR TIPOS DE MAQUINA
                // ==================================
                case 5:

                    dao.listarTipoMaquinas();

                    break;

                // ==================================
                // INSERTAR TIPO MAQUINA
                // ==================================
                case 6:

                    System.out.print("ID tipo maquina: ");
                    int idTipoNuevo = Integer.parseInt(sc.nextLine());

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Descripcion: ");
                    String desc = sc.nextLine();

                    System.out.print("Marca: ");
                    String marca = sc.nextLine();

                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();

                    System.out.print("Voltaje: ");
                    String voltaje = sc.nextLine();

                    dao.insertarTipoMaquina(
                            idTipoNuevo,
                            nombre,
                            desc,
                            marca,
                            modelo,
                            voltaje
                    );

                    break;

                // ==================================
                // ACTUALIZAR TIPO MAQUINA
                // ==================================
                case 7:

                    System.out.print("ID tipo maquina a modificar: ");
                    int idTipoActualizar;
                    try{
                        idTipoActualizar =
                                Integer.parseInt(sc.nextLine());
                    }catch(Exception e){
                        System.out.print("El ID no es valido");
                        break;
                    }

                    System.out.println("--- campos actualizables (Enter para no cambiar) ---");

                    System.out.print("Nombre: ");
                    String nuevoNombre = sc.nextLine();

                    System.out.print("Descripcion: ");
                    String nuevaDesc = sc.nextLine();

                    System.out.print("Marca: ");
                    String nuevaMarca = sc.nextLine();

                    System.out.print("Modelo: ");
                    String nuevoModelo = sc.nextLine();

                    System.out.print("Voltaje: ");
                    String nuevoVoltaje = sc.nextLine();

                    dao.actualizarTipoMaquina(
                            idTipoActualizar,
                            nuevoNombre,
                            nuevaDesc,
                            nuevaMarca,
                            nuevoModelo,
                            nuevoVoltaje
                    );

                    break;

                case 0:

                    System.out.println("Fin");

                    break;
            }

        } while(opcion != 0);
    }
}