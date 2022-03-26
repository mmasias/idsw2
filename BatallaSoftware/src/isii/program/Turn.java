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
	
	public int getTurn() {
		return this.turn;
	}
	
	public void setTurn(int turn) {
		this.turn = turn;
	}
	
	public void changeTurn() {
		if (getTurn() < numPlayers) addTurn();
		else {
			if (this.heroine.isDrinkPotion()) this.coundRounds();
			setTurn(0);
		}
	}
	
	public void addTurn() {
		this.setTurn(this.getTurn() + 1);
	}
	
	public void coundRounds() {
		if (this.getRounds() < 2) this.rounds++;
		else {
			this.heroine.setDrinkPotion(false);
			this.heroine.recoverEnergy(this.heroine.getEnergy().getEnergyBar().getMaximum());
			this.rounds = 0;
		}
	}
	
	public int getRounds() {
		return this.rounds;
	}
}
