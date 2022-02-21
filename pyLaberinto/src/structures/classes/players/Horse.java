package structures.classes.players;

import structures.classes.Position;

public class Horse extends Player {
    public Horse(Position position) {
        super(position);
    }

    @Override
    public String getAvatar() {
        return "HnH";
    }
}
