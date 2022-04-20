package proyecto;

abstract class Entidad {
    int[][] coordenadasDeMovimiento = {
            { -1, -1 },
            { -1, 0 },
            { -1, 1 },
            { 0, -1 },
            { 0, 1 },
            { 1, -1 },
            { 1, 0 },
            { 1, 1 }
    };
    Dibujable encimaDe = null;

    public void mover(int x, int y);

    public void proximoMovimiento();
}
