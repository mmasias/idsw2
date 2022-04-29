package isii.program;

import java.util.Random;
import java.util.Scanner;

import isii.characters.Heroine;
import isii.characters.Vampiress;

public class NormalGame {
	
	private Heroine heroine;
	private Vampiress vampiress;
	private Turn turn;
	private Scanner sc;
	private int numPotion = 1; 
	
	public NormalGame(Heroine heroine, Vampiress vampiress, Turn turn, Scanner sc) {
		this.heroine = heroine;
		this.vampiress = vampiress;
		this.turn = turn;
		this.sc = sc;
	}
	
	public void play() {
		printEnergy();
		System.out.println("--------------------------------------------------------------------------------------------");
		if (turn.getTurn() == 0) turnHeroine();
		if (turn.getTurn() == 1) turnVampiress();
		
	}
	
	private void printEnergy() {
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("Heroina: Vida-> " + heroine.getEnergy().getEnergy());
		System.out.println("Vampiress: Vida-> " + vampiress.getEnergy().getEnergy());
		System.out.println("--------------------------------------------------------------------------------------------");
	}
	
	public boolean anyCharacterDead() {
		return this.heroine.isDead() || this.vampiress.isDead();
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
					heroine.yourTurn(num, vampiress);
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
	
	private void turnVampiress() {
		if (vampiress.isDead()) {
			System.out.println("Vampiresa muerta");
		} else if (vampiress.isFainting()) {
			System.out.println("Vampiresa esta desmayada recupera 2 de vida");
			vampiress.recoverEnergyFainting();
			turn.changeTurn();
		} else {
			int numAttack = newAttack();
			System.out.println("La vampiresa usa el ataque numero " + numAttack);
			vampiress.yourTurn(numAttack, heroine);
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
