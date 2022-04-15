package proyecto;

public class Habitacion {
    private Dibujable[][] suelo;
    private Gato gato;
    private int ancho;
    private int largo;

    public Habitacion(int ancho, int largo) {
        this.ancho = ancho;
        this.largo = largo;
        this.suelo = new Dibujable[ancho][largo];
        this.gato = new Gato();
    }

    public void mostrarHabitacion() {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < largo; j++) {
                suelo[i][j].dibujar();
            }
            System.out.println();
        }
    }

    public void limpiarHabitacion() {

        if (gato.estaDespierto()) {
            gato.ensuciar();
        }
    }

    public int suciedadTotal() {
        int suciedadTotal = 0;
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < largo; j++) {
                suciedadTotal += suelo[i][j].getNivelDeSuciedad();
            }
        }
        return suciedadTotal;
    }

    public int areaConMayorSuciedad() {
        int areaConMayorSuciedad = 0;
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < largo; j++) {
                if (suelo[i][j].getNivelDeSuciedad() > areaConMayorSuciedad) {
                    areaConMayorSuciedad = suelo[i][j].getNivelDeSuciedad();
                }
            }
        }
        return areaConMayorSuciedad;
    }

    public int suciedadRestante() {
        return suciedadTotal() - limpiezaTotal();
    }

    public boolean esTraspasable(int x, int y) {
        return suelo[x][y].traspasable;
    }

    private int limpiezaTotal() {
        int limpiezaTotal = 0;
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < largo; j++) {
                if (suelo[i][j].getNivelDeSuciedad() == 0) {
                    limpiezaTotal += suelo[i][j].getNivelDeSuciedad();
                }
            }
        }
        return limpiezaTotal;
    }
}
