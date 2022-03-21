package isii.attacks;

import javax.swing.JProgressBar;

public class Durability {

	private int durability;
	private JProgressBar durabilityBar;

	public Durability(int durability, JProgressBar durabilityBar) {
		this.durability = durability;
		this.durabilityBar = durabilityBar;
	}

	public int getDurability() {
		return this.durability;
	}

	public JProgressBar getDurabilityBar() {
		return this.durabilityBar;
	}
	
	private void setDurabilityBar(int num) {
		this.durabilityBar.setValue(num);
	}

	public void reduceDurability() {
		setDurabilityBar(getDurability() - (int)(getDurability() * 0.1));
		this.durability = getDurabilityBar().getValue();
	}

}
