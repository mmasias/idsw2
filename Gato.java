public class Gato {
    int posX;
    int posY;
    String symbol = "\"^\"";
    int apariciones;

    public Gato(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getApariciones() {
        return apariciones;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setApariciones(int apariciones) {
        this.apariciones = apariciones;
    }

    public void moverGato(int[][] moves, int[][] map) {
        int move = (int) (Math.random() * 8);
        if (this.posX + moves[move][0] > 0 || this.posX + moves[move][0] <= map[0].length
                || this.posY + moves[move][0] > 0 || this.posY + moves[move][1] <= map.length) {
            this.posX += moves[move][0];
            this.posY += moves[move][1];
            setPosX(this.posX);
            setPosY(this.posY);
            if (map[this.posY][this.posX] + 1 <= 4) {
                map[this.posY][this.posX] = map[this.posY][this.posX] + 1;
            }
        }

    }
}
