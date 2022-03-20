package isii.attacks;

import java.awt.Graphics2D;
import java.awt.Image;

import isii.characters.ImageHeroine;
import isii.characters.SpriteImage;

public class HeroineWeapon {
	
	private Attack attack1;
	private Attack attack2;
	private Attack attack3;
	private ImageHeroine imageHeroine;
	private boolean attackFinish = true;
	private int spritesAttack = 1;
	
	public HeroineWeapon(Attack attack1, Attack attack2, Attack attack3, int X, int Y, int WIDTH, int HEIGHT) {
		imageHeroine = new ImageHeroine(X, Y, WIDTH, HEIGHT);
		attack1 = attack1.withAttack();
		attack2 = attack2.withAttack();
		attack3 = attack3.withAttack();
	}
	
	/**
	 * Metodo que se utiliza para dar comienzo a un ataque
	 * @param ataque
	 * @param numAttack
	 */
	public void startAttack(Attack ataque, int numAttack) {
		// TODO Sí se realiza con exito el ataque, quitar vida Vampiresa
		//spritesAttack = imageHeroine.getNumSprites(numAttack);
		//spritesAttack = 23;
		try {
			spritesAttack = 1;
			new SwapImageAttack(imageHeroine.getNumSprites(numAttack)).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void paintAttack(int numAttack, Graphics2D g) {
		try {
			SpriteImage sprite = imageHeroine.getImage(numAttack, spritesAttack).withSpriteImage();
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
	public Attack getAttack(int numAttack) throws Exception {
		if (numAttack == 1) return attack1;
		else if (numAttack == 2) return attack2;
		else if (numAttack == 3) return attack3;
		else throw new Exception();
	}
	
	public void setAttackFinish(boolean state) {
		this.attackFinish = state;
	}
	
	public boolean isAttackFinish() {
		return attackFinish;
	}
	
	/**
	 * Devuelve la imagen de la heroina cuando esta quieta en el sitio
	 * @param numSprite
	 * @return
	 */
	public Image getImageHeroineHalt(int numSprite) {
		return imageHeroine.getImageHalt(numSprite);
	}
	
	/**
	 * Metodo que se encarga de cambiar el numero de la imagen para que de sensacion de animacion
	 * public SwapImageAttack(int numAttack) 
	 * @author marco
	 *
	 */
	private class SwapImageAttack extends Thread {
		
		private int finalSprite;
		
		public SwapImageAttack(int finalSprite) {
			this.finalSprite = finalSprite;
		}
		
		@Override
		public synchronized void run() {
			for (spritesAttack = 1; spritesAttack <= finalSprite; spritesAttack++) {
				try { Thread.sleep(100); } catch (InterruptedException e) {}
			}
			setAttackFinish(true);
		}
	}
}
