package structures.classes.surfaces;

import structures.classes.players.Carpet;
import structures.classes.players.Player;

public class Mountain extends Surface{
    public Mountain() {
        super("/\\");
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Carpet;
    }
}
