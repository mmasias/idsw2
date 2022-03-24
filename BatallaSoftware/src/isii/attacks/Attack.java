package isii.attacks;

import javax.swing.JProgressBar;

public class Attack {
	
	private final int damage;
	private final int success;
	private Durability durability;
	private int countDurability;
	
	public Attack(int damage, int success, int durability, JProgressBar durabilityBar) {
		this.damage = damage;
		this.success = success;
		this.durability = new Durability(durability, durabilityBar);
		this.countDurability = 1;
	}
	
	public int getDamage() {
		return (int)(damage * (getDurability().getDurability() / 100f));
	}
	
	public int getSuccess() {
		return success;
	}
	
	public Durability getDurability() {
		return durability;
	}
	
	public Attack withAttack() {
		return new Attack(damage, getSuccess(), getDurability().getDurability(), getDurability().getDurabilityBar());
	}
	
	/**
	 * Reduce la durabilidad del arma cada 10 golpes, es decir, 
	 * el golpe 10 tiene la misma durabilidad, pero para el 11 esta mas gastada
	 */
	public void countDurability() {
		if (countDurability != 10) {
			countDurability++;
		} else {
			getDurability().reduceDurability();
			setCountDurability(1);
		}
	}
	
	private void setCountDurability(int num) {
		this.countDurability = num;
	}
	
	
	@Override
	public String toString() {
		return "Damage: " + getDamage() + ", Success: " + getSuccess() + ", Durability: " + getDurability();
	}
}
