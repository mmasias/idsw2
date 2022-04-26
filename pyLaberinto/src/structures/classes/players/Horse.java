package structures.classes.players;

import structures.classes.Surface;
import structures.enums.SurfaceType;

public class Horse extends Player {
    public Horse(Surface surface) {
        super(surface);
    }

    @Override
    protected boolean canMove(SurfaceType type) {
        return type == SurfaceType.HIGHGRASS;
    }

    @Override
    public String getAvatar() {
        return "HnH";
    }
}
