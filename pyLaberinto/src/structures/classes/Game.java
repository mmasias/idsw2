package structures.classes;

import structures.classes.players.*;
import structures.classes.surfaces.*;
import structures.classes.time.Time;
import structures.enums.PlayerType;
import structures.interfaces.Drawable;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    private List<List<Drawable>> maze;
    private Player player;
    private Time time;

    public Game(List<List<Drawable>> maze, Player player, Time time) {
        this.maze = maze;
        this.player = player;
        this.time = time;
    }

    public void Begin() {
        try {
            final Scanner scanner = new Scanner(System.in);
            while (true) {
                final String nextMovementText = Colors.GREEN_BG
                        + "Next movement: [w] [a] [s] [d] [q] [e] [z] [c] "
                        + Colors.RESET + "    " + "\n" + "    " + Colors.CYAN_BG;
                String selection = "";
                this.time.show();
                printMaze();

                if (player instanceof Walker)
                    System.out.print(nextMovementText + "(b:boat) (f:carpet) (h:horse) (x:exit)" + Colors.RESET + " ");
                else if (player instanceof Boat)
                    System.out
                            .println(nextMovementText + "(l:walk) (f:carpet) (h:horse) (x:exit)" + Colors.RESET + " ");
                else if (player instanceof Horse)
                    System.out
                            .println(nextMovementText + "(l:walk) (f:carpet) (b:boat) (x:exit)" + Colors.RESET + " ");
                else if (player instanceof Carpet)
                    System.out.println(nextMovementText + "(l:walk) (h:horse) (b:boat) (x:exit)" + Colors.RESET + " ");
                else
                    System.exit(1);

                System.out.println();
                selection = scanner.nextLine();

                if (selection.equals("w") || selection.equals("a") || selection.equals("s") || selection.equals("d")
                        || selection.equals("q") || selection.equals("e") || selection.equals("z")
                        || selection.equals("c")) {
                    tryAdvance(selection, 1);
                } else if (selection.equals("b") || selection.equals("f") || selection.equals("h")
                        || selection.equals("l")) {
                    if (selection.equals("b"))
                        this.player = (Player.getPlayerType(PlayerType.BOAT,
                                new Position(player.getPosition().getX(), player.getPosition().getY())));
                    else if (selection.equals("f"))
                        this.player = (Player.getPlayerType(PlayerType.CARPET,
                                new Position(player.getPosition().getX(), player.getPosition().getY())));
                    else if (selection.equals("l"))
                        this.player = (Player.getPlayerType(PlayerType.WALKER,
                                new Position(player.getPosition().getX(), player.getPosition().getY())));
                    else if (selection.equals("h"))
                        this.player = (Player.getPlayerType(PlayerType.HORSE,
                                new Position(player.getPosition().getX(), player.getPosition().getY())));
                } else if (selection.equals("x")) {
                    System.exit(0);
                } else {
                    System.out.println(
                            Colors.RED_BG + Colors.BLACK + "WRONG INPUT" + Colors.RESET + "\n");
                }
            }
        } catch (InputMismatchException exception) {
            System.out.println(
                    Colors.RED_BG + Colors.BLACK + exception.getMessage() + Colors.RESET);
        }
    }

    private void printMaze() {
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

        List<List<Drawable>> mazeToShow = IntStream.range(maxYIndex, minYIndex + 1).mapToObj(y -> {
            return IntStream.range(minXIndex, maxXIndex + 1).mapToObj(x -> {
                if (y < 0 || x < 0 || y >= this.maze.size() || x >= this.maze.get(0).size())
                    return Surface.getSurface(6);
                else
                    return this.maze.get(y).get(x);
            }).collect(Collectors.toList());
        }).collect(Collectors.toList());

        if (this.time.isNightTime()) {
            return reduceVision(mazeToShow, 3);
        } else if (this.time.isVisionReduced()) {
            return reduceVision(mazeToShow, 7);
        } else {
            return mazeToShow;
        }
    }

    private List<List<Drawable>> reduceVision(List<List<Drawable>> mazeToReduce, final int range) {
        return IntStream.range(0, mazeToReduce.size()).mapToObj(y -> {
            return IntStream.range(0, mazeToReduce.get(0).size()).mapToObj(x -> {
                return (Math.abs(x - 8) + Math.abs(y - 8) <= range) ? mazeToReduce.get(y).get(x) : new Ground();
            }).collect(Collectors.toList());
        }).collect(Collectors.toList());
    }

    public void printFullMaze() {
        IntStream.range(0, this.maze.size()).forEach(y -> {
            IntStream.range(0, this.maze.get(0).size()).forEach(x -> {
                System.out.print(y == this.player.getPosition().getY() && x == this.player.getPosition().getX()
                        ? this.player.getAvatar()
                        : this.maze.get(y).get(x).getAvatar());
            });
            System.out.println();
        });
    }

    private void tryAdvance(String direction, int amount) {
        Position nextPosition = this.getNextPosition(direction, amount);
        if (((Surface) this.maze.get(nextPosition.getY()).get(nextPosition.getX())).canAdvance(this.player)
                && (nextPosition.getX() > 0 && nextPosition.getY() > 0 && nextPosition.getX() < this.maze.get(0).size()
                        && nextPosition.getY() < this.maze.size())) {
            this.player.setPosition(nextPosition);
        }
        this.time.increaseTime(1);
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
}
