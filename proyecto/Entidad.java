package proyecto;

public abstract class Entidad implements Dibujable {

    protected int[][] coorrdenadasDeMovimiento;
    protected Dibujable encimaDe;

    public abstract void mover(int posX, int posY);

    public abstract void proximoMovimiento();
}
