import structures.classes.players.*;
import structures.classes.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
        public static void main(String[] args) {
                World world = new World();
                try {
                        final Scanner scanner = new Scanner(System.in);
                        while (true) {
                                final String nextMovementText = Colors.GREEN_BG + "Insert next movement: [w] [a] [s] [d] [q] [e] [z] [c] " + Colors.RESET + "    " + "\n" + "    " + Colors.CYAN_BG;
                                String selection = "";

                                world.print();

                                if (world.getPlayer() instanceof Walker)
                                        System.out.println(nextMovementText + "(b:boat) (f:carpet) (h:horse) (x:exit)" + Colors.RESET + " ");
                                else if (world.getPlayer() instanceof Boat)
                                        System.out.println(nextMovementText + "(l:walk) (f:carpet) (h:horse) (x:exit)" + Colors.RESET + " ");
                                else if (world.getPlayer() instanceof Horse)
                                        System.out.println(nextMovementText + "(l:walk) (f:carpet) (b:boat) (x:exit)" + Colors.RESET + " ");
                                else if (world.getPlayer() instanceof Carpet)
                                        System.out.println(nextMovementText + "(l:walk) (h:horse) (b:boat) (x:exit)" + Colors.RESET + " ");
                                else
                                        System.exit(1);

                                System.out.println();
                                selection = scanner.nextLine();

                                if (selection.equals("w") || selection.equals("a") || selection.equals("s") || selection.equals("d") || selection.equals("q") || selection.equals("e") || selection.equals("z") || selection.equals("c")) {
                                        world.updateState(selection, 1);
                                } else if (selection.equals("b") || selection.equals("f") || selection.equals("h") || selection.equals("l")) {
                                        world.updateState(selection);
                                } else if (selection.equals("x")) {
                                        System.exit(0);
                                } else {
                                        System.out.println(Colors.RED_BG + Colors.BLACK + "WRONG INPUT" + Colors.RESET + "\n");
                                }
                        }
                } catch (InputMismatchException exception) {
                        System.out.println(Colors.RED_BG + Colors.BLACK + exception.getMessage() + Colors.RESET);
                }
        }
}
