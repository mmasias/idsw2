package proyecto;

public class Edificio {
    private Habitacion habitacion;

    public Edificio(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public static int areaConMayorSuciedadEnHabitacion() {
        return Habitacion.areaConMayorSuciedad();
    }

    public static boolean esPosibleMoverseA(int x, int y) {
        return Habitacion.esTraspasable(x, y);
    }

    private void limpiarEdificio() {
        habitacion.mostrarHabitacion();

        do {
            habitacion.limpiarHabitacion();
            habitacion.mostrarHabitacion();

        } while (habitacion.suciedadRestante() == 0);

        System.out.println("La limpieza ha terminado");
    }

    public static void main(String[] args) {
        new Edificio(new Habitacion(50, 50)).limpiarEdificio();

    }
}
