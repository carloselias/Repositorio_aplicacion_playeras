package com.aplicacion.menus;

import java.math.BigDecimal;
import com.aplicacion.dao.PlayerasDAO;

import java.util.Scanner;

public class MenuPlayeras {
    Scanner sc = new Scanner(System.in);
    PlayerasDAO dao = new PlayerasDAO();
    public void menu() {
        int opcion;

        do {

            System.out.println("\n=== MENU DE PLAYERAS ===");
            System.out.println("\n-- LISTAR --          -- INSERTAR --          -- ACTUALIZAR --");
            System.out.println("1. Listar Talla         7. Insertar Playeras    13. Actualizar Playeras");
            System.out.println("2. Listar Color         8. Insertar Talla       14. Actualizar Talla");
            System.out.println("3. Listar Manga         9. Insertar Color       15. Actualizar Color");
            System.out.println("4. Listar Cuello        10. Insertar Manga      16. Actualizar Manga");
            System.out.println("5. Listar Corte         11. Insertar Cuello     17. Actualizar Cuello");
            System.out.println("6. Listar Playeras      12. Insertar Corte      18. Actualizar Corte");
            System.out.println("\n-- SALIR --");
            System.out.println("0. Salir");

            opcion = Integer.parseInt(sc.nextLine());

            switch(opcion) {

                // ==================================
                // LISTAR TALLAS
                // ==================================
                case 1:

                    dao.listarTallas();

                    break;
                // ==================================
                // LISTAR COLORES
                // ==================================
                case 2:

                    dao.listarColores();

                    break;
                // ==================================
                // LISTAR MANGAS
                // ==================================
                case 3:

                    dao.listarMangas();

                    break;
                // ==================================
                // LISTAR CUELLOS
                // ==================================
                case 4:

                    dao.listarCuellos();

                    break;
                // ==================================
                // LISTAR CORTES
                // ==================================
                case 5:

                    dao.listarCortes();

                    break;
                // ==================================
                // LISTAR PLAYERAS
                // ==================================
                case 6:

                    dao.listarPlayeras();

                    break;
                // ==================================
                // INSERTAR PLAYERA
                // ==================================
                case 7:

                    System.out.print("ID playera: ");

                    int idPlayera =
                            Integer.parseInt(sc.nextLine());

                    dao.listarTallas();

                    System.out.print("ID talla: ");

                    int idTalla =
                            Integer.parseInt(sc.nextLine());

                    dao.listarColores();

                    System.out.print("ID color: ");

                    int idColor =
                            Integer.parseInt(sc.nextLine());

                    dao.listarMangas();

                    System.out.print("ID manga: ");

                    int idManga =
                            Integer.parseInt(sc.nextLine());

                    dao.listarCuellos();

                    System.out.print("ID cuello: ");

                    int idCuello =
                            Integer.parseInt(sc.nextLine());

                    dao.listarCortes();

                    System.out.print("ID corte: ");

                    int idCorte =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Costo base: ");

                    BigDecimal costoBase =
                            new BigDecimal(sc.nextLine());

                    dao.insertarPlayera(
                            idPlayera,
                            idTalla,
                            idColor,
                            idManga,
                            idCuello,
                            idCorte,
                            costoBase
                    );

                    break;
                // ==================================
                // INSERTAR TALLA
                // ==================================
                case 8:

                    System.out.print("ID talla: ");

                    int nuevaTalla =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Nombre: ");

                    String nombreTalla =
                            sc.nextLine();

                    dao.insertarTalla(
                            nuevaTalla,
                            nombreTalla
                    );

                    break;
                // ==================================
                // INSERTAR COLOR
                // ==================================
                case 9:

                    System.out.print("ID color: ");

                    int nuevoColor =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Nombre: ");

                    String nombreColor =
                            sc.nextLine();

                    dao.insertarColor(
                            nuevoColor,
                            nombreColor
                    );

                    break;
                // ==================================
                // INSERTAR MANGA
                // ==================================
                case 10:

                    System.out.print("ID manga: ");

                    int nuevaManga =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Nombre: ");

                    String nombreManga =
                            sc.nextLine();

                    dao.insertarManga(
                            nuevaManga,
                            nombreManga
                    );

                    break;
                // ==================================
                // INSERTAR CUELLO
                // ==================================
                case 11:

                    System.out.print("ID cuello: ");

                    int nuevoCuello =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Nombre: ");

                    String nombreCuello =
                            sc.nextLine();

                    dao.insertarCuello(
                            nuevoCuello,
                            nombreCuello
                    );

                    break;
                // ==================================
                // INSERTAR CORTE
                // ==================================
                case 12:

                    System.out.print("ID corte: ");

                    int nuevoCorte =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Nombre: ");

                    String nombreCorte =
                            sc.nextLine();

                    dao.insertarCorte(
                            nuevoCorte,
                            nombreCorte
                    );

                    break;
                // ==================================
                // ACTUALIZAR PLAYERA
                // ==================================
                case 13:

                    System.out.print("ID playera: ");

                    int idActualizarPlayera =
                            Integer.parseInt(sc.nextLine());

                    dao.listarTallas();

                    System.out.print(
                            "Nuevo ID talla (ENTER para NULL): "
                    );

                    String tallaInput =
                            sc.nextLine();

                    Integer idTallaActualizar = null;

                    if(!tallaInput.isBlank()){

                        idTallaActualizar =
                                Integer.parseInt(tallaInput);
                    }

                    dao.listarColores();

                    System.out.print(
                            "Nuevo ID color (ENTER para NULL): "
                    );

                    String colorInput =
                            sc.nextLine();

                    Integer idColorActualizar = null;

                    if(!colorInput.isBlank()){

                        idColorActualizar =
                                Integer.parseInt(colorInput);
                    }

                    dao.listarMangas();

                    System.out.print(
                            "Nuevo ID manga (ENTER para NULL): "
                    );

                    String mangaInput =
                            sc.nextLine();

                    Integer idMangaActualizar = null;

                    if(!mangaInput.isBlank()){

                        idMangaActualizar =
                                Integer.parseInt(mangaInput);
                    }

                    dao.listarCuellos();

                    System.out.print(
                            "Nuevo ID cuello (ENTER para NULL): "
                    );

                    String cuelloInput =
                            sc.nextLine();

                    Integer idCuelloActualizar = null;

                    if(!cuelloInput.isBlank()){

                        idCuelloActualizar =
                                Integer.parseInt(cuelloInput);
                    }

                    dao.listarCortes();

                    System.out.print(
                            "Nuevo ID corte (ENTER para NULL): "
                    );

                    String corteInput =
                            sc.nextLine();

                    Integer idCorteActualizar = null;

                    if(!corteInput.isBlank()){

                        idCorteActualizar =
                                Integer.parseInt(corteInput);
                    }

                    System.out.print(
                            "Nuevo costo base (ENTER para NULL): "
                    );

                    String costoInput =
                            sc.nextLine();

                    BigDecimal costoActualizar = null;

                    if(!costoInput.isBlank()){

                        costoActualizar =
                                new BigDecimal(costoInput);
                    }

                    dao.actualizarPlayera(
                            idActualizarPlayera,
                            idTallaActualizar,
                            idColorActualizar,
                            idMangaActualizar,
                            idCuelloActualizar,
                            idCorteActualizar,
                            costoActualizar
                    );

                    break;
                // ==================================
                // ACTUALIZAR TALLA
                // ==================================
                case 14:

                    System.out.print("ID talla: ");

                    int idActualizarTalla =
                            Integer.parseInt(sc.nextLine());

                    System.out.print(
                            "Nuevo nombre (ENTER para NULL): "
                    );

                    String nuevaTalla2 =
                            sc.nextLine();

                    dao.actualizarTalla(
                            idActualizarTalla,
                            nuevaTalla2
                    );

                    break;
                // ==================================
                // ACTUALIZAR COLOR
                // ==================================
                case 15:

                    System.out.print("ID color: ");

                    int idActualizarColor =
                            Integer.parseInt(sc.nextLine());

                    System.out.print(
                            "Nuevo nombre (ENTER para NULL): "
                    );

                    String nuevoColor2 =
                            sc.nextLine();

                    dao.actualizarColor(
                            idActualizarColor,
                            nuevoColor2
                    );

                    break;
                // ==================================
                // ACTUALIZAR MANGA
                // ==================================
                case 16:

                    System.out.print("ID manga: ");

                    int idActualizarManga =
                            Integer.parseInt(sc.nextLine());

                    System.out.print(
                            "Nuevo nombre (ENTER para NULL): "
                    );

                    String nuevaManga2 =
                            sc.nextLine();

                    dao.actualizarManga(
                            idActualizarManga,
                            nuevaManga2
                    );

                    break;
                // ==================================
                // ACTUALIZAR CUELLO
                // ==================================
                case 17:

                    System.out.print("ID cuello: ");

                    int idActualizarCuello =
                            Integer.parseInt(sc.nextLine());

                    System.out.print(
                            "Nuevo nombre (ENTER para NULL): "
                    );

                    String nuevoCuello2 =
                            sc.nextLine();

                    dao.actualizarCuello(
                            idActualizarCuello,
                            nuevoCuello2
                    );

                    break;
                // ==================================
                // ACTUALIZAR CORTE
                // ==================================
                case 18:

                    System.out.print("ID corte: ");

                    int idActualizarCorte =
                            Integer.parseInt(sc.nextLine());

                    System.out.print(
                            "Nuevo nombre (ENTER para NULL): "
                    );

                    String nuevoCorte2 =
                            sc.nextLine();

                    dao.actualizarCorte(
                            idActualizarCorte,
                            nuevoCorte2
                    );

                    break;
                case 0:

                    System.out.println("Volviendo a menú principal");

                    break;
            }
        } while(opcion != 0);
    }
}
