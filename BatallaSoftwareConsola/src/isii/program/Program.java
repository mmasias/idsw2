package isii.program;

import java.util.Scanner;

public class Program {
	private static Game game;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mode = 0;
		System.out.println("Seleccione modo: 1-Normal, 2-Horde, Otro(0 no)-Exit");
		while (mode == 0) {
			mode = sc.nextInt();
			if (mode == 1) {
				//Normal Game
				game = new Game(false, sc);
			} else if (mode == 2) {
				//Horde Game
				game = new Game(true, sc);
			} else if (mode != 0) {
				break;
			}
		}
		
		while (!game.anyDead()) {
			game.play();
		}
		game.winner();
	}

}