package isii.attacks;

public class Attack {
	
	private final int damage;
	private final int success;
	private final int durability;
	private final int spritesAttack;
	
	public Attack(int damage, int success, int durability, int spritesAttack) {
		this.damage = damage;
		this.success = success;
		this.durability = durability;
		this.spritesAttack = spritesAttack;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public int getExito() {
		return success;
	}
	
	public int getDurability() {
		return durability;
	}
	
	public Attack withAttack() {
		return new Attack(this.damage, this.success, this.durability, this.spritesAttack);
	}

	public int getSpritesAttack() {
		return spritesAttack;
	}
}
