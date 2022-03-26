package isii.characters;

import isii.attacks.Attack;
import isii.images.ImageVampiress;
import isii.other.Dimensions;

public class Enemy extends Character {

	public Enemy(Attack ataque1, Attack ataque2, Attack ataque3, Energy energy) {
		super(ataque1, ataque2, ataque3, Dimensions.enemyX, Dimensions.enemyY, Dimensions.enemyWidth, Dimensions.enemyHeight, 
				new ImageVampiress(Dimensions.enemyX, Dimensions.enemyY, Dimensions.enemyWidth, Dimensions.enemyHeight), energy);
	}
	
	public void yourTurn(int numAttack, Heroine heroine) {
		if (this.getEnergy().isFainting()) recoverEnergy();
		else attackEnemy(numAttack, heroine);
	}
	
	private void attackEnemy(int numAttack, Heroine heroine) {
		if (heroine.isDefend()) heroine.getEnergy().setCharacterDefend(true);
		heroine.setDefend(false);
		this.setAttackFinish(false);
		heroine.getEnergy().setEnergyFinished(false);
		this.startAttack(numAttack, heroine.getEnergy());
	}
	
	private void recoverEnergy() {
		this.getEnergy().setEnergy(2, false);
	}
	
	

}
