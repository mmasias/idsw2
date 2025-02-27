import java.util.ArrayList;
import java.util.List;

public class EjemploAgregacion {
    public static void main(String[] args) {
        // Creamos algunos jugadores independientemente del equipo
        Jugador jugador1 = new Jugador("Carlos");
        Jugador jugador2 = new Jugador("María");
        Jugador jugador3 = new Jugador("Juan");
        
        // Los jugadores existen antes de formar parte de un equipo
        System.out.println("Jugadores creados: " + jugador1.getNombre() + ", " + 
                           jugador2.getNombre() + ", " + jugador3.getNombre());
        
        // Creamos un equipo y añadimos jugadores
        Equipo equipo1 = new Equipo("Equipo Azul");
        equipo1.addJugador(jugador1);
        equipo1.addJugador(jugador2);
        System.out.println("\nJugadores en " + equipo1.getNombre() + ":");
        equipo1.listarJugadores();
        
        // Creamos otro equipo con algunos de los mismos jugadores (pueden pertenecer a varios equipos)
        Equipo equipo2 = new Equipo("Equipo Rojo");
        equipo2.addJugador(jugador2);  // María está en ambos equipos
        equipo2.addJugador(jugador3);
        System.out.println("\nJugadores en " + equipo2.getNombre() + ":");
        equipo2.listarJugadores();
        
        // Podemos eliminar un jugador de un equipo sin destruirlo
        equipo1.removeJugador(jugador1);
        System.out.println("\nDespués de que " + jugador1.getNombre() + 
                           " abandona " + equipo1.getNombre() + ":");
        equipo1.listarJugadores();
        
        // Podemos cambiar el equipo al que pertenece un jugador
        System.out.println("\n" + jugador1.getNombre() + " se une a " + equipo2.getNombre());
        equipo2.addJugador(jugador1);
        equipo2.listarJugadores();
        
        // Simulamos la destrucción del equipo1
        equipo1 = null;
        System.out.println("\nEl " + "Equipo Azul" + " ha sido disuelto, pero los jugadores siguen existiendo:");
        System.out.println(jugador2.getNombre() + " ahora solo está en Equipo Rojo");
    }
}

class Equipo {
    private String nombre;
    private List<Jugador> jugadores;
    
    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    // En la agregación, el objeto contenedor recibe objetos ya creados
    // y no es responsable de su ciclo de vida
    public void addJugador(Jugador jugador) {
        if (!jugadores.contains(jugador)) {
            jugadores.add(jugador);
        }
    }

    public void removeJugador(Jugador jugador) {
        jugadores.remove(jugador);
    }
    
    public void listarJugadores() {
        if (jugadores.isEmpty()) {
            System.out.println("  No hay jugadores en este equipo");
            return;
        }
        
        for (Jugador jugador : jugadores) {
            System.out.println("  - " + jugador.getNombre());
        }
    }
    
    // Si se destruye el Equipo, los jugadores seguirán existiendo
    // ya que pueden pertenecer a otros equipos o existir independientemente
}

class Jugador {
    private String nombre;
    
    public Jugador(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
}