package isii.program;

import isii.characters.Heroine;

public class Turn {
	private int turn;
	private int rounds;
	private int numPlayers;
	private Heroine heroine;

	public Turn(int numPlayers, Heroine heroine) {
		this.turn = 0;
		this.rounds = 0;
		this.numPlayers = numPlayers - 1;
		this.heroine = heroine;
	}
	
	public synchronized int getTurn() {
		return this.turn;
	}
	
	public synchronized void setTurn(int turn) {
		this.turn = turn;
	}
	
	public synchronized void changeTurn() {
		if (getTurn() < numPlayers) this.addTurn();
		else {
			if (this.heroine.isDrinkPotion()) this.coundRoundsToDrinkPotion();
			this.setTurn(0);
		}
	}
	
	public synchronized void addTurn() {
		this.setTurn(this.getTurn() + 1);
	}
	
	public synchronized void coundRoundsToDrinkPotion() {
		if (this.getRounds() < 2) this.rounds++;
		else {
			this.heroine.recoverEnergyPotion();
			this.rounds = 0;
		}
	}
	
	public synchronized int getRounds() {
		return this.rounds;
	}
}
