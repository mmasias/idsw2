package structures.classes.surfaces;

import structures.classes.players.Boat;
import structures.classes.players.Player;

public class Water extends Surface {
    public Water() {
        super("~~");
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Boat;

    }
}
