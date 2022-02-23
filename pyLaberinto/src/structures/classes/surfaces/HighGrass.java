package structures.classes.surfaces;

import structures.classes.players.Horse;
import structures.classes.players.Player;

public class HighGrass extends Surface {
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";
    public static final String RESET = "\033[0m";
    @Override
    public String getAvatar() {
        return GREEN_BACKGROUND_BRIGHT +  "|||" + RESET ;
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Horse;
    }
}
