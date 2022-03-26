package isii.attacks;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;
import isii.characters.Energy;
import isii.images.ImageCharacter;
import isii.images.SpriteImage;

public class CharacterWeapon {
	
	private Attack attack1;
	private Attack attack2;
	private Attack attack3;
	private ImageCharacter imageCharacter;
	private boolean attackFinish = true;
	private int spritesAttack = 1;
	
	public CharacterWeapon(Attack attack1, Attack attack2, Attack attack3, ImageCharacter imageCharacter) {
		//this.imageCharacter = new ImageHeroine(X, Y, WIDTH, HEIGHT);
		this.imageCharacter = imageCharacter;
		this.attack1 = attack1;
		this.attack2 = attack2;
		this.attack3 = attack3;
	}
	
	/**
	 * Metodo que se utiliza para dar comienzo a un ataque
	 * @param ataque
	 * @param numAttack
	 */
	public synchronized void startAttack(Attack ataque, int numAttack, Energy energy) {
		// TODO Quitar vida Vampiresa no a mi mismo
		try {
			spritesAttack = 1;
			new SwapImageAttack(imageCharacter.getNumSprites(numAttack), getAttack(numAttack), energy).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Pintar la animacion del ataque
	 * @param numAttack
	 * @param g
	 */
	public synchronized void paintAttack(int numAttack, Graphics2D g) {
		try {
			SpriteImage sprite = imageCharacter.getImage(numAttack, spritesAttack).withSpriteImage();
			g.drawImage(sprite.getImage(), sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight(), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que devuelve uno de los ataques pedidos
	 * @param numAttack
	 * @return
	 * @throws Exception
	 */
	public synchronized Attack getAttack(int numAttack) {
		if (numAttack == 1) return attack1;
		else if (numAttack == 2) return attack2;
		else return attack3;
	}
	
	public synchronized void setAttackFinish(boolean state) {
		this.attackFinish = state;
	}
	
	public synchronized boolean isAttackFinish() {
		return attackFinish;
	}
	
	/**
	 * Devuelve la imagen de la heroina cuando esta quieta en el sitio
	 * @param numSprite
	 * @return
	 */
	public synchronized Image getImageHalt(int numSprite) {
		return imageCharacter.getImageHalt(numSprite);
	}
	
	/**
	 * Metodo que se encarga de cambiar el numero de la imagen para que de sensacion de animacion
	 * public SwapImageAttack(int numAttack) 
	 * @author marco
	 *
	 */
	private class SwapImageAttack extends Thread {
		
		private int finalSprite;
		private int damage;
		private int success;
		private Energy energy;
		
		public SwapImageAttack(int finalSprite, Attack weapon, Energy energy) {
			this.finalSprite = finalSprite;
			this.damage = weapon.getDamage();
			this.success = weapon.getSuccess();
			this.energy = energy;
			if (weapon.getDurability() != null) weapon.countDurability();
		}
		
		@Override
		public synchronized void run() {
			for (spritesAttack = 1; spritesAttack < finalSprite; spritesAttack++) {
				try { Thread.sleep(100); } catch (InterruptedException e) {}
			}
			getSuccessDamage(damage, success, energy);
			setAttackFinish(true);
		}

		private void getSuccessDamage(int damage, int success, Energy energy) {
			int probability = new Random().nextInt(101);
			if (probability <= success) energy.setEnergy(damage, true);
			else energy.setEnergyFinished(true);
		}
	}
}
