package structures.classes.surfaces;

import structures.classes.players.Player;
import structures.classes.players.Walker;

public class Ground extends Surface {
    @Override
    public String getAvatar() {
        return "  ";
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Walker;
    }
}
