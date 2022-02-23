package structures.classes.surfaces;

import structures.classes.players.Player;
import structures.classes.players.Walker;

public class LowGrass extends Surface {
    public static final String GREEN = "\033[0;32m";
    public static final String RESET = "\033[0m";
    @Override
    public String getAvatar() {
        return GREEN + "..." + RESET;
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Walker;
    }
}
