package isii.characters;

import java.util.Random;
import isii.attacks.Attack;
import isii.images.ImageHeroine;
import isii.other.Dimensions;

public class Heroine extends Character { //TODO Cambiar drinkPotion y numDrinkPotion con sus respectivos metodos a esta clase
	
	private boolean defend = false;
	private boolean doAction = false;
	private boolean drinkPotion;
	
	public Heroine(Attack ataque1, Attack ataque2, Attack ataque3, Energy energy) {
		super(ataque1, ataque2, ataque3, Dimensions.heroineX, Dimensions.heroineY, Dimensions.heroineWidth, Dimensions.heroineHeight, 
				new ImageHeroine(Dimensions.heroineX, Dimensions.heroineY, Dimensions.heroineWidth, Dimensions.heroineHeight), energy);
		this.drinkPotion = false;
	}
	
	public void yourTurn(int numAttack, Character character) {
		if (this.isDrinkPotion()) {
			if (this.getEnergy().isFainting()) this.recoverEnergy(2);
		}
		else if (this.getEnergy().isFainting()) this.recoverEnergy(2);
		else attackEnemy(numAttack, character);
	}
	
	private void attackEnemy(int numAttack, Character character) {
		this.setAttackFinish(false);
		character.getEnergy().setEnergyFinished(false);
		this.startAttack(numAttack, character.getEnergy());
	}

	public void recoverEnergy(int energy) {
		this.getEnergy().setEnergyFinished(false);
		this.getEnergy().setEnergy(energy, false);
	}
	
	public boolean isDrinkPotion() {
		return drinkPotion;
	}

	public void setDrinkPotion(boolean drinkPotion) {
		this.drinkPotion = drinkPotion;
	}
	
	public void setDefend(boolean defend) {
		this.defend = defend ? get80Percent() ? true : false : false;
	}
	
	private boolean get80Percent() {
		if(new Random().nextInt(101) <= 80) return true;
		else return false;
	}
	
	public boolean isDefend() {
		return this.defend;
	}
	
	public boolean isDoAction() {
		return doAction;
	}

	public void setDoAction(boolean doAction) {
		this.doAction = doAction;
	}

}
