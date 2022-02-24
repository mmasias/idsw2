package structures.classes.surfaces;

import structures.classes.players.Player;
import structures.interfaces.Drawable;

public abstract class Surface implements Drawable {
    public abstract boolean canAdvance(Player player);

    public static Surface getSurface(int type) {
        switch (type) {
            case 0:
                return new Ground();
            case 1:
                return new LowGrass();
            case 2:
                return new MidGrass();
            case 3:
                return new HighGrass();
            case 4:
                return new Sand();
            case 5:
                return new Mountain();
            case 6:
                return new Wall();
            case 7:
                return new Water();
            case 8:
                return new TroubledWaters();
            default:
                return null;
        }
    }
}
