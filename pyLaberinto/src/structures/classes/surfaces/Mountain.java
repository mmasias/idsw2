package structures.classes.surfaces;

import structures.classes.players.Carpet;
import structures.classes.players.Player;

public class Mountain extends Surface{
    private static final String GREEN_BACKGROUND = "\033[42m";
    private static final String RESET = "\033[0m";

    @Override
    public String getAvatar() {
        return GREEN_BACKGROUND + "/\\\\" +RESET;
    }
    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Carpet;
    }
}
