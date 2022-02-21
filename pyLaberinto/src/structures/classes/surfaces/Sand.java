package structures.classes.surfaces;

import structures.classes.players.Player;
import structures.classes.players.Walker;

public class Sand extends Surface{
    public Sand() {
        super("--");
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Walker;
    }
}
