import structures.interfaces.Drawable;

public abstract class Player implements Drawable {
    protected Position position;

    public Player(Position position) {
        this.position = position;
    }

    public abstract void Move();
}
