package structures.classes.surfaces;

import structures.classes.players.Player;

public class Wall extends Surface {
    @Override
    public String getAvatar() {
        return "[ ]";
    }

    @Override
    public boolean canAdvance(Player player) {
        return false;
    }
}
