package isii.characters;

import isii.attacks.CharacterWeapon;
import isii.characters.energy.Energy;
import isii.attacks.Attack;

public abstract class Character{
	
	protected CharacterWeapon weapon;
	private Energy energy;
	
	public Character(Attack ataque1, Attack ataque2, Attack ataque3, Energy energy) { 
		this.energy = energy;
		this.weapon = new CharacterWeapon(ataque1, ataque2, ataque3);
	}
	
	/**
	 * Iniciar un ataque a alguien
	 * @param numAttack
	 * @param character
	 */
	protected void attackEnemy(int numAttack, Character character) {
		this.startAttack(numAttack, character.getEnergy());
	}
	
	/**
	 * Numero del ataque y la energia del enemigo
	 * @param numAttack
	 * @param energy
	 */
	public void startAttack(int numAttack, Energy energy) {
		weapon.startAttack(weapon.getAttack(numAttack) , numAttack, energy);
	}
	
	
	public Energy getEnergy() {
		return this.energy;
	}
	
	public boolean isDead() {
		return this.getEnergy().isDead();
	}
	
	public synchronized boolean isFainting() {
		return this.getEnergy().isFainting();
	}
	
	public synchronized void recoverEnergyFainting() {
		this.recoverEnergy(2);
	}
	
	/**
	 * Recuperar energia, tanto si es por pocion o por desmayo
	 * @param energy
	 */
	protected void recoverEnergy(int energy) {
		this.getEnergy().setEnergy(energy, false);
	}
	
	public CharacterWeapon getCharacterWeapon() {
		return this.weapon;
	}
}
