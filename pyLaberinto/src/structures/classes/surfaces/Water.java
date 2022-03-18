package structures.classes.surfaces;

import structures.classes.Colors;
import structures.classes.players.Boat;
import structures.classes.players.Player;

public class Water extends Surface {

    @Override
    public String getAvatar() {
        return Colors.BLUE_BG + "~~~" + Colors.RESET_BG;
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Boat;
    }
}
