package isii.program;

import java.util.Scanner;
import isii.attacks.Attack;
import isii.characters.Heroine;
import isii.characters.Vampiress;
import isii.characters.energy.Energy;

public class Game {
	private Heroine heroine;
	private Vampiress vampiress_1, vampiress_2, vampiress_3;
	
	private Turn turn;
	private int heroineEnergy;
	private int vampiressEnergy;
	private int numPlayers;
	private boolean horde;
	private Scanner sc;
	private NormalGame normalGame;
	private HordeGame hordeGame;
	
	public Game(boolean horde, Scanner sc) {
		vampiressEnergy = 60;
		this.numPlayers = horde ? 4 : 2;
		this.horde = horde;
		this.heroineEnergy = horde ? 250 : 150;
		this.sc = sc;
		createCharacters();
		playGame();
	}

	public void play() {
		if (horde) {
			//Horda
			hordeGame.play();
		} else {
			normalGame.play();
		}
	}
	
	private void playGame() {
		if (horde) {
			//Modo horda
			hordeGame = new HordeGame(heroine, vampiress_1, vampiress_2, vampiress_3, turn, sc);
		} else {
			//Modo Normal
			normalGame = new NormalGame(heroine, vampiress_1, turn, sc);
		}
	}
	
	public boolean anyDead() {
		if (horde) return hordeGame.anyCharacterDead();
		else return normalGame.anyCharacterDead();
	}
	
	public void winner() {
		if (heroine.isDead()) System.out.println("Heroina pierde");
		else System.out.println("Heroina gana");
	}
	
	private void createCharacters() {
		createHeroine();
		createVampiress();
		if (horde) createHorde();
	}

	private void createHeroine() {
		Attack attack1 = new Attack(7, 50, 100);
		Attack attack2 = new Attack(15, 25, 100);
		Attack attack3 = new Attack(30, 12, 100);
		Energy heroineEnergy = new Energy(this.heroineEnergy, 30);
		heroine = new Heroine(attack1, attack2, attack3, heroineEnergy);
		turn = new Turn(numPlayers, heroine);
	}
	
	private void createVampiress() {
		Attack attack1 = new Attack(5, 90);
		Attack attack2 = new Attack(10, 60);
		Attack attack3 = new Attack(20, 40);
		Energy vampiressEnergy = new Energy(this.vampiressEnergy, 20);
		vampiress_1 = new Vampiress(attack1, attack2, attack3, vampiressEnergy);
	}
	
	private void createHorde() {
		Energy vampiressEnergy2 = new Energy(vampiressEnergy, 20);
		vampiress_2 = new Vampiress(new Attack(5, 90), new Attack(10, 60), new Attack(20, 40), vampiressEnergy2);
		
		Energy vampiressEnergy3 = new Energy(vampiressEnergy, 20);
		vampiress_3 = new Vampiress(new Attack(5, 90), new Attack(10, 60), new Attack(20, 40), vampiressEnergy3);
	}
}
