
public class Character {

    private String name;
    private String CharacterRep;
    private World world = new World();

    public Character() {
        // this.name = name;
        // this.CharacterRep = CharacterRep;
    }

    public void move(Position position, Character characters, String selection) {
        if (selection.equalsIgnoreCase("w") && position.getX() > 0) {
            if (characters.getChoice() == ":_;" && characters.getChoice() != "_/*" && characters.getChoice() != "|_|") {
                if (world.maze[position.getX() - 1][position.getY()] % 2 == 0) {
                    position.setX(position.getX() - 1);
                }
            } else if (characters.getChoice() == ":_;") {
                if (world.maze[position.getX() - 1][position.getY()] == 3 || world.maze[position.getX() - 1][position.getY()] == 11) {
                    position.setX(position.getX() - 1);
                }
            } else if (characters.getChoice() == "_/*") {
                if (world.maze[position.getX() - 1][position.getY()] == 7) {
                    position.setX(position.getX() - 1);
                }
            } else if (characters.getChoice() == "|_|") {
                if (world.maze[position.getX() - 1][position.getY()] == 9) {
                    position.setX(position.getX() - 1);
                }
            }
        } else if (selection.equalsIgnoreCase("s")) {
            if (characters.getChoice() != ":_;" && characters.getChoice() != "_/*" && characters.getChoice() != "|_|") {
                if (world.maze[position.getX() + 1][position.getY()] % 2 == 0) {
                    position.setX(position.getX() + 1);
                }
            } else if (characters.getChoice() == ":_;") {
                if (world.maze[position.getX() + 1][position.getY()] == 3 || world.maze[position.getX() + 1][position.getY()] == 11) {
                    position.setX(position.getX() + 1);
                }
            } else if (characters.getChoice() == "_/*") {
                if (world.maze[position.getX() + 1][position.getY()] == 7) {
                    position.setX(position.getX() + 1);
                }
            } else if (characters.getChoice() == "|_|") {
                if (world.maze[position.getX() + 1][position.getY()] == 9) {
                    position.setX(position.getX() + 1);
                }
            }
        } else if (selection.equalsIgnoreCase("a")) {
            if (characters.getChoice() != ":_;" && characters.getChoice() != "_/*" && characters.getChoice() != "|_|") {
                if (world.maze[position.getX()][position.getY() - 1] % 2 == 0) {
                    position.setY(position.getY() - 1);
                }
            } else if (characters.getChoice() == ":_;") {
                if (world.maze[position.getX()][position.getY() - 1] == 3 || world.maze[position.getX()][position.getY() - 1] == 11) {
                    position.setY(position.getY() - 1);
                }
            } else if (characters.getChoice() == "_/*") {
                if (world.maze[position.getX()][position.getY() - 1] == 7) {
                    position.setY(position.getY() - 1);
                }
            } else if (characters.getChoice() == "|_|") {
                if (world.maze[position.getX()][position.getY() - 1] == 9) {
                    position.setY(position.getY() - 1);
                }
            }
        } else if (selection.equalsIgnoreCase("d")) {
            if (characters.getChoice() != ":_;" && characters.getChoice() != "_/*" && characters.getChoice() != "|_|") {
                if (world.maze[position.getX()][position.getY() + 1] % 2 == 0) {
                    position.setY(position.getY() + 1);
                }
            } else if (characters.getChoice() == ":_;") {
                if (world.maze[position.getX()][position.getY() + 1] == 3 || world.maze[position.getX()][position.getY() + 1] == 11) {
                    position.setY(position.getY() + 1);
                }
            } else if (characters.getChoice() == "_/*") {
                if (world.maze[position.getX()][position.getY() + 1] == 7) {
                    position.setY(position.getY() + 1);
                }
            } else if (characters.getChoice() == "|_|") {
                if (world.maze[position.getX()][position.getY() + 1] == 9) {
                    position.setY(position.getY() + 1);
                }
            }
    }
}
    public void setChoice(String option) {
        boolean boat = false;
        boolean horse = false;
        boolean flyingCarpet = false;

        if (option == "h") {
            if (boat == true || flyingCarpet == true) {
                boat = false;
                flyingCarpet = false;
            }
            horse = !horse;
        } else if (option == "b") {
            if (horse == true || flyingCarpet == true) {
                horse = false;
                flyingCarpet = false;
            }
            boat = !boat;
        } else if (option == "c") {
            if (boat == true || horse == true) {
                boat = false;
                horse = false;
            }
            flyingCarpet = !flyingCarpet;
        }

        if (boat == false && horse == false && flyingCarpet == false) {
            CharacterRep = "_O_";
        } else if (boat == true) {
            CharacterRep = ":_;";
        } else if (horse == true) {
            CharacterRep = "_/*";
        } else if (flyingCarpet == true) {
            CharacterRep = "|_|";
        }
    }

    public String getChoice() {
        return CharacterRep;
    }
}
