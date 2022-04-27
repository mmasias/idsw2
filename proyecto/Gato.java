package proyecto;

public class Gato extends Entidad{
    // protected String simbolo = "\uD83D\uDE3A";
    protected boolean estado;
    protected int impaciencia;

    public Gato(int posX, int posY) {
        // this.posX = posX;
        // this.posY = posY;
    }

    public void cambioEstado(){
        this.estado = !this.estado;
    }

    public void ensuciar(){
        // TODO Auto-generated method stub
    }

    public void dibujar() {
        if(estado){
            System.out.print(this.simbolo);
        }
        else{
            System.out.print(this.encimaDe.getSimbolo())
        }
        
    }

    public void mover(int posX, int posY) {
        // TODO Auto-generated method stub
        
    }

    public void proximoMovimiento() {
        // TODO Auto-generated method stub
        
    }

    // public void moverGato(int[][] moves, int[][] map) {
    //     int move = (int) (Math.random() * 8);
    //     if ((this.posX + moves[move][0] > 0 || this.posX + moves[move][0] < map[0].length
    //             || this.posY + moves[move][1] > 0 || this.posY + moves[move][1] < map.length)
    //             && (map[this.posY + moves[move][1]][this.posX + moves[move][0]] >= 0)) {
    //         this.posX += moves[move][0];
    //         this.posY += moves[move][1];
    //         setPosX(this.posX);
    //         setPosY(this.posY);
    //         if (map[this.posY][this.posX] + 1 < 4) {
    //             map[this.posY][this.posX] = map[this.posY][this.posX] + 1;
    //         }
    //     }

    // }
}
