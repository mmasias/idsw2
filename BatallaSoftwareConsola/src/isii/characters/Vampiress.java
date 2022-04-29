package isii.characters;

import isii.attacks.Attack;
import isii.characters.energy.Energy;

public class Vampiress extends Character {

	public Vampiress(Attack ataque1, Attack ataque2, Attack ataque3, Energy energy) {
		super(ataque1, ataque2, ataque3, energy);
	}
	
	public void yourTurn(int numAttack, Heroine heroine) {
		if (!this.getEnergy().isDead()) vampiressAttack(numAttack, heroine);
	}

	private void vampiressAttack(int numAttack, Heroine heroine) {
		if (heroine.isDefend()) heroine.getEnergy().setCharacterDefend(true);
		this.attackEnemy(numAttack, heroine);
	}
}
