package structures.classes;

public class Walker extends Player {
    public Walker(Position position) {
        super(position);
    }

    @Override
    public String getAvatar() {
        return "UnU";
    }
}
