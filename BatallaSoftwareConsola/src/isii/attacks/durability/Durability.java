package isii.attacks.durability;


public class Durability {

	private int durability;

	public Durability(int durability) {
		this.durability = durability;
	}

	public int getDurability() {
		return this.durability;
	}

	public void reduceDurability() {
		this.durability = getDurability() - (int)(getDurability() * 0.1);
	}

}
