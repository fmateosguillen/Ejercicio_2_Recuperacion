package crud;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Equipo {
    private ArrayList<Jugador> listaJugadores;

    public Equipo(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public void addJugador(Jugador j){
        this.listaJugadores.add(j);
        System.out.println("Jugador agregado correctamente");
    }

    public void deleteJugadorPorDorsal(int num){
        Iterator<Jugador> it = listaJugadores.iterator();
        while (it.hasNext()){
            Jugador jugador = it.next();
            if(jugador.getNumCamiseta() == num){
                it.remove();
                System.out.println("Jugador eliminado de la plantilla correctamente\n");
            }
        }
    }

    public void mostrarPlantilla(){
        Iterator<Jugador> it = listaJugadores.iterator();
        while (it.hasNext()){
            Jugador jugador = it.next();
            System.out.println(jugador);
        }
    }

    public void buscarJugadorPorNombre(String nombre){
        Iterator<Jugador> it = listaJugadores.iterator();
        int contador = 0;
        while (it.hasNext()){
            Jugador jugador = it.next();
            if(jugador.getNombre().toUpperCase().equals(nombre.toUpperCase())){
                System.out.println(jugador);
            }else{
                contador++;
            }

            if (contador == listaJugadores.size()){
                System.out.println("No hay ningún jugador con ese nombre en el equipo\n(Compruebe que haya introducido el nombre completo del jugador correctamente)\n");
            }
        }
    }

    public void buscarJugadoresPorPosicion(String posicion){
        Iterator<Jugador> it = listaJugadores.iterator();
        while (it.hasNext()){
            Jugador jugador = it.next();
            if(jugador.getPosicion().toUpperCase().equals(posicion.toUpperCase())){
                System.out.println(jugador);
            }
        }
    }

    public void modificarPosicionJugador(int dorsal, String posicion){
        Iterator<Jugador> it = listaJugadores.iterator();
        while (it.hasNext()){
            Jugador jugador = it.next();
            if(jugador.getNumCamiseta() == dorsal){
                jugador.setPosicion(posicion);
                System.out.println("Posición modificada correctamente\n");
            }
        }
    }

    public void ordenarEquipoPorPosicion(){
        Iterator<Jugador> it = listaJugadores.iterator();
        Collections.sort(listaJugadores);
        System.out.println("Lista ordenada correctamente\n");
    }

    public boolean dorsalDisponible(int dorsal){
        boolean disponible = true;
        Iterator<Jugador> it = listaJugadores.iterator();
        while (it.hasNext()){
            Jugador jugador = it.next();
            if(jugador.getNumCamiseta() == dorsal){
                disponible = false;
            }
        }
        return disponible;
    }
}
