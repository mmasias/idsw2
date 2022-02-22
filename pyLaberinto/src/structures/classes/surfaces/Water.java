package structures.classes.surfaces;

import structures.classes.players.Boat;
import structures.classes.players.Player;

public class Water extends Surface {
    @Override
    public String getAvatar() {
        return "~~";
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Boat;
    }
}
