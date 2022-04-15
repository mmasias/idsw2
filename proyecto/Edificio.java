package proyecto;

public class Edificio {
    private Habitacion habitacion;

    public Edificio(int ancho, int largo) {
        this.habitacion = new Habitacion(ancho, largo);
    }

    public static int areaConMayorSuciedadEnHabitacion() {
        return habitacion.areaConMayorSuciedad();
    }

    public static boolean esPosibleMoverseA(int x, int y) {
        return habitacion.esTraspasable(x, y);
    }

    public static void main(String[] args) {
        new Edificio(50, 50);

        habitacion.mostrarHabitacion();

        do {
            habitacion.limpiarHabitacion();
            habitacion.mostrarHabitacion();

        } while (habitacion.suciedadRestante() == 0);

        System.out.println("La limpieza ha terminado");
    }
}
