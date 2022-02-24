package structures.classes.surfaces;

import structures.classes.players.Player;
import structures.classes.players.Walker;

public class LowGrass extends Surface {
    private static final String GREEN = "\033[0;32m";
    private static final String RESET = "\033[0m";

    @Override
    public String getAvatar() {
        return GREEN + "..." + RESET;
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Walker;
    }
}
