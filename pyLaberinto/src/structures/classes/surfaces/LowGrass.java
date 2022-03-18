package structures.classes.surfaces;

import structures.classes.Colors;
import structures.classes.players.Player;
import structures.classes.players.Walker;

public class LowGrass extends Surface {

    @Override
    public String getAvatar() {
        return Colors.GREEN + "..." + Colors.RESET;
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Walker;
    }
}
