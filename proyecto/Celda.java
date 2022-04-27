package proyecto;

public class Celda {
    private int posX;
    private int posY;
    private Suciedad suciedad;
    private String representacion;

    public Celda(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.suciedad = new Suciedad(generarNumeroAleatorio());
        this.representacion = suciedad.getNivelDeSuciedad();
    }

    public void dibujar() {
        System.out.print(representacion);
    }

    private int generarNumeroAleatorio() {
        return (Random.nextInt() * (3 + 1 - 0) + 0);
    }

}
