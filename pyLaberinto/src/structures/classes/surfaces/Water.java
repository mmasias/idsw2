package structures.classes.surfaces;

import structures.classes.players.Boat;
import structures.classes.players.Player;

public class Water extends Surface {
    private static final String BLUE_BACKGROUND = "\033[44m";
    private static final String TEXT_RESET = "\u001B[0m";

    @Override
    public String getAvatar() {
        return  BLUE_BACKGROUND + "~~~" + TEXT_RESET;
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Boat;
    }
}
