package proyecto;

public class Gato extends Entidad {
    private boolean estado;
    private int impaciencia;

    public Gato(int x, int y, int impaciencia) {
        super(x, y);
        this.estado = false;
        this.impaciencia = impaciencia;
    }

    public void cambioEstado() {
        this.estado = !estado;
    }

    public boolean ensuciar(Suciedad suciedad) {

    }
}
