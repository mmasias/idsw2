package structures.classes.players;

import structures.classes.Surface;
import structures.enums.PlayerType;
import structures.enums.SurfaceType;
import structures.interfaces.Drawable;

public abstract class Player implements Drawable {
    public Surface currentSurface;

    public Player(Surface surface) {
        this.currentSurface = surface;
    }

    public void tryMove(Surface surface) {
        if (canMove(surface.getType())) this.currentSurface = surface;
    }

    protected abstract boolean canMove(SurfaceType type);

    public static Player getPlayerType(PlayerType playerType, Surface surface) {
        switch (playerType) {
            case BOAT:
                return new Boat(surface);
            case HORSE:
                return new Horse(surface);
            case CARPET:
                return new Carpet(surface);
            case WALKER:
                return new Walker(surface);
            default:
                return null;
        }
    }

    public Surface getSurface() {
        return this.currentSurface;
    }

    public void setSurface(Surface surface) {
        this.currentSurface = surface;
    }
}
