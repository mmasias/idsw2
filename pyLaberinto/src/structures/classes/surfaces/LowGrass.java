package structures.classes.surfaces;

import structures.classes.Player;
import structures.classes.Walker;

public class LowGrass extends Surface {
    public LowGrass() {
        super("...");
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Walker;
    }
}
