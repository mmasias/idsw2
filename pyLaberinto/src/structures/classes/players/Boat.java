package structures.classes.players;

import structures.classes.Surface;
import structures.enums.SurfaceType;

public class Boat extends Player {
    public Boat(Surface surface) {
        super(surface);
    }

    @Override
    protected boolean canMove(SurfaceType type) {
        return type == SurfaceType.WATER || type == SurfaceType.TROUBLEDWATERS;
    }

    @Override
    public String getAvatar() {
        return "BnB";
    }
}
