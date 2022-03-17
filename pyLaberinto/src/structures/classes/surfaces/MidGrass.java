package structures.classes.surfaces;

import structures.classes.Colors;
import structures.classes.players.Player;
import structures.classes.players.Walker;

public class MidGrass extends Surface {
    @Override
    public String getAvatar() {
        return Colors.GREEN_BOLD_BRIGHT + ":::" + Colors.RESET;
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Walker;
    }
}
