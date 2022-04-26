package structures.classes;

import structures.classes.players.*;
import structures.enums.PlayerType;
import structures.enums.SurfaceType;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class World {
    private List<List<Surface>> maze;
    private Player player;
    private Time time;
    private Sky sun;

    public World(List<List<Surface>> maze, Player player, Time time, Sky sky) {
        this.maze = maze;
        this.player = player;
        this.time = time;
        this.sun = sky;
    }

    public void printWorld() {
        this.sun.showSky(this.time.isNightTime());
        this.time.showTime();
        this.printMaze();
    }

    public void updateState(String direction, int amount) {
        Position nextPosition = this.getNextPosition(direction, amount);
        if (nextPosition.getX() > 0 && nextPosition.getY() > 0 && nextPosition.getX() < this.maze.get(0).size() && nextPosition.getY() < this.maze.size()) {
            this.player.tryMove(this.maze.get(nextPosition.getY()).get(nextPosition.getX()));
        }
        this.triggerListeners();
    }

    public void updateState(String selection) {
        switch (selection) {
            case "b":
                this.player = Player.getPlayerType(PlayerType.BOAT, this.player.getSurface());
                break;
            case "f":
                this.player = Player.getPlayerType(PlayerType.CARPET, this.player.getSurface());
                break;
            case "l":
                this.player = Player.getPlayerType(PlayerType.WALKER, this.player.getSurface());
                break;
            case "h":
                this.player = Player.getPlayerType(PlayerType.HORSE, this.player.getSurface());
                break;
        }
        this.triggerListeners();
    }

    public Player getPlayer() {
        return player;
    }

    private void printMaze() {
        final List<List<Surface>> mazeToPrint = this.getMazeToPrint();

        IntStream.range(0, mazeToPrint.size()).forEach(y -> {
            IntStream.range(0, mazeToPrint.get(0).size()).forEach(x -> {
                System.out.print(y == 8 && x == 8 ? this.player.getAvatar() : mazeToPrint.get(y).get(x).getAvatar());
            });
            System.out.println();
        });
    }

    private List<List<Surface>> getMazeToPrint() {
        final int maxXIndex = this.player.getSurface().getPosition().getX() + 8;
        final int minXIndex = this.player.getSurface().getPosition().getX() - 8;
        final int maxYIndex = this.player.getSurface().getPosition().getY() - 8;
        final int minYIndex = this.player.getSurface().getPosition().getY() + 8;

        List<List<Surface>> mazeToShow = IntStream.range(maxYIndex, minYIndex + 1).mapToObj(y -> {
            return IntStream.range(minXIndex, maxXIndex + 1).mapToObj(x -> {
                if (y < 0 || x < 0 || y >= this.maze.size() || x >= this.maze.get(0).size())
                    return new Surface(SurfaceType.WALL, new Position(-1, -1));
                else
                    return this.maze.get(y).get(x);
            }).collect(Collectors.toList());
        }).collect(Collectors.toList());

        if (this.time.isNightTime()) return reduceVision(mazeToShow, 3);
        else if (this.time.isVisionReduced()) return reduceVision(mazeToShow, 7);
        else return mazeToShow;
    }

    private List<List<Surface>> reduceVision(List<List<Surface>> mazeToReduce, final int range) {
        return IntStream.range(0, mazeToReduce.size()).mapToObj(y -> {
            return IntStream.range(0, mazeToReduce.get(0).size()).mapToObj(x -> {
                return (Math.abs(x - 8) + Math.abs(y - 8) <= range) ? mazeToReduce.get(y).get(x) : new Surface(SurfaceType.GROUND, new Position(-1, -1));
            }).collect(Collectors.toList());
        }).collect(Collectors.toList());
    }

    public void printFullMaze() {
        IntStream.range(0, this.maze.size()).forEach(y -> {
            IntStream.range(0, this.maze.get(0).size()).forEach(x -> {
                System.out.print(y == this.player.getSurface().getPosition().getY() && x == this.player.getSurface().getPosition().getX()
                        ? this.player.getAvatar()
                        : this.maze.get(y).get(x).getAvatar());
            });
            System.out.println();
        });
    }

    private void triggerListeners() {
        this.time.increaseTime(1);
        if (!this.time.isNightTime() && this.time.getTicks() == 0) this.sun.moveSun();
    }

    private Position getNextPosition(String direction, int amount) {
        Position position = new Position(this.player.getSurface().getPosition().getX(), this.player.getSurface().getPosition().getY());

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
}
