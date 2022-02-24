package structures.classes.surfaces;

import structures.classes.players.Player;
import structures.classes.players.Walker;

public class MidGrass extends Surface {
    private static final String GREEN_BOLD_BRIGHT = "\033[1;92m";
    private static final String RESET = "\033[0m";

    @Override
    public String getAvatar() {
        return GREEN_BOLD_BRIGHT + ":::" + RESET;
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Walker;
    }
}
