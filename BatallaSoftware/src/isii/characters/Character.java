package isii.characters;

import java.awt.Graphics2D;


public interface Character<T> {
	public void startAttack(int numAttack);
	public void paint(Graphics2D g);
	public void paintAttack(int numAttack, Graphics2D g);
}
