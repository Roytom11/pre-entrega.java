package inicio;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Jugador> lista = new ArrayList<>();
    static ArrayList<Jugador> equipo1 = new ArrayList<>();
    static ArrayList<Jugador> equipo2 = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        int opcion;         

        do {
            System.out.println("--Menu de Jugador--");
            System.out.println("1. Crear Jugador");
            System.out.println("2. Listar Jugadores");
            System.out.println("3. Modificar Jugador");
            System.out.println("4. Asignar jugadores a equipos");
            System.out.println("5. Mostrar equipos");
            System.out.println("6. Eliminar Jugador");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearJugador();
                    break;
                case 2:
                    listarJugadores();
                    break;
                case 3:
                    modificarJugador();
                    break;
                case 4:
                    asignarEquipos();
                    break;
                case 5:
                    mostrarEquipos();
                    break;
                case 6:
                    eliminarJugador();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");

            }
        } while (opcion != 7);
        sc.close();
    }

    public static void crearJugador() {
        System.out.print("Ingrese ID del jugador: ");
        int id = sc.nextInt();
        sc.nextLine();  // Limpiar el buffer
        for (Jugador jugador : lista) {
        if (jugador.id == id) {
            System.out.println("Ya existe un jugador con ese ID. Intente con otro ID.");
            return;
        }
    }
        System.out.print("Ingrese nombre del jugador: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese posición del jugador: ");
        String posicion = sc.nextLine();
        lista.add(new Jugador(id, nombre, posicion));
        System.out.println("Jugador agregado.");
    }

    public static void listarJugadores() {
        if (lista.isEmpty()) {
            System.out.println("No hay jugadores para mostrar.");
        } else {
            System.out.println("--Lista de Jugadores--");
            for (Jugador jugador : lista) {
                jugador.mostrar();
            }
        }
    }   

    public static void modificarJugador() {
        System.out.print("Ingrese ID del jugador a modificar: ");
        int id = sc.nextInt();
        sc.nextLine();  // Limpiar el buffer
        for (Jugador jugador : lista) {
            if (jugador.id == id) {
                System.out.print("Ingrese nuevo nombre: ");
                jugador.nombre = sc.nextLine();
                System.out.print("Ingrese nueva posición: ");
                jugador.posicion = sc.nextLine();
                System.out.println("Jugador modificado.");
                return;
            }
        }
        System.out.println("Jugador no encontrado.");
    }

    public static void asignarEquipos() {
    equipo1.clear();
    equipo2.clear();

    for (int i = 0; i < lista.size(); i++) {
        if (i % 2 == 0) {
            equipo1.add(lista.get(i));
        } else {
            equipo2.add(lista.get(i));
        }
    }

    System.out.println("Jugadores asignados a equipos automáticamente.");
}

public static void mostrarEquipos() {
    System.out.println("--Equipo 1--");
    if (equipo1.isEmpty()) {
        System.out.println("No hay jugadores en el Equipo 1.");
    } else {
        for (Jugador jugador : equipo1) {
            jugador.mostrar();
        }
    }

    System.out.println("--Equipo 2--");
    if (equipo2.isEmpty()) {
        System.out.println("No hay jugadores en el Equipo 2.");
    } else {
        for (Jugador jugador : equipo2) {
            jugador.mostrar();
        }
    }
}

    public static void eliminarJugador() {
        System.out.print("Ingrese ID del jugador a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine();  // Limpiar el buffer
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).id == id) {
                lista.remove(i);
                System.out.println("Jugador eliminado.");
                return;
            }
        }
        System.out.println("Jugador no encontrado.");
    }
}