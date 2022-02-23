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
        final List<List<Drawable>> mazeToPrint = this.getMazeToPrint();

        IntStream.range(0, mazeToPrint.size()).forEach(y -> {
            IntStream.range(0, mazeToPrint.get(0).size()).forEach(x -> {
                System.out.print(y == 8 && x == 8 ? this.player.getAvatar() : mazeToPrint.get(y).get(x).getAvatar());
            });
            System.out.println();
        });
    }

    private List<List<Drawable>> getMazeToPrint() {
        final int maxXIndex = this.player.getPosition().getX() + 8;
        final int minXIndex = this.player.getPosition().getX() - 8;
        final int maxYIndex = this.player.getPosition().getY() - 8;
        final int minYIndex = this.player.getPosition().getY() + 8;

        return IntStream.range(maxYIndex, minYIndex + 1).mapToObj(y -> {
            return IntStream.range(minXIndex, maxXIndex + 1).mapToObj(x -> {
                if (y < 0 || x < 0 || y >= this.maze.size() || x >= this.maze.get(0).size()) return Surface.getSurface(6);
                else return this.maze.get(y).get(x);
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
        if(((Surface) this.maze.get(nextPosition.getY()).get(nextPosition.getX())).canAdvance(this.player) && (nextPosition.getX() > 0 && nextPosition.getY() > 0 && nextPosition.getX() < this.maze.get(0).size() && nextPosition.getY() < this.maze.size())) {
            this.player.setPosition(nextPosition);
        }
    }

    private Position getNextPosition(String direction, int amount) {
        Position position = new Position(this.player.getPosition().getX(), this.player.getPosition().getY());

        switch (direction) {
            case "w":
                position.setY(position.getY() - amount);
                break;
            case "a":
                position.setX(position.getX() - amount);
                break;
            case "s":
                position.setY(position.getY() + amount);
                break;
            case "d":
                position.setX(position.getX() + amount);
                break;
            case "q":
                position.setY(position.getY() - amount);
                position.setX(position.getX() - amount);
                break;
            case "e":
                position.setX(position.getX() + amount);
                position.setY(position.getY() - amount);
                break;
            case "z":
                position.setX(position.getX() - amount);
                position.setY(position.getY() + amount);
                break;
            case "c":
                position.setX(position.getX() + amount);
                position.setY(position.getY() + amount);
                break;
        }
        return position;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
