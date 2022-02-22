package structures.classes.surfaces;

import structures.classes.players.Carpet;
import structures.classes.players.Player;

public class Mountain extends Surface{
    @Override
    public String getAvatar() {
        return "/\\";
    }
    @Override
    public boolean canAdvance(Player player) {
        return player instanceof Carpet;
    }
}
