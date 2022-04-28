package proyecto;

public class Bolsa {
    private int capacidad;
    private int cantidad;

    public Bolsa(int capacidad){
        this.capacidad =  capacidad;
        this.cantidad = 0;
    }

    public void llenar(){
        this.cantidad = Math.min(capacidad, this.cantidad + 1);
    }

    public void vaciar(){
        this.cantidad = 0;
    }

    public boolean tieneEspacio(){
        return this.cantidad < this.capacidad;
    }
}
