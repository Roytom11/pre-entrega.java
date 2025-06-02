package inicio;

public class Jugador {
    int id; 
    String nombre;
    String posicion;

    public Jugador(int id, String nombre, String posicion) {
        this.id = id;
        this.nombre = nombre;
        this.posicion = posicion;
        
    }

    void mostrar() {
        System.out.println("ID: " + id + "  n | Nombre: " + nombre + " | Posición: " + posicion);
            System.out.println("Nombre: " + nombre);
            System.out.println("Posición: " + posicion);
    }
}