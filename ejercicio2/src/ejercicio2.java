import crud.Equipo;
import crud.Jugador;

import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args){
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        Jugador j1 = new Jugador("Pepe", "POR", 1);
        Jugador j2 = new Jugador("Juan", "DFC", 4);
        Jugador j3 = new Jugador("Manolo", "MCO", 10);
        Jugador j4 = new Jugador("Fran", "DC", 9);

        jugadores.add(j1);
        jugadores.add(j2);
        jugadores.add(j3);
        jugadores.add(j4);

        Equipo e = new Equipo(jugadores);

        int respuesta = 0;
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("¡Bienvenido!");
        do{
            System.out.println("Seleccione una acción:");
            System.out.println("1. Añadir jugador");
            System.out.println("2. Borrar un jugador (Buscándolo por su dorsal)");
            System.out.println("3. Mostrar todos los jugadores del equipo");
            System.out.println("4. Buscar un jugador por su nombre");
            System.out.println("5. BUscar a todos los jugadores de una misma posicion");
            System.out.println("6. Modificar la posición de un jugador (Buscándolo por su dorsal)");
            System.out.println("7. Ordenar la lista por posiciones.");
            System.out.println("0. Salir");
            respuesta = sc.nextInt();
            switch (respuesta){
                case 1:
                    System.out.println("Introduzca el nombre del jugador \n(Si el nombre es compuesto use guiones bajos)");
                    String name = sc2.next();
                    System.out.println("Introduzca la posición del jugador de forma abreviada (DC --> Delantero centro, MCD --> Medio centro defensivo...)");
                    String posicion = sc2.next();
                    System.out.println("Introduzca el dorsal del jugador");
                    int dorsal = sc2.nextInt();
                    do{
                        if (!e.dorsalDisponible(dorsal)){
                            System.out.println("El dorsal introducido ya corresponde a otro jugador, por favor introduzca otro");
                            dorsal = sc2.nextInt();
                        }
                    }while (!e.dorsalDisponible(dorsal));
                    e.addJugador(new Jugador(name, posicion, dorsal));
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Inserte el dorsal del jugador que desea borrar");
                    dorsal = sc.nextInt();
                    e.deleteJugadorPorDorsal(dorsal);
                    break;

                case 3:
                    e.mostrarPlantilla();
                    break;

                case 4:
                    System.out.println("Introduzca el nombre del jugador que esté buscando");
                    String name2 = sc.next();
                    e.buscarJugadorPorNombre(name2);
                    break;

                case 5:
                    System.out.println("Introduzca una posición para mostrar todos los jugadores de la misma");
                    String posicion2 = sc.next();
                    e.buscarJugadoresPorPosicion(posicion2);
                    break;

                case 6:
                    System.out.println("Indique el dorsal del jugador al que quiere cambiar la posición");
                    dorsal = sc.nextInt();
                    System.out.println("Ahora indique la nueva posición del jugador");
                    String posicion3 = sc.next();
                    e.modificarPosicionJugador(dorsal, posicion3);
                    break;

                case 7:
                    e.ordenarEquipoPorPosicion();
                    break;

                case 0:
                    break;

                default: System.out.println("Seleccione una opción correcta\n");
            }
        }while(respuesta != 0);
        System.out.println("¡Hasta pronto!");
    }
}
