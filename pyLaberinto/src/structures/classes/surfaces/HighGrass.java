package structures.classes.surfaces;

import structures.classes.players.Horse;
import structures.classes.players.Player;

public class HighGrass extends Surface {
    @Override
    public String getAvatar() {
        return "|||";
    }

    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Horse;
    }
}
