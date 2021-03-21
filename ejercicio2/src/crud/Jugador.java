package crud;

public class Jugador implements Comparable<Jugador>{
    private String nombre;
    private String posicion;
    private int numCamiseta;

    public Jugador(String nombre, String posicion, int numCamiseta) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.numCamiseta = numCamiseta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getNumCamiseta() {
        return numCamiseta;
    }

    public void setNumCamiseta(int numCamiseta) {
        this.numCamiseta = numCamiseta;
    }

    public String toString() {
        return "Nombre: "+this.nombre+"\n\tPosición: "+this.posicion+"\n\tDorsal: "+this.numCamiseta+"\n";
    }

    @Override
    public int compareTo(Jugador o) {
        String a = new String(this.getPosicion());
        String b = new String(o.getPosicion());
        return a.compareTo(b);
    }
}
