package structures.classes.players;

import structures.classes.Position;

public class Carpet extends Player {
    public Carpet(Position position) {
        super(position);
    }

    @Override
    public String getAvatar() {
        return "CnC";
    }
}
