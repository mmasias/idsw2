package structures.classes.surfaces;

import structures.classes.Colors;
import structures.classes.players.Horse;
import structures.classes.players.Player;

public class HighGrass extends Surface {
    @Override
    public String getAvatar() {
        return Colors.GREEN_BRIGHT_BG + "|||" + Colors.RESET_BG;
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Horse;
    }
}
