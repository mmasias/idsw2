package structures.classes.surfaces;

import structures.classes.players.Player;

public class Wall extends Surface {
    private static final String WHITE_BACKGROUND = "\033[47m";
    private static final String TEXT_RESET = "\u001B[0m";

    @Override
    public String getAvatar() {
        return WHITE_BACKGROUND + "[ ]" + TEXT_RESET;
    }

    @Override
    public boolean canAdvance(Player player) {
        return false;
    }
}
