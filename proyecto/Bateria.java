package proyecto;

public class Bateria {
    
    private int carga;
    private int cantidad;

    public Bateria(int carga){
        this.carga = carga;
        this.cantidad = 0;
    }

    public void cargar(){
        this.cantidad = carga; 
    }

    public void descargar(){
        this.cantidad = Math.max(0, this.cantidad -1 );
    }

    public boolean tieneCarga(){
        return this.cantidad > 0;
    }
}
