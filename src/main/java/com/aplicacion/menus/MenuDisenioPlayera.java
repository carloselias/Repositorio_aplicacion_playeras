package com.aplicacion.menus;

import com.aplicacion.dao.DisenioPlayeraDAO;

import java.math.BigDecimal;
import java.util.Scanner;

public class MenuDisenioPlayera {
    Scanner sc = new Scanner(System.in);

    DisenioPlayeraDAO dao = new DisenioPlayeraDAO();

    public void menu() {

        int opcion;

        do {

            System.out.println("\n=== DISEÑOS DE PLAYERA ===");
            System.out.println("1. Listar diseños");
            System.out.println("2. Agregar diseño");
            System.out.println("3. Modificar diseño");
            System.out.println("0. Salir");

            opcion = Integer.parseInt(sc.nextLine());

            switch(opcion){

                // ==================================
                // LISTAR DISENIOS
                // ==================================
                case 1:

                    dao.listarDisenios();

                    break;

                // ==================================
                // INSERTAR DISENIO
                // ==================================
                case 2:

                    System.out.print("Codigo diseño: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Descripcion: ");
                    String desc = sc.nextLine();

                    System.out.print("Costo: ");
                    BigDecimal costo = new BigDecimal(sc.nextLine());

                    System.out.print("Activo (1/0): ");
                    boolean activo = sc.nextLine().trim().equals("1");

                    dao.insertarDisenio(
                            id,
                            nombre,
                            desc,
                            costo,
                            activo
                    );

                    break;

                // ==================================
                // ACTUALIZAR DISENIO
                // ==================================
                case 3:

                    System.out.print("Codigo diseño a actualizar: ");
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

                    System.out.print("Descripcion: ");
                    String nuevaDesc = sc.nextLine();

                    System.out.print("Costo: ");
                    String nuevoCosto = sc.nextLine();

                    System.out.print("Activo (1/0): ");
                    String nuevoActivo = sc.nextLine();

                    dao.actualizarDisenio(
                            idActualizar,
                            nuevoNombre,
                            nuevaDesc,
                            nuevoCosto,
                            nuevoActivo
                    );

                    break;

                case 0:

                    System.out.println("Fin");

                    break;
            }

        } while(opcion != 0);
    }
}