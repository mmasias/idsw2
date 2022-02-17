package structures.classes.surfaces;

import structures.classes.Player;
import structures.classes.Walker;

public class MidGrass extends Surface {
    public MidGrass() {
        super(":::");
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Walker;
    }
}
