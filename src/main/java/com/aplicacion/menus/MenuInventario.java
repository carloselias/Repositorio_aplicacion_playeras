package com.aplicacion.menus;

import com.aplicacion.dao.InventarioMateriaDAO;
import com.aplicacion.dao.InventarioProductoDAO;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Scanner;

public class MenuInventario {
    Scanner sc = new Scanner(System.in);

    InventarioMateriaDAO daoMateria = new InventarioMateriaDAO();
    InventarioProductoDAO daoProducto = new InventarioProductoDAO();

    public void menu() {

        int opcion;

        do {

            System.out.println("\n=== MENU INVENTARIO ===");
            System.out.println("1. Inventario de Materia Prima");
            System.out.println("2. Inventario de Productos");
            System.out.println("3. Movimiento de Inventario de Materia Prima");
            System.out.println("4. Movimiento de Inventario de Productos");
            System.out.println("0. Salir");

            opcion = Integer.parseInt(sc.nextLine());

            switch(opcion){

                // ==================================
                // LISTAR
                // ==================================
                case 1:

                    int opcion2;

                    do {
                        System.out.println("=== Inventario de Materia Prima ===");
                        System.out.println("1. Listar materia prima");
                        System.out.println("2. Insertar materia prima");
                        System.out.println("3. Modificar materia prima");
                        System.out.println("0. Salir");

                        opcion2 = Integer.parseInt(sc.nextLine());

                        switch (opcion2) {

                            case 1:
                                daoMateria.listarMateriaPrima();
                                break;

                            case 2:
                                System.out.print("ID: ");
                                int id = Integer.parseInt(sc.nextLine());

                                System.out.print("ID de unidad de medida: ");
                                int id_unidad_m = Integer.parseInt(sc.nextLine());

                                System.out.print("Nombre: ");
                                String nombre = sc.nextLine();

                                System.out.print("Costo unitario : ");
                                Float costo_unitario = sc.nextFloat();
                                sc.nextLine();

                                System.out.print("Stock: ");
                                int stock = Integer.parseInt(sc.nextLine());

                                daoMateria.insertarMateria(
                                        id,
                                        id_unidad_m,
                                        nombre,
                                        costo_unitario,
                                        stock
                                );
                                break;

                            case 3:
                                System.out.println("Campos a actualizar");
                                System.out.print("ID: ");
                                int nuevoid = Integer.parseInt(sc.nextLine());

                                System.out.print("Costo unitario : ");
                                Float nuevocosto_unitario = sc.nextFloat();
                                sc.nextLine();

                                System.out.print("Stock: ");
                                int nuevostock = Integer.parseInt(sc.nextLine());

                                daoMateria.actualizarMateria(
                                        nuevoid,
                                        nuevocosto_unitario,
                                        nuevostock
                                );
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
                        System.out.println("=== Inventario de Productos ===");
                        System.out.println("1. Listar inventario");
                        System.out.println("2. Insertar producto");
                        System.out.println("3. Modificar producto");
                        System.out.println("4. Buscar producto");
                        System.out.println("0. Salir");

                        opcion3 = Integer.parseInt(sc.nextLine());

                        switch (opcion3) {

                            case 1:
                                daoProducto.listarProductos();
                                break;

                            case 2:
                                System.out.print("ID: ");
                                int id = Integer.parseInt(sc.nextLine());

                                System.out.print("ID de producto: ");
                                int id_producto = Integer.parseInt(sc.nextLine());

                                System.out.print("ID de almacen: ");
                                int id_almacen = Integer.parseInt(sc.nextLine());

                                System.out.print("Stock: ");
                                int stock = Integer.parseInt(sc.nextLine());

                                daoProducto.insertarProductoInv(
                                        id,
                                        id_producto,
                                        id_almacen,
                                        stock
                                );
                                break;

                            case 3:
                                System.out.println("Campos a actualizar");
                                System.out.print("ID: ");
                                int nuevoid = Integer.parseInt(sc.nextLine());

                                System.out.print("ID de almacen: ");
                                int nuevoid_almacen = Integer.parseInt(sc.nextLine());

                                System.out.print("Stock: ");
                                int nuevostock = Integer.parseInt(sc.nextLine());

                                daoProducto.actualizarProductoInv(
                                        nuevoid,
                                        nuevoid_almacen,
                                        nuevostock
                                );
                                break;

                            case 4:
                                System.out.print("ID: ");
                                int id_buscar = Integer.parseInt(sc.nextLine());

                                daoProducto.BuscarProductoInv(id_buscar);
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


                    break;

                case 0:

                    System.out.println("Fin");

                    break;
            }

        } while(opcion != 0);
    }


}
