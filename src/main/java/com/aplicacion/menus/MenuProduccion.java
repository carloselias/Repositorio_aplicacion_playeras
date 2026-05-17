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
            System.out.println("2. Catalogo Maquinas");
            System.out.println("3. Maquinas existentes\n");
            System.out.println("4. Ordenes de producción");
            System.out.println("5. Registros de produccion (lotes) ");
            System.out.println("6. Registros de procesos (fases de cada lote)");
            System.out.println("7. Registros de maquinas (en fases de lote) \n");
            System.out.println("0. Salir");

            opcion = Integer.parseInt(sc.nextLine());

            switch(opcion){

                // ==================================
                // LISTAR
                // ==================================
                case 1:

                    dao.listarProveedores();

                    break;

                // ==================================
                // INSERTAR
                // ==================================
                case 2:

                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Telefono: ");
                    String telefono = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Direccion: ");
                    String direccion = sc.nextLine();

                    System.out.print("Estado activo: ");
                    int activo = Integer.parseInt(sc.nextLine());

                    dao.insertarProveedores(
                            id,
                            nombre,
                            telefono,
                            email,
                            direccion,
                            activo
                    );

                    break;

                // ==================================
                // ACTUALIZAR
                // ==================================
                case 3:

                    System.out.print("ID proveedor a actualizar: ");
                    int idActualizar;
                    try{
                        idActualizar =
                                Integer.parseInt(sc.nextLine());
                    }catch(Exception e){
                        System.out.print("El ID no es valido");
                        break;
                    }

                    System.out.print("--- campos actualizables ---\n");
                    System.out.print("Nombre: ");
                    String nuevoNombre = sc.nextLine();

                    System.out.print("Telefono: ");
                    String nuevoTelefono = sc.nextLine();

                    System.out.print("Email: ");
                    String nuevoEmail = sc.nextLine();

                    System.out.print("Direccion: ");
                    String nuevaDireccion = sc.nextLine();

                    System.out.print("Activo: ");
                    String nuevoActivo = sc.nextLine();

                    dao.actualizarProveedor(
                            idActualizar,
                            nuevoNombre,
                            nuevoTelefono,
                            nuevoEmail,
                            nuevaDireccion,
                            nuevoActivo
                    );

                    break;

                case 4:

                    System.out.println("Fin");

                    break;
            }

        } while(opcion != 4);
    }

}
