package isii.characters;

import java.awt.Graphics2D;
import isii.attacks.Attack;
import isii.characters.energy.Energy;
import isii.images.characters.ImageVampiress;
import isii.other.Dimension;

public class Vampiress extends Character {

	private int numAttack;
	
	public Vampiress(Attack ataque1, Attack ataque2, Attack ataque3, Energy energy, Dimension dimension) {
		super(ataque1, ataque2, ataque3, dimension, 
				new ImageVampiress(dimension), energy);
		this.numAttack = 1;
	}
	
	public synchronized void paint(Graphics2D g) {
		if (!this.weapon.isAttackFinish()) this.paintAttack(this.numAttack, g);
		else if (this.getEnergy().isFainting()) g.drawImage(this.weapon.getImageCharacter().getImageFainting(), X, Y, WIDTH, HEIGHT, null);
		else this.paintHalt(g);
	}
	
	public void yourTurn(int numAttack, Heroine heroine) {
		if (!this.getEnergy().isDead()) vampiressAttack(numAttack, heroine);
	}

	private void vampiressAttack(int numAttack, Heroine heroine) {
		if (heroine.isDefend()) heroine.getEnergy().setCharacterDefend(true);
		this.numAttack = numAttack;
		this.attackEnemy(numAttack, heroine);
	}
}
