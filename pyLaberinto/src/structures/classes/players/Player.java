package structures.classes.players;

import structures.classes.Position;
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

    public static Player getPlayerType(PlayerType playerType, Position position) {
        switch (playerType) {
            case BOAT:
                return new Boat(position);
            case HORSE:
                return new Horse(position);
            case CARPET:
                return new Carpet(position);
            case WALKER:
                return new Walker(position);
            default:
                return null;
        }
    }
}
