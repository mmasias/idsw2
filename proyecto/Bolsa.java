package proyecto;

public class Bolsa {
    private int capacidad;
    private int cantidad;

    public Bolsa(int capacidad, int cantidad){
        this.capacidad =  capacidad;
        this.cantidad = cantidad;
    }

    public void llenar(){
        this.cantidad++;
    }

    public void vaciar(){
        this.cantidad = 0;
    }

    public boolean tieneEspacio(){
        return this.cantidad < this.capacidad;
    }
}
