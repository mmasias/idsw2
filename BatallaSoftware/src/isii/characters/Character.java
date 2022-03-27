package isii.characters;

import java.awt.Graphics2D;
import isii.attacks.CharacterWeapon;
import isii.images.ImageCharacter;
import isii.attacks.Attack;

public abstract class Character{
	
	protected CharacterWeapon weapon;
	private Energy energy;
	protected boolean image = true;
	protected final int X;
	protected final int Y;
	protected final int WIDTH;
	protected final int HEIGHT;
	
	public Character(Attack ataque1, Attack ataque2, Attack ataque3, int x, int y, int width, int height, ImageCharacter imageCharacter, Energy energy) { 
		this.X = x;
		this.Y = y;
		this.WIDTH = width;
		this.HEIGHT = height;
		this.energy = energy;
		this.weapon = new CharacterWeapon(ataque1, ataque2, ataque3, imageCharacter);
		new SwapImageHalt().start();
	}
	
	/**
	 * Numero del ataque y la energia del enemigo
	 * @param numAttack
	 * @param energy
	 */
	public void startAttack(int numAttack, Energy energy) {
		weapon.startAttack(weapon.getAttack(numAttack) , numAttack, energy);
	}
	
	public synchronized void paintAttack(int numAttack, Graphics2D g) {
		weapon.paintAttack(numAttack, g);
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
