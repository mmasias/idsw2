package proyecto;

public class Suciedad implements Dibujable{
    String[] nivelesDeSuciedad = { " ⬜ ", " ⬛ ", " \uD83D\uDCA9 ", " \uD83D\uDCA9 ", " \uD83D\uDCA9 " };
    int nivelDeSuciedad;
    
    public Suciedad(int nivelDeSuciedad){
        this.nivelDeSuciedad =  Math.max(Math.min(nivelDeSuciedad,4),0);
    }

    public int getNivelDeSuciedad(){
        return this.nivelDeSuciedad;
    }

    public void aumentarSuciedad(){
        this.nivelDeSuciedad = Math.min(4, this.nivelDeSuciedad + 1);
    }

    public void reducirSuciedad(){
        this.nivelDeSuciedad = Math.max(0, this.nivelDeSuciedad - 1);
    }

    public void dibujar() {
        System.out.print(this.getSimbolo());
    }

    public boolean getTraspasable() {
        return false;
    }

    public void avanzarEstado() {
        // La suciedad de momento no hace nada
    }

    public String getSimbolo() {
        return this.nivelesDeSuciedad[this.nivelDeSuciedad];
    }
}
