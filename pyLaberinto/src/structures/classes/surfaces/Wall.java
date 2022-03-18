package structures.classes.surfaces;

import structures.classes.Colors;
import structures.classes.players.Player;

public class Wall extends Surface {
    @Override
    public String getAvatar() {
        return Colors.WHITE_BG + "[ ]" + Colors.RESET_BG;
    }

    @Override
    public boolean canAdvance(Player player) {
        return false;
    }
}
