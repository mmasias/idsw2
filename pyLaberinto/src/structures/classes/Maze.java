package structures.classes;

import structures.interfaces.Drawable;
import java.util.List;

public class Maze {
    private List<List<Drawable>> maze;
    private Player player;

    public Maze(List<List<Drawable>> maze, Player player) {
        this.maze = maze;
        this.player = player;
    }

    public List<List<Drawable>> printMaze() {
        //7x7
       return null;
    }

    public List<List<Drawable>> tryAdvance(String direction, int amount) {
        Position nextPosition = this.getNextPosition(direction, amount);
        if (nextPosition.getX() < 0 || nextPosition.getY() < 0) {
            return printMaze();
        } else {

        }
        return null;
    }

    public Position getNextPosition(String direction, int amount) {
        Position position = player.getPosition();

        switch (direction) {
            case "w":
                position.setY(position.getY() - amount);
            case "a":
                position.setX(position.getX() + amount);
            case "s":
                position.setX(position.getX() - amount);
            case "d":
                position.setY(position.getY() + amount);
            case "q":
                position.setY(position.getY() - amount);
                position.setX(position.getX() + amount);
            case "e":
                position.setY(position.getY() - amount);
                position.setY(position.getY() + amount);
            case "z":
                position.setX(position.getX() + amount);
                position.setX(position.getX() - amount);
            case "c":
                position.setX(position.getX() - amount);
                position.setY(position.getY() + amount);
        }
        return position;
    }
}
