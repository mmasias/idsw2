package isii.program;

import java.util.Random;
import java.util.Scanner;
import isii.characters.Heroine;
import isii.characters.Vampiress;

public class HordeGame {

	private Heroine heroine;
	private Vampiress vampiress_1, vampiress_2, vampiress_3;
	private Turn turn;
	private Scanner sc;
	private int numPotion = 3;
	
	public HordeGame(Heroine heroine, Vampiress vampiress_1, Vampiress vampiress_2, Vampiress vampiress_3, Turn turn, Scanner sc) {
		this.heroine = heroine;
		this.vampiress_1 = vampiress_1;
		this.vampiress_2 = vampiress_2;
		this.vampiress_3 = vampiress_3;
		this.turn = turn;
		this.sc = sc;
	}
	
	public void play() {
		printEnergy();
		System.out.println("--------------------------------------------------------------------------------------------");
		if (turn.getTurn() == 0) {
			System.out.println("Turno Heroina");
			turnHeroine();
		}
		if (turn.getTurn() == 1) {
			System.out.println("Turno Vampiresa 1");
			turnVampiress(this.vampiress_1);
		}
		if (turn.getTurn() == 2) {
			System.out.println("Turno Vampiresa 2");
			turnVampiress(this.vampiress_2);
		}
		if (turn.getTurn() == 3) {
			System.out.println("Turno Vampiresa 3");
			turnVampiress(this.vampiress_3);
		}
		
	}
	
	private void printEnergy() {
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("Heroina: Vida-> " + heroine.getEnergy().getEnergy());
		System.out.println("Vampiress: Vida-> " + vampiress_1.getEnergy().getEnergy());
		System.out.println("Vampiress: Vida-> " + vampiress_2.getEnergy().getEnergy());
		System.out.println("Vampiress: Vida-> " + vampiress_3.getEnergy().getEnergy());
		System.out.println("--------------------------------------------------------------------------------------------");
	}
	
	public boolean anyCharacterDead() {
		return this.heroine.isDead() || hordeDead();
	}
	
	private boolean hordeDead() {
		if (this.vampiress_1.isDead() && this.vampiress_2.isDead() && this.vampiress_3.isDead()) return true;
		else return false;
	}

	private void turnHeroine() {
		if (heroine.isDead()) {
			System.out.println("Heroina muerta");
		} else if (heroine.isFainting()) {
			System.out.println("Heroine esta desmayada recupera 2 de vida");
			heroine.recoverEnergyFainting();
			turn.changeTurn();
		} else {
			if (heroine.isDrinkPotion()) {
				System.out.println("La heroine se esta tomando la pocion");
				turn.changeTurn();
			} else {
				printText();
				int num = sc.nextInt();
				if (num > 0 && num < 4) {
					System.out.println("Heroina ataca a Vampiresa con ataque numero: " + num);
					heroine.yourTurn(num, getVampiress());
					turn.changeTurn();
				} else if (num == 4) {
					heroine.setDefend(true);
					System.out.println("Heroina defensa:" + (heroine.isDefend() ? " exitosa" : " fallida"));
					turn.changeTurn();
				} else if (num == 5) {
					if (numPotion > 0) {
						heroine.setDrinkPotion(true);
						System.out.println("Heroina tomando pocion");
						turn.changeTurn();
						numPotion--;
					} else {
						System.out.println("No quedan pociones");
					}
				} else {
					System.out.println("Opcion no valida");
				}
			}
		}
	}
	
	private Vampiress getVampiress() {
		if (!vampiress_1.isDead()) return this.vampiress_1;
		else if (!vampiress_2.isDead()) return this.vampiress_2;
		else return this.vampiress_3;
	}

	private void turnVampiress(Vampiress vampiress) {
		if (vampiress.isDead()) {
			System.out.println("Vampiresa muerta");
			turn.changeTurn();
		} else if (vampiress.isFainting()) {
			System.out.println("Vampiresa esta desmayada recupera 2 de vida");
			vampiress.recoverEnergyFainting();
			turn.changeTurn();
		} else {
			int numAttack = newAttack();
			vampiress.yourTurn(numAttack, heroine);
			System.out.println("La vampiresa usa el ataque numero " + numAttack);
			turn.changeTurn();
		}
	}
	
	/*
	 * Asignar nuevo valor aleatorio al ataque
	 */
	private synchronized int newAttack() {
		return new Random().nextInt(3) + 1;
	}

	private void printText() {
		System.out.println("Escoge arma: ");
		System.out.println("1- Arma 1: Daño-> 7,  Probabilidad-> 50%");
		System.out.println("2- Arma 2: Daño-> 15,  Probabilidad-> 25%");
		System.out.println("3- Arma 3: Daño-> 30,  Probabilidad-> 12%");
		System.out.println("4- Defenderse");
		System.out.println("5- Pocion (" + numPotion + ")");
	}
}
