package isii.characters;

import java.util.Random;
import isii.attacks.Attack;
import isii.characters.energy.Energy;

public class Heroine extends Character {
	
	private boolean defend;
	private boolean drinkPotion;
	
	public Heroine(Attack ataque1, Attack ataque2, Attack ataque3, Energy energy) {
		super(ataque1, ataque2, ataque3, energy);
		this.defend = false;
		this.drinkPotion = false;
	}
	
	/**
	 * Metodo publico para atacar
	 * @param numAttack
	 * @param character
	 */
	public synchronized void yourTurn(int numAttack, Character character) {
		heroineAttack(numAttack, character);
	}
	
	private synchronized void heroineAttack(int numAttack, Character character) {
		this.attackEnemy(numAttack, character);
	}
	
	public synchronized void recoverEnergyPotion() {
		this.setDrinkPotion(false);
		this.recoverEnergy(this.getEnergy().getMaxEnergy());
	}
	
	public synchronized boolean isDrinkPotion() {
		return drinkPotion;
	}

	public  void setDrinkPotion(boolean drinkPotion) {
		this.drinkPotion = drinkPotion;
	}
	
	public boolean isDefend() {
		return this.defend;
	}
	
	public void setDefend(boolean defend) {
		this.defend = defend ? get80Percent() ? true : false : false;
	}
	
	private boolean get80Percent() {
		return new Random().nextInt(101) <= 80;
	}
	
}
