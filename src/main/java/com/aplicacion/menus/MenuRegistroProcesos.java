package com.aplicacion.menus;

import com.aplicacion.dao.RegistroProcesosDAO;

import java.sql.Timestamp;
import java.util.Scanner;

public class MenuRegistroProcesos {
    Scanner sc = new Scanner(System.in);

    RegistroProcesosDAO dao = new RegistroProcesosDAO();

    public void menu() {

        int opcion;

        do {

            System.out.println("\n=== REGISTRO DE PROCESOS ===");
            System.out.println("1. Listar procesos");
            System.out.println("2. Iniciar proceso");
            System.out.println("3. Registrar empleado en proceso");
            System.out.println("4. Terminar proceso");
            System.out.println("5. Cancelar proceso");
            System.out.println("6. Consultar empleados en proceso");
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
                // INICIAR PROCESO
                // ==================================
                case 2:

                    System.out.print("ID registro proceso: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("ID detalle orden: ");
                    int idDetalleOrden = Integer.parseInt(sc.nextLine());

                    System.out.print("ID proceso: ");
                    int idProceso = Integer.parseInt(sc.nextLine());

                    System.out.print("Fecha iniciado (yyyy-MM-dd HH:mm:ss) o 'now': ");
                    String inputFechaInicio = sc.nextLine().trim();
                    Timestamp fechaIniciado = inputFechaInicio.equalsIgnoreCase("now")
                            ? new Timestamp(System.currentTimeMillis())
                            : Timestamp.valueOf(inputFechaInicio);

                    System.out.print("Observaciones: ");
                    String observaciones = sc.nextLine();

                    dao.iniciarProceso(
                            id,
                            idDetalleOrden,
                            idProceso,
                            fechaIniciado,
                            observaciones
                    );

                    break;

                // ==================================
                // REGISTRAR EMPLEADO EN PROCESO
                // ==================================
                case 3:

                    System.out.print("ID registro proceso: ");
                    int idRegistro;
                    try{
                        idRegistro =
                                Integer.parseInt(sc.nextLine());
                    }catch(Exception e){
                        System.out.print("El ID no es valido");
                        break;
                    }

                    System.out.print("ID empleado: ");
                    int idEmpleado;
                    try{
                        idEmpleado =
                                Integer.parseInt(sc.nextLine());
                    }catch(Exception e){
                        System.out.print("El ID no es valido");
                        break;
                    }

                    dao.registrarEmpleado(
                            idRegistro,
                            idEmpleado
                    );

                    break;

                // ==================================
                // TERMINAR PROCESO
                // ==================================
                case 4:

                    System.out.print("ID proceso a terminar: ");
                    int idTerminar;
                    try{
                        idTerminar =
                                Integer.parseInt(sc.nextLine());
                    }catch(Exception e){
                        System.out.print("El ID no es valido");
                        break;
                    }

                    System.out.print("Fecha terminado (yyyy-MM-dd HH:mm:ss) o 'now': ");
                    String inputFechaFin = sc.nextLine().trim();
                    Timestamp fechaTerminado = inputFechaFin.equalsIgnoreCase("now")
                            ? new Timestamp(System.currentTimeMillis())
                            : Timestamp.valueOf(inputFechaFin);

                    dao.terminarProceso(
                            idTerminar,
                            fechaTerminado
                    );

                    break;

                // ==================================
                // CANCELAR PROCESO
                // ==================================
                case 5:

                    System.out.print("ID proceso a cancelar: ");
                    int idCancelar;
                    try{
                        idCancelar =
                                Integer.parseInt(sc.nextLine());
                    }catch(Exception e){
                        System.out.print("El ID no es valido");
                        break;
                    }

                    System.out.print("Fecha cancelado (yyyy-MM-dd HH:mm:ss) o 'now': ");
                    String inputFechaCancelar = sc.nextLine().trim();
                    Timestamp fechaCancelado = inputFechaCancelar.equalsIgnoreCase("now")
                            ? new Timestamp(System.currentTimeMillis())
                            : Timestamp.valueOf(inputFechaCancelar);

                    dao.cancelarProceso(
                            idCancelar,
                            fechaCancelado
                    );

                    break;

                // ==================================
                // CONSULTAR EMPLEADOS EN PROCESO
                // ==================================
                case 6:

                    System.out.print("ID registro proceso a consultar: ");
                    int idConsultar;
                    try{
                        idConsultar =
                                Integer.parseInt(sc.nextLine());
                    }catch(Exception e){
                        System.out.print("El ID no es valido");
                        break;
                    }

                    dao.consultarEmpleados(idConsultar);

                    break;

                case 0:

                    System.out.println("Fin");

                    break;
            }

        } while(opcion != 0);
    }
}