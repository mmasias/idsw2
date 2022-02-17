import structures.interfaces.Drawable;

public abstract class Player implements Drawable {
    protected Position position;

    public Player(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void Move(Direction direction, int amount) {
        switch (direction) {
            case UP:
                this.position.setY(position.getY() - amount);
                break;
            case DOWN:
                position.setY(position.getY() + amount);
                break;
            case LEFT:
                position.setX(position.getX() - amount);
                break;
            case RIGHT:
                position.setX(position.getX() + amount);
                break;
        }
    }
}
