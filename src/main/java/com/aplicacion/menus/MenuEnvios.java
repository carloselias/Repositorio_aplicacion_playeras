package com.aplicacion.menus;

import com.aplicacion.dao.EnviosDAO;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Scanner;

public class MenuEnvios {

    Scanner sc = new Scanner(System.in);

    EnviosDAO dao = new EnviosDAO();

    public void menu() {

        int opcion;

        do {

            System.out.println("\n=== MENU DE ENVIOS ===");
            System.out.println("1. Listar empresas");
            System.out.println("2. Insertar empresa");
            System.out.println("3. Actualizar empresa");
            System.out.println("4. Buscar envio");
            System.out.println("5. Listar envios");
            System.out.println("6. Insertar envio producto");
            System.out.println("7. Insertar detalle envio");
            System.out.println("8. Actualizar estado envio");
            System.out.println("0. Salir");

            opcion = Integer.parseInt(sc.nextLine());

            switch(opcion) {

                // ==================================
                // LISTAR
                // ==================================
                case 1:

                    dao.listarEmpresasRepartidoras();

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

                    System.out.print("Cobro envio: ");
                    BigDecimal cobro =
                            new BigDecimal(sc.nextLine());

                    System.out.print("Hora inicio (HH:MM:SS): ");
                    Time horaInicio =
                            Time.valueOf(sc.nextLine());

                    System.out.print("Hora fin (HH:MM:SS): ");
                    Time horaFin =
                            Time.valueOf(sc.nextLine());

                    System.out.print("Dia inicio: ");
                    String diaInicio = sc.nextLine();

                    System.out.print("Dia fin: ");
                    String diaFin = sc.nextLine();

                    dao.insertarEmpresaRepartidora(
                            id,
                            nombre,
                            telefono,
                            email,
                            direccion,
                            cobro,
                            horaInicio,
                            horaFin,
                            diaInicio,
                            diaFin
                    );

                    break;

                // ==================================
                // ACTUALIZAR
                // ==================================
                case 3:

                    System.out.print("ID empresa: ");
                    int idActualizar =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Nombre: ");
                    String nuevoNombre = sc.nextLine();

                    System.out.print("Telefono: ");
                    String nuevoTelefono = sc.nextLine();

                    System.out.print("Email: ");
                    String nuevoEmail = sc.nextLine();

                    System.out.print("Direccion: ");
                    String nuevaDireccion = sc.nextLine();

                    dao.actualizarEmpresaRepartidora(
                            idActualizar,
                            nuevoNombre,
                            nuevoTelefono,
                            nuevoEmail,
                            nuevaDireccion,
                            null,
                            null,
                            null,
                            null,
                            null
                    );

                    break;

                // ==================================
                // BUSCAR ENVIO
                // ==================================
                case 4:

                    System.out.print("Ingrese ID envio: ");

                    int idBuscar =
                            Integer.parseInt(sc.nextLine());

                    dao.buscarEnvioPorId(idBuscar);

                    break;

                // ==================================
                // LISTAR ENVIOS
                // ==================================
                case 5:

                    dao.listarEnvios();

                    break;

                // ==================================
                // INSERTAR ENVIO PRODUCTO
                // ==================================
                case 6:

                    System.out.print("ID envio: ");

                    int idEnvio =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("ID factura: ");

                    int idFactura =
                            Integer.parseInt(sc.nextLine());

                    // Mostrar empresas repartidoras
                    dao.listarEmpresasRepartidorasCompacto();

                    System.out.print(
                            "\nID empresa repartidora: "
                    );

                    int idEmpresa =
                            Integer.parseInt(sc.nextLine());

                    dao.insertarEnvioProducto(
                            idEnvio,
                            idFactura,
                            idEmpresa
                    );

                    break;

                // ==================================
                // INSERTAR DETALLE ENVIO
                // ==================================
                case 7:

                    System.out.print("ID envio: ");

                    int idEnvioDetalle =
                            Integer.parseInt(sc.nextLine());

                    System.out.print(
                            "ID detalle factura: "
                    );

                    int idDetalleFactura =
                            Integer.parseInt(sc.nextLine());

                    dao.insertarDetalleEnvio(
                            idEnvioDetalle,
                            idDetalleFactura
                    );

                    break;

                // ==================================
                // ACTUALIZAR ESTADO ENVIO
                // ==================================
                case 8:

                    System.out.print("ID envio: ");

                    int idActualizarEnvio =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Nuevo estado: ");

                    String estado =
                            sc.nextLine();

                    dao.actualizarEstadoEnvio(
                            idActualizarEnvio,
                            estado
                    );

                    break;

                case 0:

                    System.out.println("Volviendo a menú principal");

                    break;
            }

        } while(opcion != 0);
    }
}