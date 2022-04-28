package structures.classes.players;

import structures.classes.Surface;
import structures.enums.SurfaceType;

public class Carpet extends Player {
    public Carpet(Surface surface) {
        super(surface);
    }

    @Override
    protected boolean canMove(SurfaceType type) {
        return type == SurfaceType.MOUNTAIN;
    }

    @Override
    public String getAvatar() {
        return "CnC";
    }
}
