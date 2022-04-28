package proyecto;

public class Aspiradora extends Entidad{

    private Bateria bateria;
    private Bolsa bolsa;
    private int pasos;
    private final String simbolo = ".\uD83E\uDDBC.";

    public Aspiradora(){
        this.bateria = new Bateria(Edificio.habitacion.getAncho() * Edificio.habitacion.getLargo() * 5);
        this.bolsa = new Bolsa(100);
    }

    public void limpiar(){
        ((Suciedad) this.encimaDe).reducirSuciedad();
    }

    private boolean bolsaLlena(){
        return !this.bolsa.tieneEspacio();
    }
    
    public boolean tieneCarga(){
        return this.bateria.tieneCarga();
    }

    public void cargarBateria(){
        this.bateria.cargar();
    }

    public void vaciarBolsa(){
        this.bolsa.vaciar();
    }

    private int[] areaConMayorSuciedad(){
        return Edificio.areaConMayorSuciedad();
    }

    public void mover(int posX, int posY) {
        
    }


    protected int[] proximoMovimiento() {
        int[] movimiento = {(int)Math.random()*3-1,(int)Math.random()*3-1}; //TODO calculo del proximo movimiento
        return movimiento;
    }

    public void dibujar() {
        System.out.print(this.simbolo);
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    public void avanzarEstado() {
        int[] movimiento = this.proximoMovimiento();
        this.mover(this.posX+movimiento[0],this.posY+movimiento[1]);
        if(!this.bolsaLlena() && this.tieneCarga()) this.limpiar();
        
    }

    @Override
    public boolean getTraspasable() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
