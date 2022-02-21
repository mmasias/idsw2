package structures.classes;

import structures.classes.players.Player;
import structures.classes.surfaces.Surface;
import structures.interfaces.Drawable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Maze {
    private List<List<Drawable>> maze;
    private Player player;

    public Maze(List<List<Drawable>> maze, Player player) {
        this.maze = maze;
        this.player = player;
    }

    public void printMaze() {
        List<List<Drawable>> mazeToPrint = this.getMazeToPrint();

        IntStream.range(0, mazeToPrint.size()).forEach(y -> {
            IntStream.range(0, mazeToPrint.get(0).size()).forEach(x -> {
                System.out.print(y == 8 && x == 8 ? this.player.getAvatar() : mazeToPrint.get(y).get(x).getAvatar());
            });
            System.out.println();
        });
    }

    private List<List<Drawable>> getMazeToPrint() {
        return IntStream.range(0, this.maze.size()).filter(el -> {
            return el >= this.player.getPosition().getY() - 8 && el <= this.player.getPosition().getY() + 8;
        }).mapToObj(el -> {
            return IntStream.range(0, this.maze.get(0).size()).filter(elem -> {
                return elem >= this.player.getPosition().getX() - 8 && elem <= this.player.getPosition().getX() + 8;
            }).mapToObj(elem -> {
                return this.maze.get(el).get(elem);
            }).collect(Collectors.toList());
        }).collect(Collectors.toList());
    }

    public void printFullMaze() {
        IntStream.range(0, this.maze.size()).forEach(y -> {
            IntStream.range(0, this.maze.get(0).size()).forEach(x -> {
                System.out.print(y == this.player.getPosition().getY() && x == this.player.getPosition().getX() ? this.player.getAvatar() : this.maze.get(y).get(x).getAvatar());
            });
            System.out.println();
        });
    }

    public void tryAdvance(String direction, int amount) {
        Position nextPosition = this.getNextPosition(direction, amount);
        if(((Surface) this.maze.get(nextPosition.getY()).get(nextPosition.getX())).canAdvance(this.player) && (nextPosition.getX() < 0 || nextPosition.getY() < 0)) {
            this.player.setPosition(nextPosition);
        }
        printMaze();
    }

    private Position getNextPosition(String direction, int amount) {
        Position position = new Position(this.player.getPosition().getX(), this.player.getPosition().getY());

        switch (direction) {
            case "w":
                position.setY(position.getY() - amount);
            case "a":
                position.setX(position.getX() - amount);
            case "s":
                position.setY(position.getY() - amount);
            case "d":
                position.setX(position.getX() + amount);
            case "q":
                position.setY(position.getY() - amount);
                position.setX(position.getX() - amount);
            case "e":
                position.setX(position.getX() + amount);
                position.setY(position.getY() - amount);
            case "z":
                position.setX(position.getX() - amount);
                position.setY(position.getY() + amount);
            case "c":
                position.setX(position.getX() + amount);
                position.setY(position.getY() + amount);
        }
        return position;
    }
}
