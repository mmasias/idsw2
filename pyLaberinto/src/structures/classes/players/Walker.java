package structures.classes.players;

import structures.classes.Surface;
import structures.enums.SurfaceType;

public class Walker extends Player {
    public Walker(Surface surface) {
        super(surface);
    }

    @Override
    public String getAvatar() {
        return "WnW";
    }

    @Override
    protected boolean canMove(SurfaceType type) {
        return type == SurfaceType.GROUND || type == SurfaceType.SAND || type == SurfaceType.LOWGRASS || type == SurfaceType.MIDGRASS;
    }
}
