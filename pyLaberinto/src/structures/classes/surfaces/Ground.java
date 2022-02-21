package structures.classes.surfaces;

import structures.classes.players.Player;
import structures.classes.players.Walker;

public class Ground extends Surface {
    public Ground() {
        super("  ");
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Walker;
    }
}
