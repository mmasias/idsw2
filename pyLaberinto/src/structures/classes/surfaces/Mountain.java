package structures.classes.surfaces;

import structures.classes.Player;

public class Mountain extends Surface{
    public Mountain() {
        super("/\\");
    }

    @Override
    public boolean canAdvance(Player player) {
//        return player instanceof Carpet;
        return false;
    }
}
