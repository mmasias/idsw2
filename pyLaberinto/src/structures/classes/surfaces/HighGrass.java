package structures.classes.surfaces;

import structures.classes.players.Horse;
import structures.classes.players.Player;

public class HighGrass extends Surface {
    public HighGrass() {
        super("|||");
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Horse;
    }
}
