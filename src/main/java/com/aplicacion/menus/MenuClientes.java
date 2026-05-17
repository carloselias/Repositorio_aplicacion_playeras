package com.aplicacion.menus;

import com.aplicacion.dao.ClientesDAO;

import java.util.Scanner;

public class MenuClientes {
    Scanner sc = new Scanner(System.in);

    ClientesDAO dao = new ClientesDAO();
    public void menu() {
        int opcion;

        do {
            System.out.println("\n=== MENU DE CLIENTES ===");
            System.out.println("1. Listar clientes");
            System.out.println("2. Insertar Cliente");
            System.out.println("3. Actualizar Cliente");
            System.out.println("4. Consultar Cliente");
            System.out.println("5. Eliminar Cliente");
            System.out.println("0. Salir");

            opcion = Integer.parseInt(sc.nextLine());

            switch(opcion) {

                //LISTAR CLIENTE
                case 1:

                    dao.listarClientes();

                    break;
                // ==================================
                // INSERTAR CLIENTE
                // ==================================
                case 2:

                    System.out.print("ID cliente: ");

                    int idCliente =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("ID tipo cliente: ");

                    int idTipoCliente =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Nombre: ");

                    String nombre =
                            sc.nextLine();

                    System.out.print("Telefono: ");

                    String telefono =
                            sc.nextLine();

                    System.out.print("Email: ");

                    String email =
                            sc.nextLine();

                    System.out.print("Direccion: ");

                    String direccion =
                            sc.nextLine();

                    dao.insertarCliente(
                            idCliente,
                            idTipoCliente,
                            nombre,
                            telefono,
                            email,
                            direccion
                    );

                    break;

                // ==================================
                // ACTUALIZAR CLIENTE
                // ==================================
                case 3:

                    System.out.print("ID cliente: ");

                    int idActualizar =
                            Integer.parseInt(sc.nextLine());

                    System.out.print(
                            "Nuevo nombre (ENTER para NULL): "
                    );

                    String nuevoNombre =
                            sc.nextLine();

                    System.out.print(
                            "Nuevo telefono (ENTER para NULL): "
                    );

                    String nuevoTelefono =
                            sc.nextLine();

                    System.out.print(
                            "Nuevo email (ENTER para NULL): "
                    );

                    String nuevoEmail =
                            sc.nextLine();

                    System.out.print(
                            "Nueva direccion (ENTER para NULL): "
                    );

                    String nuevaDireccion =
                            sc.nextLine();

                    dao.actualizarCliente(
                            idActualizar,
                            nuevoNombre,
                            nuevoTelefono,
                            nuevoEmail,
                            nuevaDireccion
                    );

                    break;

                // ==================================
                // CONSULTAR CLIENTE
                // ==================================
                case 4:

                    System.out.print(
                            "ID cliente (ENTER para NULL): "
                    );

                    String inputId =
                            sc.nextLine();

                    Integer idConsulta = null;

                    if(!inputId.isBlank()){

                        idConsulta =
                                Integer.parseInt(inputId);
                    }

                    System.out.print(
                            "Campos (ej: 1,2,5 o ENTER para NULL): "
                    );

                    String campos =
                            sc.nextLine();

                    dao.consultarCliente(
                            idConsulta,
                            campos
                    );

                    break;
                // ==================================
                // ELIMINAR CLIENTE
                // ==================================
                case 5:

                    System.out.print("ID cliente: ");

                    int idEliminar =
                            Integer.parseInt(sc.nextLine());

                    dao.eliminarCliente(
                            idEliminar
                    );

                    break;

                case 0:

                    System.out.println("Volviendo a menú principal");

                    break;
            }
        } while(opcion != 0);
    }
}
