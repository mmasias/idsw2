package proyecto;

public class Edificio {

    
    static Habitacion habitacion;

    static int[] areaConMayorSuciedad() {
        return habitacion.areaConMayorSuciedad();
    }

    static boolean esPosibleMoverse(int x, int y) {
        return habitacion.esTraspasable(x, y);
    }

    static void main(String[] args) {
        habitacion = new Habitacion(25, 25);
        habitacion.limpiarHabitacion();
    }
}
