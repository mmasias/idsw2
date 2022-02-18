package structures.classes;

import structures.enums.Direction;
import structures.enums.PlayerType;
import structures.interfaces.Drawable;

public abstract class Player implements Drawable {
    protected Position position;

    public Player(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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

    public Player getPlayerType(PlayerType playerType, Position position) {
        switch (playerType) {
            case BOAT:
                return new Walker(position);
            case HORSE:
                return new Walker(position);
            case CARPET:
                return new Walker(position);
            case WALKER:
                return new Walker(position);
            default:
                return null;
        }
    }
}
