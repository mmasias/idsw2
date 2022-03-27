package isii.characters;

import java.awt.Graphics2D;
import isii.attacks.Attack;
import isii.images.ImageVampiress;
import isii.other.Dimensions;

public class Enemy extends Character {

	public Enemy(Attack ataque1, Attack ataque2, Attack ataque3, Energy energy) {
		super(ataque1, ataque2, ataque3, Dimensions.enemyX, Dimensions.enemyY, Dimensions.enemyWidth, Dimensions.enemyHeight, 
				new ImageVampiress(Dimensions.enemyX, Dimensions.enemyY, Dimensions.enemyWidth, Dimensions.enemyHeight), energy);
	}
	
	public synchronized void paint(Graphics2D g) {
		if (image) g.drawImage(this.weapon.getImageHalt(1), X, Y, WIDTH, HEIGHT, null);
		else g.drawImage(this.weapon.getImageHalt(2), X, Y, WIDTH, HEIGHT, null);
	}
	
	public void yourTurn(int numAttack, Heroine heroine) {
		if (this.getEnergy().isFainting()) recoverEnergy();
		else attackEnemy(numAttack, heroine);
	}
	
	private void attackEnemy(int numAttack, Heroine heroine) {
		if (heroine.isDefend()) heroine.getEnergy().setCharacterDefend(true);
		this.setAttackFinish(false);
		heroine.getEnergy().setEnergyFinished(false);
		this.startAttack(numAttack, heroine.getEnergy());
	}
	
	private void recoverEnergy() {
		this.getEnergy().setEnergy(2, false);
	}
	
	

}
