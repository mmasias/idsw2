package isii.attacks;

import isii.attacks.durability.Durability;

public class Attack {
	
	private final int damage;
	private final int success;
	private Durability durability;
	private int countDurability;
	
	public Attack(int damage, int success, int durability) {
		this.damage = damage;
		this.success = success;
		this.durability = new Durability(durability);
		this.countDurability = 1;
	}
	
	public Attack(int damage, int success) {
		this.damage = damage;
		this.success = success;
		this.durability = null;
		this.countDurability = 0;
	}
	
	public int getDamage() {
		if (this.durability == null) return damage;
		else return (int)(damage * (getDurability().getDurability() / 100f));
	}
	
	public int getSuccess() {
		return success;
	}
	
	public Durability getDurability() {
		return durability;
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
	
	public Attack withAttackNotDurability() {
		return new Attack(damage, success);
	}
	
	
	@Override
	public String toString() {
		return "Damage: " + getDamage() + ", Success: " + getSuccess() + ", Durability: " + getDurability();
	}
}
