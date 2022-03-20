package isii.characters;

import java.awt.Graphics2D;

import isii.attacks.HeroineWeapon;
import isii.attacks.Attack;

public class Heroine implements Character<HeroineWeapon>{
	
	private HeroineWeapon arma;
	private boolean image = true;
	private static final int X = 1000;
	private static final int Y = 120;
	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;
	
	public Heroine(Attack ataque1, Attack ataque2, Attack ataque3) {
		this.arma = new HeroineWeapon(ataque1, ataque2, ataque3, X, Y, WIDTH, HEIGHT);
		new SwapImageHalt().start();
	}
	
	@Override
	public void startAttack(int numAttack) {
		// TODO Sí se realiza con exito el ataque, quitar vida Vampiresa
		try {
			arma.startAttack(arma.getAttack(numAttack) , numAttack);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public synchronized void paint(Graphics2D g) {
		if (image) g.drawImage(arma.getImageHeroineHalt(1), X, Y, WIDTH, HEIGHT, null);
		else g.drawImage(arma.getImageHeroineHalt(2), X, Y, WIDTH, HEIGHT, null);
		
	}
	
	@Override
	public synchronized void paintAttack(int numAttack, Graphics2D g) {
		arma.paintAttack(numAttack, g);
	}
	
	public boolean isAttackFinish() {
		return this.arma.isAttackFinish();
	}
	
	public void setAttackFinish(boolean state) {
		this.arma.setAttackFinish(state);
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
