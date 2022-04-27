package proyecto;

public class Aspiradora extends Entidad{

    private Bateria bateria;
    private Bolsa bolsa;
    private int pasos;

    public Aspiradora(String simbolo){
        this.simbolo = simbolo;
    }

    public void limpiar(){
        // TODO Auto-generated method stub
    }

    public void bolsaLlena(){
        // TODO Auto-generated method stub
    }
    
    public void cargaBateria(){
        // TODO Auto-generated method stub
    }

    public void cargarBateria(){
        // TODO Auto-generated method stub
    }

    public void vaciarBolsa(){
        // TODO Auto-generated method stub
    }

    public void areaConMayorSuciedad(){
        // TODO Auto-generated method stub
    }

    public void mover(int posX, int posY) {
        // TODO Auto-generated method stub  
    }


    public void proximoMovimiento() {
        // TODO Auto-generated method stub
    }

    public void dibujar() {
        
    }

    public String getSimbolo() {
        return this.simbolo;
    }
    
}
