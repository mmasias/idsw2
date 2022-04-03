package isii.characters;

import java.awt.Graphics2D;
import java.util.Random;
import isii.attacks.Attack;
import isii.characters.energy.Energy;
import isii.images.characters.ImageHeroine;
import isii.other.Dimensions;

public class Heroine extends Character {
	
	private boolean defend;
	private boolean drinkPotion;
	private int numSprite;
	private int numAttack;
	
	public Heroine(Attack ataque1, Attack ataque2, Attack ataque3, Energy energy) {
		super(ataque1, ataque2, ataque3, Dimensions.heroineDimension(), 
				new ImageHeroine(Dimensions.heroineDimension()), energy);
		this.defend = false;
		this.drinkPotion = false;
		this.numAttack = 1;
		this.numSprite = 1;
	}
	
	
	/**
	 * Metodo para pintar la heroine, todas las acciones
	 * @param g
	 */
	public synchronized void paint(Graphics2D g) {
		if (!this.weapon.isAttackFinish()) this.paintAttack(numAttack, g);
		else if (this.isDrinkPotion()) g.drawImage(((ImageHeroine) this.weapon.getImageCharacter()).getImagePotion(numSprite), X, Y, WIDTH, HEIGHT, null);
		else if (this.isDefend()) g.drawImage(((ImageHeroine) this.weapon.getImageCharacter()).getImageDefend(), X, Y, WIDTH, HEIGHT, null);
		else if (this.getEnergy().isFainting()) g.drawImage(this.weapon.getImageCharacter().getImageFainting(), X, Y, WIDTH, HEIGHT, null);
		else paintHalt(g);
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
		this.numAttack = numAttack;
		this.attackEnemy(numAttack, character);
	}
	
	public synchronized void recoverEnergyPotion() {
		this.setDrinkPotion(false);
		this.recoverEnergy(this.getEnergy().getEnergyBar().getMaximum());
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
	
	public void printAnimationPotion() {
		SwapImagePotion swapImagePotion = new SwapImagePotion(12);
		swapImagePotion.start();
	}
	
	/**
	 * Cambiar el sprite de la animacion de la pocion
	 * @author marco
	 *
	 */
	private class SwapImagePotion extends Thread {
		
		private int finalSprite;
		
		public SwapImagePotion(int finalSprite) {
			this.finalSprite = finalSprite;
		}
		
		@Override
		public synchronized void run() {
			for (numSprite = 1; numSprite < finalSprite; numSprite++) {
				try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
			}
		}
		
	}

}
