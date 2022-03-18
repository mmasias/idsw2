package structures.classes.surfaces;

import structures.classes.Colors;
import structures.classes.players.Carpet;
import structures.classes.players.Player;

public class Mountain extends Surface {
    @Override
    public String getAvatar() {
        return Colors.GREEN_BG + "/\\\\" + Colors.RESET_BG;
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Carpet;
    }
}
