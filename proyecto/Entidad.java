package proyecto;

public abstract class Entidad implements Dibujable {

    protected int[][] coorrdenadasDeMovimiento;
    protected Dibujable encimaDe;
    protected int posX;
    protected int posY;
    protected boolean traspasable;
    protected String simbolo;

    public abstract void mover(int posX, int posY);

    protected abstract int[] proximoMovimiento();
}
