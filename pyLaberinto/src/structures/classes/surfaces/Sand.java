package structures.classes.surfaces;

import structures.classes.Colors;
import structures.classes.players.Player;
import structures.classes.players.Walker;

public class Sand extends Surface {
    @Override
    public String getAvatar() {
        return Colors.YELLOW_BG + "---" + Colors.RESET_BG;
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Walker;
    }
}
