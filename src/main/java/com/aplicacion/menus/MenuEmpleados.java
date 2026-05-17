package com.aplicacion.menus;

import com.aplicacion.dao.EmpleadosDAO;
import com.aplicacion.dao.DepartamentosDAO;

import java.util.Scanner;

public class MenuEmpleados {
    Scanner sc = new Scanner(System.in);

    EmpleadosDAO dao = new EmpleadosDAO();
    DepartamentosDAO dao2 = new DepartamentosDAO();

    public void menu() {

        int opcion;

        do {

            System.out.println("\n=== EMPLEADOS ===");
            System.out.println("EMPLEADOS");
            System.out.println("1. Listar empleados");
            System.out.println("2. Agregar empleado");
            System.out.println("3. Modificar empleado\n");
            System.out.println("DEPARTAMENTOS");
            System.out.println("4. Listar departamento");
            System.out.println("5. Agregar departamento");
            System.out.println("6. Modificar departamento\n");
            System.out.println("0. Salir");


            opcion = Integer.parseInt(sc.nextLine());

            switch(opcion){

                // ==================================
                // LISTAR EMPLEADOS
                // ==================================
                case 1:

                    dao.listarEmpleados();

                    break;

                // ==================================
                // INSERTAR EMPLEADOS
                // ==================================
                case 2:

                    System.out.print("Codigo empleado: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Codigo departamento: ");
                    int idDepto = Integer.parseInt(sc.nextLine());

                    System.out.print("DPI: ");
                    int dpi = Integer.parseInt(sc.nextLine());

                    System.out.print("Nombres: ");
                    String nombres = sc.nextLine();

                    System.out.print("Apellidos: ");
                    String apellidos = sc.nextLine();

                    System.out.print("Puesto: ");
                    String puesto = sc.nextLine();

                    System.out.print("Direccion: ");
                    String direccion = sc.nextLine();

                    System.out.print("Telefono: ");
                    String telefono = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    dao.InsertarEmpleado(
                            id,
                            idDepto,
                            dpi,
                            nombres,
                            apellidos,
                            puesto,
                            direccion,
                            telefono,
                            email
                    );

                    break;

                // ==================================
                // ACTUALIZAR EMPLEADOS
                // ==================================
                case 3:

                    System.out.print("ID empleado a actualizar: ");
                    int idActualizar;
                    try{
                        idActualizar =
                                Integer.parseInt(sc.nextLine());
                    }catch(Exception e){
                        System.out.print("El ID no es valido");
                        break;
                    }

                    System.out.println("--- campos actualizables ---");

                    System.out.print("Codigo departamento: ");
                    String inputDepto = sc.nextLine().trim();
                    int nuevoIdDepto = inputDepto.isEmpty() ? 0 : Integer.parseInt(inputDepto);

                    System.out.print("DPI: ");
                    String inputDpi = sc.nextLine().trim();
                    int nuevoDpi = inputDpi.isEmpty() ? 0 : Integer.parseInt(inputDpi);

                    System.out.print("Nombres: ");
                    String nuevoNombres = sc.nextLine();

                    System.out.print("Apellidos: ");
                    String nuevoApellidos = sc.nextLine();

                    System.out.print("Puesto: ");
                    String nuevoPuesto = sc.nextLine();

                    System.out.print("Direccion: ");
                    String nuevaDireccion = sc.nextLine();

                    System.out.print("Telefono: ");
                    String nuevoTelefono = sc.nextLine();

                    System.out.print("Email: ");
                    String nuevoEmail = sc.nextLine();

                    dao.actualizarEmpleado(
                            idActualizar,
                            nuevoIdDepto,
                            nuevoDpi,
                            nuevoNombres,
                            nuevoApellidos,
                            nuevoPuesto,
                            nuevaDireccion,
                            nuevoTelefono,
                            nuevoEmail
                    );

                    break;

                // ==================================
                // LISTAR DEPARTAMENTOS
                // ==================================
                case 4:

                    dao2.listarDepartamentos();

                    break;

                // ==================================
                // INSERTAR DEPARTAMENTO
                // ==================================
                case 5:

                    System.out.print("Codigo departamento: ");
                    int idd = Integer.parseInt(sc.nextLine());

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Ubicacion: ");
                    String ubicacion = sc.nextLine();

                    dao2.insertarDepartamento(
                            idd,
                            nombre,
                            ubicacion
                    );

                    break;



                // ==================================
                // ACTUALIZAR DEPARTAMENTO
                // ==================================
                case 6:

                    System.out.print("Codigo departamento a actualizar: ");
                    int idActualizarD;
                    try{
                        idActualizarD =
                                Integer.parseInt(sc.nextLine());
                    }catch(Exception e){
                        System.out.print("El ID no es valido");
                        break;
                    }

                    System.out.println("--- campos actualizables ---");

                    System.out.print("Nombre: ");
                    String nuevoNombre = sc.nextLine();

                    System.out.print("Ubicacion: ");
                    String nuevaUbicacion = sc.nextLine();

                    dao2.actualizarDepartamento(
                            idActualizarD,
                            nuevoNombre,
                            nuevaUbicacion
                    );

                    break;
                case 0:

                    System.out.println("Fin");

                    break;
            }

        } while(opcion != 0);
    }
}