package proyecto;

public class Habitacion {
    protected Dibujable[][] suelo;
    protected int ancho;
    protected int largo;

    public Habitacion(int ancho, int largo) {
        this.ancho = ancho;
        this.largo = largo;
    }

    public void limpiarHabitacion() {
        while(this.suciedadRestante() > 0){
            this.mostrarHabitacion();
            this.avanzarEstado();
        }
    }

    private void avanzarEstado(){
        for (Dibujable[] fila : suelo) {
            for (Dibujable dibujable : fila) {
                dibujable.avanzarEstado();
            }
        }
    }
    private void mostrarHabitacion() {
        for (Dibujable[] fila : suelo) {
            for (Dibujable dibujable : fila) {
                dibujable.dibujar();
            }
        }
    }

    public int[] areaConMayorSuciedad() {
        int[] lugar = {0,0};
        int currMax = 0;
        for (int fila = 0; fila<largo;fila++) {
            for (int columna = 0; columna < ancho; columna ++) {
                Dibujable dibujable = suelo[fila][columna];
                if(suelo[fila][columna].getClass() == Suciedad.class){
                    Suciedad suciedad = (Suciedad) dibujable;
                    if(suciedad.getNivelDeSuciedad() > currMax){
                        currMax = suciedad.getNivelDeSuciedad();
                        lugar[0] = fila;
                        lugar[1] = columna;
                    }
                }
            }
        }
        return lugar;
    }

    private int suciedadRestante() {
        int suciedadRestante = 0;
        for (Dibujable[] fila : suelo) {
            for (Dibujable dibujable : fila) {
                if(dibujable.getClass() == Suciedad.class){
                    Suciedad suciedad = (Suciedad) dibujable;
                    suciedadRestante += suciedad.getNivelDeSuciedad();
                }
            }
        }
        return suciedadRestante;
    }

    public boolean esTraspasable(int x, int y) {
        return this.suelo[x][y].getTraspasable();
    }

    public int getAncho(){
        return this.ancho;
    }

    public int getLargo(){
        return this.ancho;
    }

}
