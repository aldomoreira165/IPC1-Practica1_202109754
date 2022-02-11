package pacman;

import java.util.Scanner;
import java.util.Random;

public class Pacman {

    public static void main(String[] args) {
        int contador = -1;
        menuPrincipal(contador);
    }

    //Creando el método del menú principal
    public static void menuPrincipal(int contador) {
        Scanner lector = new Scanner(System.in);
        String[] nombresJugador = new String[10];
        int[] edadJugador = new int[10];
        int[] punteoJugador = new int[10];
        int[] movimientosJugador = new int[10];
        int opcion;

        do {
            System.out.println("*************************************");
            System.out.println("* --------Bienvenido a Pacman-------*");
            System.out.println("*                                   *");
            System.out.println("* Seleccione una opción:            *");
            System.out.println("*                                   *");
            System.out.println("* [1] Jugar                         *");
            System.out.println("* [2] Historial                     *");
            System.out.println("* [3] Salir                         *");
            System.out.println("*************************************");
            opcion = lector.nextInt();

            switch (opcion) {
                case 1:
                    int filas;
                    int columnas;
                    int cantidadMovimientos = 0;
                    int punteo = 10;
                    int pfAsterisco = 0;
                    int pcAsterisco = 0;
                    int pfDolar = 0;
                    int pcDolar = 0;
                    int pfArroba = 0;
                    int pcArroba = 0;
                    int pfPacman = 0;
                    int pcPacman = 0;
                    int pfAsteriscoI = 0;
                    int pcAsteriscoI = 0;
                    String movimiento = " ";
                    String memoriaDato = " ";
                    Random numeroRandom = new Random();

                    System.out.println("¡Bienvenido (a)! Antes de jugar es necesario que se registre. ");
                    System.out.println("Por favor ingrese su nombre de usuario: ");
                    String nombre = lector.next();
                    System.out.println("Bienvenido (a) " + nombre + ". Por favor ingrese su edad");
                    int edad = lector.nextInt();
                    contador = contador + 1;
                    nombresJugador[contador] = nombre;
                    edadJugador[contador] = edad;

                    do {
                        System.out.println("Por favor ingresa el número de filas que deseas para el tablero. La cantidad de filas debe ser mayor o igual a 8.");
                        filas = lector.nextInt();
                        if (filas < 8) {
                            System.out.println("No puedes ingresar menos de 8 filas.");
                        }
                    } while (filas < 8);
                    filas = filas + 2;

                    do {
                        System.out.println("Por favor ingresa el número de columnas que deseas para el tablero. La cantidad de columnas debe ser mayor o igual a 8.");
                        columnas = lector.nextInt();
                        if (columnas < 8) {
                            System.out.println("No puedes ingresar menos de 8 columnas.");
                        }
                    } while (columnas < 8);
                    columnas = columnas + 2;

                    System.out.println("¡Tablero generado exitosamente!");
                    System.out.println("");
                    //Creando la matriz para mostrar el tablero
                    int salida1 = 0, salida2 = 0, salida3 = -1;
                    if (filas % 2 == 0) {
                        salida1 = (filas / 2) - 1;
                        salida2 = salida1 + 1;
                    } else {
                        salida1 = (((filas - 1) / 2)) - 1;
                        salida2 = salida1 + 1;
                        salida3 = salida2 + 1;
                    }
                    String[][] tablero = new String[filas][columnas];
                    for (int i = 0; i < filas; i++) {
                        for (int j = 0; j < columnas; j++) {
                            if (i == 0 || i == (filas - 1) || j == 0 || j == (columnas - 1)) {
                                if (i == salida1 || i == salida2 || i == salida3) {
                                    tablero[i][j] = " ";
                                } else {
                                    tablero[i][j] = "*";
                                }
                            } else {
                                tablero[i][j] = " ";
                            }
                        }
                    }
                    int cantidadCeldas = filas * columnas;
                    int porcentajeColumnas = ((int) (cantidadCeldas * 0.08));
                    for (int i = 0; i < porcentajeColumnas; i++) {
                        do {
                            pfAsteriscoI = numeroRandom.nextInt(filas - 2) + 1;
                            pcAsteriscoI = numeroRandom.nextInt(columnas - 2) + 1;
                        } while (tablero[pfAsteriscoI][pcAsteriscoI].equals(" ") == false && pcAsteriscoI != 0 && pcAsteriscoI != (columnas - 1));
                        tablero[pfAsteriscoI][pcAsteriscoI] = "*";
                    }
                    do {
                        pfAsterisco = numeroRandom.nextInt(filas - 2) + 1;
                        pcAsterisco = numeroRandom.nextInt(columnas - 2) + 1;
                    } while (tablero[pfAsterisco][pcAsterisco].equals(" ") == false);
                    tablero[pfAsterisco][pcAsterisco] = "#";
                    do {
                        pfDolar = numeroRandom.nextInt(filas - 2) + 1;
                        pcDolar = numeroRandom.nextInt(columnas - 2) + 1;
                    } while (tablero[pfDolar][pcDolar].equals(" ") == false);
                    tablero[pfDolar][pcDolar] = "$";
                    do {
                        pfArroba = numeroRandom.nextInt(filas - 2) + 1;
                        pcArroba = numeroRandom.nextInt(columnas - 2) + 1;
                    } while (tablero[pfArroba][pcArroba].equals(" ") == false);
                    tablero[pfArroba][pcArroba] = "@";
                    do {
                        pfPacman = numeroRandom.nextInt(filas - 2) + 1;
                        pcPacman = numeroRandom.nextInt(columnas - 2) + 1;
                    } while (tablero[pfPacman][pcPacman].equals(" ") == false);
                    tablero[pfPacman][pcPacman] = "V";



                    System.out.println("---------------DATOS DE JUGADOR-----------------");
                    System.out.println("Jugador: " + nombre);
                    System.out.println("Punteo: " + punteo);
                    System.out.println("Cantidad de movimientos: " + cantidadMovimientos);
                    System.out.println("-------------------------------------------------");
                    for (int i = 0; i < filas; i++) {
                        for (int j = 0; j < columnas; j++) {
                            System.out.print(tablero[i][j]);
                        }
                        System.out.println();
                    }

                    do {
                        System.out.println("¿Qúe movimiento desea hacer?");
                        System.out.println("W - Arriba");
                        System.out.println("S - Abajo");
                        System.out.println("D - Derecha");
                        System.out.println("A - Izquierda");
                        System.out.println("M - Ir al menú principal");
                        movimiento = lector.next();

                        if (movimiento.equals("A") || movimiento.equals("D") || movimiento.equals("W") || movimiento.equals("S")) {
                            cantidadMovimientos = cantidadMovimientos + 1;
                        }

                        switch (movimiento) {
                            case "W":
                                int pfPacman2 = pfPacman - 1;
                                memoriaDato = tablero[pfPacman2][pcPacman];
                                if (memoriaDato.equals("*")) {
                                    tablero[pfPacman][pcPacman] = "V";
                                    tablero[pfPacman2][pcPacman] = "*";
                                    pfPacman2 = pfPacman2 + 1;
                                } else {
                                    tablero[pfPacman][pcPacman] = " ";
                                    tablero[pfPacman2][pcPacman] = "V";
                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < columnas; j++) {
                                            if (i == pfPacman2 & j == pcPacman) {
                                                tablero[i][j] = tablero[pfPacman2][pcPacman];
                                                if (memoriaDato.equals("@")) {
                                                    punteo = punteo + 10;
                                                    tablero[pfPacman2][pcPacman] = "V";
                                                    do {
                                                        pfArroba = numeroRandom.nextInt(filas - 2) + 1;
                                                        pcArroba = numeroRandom.nextInt(columnas - 2) + 1;
                                                    }while (tablero[pfArroba][pcArroba].equals(" ") == false);
                                                    tablero[pfArroba][pcArroba] = "@";
                                                    tablero[i][j] = tablero[pfPacman2][pcPacman];
                                                }
                                                if (memoriaDato.equals("$")) {
                                                    punteo = punteo + 15;
                                                    tablero[pfPacman2][pcPacman] = "V";
                                                    do {
                                                        pfDolar = numeroRandom.nextInt(filas - 2) + 1;
                                                        pcDolar = numeroRandom.nextInt(columnas - 2) + 1;
                                                    }while (tablero[pfDolar][pcDolar].equals(" ") == false);
                                                    tablero[pfDolar][pcDolar] = "$";
                                                    tablero[i][j] = tablero[pfPacman2][pcPacman];
                                                }
                                                if (memoriaDato.equals("#")) {
                                                    punteo = punteo - 10;
                                                    tablero[pfPacman2][pcPacman] = "V";
                                                    do {
                                                        pfAsterisco = numeroRandom.nextInt(filas - 2) + 1;
                                                        pcAsterisco = numeroRandom.nextInt(columnas - 2) + 1;
                                                    }while (tablero[pfAsterisco][pcAsterisco].equals(" ") == false);
                                                    tablero[pfAsterisco][pcAsterisco] = "#";
                                                    tablero[i][j] = tablero[pfPacman2][pcPacman];
                                                }
                                            }
                                        }
                                    }
                                }
                                if (punteo >= 100){
                                    punteo = 100;
                                }
                                if (punteo <= 0){
                                    punteo = 0;
                                }
                                punteoJugador[contador] = punteo;
                                movimientosJugador[contador] = cantidadMovimientos;
                                pfPacman = pfPacman2;
                                System.out.println("---------------DATOS DE JUGADOR-----------------");
                                System.out.println("Jugador: " + nombre);
                                System.out.println("Punteo: " + punteo);
                                System.out.println("Cantidad de movimientos: " + cantidadMovimientos);
                                System.out.println("-------------------------------------------------");

                                for (int i = 0; i < filas; i++) {
                                    for (int j = 0; j < columnas; j++) {
                                        System.out.print(tablero[i][j]);
                                    }
                                    System.out.println();
                                }

                                if (punteo <= 0) {
                                    System.out.println("Has perdido. Vuelve a intentarlo.");
                                    movimiento = "M";
                                    System.out.println(" ");
                                }

                                if (punteo >= 100) {
                                    System.out.println("¡Felicidades, ha ganado!");
                                    movimiento = "M";
                                    System.out.println(" ");
                                }
                                break;
                            case "A":
                                int pcPacman2 = pcPacman - 1;
                                memoriaDato = tablero[pfPacman][pcPacman2];
                                if (memoriaDato.equals("*")) {
                                    tablero[pfPacman][pcPacman] = "V";
                                    tablero[pfPacman][pcPacman2] = "*";
                                    pcPacman2 = pcPacman2 + 1;
                                } else {
                                    tablero[pfPacman][pcPacman] = " ";
                                    tablero[pfPacman][pcPacman2] = "V";
                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < columnas; j++) {
                                            if (i == pfPacman & j == pcPacman2) {

                                                if (pcPacman2 == 0) {
                                                    tablero[pfPacman][pcPacman2] = " ";
                                                    tablero[i][j] = tablero[pfPacman][pcPacman2];
                                                    pcPacman2 = columnas - 2;
                                                    j = pcPacman2;
                                                    tablero[pfPacman][pcPacman2] = "V";
                                                    tablero[i][j] = tablero[pfPacman][pcPacman2];
                                                } else {
                                                    tablero[i][j] = tablero[pfPacman][pcPacman2];
                                                }
                                                if (memoriaDato.equals("@")) {
                                                    punteo = punteo + 10;
                                                    tablero[pfPacman][pcPacman2] = "V";
                                                    do {
                                                        pfArroba = numeroRandom.nextInt(filas - 2) + 1;
                                                        pcArroba = numeroRandom.nextInt(columnas - 2) + 1;
                                                    }while (tablero[pfArroba][pcArroba].equals(" ") == false);
                                                    tablero[pfArroba][pcArroba] = "@";
                                                    tablero[i][j] = tablero[pfPacman][pcPacman2];
                                                }
                                                if (memoriaDato.equals("$")) {
                                                    punteo = punteo + 15;
                                                    tablero[pfPacman][pcPacman2] = "V";
                                                    do {
                                                        pfDolar = numeroRandom.nextInt(filas - 2) + 1;
                                                        pcDolar = numeroRandom.nextInt(columnas - 2) + 1;
                                                    }while (tablero[pfDolar][pcDolar].equals(" ")==false);
                                                    tablero[pfDolar][pcDolar] = "$";
                                                    tablero[i][j] = tablero[pfPacman][pcPacman2];
                                                }
                                                if (memoriaDato.equals("#")) {
                                                    punteo = punteo - 10;
                                                    tablero[pfPacman][pcPacman2] = "V";
                                                    do {
                                                        pfAsterisco = numeroRandom.nextInt(filas - 2) + 1;
                                                        pcAsterisco = numeroRandom.nextInt(columnas - 2) + 1;
                                                    }while (tablero[pfAsterisco][pcAsterisco].equals(" ") == false);
                                                    tablero[pfAsterisco][pcAsterisco] = "#";
                                                    tablero[i][j] = tablero[pfPacman][pcPacman2];
                                                }
                                            }
                                        }
                                    }
                                }
                                if (punteo >= 100){
                                    punteo = 100;
                                }
                                if (punteo <= 0){
                                    punteo = 0;
                                }
                                punteoJugador[contador] = punteo;
                                movimientosJugador[contador] = cantidadMovimientos;
                                pcPacman = pcPacman2;
                                System.out.println("---------------DATOS DE JUGADOR-----------------");
                                System.out.println("Jugador: " + nombre);
                                System.out.println("Punteo: " + punteo);
                                System.out.println("Cantidad de movimientos: " + cantidadMovimientos);
                                System.out.println("-------------------------------------------------");

                                for (int i = 0; i < filas; i++) {
                                    for (int j = 0; j < columnas; j++) {
                                        System.out.print(tablero[i][j]);
                                    }
                                    System.out.println();
                                }

                                if (punteo <= 0) {
                                    System.out.println("Has perdido. Vuelve a intentarlo.");
                                    movimiento = "M";
                                    System.out.println(" ");
                                }

                                if (punteo >= 100) {
                                    System.out.println("¡Felicidades, ha ganado!");
                                    movimiento = "M";
                                    System.out.println(" ");
                                }
                                break;
                            case "S":
                                pfPacman2 = pfPacman + 1;
                                memoriaDato = tablero[pfPacman2][pcPacman];
                                if (memoriaDato.equals("*")) {
                                    tablero[pfPacman][pcPacman] = "V";
                                    tablero[pfPacman2][pcPacman] = "*";
                                    pfPacman2 = pfPacman2 - 1;
                                } else {
                                    tablero[pfPacman][pcPacman] = " ";
                                    tablero[pfPacman2][pcPacman] = "V";
                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < columnas; j++) {
                                            if (i == pfPacman2 & j == pcPacman) {
                                                tablero[i][j] = tablero[pfPacman2][pcPacman];
                                                if (memoriaDato.equals("@")) {
                                                    punteo = punteo + 10;
                                                    tablero[pfPacman2][pcPacman] = "V";
                                                    do {
                                                        pfArroba = numeroRandom.nextInt(filas - 2) + 1;
                                                        pcArroba = numeroRandom.nextInt(columnas - 2) + 1;
                                                    }while (tablero[pfArroba][pcArroba].equals(" ") == false);
                                                    tablero[pfArroba][pcArroba] = "@";
                                                    tablero[i][j] = tablero[pfPacman2][pcPacman];
                                                }
                                                if (memoriaDato.equals("$")) {
                                                    punteo = punteo + 15;
                                                    tablero[pfPacman2][pcPacman] = "V";
                                                    do {
                                                        pfDolar = numeroRandom.nextInt(filas - 2) + 1;
                                                        pcDolar = numeroRandom.nextInt(columnas - 2) + 1;
                                                    }while (tablero[pfDolar][pcDolar].equals(" ")==false);
                                                    tablero[pfDolar][pcDolar] = "$";
                                                    tablero[i][j] = tablero[pfPacman2][pcPacman];
                                                }
                                                if (memoriaDato.equals("#")) {
                                                    punteo = punteo - 10;
                                                    tablero[pfPacman2][pcPacman] = "V";
                                                    do {
                                                        pfAsterisco = numeroRandom.nextInt(filas - 2) + 1;
                                                        pcAsterisco = numeroRandom.nextInt(columnas - 2) + 1;
                                                    }while (tablero[pfAsterisco][pcAsterisco].equals(" ") == false);
                                                    tablero[pfAsterisco][pcAsterisco] = "#";
                                                    tablero[i][j] = tablero[pfPacman2][pcPacman];
                                                }
                                            }
                                        }
                                    }
                                }
                                if (punteo >= 100){
                                    punteo = 100;
                                }
                                if (punteo <= 0){
                                    punteo = 0;
                                }
                                punteoJugador[contador] = punteo;
                                movimientosJugador[contador] = cantidadMovimientos;
                                pfPacman = pfPacman2;
                                System.out.println("---------------DATOS DE JUGADOR-----------------");
                                System.out.println("Jugador: " + nombre);
                                System.out.println("Punteo: " + punteo);
                                System.out.println("Cantidad de movimientos: " + cantidadMovimientos);
                                System.out.println("-------------------------------------------------");

                                for (int i = 0; i < filas; i++) {
                                    for (int j = 0; j < columnas; j++) {
                                        System.out.print(tablero[i][j]);
                                    }
                                    System.out.println();
                                }
                                if (punteo <= 0) {
                                    System.out.println("Has perdido. Vuelve a intentarlo.");
                                    movimiento = "M";
                                    System.out.println(" ");
                                }

                                if (punteo >= 100) {
                                    System.out.println("¡Felicidades, ha ganado!");
                                    movimiento = "M";
                                    System.out.println(" ");
                                }
                                break;
                            case "D":
                                pcPacman2 = pcPacman + 1;
                                memoriaDato = tablero[pfPacman][pcPacman2];
                                if (memoriaDato.equals("*")) {
                                    tablero[pfPacman][pcPacman] = "V";
                                    tablero[pfPacman][pcPacman2] = "*";
                                    pcPacman2 = pcPacman2 - 1;
                                } else {
                                    tablero[pfPacman][pcPacman] = " ";
                                    tablero[pfPacman][pcPacman2] = "V";
                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < columnas; j++) {
                                            if (i == pfPacman & j == pcPacman2) {
                                                if (pcPacman2 == (columnas - 1)) {
                                                    tablero[pfPacman][pcPacman2] = " ";
                                                    tablero[i][j] = tablero[pfPacman][pcPacman2];
                                                    pcPacman2 = 1;
                                                    j = pcPacman2;
                                                    tablero[pfPacman][pcPacman2] = "V";
                                                    tablero[i][j] = tablero[pfPacman][pcPacman2];
                                                } else {
                                                    tablero[i][j] = tablero[pfPacman][pcPacman2];
                                                }
                                                if (memoriaDato.equals("@")) {
                                                    punteo = punteo + 10;
                                                    tablero[pfPacman][pcPacman2] = "V";
                                                    do {
                                                        pfArroba = numeroRandom.nextInt(filas - 2) + 1;
                                                        pcArroba = numeroRandom.nextInt(columnas - 2) + 1;
                                                    }while (tablero[pfArroba][pcArroba].equals(" ") == false);
                                                    tablero[pfArroba][pcArroba] = "@";
                                                    tablero[i][j] = tablero[pfPacman][pcPacman2];
                                                }
                                                if (memoriaDato.equals("$")) {
                                                    punteo = punteo + 15;
                                                    tablero[pfPacman][pcPacman2] = "V";
                                                    do {
                                                        pfDolar = numeroRandom.nextInt(filas - 2) + 1;
                                                        pcDolar = numeroRandom.nextInt(columnas - 2) + 1;
                                                    }while (tablero[pfDolar][pcDolar].equals(" ") == false);
                                                    tablero[pfDolar][pcDolar] = "$";
                                                    tablero[i][j] = tablero[pfPacman][pcPacman2];
                                                }
                                                if (memoriaDato.equals("#")) {
                                                    punteo = punteo - 10;
                                                    tablero[pfPacman][pcPacman2] = "V";
                                                    do {
                                                        pfAsterisco = numeroRandom.nextInt(filas - 2) + 1;
                                                        pcAsterisco = numeroRandom.nextInt(columnas - 2) + 1;
                                                    }while (tablero[pfAsterisco][pcAsterisco].equals(" ") == false);
                                                    tablero[pfAsterisco][pcAsterisco] = "#";
                                                    tablero[i][j] = tablero[pfPacman][pcPacman2];
                                                }
                                            }
                                        }
                                    }
                                }
                                if (punteo >= 100){
                                    punteo = 100;
                                }
                                if (punteo <= 0){
                                    punteo = 0;
                                }
                                punteoJugador[contador] = punteo;
                                movimientosJugador[contador] = cantidadMovimientos;
                                pcPacman = pcPacman2;
                                System.out.println("---------------DATOS DE JUGADOR-----------------");
                                System.out.println("Jugador: " + nombre);
                                System.out.println("Punteo: " + punteo);
                                System.out.println("Cantidad de movimientos: " + cantidadMovimientos);
                                System.out.println("-------------------------------------------------");

                                for (int i = 0; i < filas; i++) {
                                    for (int j = 0; j < columnas; j++) {
                                        System.out.print(tablero[i][j]);
                                    }
                                    System.out.println();
                                }

                                if (punteo <= 0) {
                                    System.out.println("Has perdido. Vuelve a intentarlo.");
                                    movimiento = "M";
                                    System.out.println(" ");
                                }

                                if (punteo >= 100) {
                                    System.out.println("¡Felicidades, ha ganado!");
                                    movimiento = "M";
                                    System.out.println(" ");
                                }
                                break;
                            case "M":
                                movimiento = "M";
                                break;
                            default:
                                System.out.println("Ingrese una opción válida o asegúrese de activar las mayúsculas.");
                                break;
                        }
                    } while (movimiento.equals("M") == false);
                    break;
                case 2:
                    System.out.println("-------------HISTORIAL---------------");

                    //Para llenar espacios vacíos
                    for (int i = 0; i < 10; i++) {
                        if (edadJugador[i] == 0) {
                            nombresJugador[i] = "----";
                            edadJugador[i] = 0;
                            punteoJugador[i] = 0;
                            movimientosJugador[i] = 0;
                        }
                    }

                    //Imprimir historial
                    for (int i = 0; i < 10; i++) {
                        if (edadJugador[i] == 0) {
                            System.out.print("");
                        } else {
                            System.out.println("Nombre: " + nombresJugador[i]);
                            System.out.println("Edad: " + edadJugador[i]);
                            System.out.println("Punteo: " + punteoJugador[i]);
                            System.out.println("Movimientos: " + movimientosJugador[i]);
                            System.out.println("*************************************");
                        }
                    }
                    System.out.println(" ");
                    break;
                case 3:
                    System.out.println("Has salido de PACMAN. ¡Gracias por jugar!");
                    break;
                default:
                    System.out.println("Ingrese una opción valida");
                    break;
            }
        } while (opcion != 3);

    }


}




