package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

		final Time time;
		final Sun sun;
		sun = new Sun();
		time = new Time();

        Scanner enter = new Scanner(System.in);
		String selection;
		boolean EndGame = false;
		int viewport = 8;


		System.out.print("\033[H\033[2J");
		System.out.flush();

        do {

			time.avanzarHora(sun);

			System.out.print("\033[0;0H");System.out.flush();	
			
			System.out.print(Colors.BLOCK);for(int i=0;i<=viewport*2;i=i+1){System.out.print(Colors.BLOCK);}System.out.println(Colors.BLOCK);
			System.out.print(Colors.BLOCK);

			Sun.showSun(time.getHour(), time.getMinutes());

			System.out.println(Colors.BLOCK);

			System.out.print(Colors.BLOCK);
			for (int i = 0; i <= viewport * 2; i = i + 1) {
				System.out.print(Colors.BLOCK);
			}
			System.out.println(Colors.BLOCK);

            World.showMaze(sun.getBrightness(), viewport);

			System.out.print("Lat:[" + World.actualRow + "] Long:[" + World.actualColumn + "] - ");
			System.out.println("[" + time.getHour() + "]h:[" + time.getMinutes() + "]m     ");
			System.out.println();
			System.out.println("Commands: w/a/s/d (f:exit) (b:boat) (c:horse) (x:Flying carpet)");
			selection = enter.nextLine();

			if (selection.equalsIgnoreCase("f")) {
				EndGame = true;
			} else if (selection.equalsIgnoreCase("c")) {
				if (Characters.boat == true || Characters.flyingCarpet == true) {
					Characters.boat = false;
					Characters.flyingCarpet = false;
				}
				Characters.horse = !Characters.horse;
			} else if (selection.equalsIgnoreCase("x")) {
				if (Characters.boat == true || Characters.horse == true) {
					Characters.boat = false;
					Characters.horse = false;
				}
				Characters.flyingCarpet = !Characters.flyingCarpet;
			} else if (selection.equalsIgnoreCase("b")) {
				if (Characters.horse == true || Characters.flyingCarpet == true) {
					Characters.horse = false;
					Characters.flyingCarpet = false;
				}
				Characters.boat = !Characters.boat;
			} else if (selection.equalsIgnoreCase("w") && World.actualRow > 0) {
				if (Characters.boat == false && Characters.horse == false && Characters.flyingCarpet == false) {
					if (World.maze[World.actualRow - 1][World.actualColumn] % 2 == 0) {
						World.actualRow = World.actualRow - 1;
					}
				} else if (Characters.boat == true) {
					if (World.maze[World.actualRow - 1][World.actualColumn] == 3 || World.maze[World.actualRow - 1][World.actualColumn] == 11) {
						World.actualRow = World.actualRow - 1;
					}
				} else if (Characters.horse == true) {
					if (World.maze[World.actualRow - 1][World.actualColumn] == 7) {
						World.actualRow = World.actualRow - 1;
					}
				} else if (Characters.flyingCarpet == true) {
					if (World.maze[World.actualRow - 1][World.actualColumn] == 9) {
						World.actualRow = World.actualRow - 1;
					}
				}
			} else if (selection.equalsIgnoreCase("s")) {
				if (Characters.boat == false && Characters.horse == false && Characters.flyingCarpet == false) {
					if (World.maze[World.actualRow + 1][World.actualColumn] % 2 == 0) {
						World.actualRow = World.actualRow + 1;
					}
				} else if (Characters.boat == true) {
					if (World.maze[World.actualRow + 1][World.actualColumn] == 3 || World.maze[World.actualRow + 1][World.actualColumn] == 11) {
						World.actualRow = World.actualRow + 1;
					}
				} else if (Characters.horse == true) {
					if (World.maze[World.actualRow + 1][World.actualColumn] == 7) {
						World.actualRow = World.actualRow + 1;
					}
				} else if (Characters.flyingCarpet == true) {
					if (World.maze[World.actualRow + 1][World.actualColumn] == 9) {
						World.actualRow = World.actualRow + 1;
					}
				}
			} else if (selection.equalsIgnoreCase("a")) {
				if (Characters.boat == false && Characters.horse == false && Characters.flyingCarpet == false) {
					if (World.maze[World.actualRow][World.actualColumn - 1] % 2 == 0) {
						World.actualColumn = World.actualColumn - 1;
					}
				} else if (Characters.boat == true) {
					if (World.maze[World.actualRow][World.actualColumn - 1] == 3 || World.maze[World.actualRow][World.actualColumn - 1] == 11) {
						World.actualColumn = World.actualColumn - 1;
					}
				} else if (Characters.horse == true) {
					if (World.maze[World.actualRow][World.actualColumn - 1] == 7) {
						World.actualColumn = World.actualColumn - 1;
					}
				} else if (Characters.flyingCarpet == true) {
					if (World.maze[World.actualRow][World.actualColumn - 1] == 9) {
						World.actualColumn = World.actualColumn - 1;
					}
				}
			} else if (selection.equalsIgnoreCase("d")) {
				if (Characters.boat == false && Characters.horse == false && Characters.flyingCarpet == false) {
					if (World.maze[World.actualRow][World.actualColumn + 1] % 2 == 0) {
						World.actualColumn = World.actualColumn + 1;
					}
				} else if (Characters.boat == true) {
					if (World.maze[World.actualRow][World.actualColumn + 1] == 3 || World.maze[World.actualRow][World.actualColumn + 1] == 11) {
						World.actualColumn = World.actualColumn + 1;
					}
				} else if (Characters.horse == true) {
					if (World.maze[World.actualRow][World.actualColumn + 1] == 7) {
						World.actualColumn = World.actualColumn + 1;
					}
				} else if (Characters.flyingCarpet == true) {
					if (World.maze[World.actualRow][World.actualColumn + 1] == 9) {
						World.actualColumn = World.actualColumn + 1;
					}
				}
			}
			
        } while (!EndGame);
    }
}
