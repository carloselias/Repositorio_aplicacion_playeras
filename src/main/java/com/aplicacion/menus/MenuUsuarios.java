package com.aplicacion.menus;

import com.aplicacion.dao.*;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Scanner;

public class MenuUsuarios {
    Scanner sc = new Scanner(System.in);

    UsuarioDAO daoUsuario = new UsuarioDAO();
    RolDAO daoRol = new RolDAO();
    MovimientoInvMaterialDAO daoInvMateria = new MovimientoInvMaterialDAO();
    MovimientoInvProductoDAO daoInvProducto = new MovimientoInvProductoDAO();

    public void menu() {

        int opcion;

        do {

            System.out.println("\n=== MENU USUARIOS ===");
            System.out.println("1. Usuarios");
            System.out.println("2. Roles");
            System.out.println("3. Permisos");
            System.out.println("4. Asignacion de Rol");
            System.out.println("0. Salir");

            opcion = Integer.parseInt(sc.nextLine());

            switch(opcion){

                // ==================================
                // LISTAR
                // ==================================
                case 1:

                    int opcion2;

                    do {
                        System.out.println("=== Usuario ===");
                        System.out.println("1. Listar usuarios");
                        System.out.println("2. Insertar usuario");
                        System.out.println("3. Modificar usuario");
                        System.out.println("4. Buscar usuario");
                        System.out.println("0. Salir");

                        opcion2 = Integer.parseInt(sc.nextLine());

                        switch (opcion2) {

                            case 1:
                                daoUsuario.listarUsiario();
                                break;

                            case 2:
                                System.out.print("ID: ");
                                int id = Integer.parseInt(sc.nextLine());

                                System.out.print("ID de empleado: ");
                                int id_empleado = Integer.parseInt(sc.nextLine());

                                System.out.print("Usuario: ");
                                String usuario = sc.nextLine();

                                System.out.print("Contrasenia: ");
                                String contrasenia = sc.nextLine();

                                daoUsuario.insertarUsuario(
                                        id,
                                        id_empleado,
                                        usuario,
                                        contrasenia

                                );
                                break;

                            case 3:
                                System.out.println("Campos a actualizar");
                                System.out.print("ID: ");
                                int nuevoid = Integer.parseInt(sc.nextLine());

                                System.out.print("ID de empleado: ");
                                int nuevoid_empleado = Integer.parseInt(sc.nextLine());

                                System.out.print("Usuario: ");
                                String nuevousuario = sc.nextLine();

                                System.out.print("Contrasenia: ");
                                String nuevocontrasenia = sc.nextLine();

                                daoUsuario.actualizarPermiso(
                                        nuevoid,
                                        nuevoid_empleado,
                                        nuevousuario,
                                        nuevocontrasenia
                                );
                                break;

                            case 4:
                                System.out.print("ID: ");
                                int id_buscar = Integer.parseInt(sc.nextLine());

                                daoUsuario.buscarUsuario(id_buscar);
                                break;

                            case 0:
                                System.out.println("Fin");
                                break;
                        }

                    }while (opcion2 != 0);

                    break;

                // ==================================
                // INSERTAR
                // ==================================
                case 2:
                    int opcion3;

                    do {
                        System.out.println("=== ROLES ===");
                        System.out.println("1. Listar roles");
                        System.out.println("2. Insertar rol");
                        System.out.println("3. Modificar rol");
                        System.out.println("4. Buscar rol");
                        System.out.println("0. Salir");

                        opcion3 = Integer.parseInt(sc.nextLine());

                        switch (opcion3) {

                            case 1:
                            daoRol.listarRol();
                            break;

                            case 2:
                                System.out.print("ID: ");
                                int id = Integer.parseInt(sc.nextLine());

                                System.out.print("Nombre: ");
                                String nombre = sc.nextLine();

                                System.out.print("Descripcion: ");
                                String desc = sc.nextLine();

                                daoRol.insertarRol(
                                        id,
                                        nombre,
                                        desc

                                );
                                break;

                            case 3:
                                System.out.println("Campos a actualizar");
                                System.out.print("ID: ");
                                int nuevoid = Integer.parseInt(sc.nextLine());

                                System.out.print("Nombre : ");
                                String nuevonombre = sc.nextLine();

                                System.out.print("Descripcion: ");
                                String nuevadescr = sc.nextLine();

                                daoRol.actualizarRol(
                                        nuevoid,
                                        nuevonombre,
                                        nuevadescr
                                );
                                break;

                            case 4:
                                System.out.print("ID: ");
                                int id_buscar = Integer.parseInt(sc.nextLine());

                                daoRol.BuscarRol(id_buscar);
                                break;

                            case 0:
                                System.out.println("Fin");
                                break;
                        }

                    }while (opcion3 != 0);


                    break;

                // ==================================
                // ACTUALIZAR
                // ==================================
                case 3:
                    daoInvMateria.listarMovMateria();
                    break;

                case 4:
                    daoInvProducto.listarMovProducto();
                    break;

                case 0:

                    System.out.println("Fin");

                    break;
            }

        } while(opcion != 0);
    }


}
