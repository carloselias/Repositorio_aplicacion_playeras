package com.aplicacion.menus;

import com.aplicacion.dao.OrdenProduccionDAO;

import java.sql.Timestamp;
import java.util.Scanner;

public class MenuOrdenProduccion {
    Scanner sc = new Scanner(System.in);

    OrdenProduccionDAO dao = new OrdenProduccionDAO();

    public void menu() {

        int opcion;

        do {

            System.out.println("\n=== ORDENES DE PRODUCCION ===");
            System.out.println("ORDENES");
            System.out.println("1. Listar ordenes");
            System.out.println("2. Agregar orden");
            System.out.println("3. Aprobar orden");
            System.out.println("4. Modificar orden");
            System.out.println("\nDETALLE ORDENES");
            System.out.println("5. Listar ordenes");
            System.out.println("0. Salir");

            opcion = Integer.parseInt(sc.nextLine());

            switch(opcion){

                // ==================================
                // LISTAR ORDENES
                // ==================================
                case 1:

                    dao.listarOrdenes();

                    break;

                // ==================================
                // INSERTAR ORDEN
                // ==================================
                case 2:

                    System.out.print("\nCodigo orden: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Codigo factura: ");
                    int idFactura = Integer.parseInt(sc.nextLine());

                    String estado = "No aprobada";

                    System.out.print("Fecha solicitud (yyyy-MM-dd HH:mm:ss) o \"now\"': ");
                    String inputFecha = sc.nextLine().trim();
                    Timestamp fechaSolicitud = inputFecha.equalsIgnoreCase("now")
                            ? new Timestamp(System.currentTimeMillis())
                            : Timestamp.valueOf(inputFecha);

                    dao.insertarOrden(
                            id,
                            idFactura,
                            estado,
                            fechaSolicitud
                    );

                    break;



                case 3:
                    System.out.print("\nCodigo orden a aprobar: ");
                    int id_aprob = Integer.parseInt(sc.nextLine());
                    dao.aprobarOrden(id_aprob);

                    break;
                // ==================================
                // ACTUALIZAR ORDEN
                // ==================================
                case 4:

                    System.out.print("\nCodigo orden a actualizar: ");
                    int idActualizar;
                    try{
                        idActualizar =
                                Integer.parseInt(sc.nextLine());
                    }catch(Exception e){
                        System.out.print("El ID no es valido");
                        break;
                    }

                    System.out.println("--- campos actualizables (Enter para no cambiar) ---");

                    System.out.print("Codigo factura: ");
                    String nuevoIdFactura = sc.nextLine();

                    String nuevoEstado = "";

                    System.out.print("Fecha solicitud (yyyy-MM-dd HH:mm:ss), \"now\" o Enter para no cambiar: ");
                    String nuevaFecha = sc.nextLine().trim();
                    if(nuevaFecha.equalsIgnoreCase("now")){
                        nuevaFecha = new Timestamp(System.currentTimeMillis()).toString();
                    }


                    dao.actualizarOrden(
                            idActualizar,
                            nuevoIdFactura,
                            nuevoEstado,
                            nuevaFecha
                    );

                    break;

                case 0:

                    System.out.println("Fin");

                    break;
            }

        } while(opcion != 0);
    }
}