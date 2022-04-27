package proyecto;

public interface Dibujable {
    public int posX;
    public int poxY;
    public boolean traspasable;
    public String simbolo;

    public void dibujar();
    public String getSimbolo();
}
