package proyecto;

public class Celda {
    private int posX;
    private int posY;
    private Suciedad suciedad;
    private String representacion;

    public Celda(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.suciedad = new Suciedad();
        this.representacion = ".";
    }

    public void dibujar() {
        System.out.print(representacion);
    }
        
    }
}
