package isii.characters;

import java.awt.Graphics2D;
import isii.attacks.CharacterWeapon;
import isii.images.ImageCharacter;
import isii.attacks.Attack;

public class Character{
	
	private CharacterWeapon weapon;
	private Energy energy;
	private boolean image = true;
	private final int X;
	private final int Y;
	private final int WIDTH;
	private final int HEIGHT;
	
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
	
	public synchronized void paint(Graphics2D g) {
		if (image) g.drawImage(weapon.getImageHalt(1), X, Y, WIDTH, HEIGHT, null);
		else g.drawImage(weapon.getImageHalt(2), X, Y, WIDTH, HEIGHT, null);
		
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
