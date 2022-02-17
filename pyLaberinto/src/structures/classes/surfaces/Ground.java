package structures.classes.surfaces;

import structures.classes.Player;
import structures.classes.Walker;

public class Ground extends Surface {
    public Ground() {
        super("  ");
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Walker;
    }
}
