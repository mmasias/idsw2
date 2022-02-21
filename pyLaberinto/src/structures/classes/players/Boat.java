package structures.classes.players;

import structures.classes.Position;

public class Boat extends Player {
    public Boat(Position position) {
        super(position);
    }

    @Override
    public String getAvatar() { return "BnB";  }
}
