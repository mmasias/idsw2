package structures.classes.surfaces;

import structures.classes.players.Boat;
import structures.classes.players.Player;

public class TroubledWaters extends Surface {
    private static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";
    private static final String TEXT_RESET = "\u001B[0m";

    @Override
    public String getAvatar() {
        return BLUE_BACKGROUND_BRIGHT + "%%%" + TEXT_RESET;
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Boat;
    }
}
