package com.aplicacion.menus;

import java.math.BigDecimal;
import com.aplicacion.dao.ProductosDAO;

import java.util.Scanner;

public class MenuProductos {
    Scanner sc = new Scanner(System.in);
    ProductosDAO dao = new ProductosDAO();
    public void menu() {
        int opcion;
        do {
            System.out.println("\n=== MENU DE ENVIOS ===");
            System.out.println("1. Insertar producto");
            System.out.println("2. Consultar producto");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Listar recetas producto");
            System.out.println("5. Insertar recetas producto");
            System.out.println("6. Actualizar recetas producto");
            System.out.println("0. Salir");

            opcion = Integer.parseInt(sc.nextLine());

            switch(opcion) {
                // ==================================
                // INSERTAR PRODUCTO
                // ==================================
                case 1:

                    System.out.print("ID producto: ");

                    int idProducto =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("ID playera: ");

                    int idPlayera =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("ID diseño: ");

                    int idDisenio =
                            Integer.parseInt(sc.nextLine());

                    dao.insertarProducto(
                            idProducto,
                            idPlayera,
                            idDisenio
                    );

                    break;
                // ==================================
                // CONSULTAR PRODUCTO
                // ==================================
                case 2:

                    System.out.print(
                            "ID producto (ENTER para NULL): "
                    );

                    String inputProducto =
                            sc.nextLine();

                    Integer idConsulta = null;

                    if(!inputProducto.isBlank()){

                        idConsulta =
                                Integer.parseInt(inputProducto);
                    }

                    System.out.print(
                            "Campos (ej: 1,2,5 o ENTER para NULL): "
                    );

                    String campos =
                            sc.nextLine();

                    dao.consultarProducto(
                            idConsulta,
                            campos
                    );

                    break;
                // ==================================
                // ACTUALIZAR PRODUCTO
                // ==================================
                case 3:

                    System.out.print("ID producto: ");

                    int idActualizar =
                            Integer.parseInt(sc.nextLine());

                    System.out.print(
                            "Nuevo costo (ENTER para NULL): "
                    );

                    String costoInput =
                            sc.nextLine();

                    BigDecimal costo = null;

                    if(!costoInput.isBlank()){

                        costo =
                                new BigDecimal(costoInput);
                    }

                    System.out.print(
                            "Nuevo precio venta (ENTER para NULL): "
                    );

                    String ventaInput =
                            sc.nextLine();

                    BigDecimal precioVenta = null;

                    if(!ventaInput.isBlank()){

                        precioVenta =
                                new BigDecimal(ventaInput);
                    }

                    System.out.print(
                            "Nuevo precio empresa (ENTER para NULL): "
                    );

                    String empresaInput =
                            sc.nextLine();

                    BigDecimal precioEmpresa = null;

                    if(!empresaInput.isBlank()){

                        precioEmpresa =
                                new BigDecimal(empresaInput);
                    }

                    dao.actualizarProducto(
                            idActualizar,
                            costo,
                            precioVenta,
                            precioEmpresa
                    );

                    break;
                // ==================================
                // LISTAR RECETAS PRODUCTO
                // ==================================
                case 4:

                    dao.listarRecetasProducto();

                    break;
                // ==================================
                // INSERTAR RECETA PRODUCTO
                // ==================================
                case 5:

                    System.out.print("ID receta: ");

                    int idReceta =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("ID producto: ");

                    int idProducto2 =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("ID materia: ");

                    int idMateria =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Cantidad usada: ");

                    BigDecimal cantidadUsada =
                            new BigDecimal(sc.nextLine());

                    dao.insertarRecetaProducto(
                            idReceta,
                            idProducto2,
                            idMateria,
                            cantidadUsada
                    );

                    break;
                // ==================================
                // ACTUALIZAR RECETA PRODUCTO
                // ==================================
                case 6:

                    System.out.print("ID receta: ");

                    int idActualizarReceta =
                            Integer.parseInt(sc.nextLine());

                    System.out.print(
                            "Nuevo ID producto (ENTER para NULL): "
                    );

                    String productoInput =
                            sc.nextLine();

                    Integer nuevoProducto = null;

                    if(!productoInput.isBlank()){

                        nuevoProducto =
                                Integer.parseInt(productoInput);
                    }

                    System.out.print(
                            "Nuevo ID materia (ENTER para NULL): "
                    );

                    String materiaInput =
                            sc.nextLine();

                    Integer nuevaMateria = null;

                    if(!materiaInput.isBlank()){

                        nuevaMateria =
                                Integer.parseInt(materiaInput);
                    }

                    System.out.print(
                            "Nueva cantidad usada (ENTER para NULL): "
                    );

                    String cantidadInput =
                            sc.nextLine();

                    BigDecimal nuevaCantidad = null;

                    if(!cantidadInput.isBlank()){

                        nuevaCantidad =
                                new BigDecimal(cantidadInput);
                    }

                    dao.actualizarRecetaProducto(
                            idActualizarReceta,
                            nuevoProducto,
                            nuevaMateria,
                            nuevaCantidad
                    );

                    break;
                case 0:

                    System.out.println("Volviendo a menú principal");

                    break;
            }
        } while(opcion != 0);
    }

}
