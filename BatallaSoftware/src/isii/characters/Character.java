package isii.characters;

import java.awt.Graphics2D;
import isii.attacks.CharacterWeapon;
import isii.characters.energy.Energy;
import isii.images.characters.ImageCharacter;
import isii.other.Dimension;
import isii.attacks.Attack;

public abstract class Character{
	
	protected CharacterWeapon weapon;
	private Energy energy;
	protected boolean image = true;
	protected final int X;
	protected final int Y;
	protected final int WIDTH;
	protected final int HEIGHT;
	
	public Character(Attack ataque1, Attack ataque2, Attack ataque3, Dimension dimension, ImageCharacter imageCharacter, Energy energy) { 
		this.X = dimension.getX();
		this.Y = dimension.getY();
		this.WIDTH = dimension.getWidth();
		this.HEIGHT = dimension.getHeight();
		this.energy = energy;
		this.weapon = new CharacterWeapon(ataque1, ataque2, ataque3, imageCharacter);
		new SwapImageHalt().start();
	}
	
	/**
	 * Iniciar un ataque a alguien
	 * @param numAttack
	 * @param character
	 */
	protected void attackEnemy(int numAttack, Character character) {
		this.setAttackFinish(false);
		character.getEnergy().setEnergyFinished(false);
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
	
	protected synchronized void paintAttack(int numAttack, Graphics2D g) {
		weapon.paintAttack(numAttack, g);
	}
	
	/**
	 * Pintar la heroine cuando esta quieta
	 * @param g
	 */
	protected synchronized void paintHalt(Graphics2D g) {
		if (image) g.drawImage(this.weapon.getImageHalt(1), X, Y, WIDTH, HEIGHT, null);
		else g.drawImage(this.weapon.getImageHalt(2), X, Y, WIDTH, HEIGHT, null);
	}
	
	public boolean isAttackFinish() {
		return this.weapon.isAttackFinish();
	}
	
	public void setAttackFinish(boolean state) {
		this.weapon.setAttackFinish(state);
	}
	
	public Energy getEnergy() {
		return this.energy;
	}
	
	public boolean isDead() {
		return this.getEnergy().isDead();
	}
	
	public synchronized boolean isEnergyRecovered() {
		return this.getEnergy().isEnergyRecovered();
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
		this.getEnergy().setEnergyFinished(false);
		this.getEnergy().setEnergy(energy, false);
	}
	
	public CharacterWeapon getCharacterWeapon() {
		return this.weapon;
	}
	
	/**
	 * Sincronizacion de la imagen de la heroina cuando esta detenida
	 * @author marco
	 *
	 */
	private class SwapImageHalt extends Thread {
		
		@Override
		public synchronized void run() {
			while(true) {
				try { Thread.sleep(500); } catch (InterruptedException e) {}
				if (image) image = false;
				else image = true;
			}
		}
	}
}
