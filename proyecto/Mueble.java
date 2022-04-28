package proyecto;

import java.util.Map;

public class Mueble implements Dibujable{

    protected Map<String, String> tipoDeMueble;
    protected String tipo;
    protected int posX;
    protected int poxY;
    protected boolean traspasable;

    public Mueble(){
        this.traspasable = false;
        this.tipo = "Mesa"; // Tipo fijo de momento
    }
    
    public void dibujar() {
        System.out.print(this.getSimbolo());
    }

    public String getSimbolo(){
        return this.tipoDeMueble.get(this.tipo);
    }
    public boolean getTraspasable(){
        return traspasable;
    }

    public void avanzarEstado() {
        // Los muebles no hacen nada
    }
    
}
