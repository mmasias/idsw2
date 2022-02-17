package structures.classes.surfaces;

import structures.classes.Player;
import structures.classes.Walker;

public class Sand extends Surface{
    public Sand() {
        super("--");
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Walker;
    }
}
