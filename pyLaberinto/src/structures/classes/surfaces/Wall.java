package structures.classes.surfaces;

import structures.classes.players.Player;

public class Wall extends Surface {
    public Wall() {
        super("[ ]");
    }

    @Override
    public boolean canAdvance(Player player) {
        return false;
    }
}
