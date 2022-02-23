package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner enter = new Scanner(System.in);
		String selection;
		boolean EndGame = false;
        int hour = 6;
		int minutes = 55;
		int torch = 100;
		int viewport = 8;


		System.out.print("\033[H\033[2J");
		System.out.flush();

        do {
			minutes = minutes + 55;
			if (minutes >= 60) {
				hour = hour + 1;
				minutes = 0;
			}
				if (hour==24){hour=0;}

			if (hour == 4) {
				torch = 3;
			} else if (hour == 5) {
				torch = 4;
			} else if (hour == 6) {
				torch = 5;
			} else if (hour == 7) {
				torch = 100;
			} else if (hour == 17) {
				torch = 10;
			} else if (hour == 18) {
				torch = 7;
			} else if (hour == 19) {
				torch = 5;
			} else if (hour == 20) {
				torch = 4;
			} else if (hour == 21) {
				torch = 3;
			}
			else if (hour == 22) {
				torch = 2;
			}

			System.out.print("\033[0;0H");System.out.flush();	// <-- 	En lugar de borrar pantalla, reposiciono el cursor
																				// 		en el borde superior izquierdo de la pantalla	
																				//		Con esto se atenúa el parpadeo
			
			System.out.print(Colors.BLOCK);for(int i=0;i<=viewport*2;i=i+1){System.out.print(Colors.BLOCK);}System.out.println(Colors.BLOCK);
			System.out.print(Colors.BLOCK);

			Sun.showSun(hour, minutes);

			System.out.println(Colors.BLOCK);

			System.out.print(Colors.BLOCK);
			for (int i = 0; i <= viewport * 2; i = i + 1) {
				System.out.print(Colors.BLOCK);
			}
			System.out.println(Colors.BLOCK);

            World.showMaze(torch, viewport);

			System.out.print("Lat:[" + World.actualRow + "] Long:[" + World.actualColumn + "] - ");
			System.out.println("[" + hour + "]h:[" + minutes + "]m     ");
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
