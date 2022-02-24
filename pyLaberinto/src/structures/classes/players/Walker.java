package structures.classes.players;

import structures.classes.Position;

public class Walker extends Player {
    public Walker(Position position) {
        super(position);
    }

    @Override
    public String getAvatar() {
        return "WnW";
    }
}
