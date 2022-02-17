package structures.classes.surfaces;

import structures.classes.Player;

public class TroubledWaters extends Surface {
    public TroubledWaters() {
        super("%%");
    }

    @Override
    public boolean canAdvance(Player player) {
//        return player instanceof Boat;
        return false;
    }
}
