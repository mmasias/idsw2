package structures.classes.surfaces;

import structures.classes.players.Player;
import structures.classes.players.Walker;

public class MidGrass extends Surface {
    public MidGrass() {
        super(":::");
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Walker;
    }
}
