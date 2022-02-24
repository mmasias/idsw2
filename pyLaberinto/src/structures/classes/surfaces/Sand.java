package structures.classes.surfaces;

import structures.classes.players.Player;
import structures.classes.players.Walker;

public class Sand extends Surface{
    private static final String YELLOW_BACKGROUND = "\033[43m";
    private static final String RESET = "\033[0m";

    @Override
    public String getAvatar() {
        return YELLOW_BACKGROUND+ "---" + RESET ;
    }
    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Walker;
    }
}
