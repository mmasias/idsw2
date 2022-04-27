package proyecto;

public class Bateria {
    
    private int carga;
    private int cantidad;

    public Bateria(int carga, int cantidad){
        this.carga = carga;
        this.cantidad = cantidad;
    }

    public void cargar(){
        this.cantidad = carga; 
    }

    public void descargar(){
        this.cantidad--;
    }

    public boolean tieneCarga(){
        return this.cantidad > 0;
    }
}
