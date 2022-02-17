package structures.classes.surfaces;

import structures.classes.Player;

public class Water extends Surface {
    public Water() {
        super("~~");
    }

    @Override
    public boolean canAdvance(Player player) {
//        return player instanceof Boat;
        return false;
    }
}
