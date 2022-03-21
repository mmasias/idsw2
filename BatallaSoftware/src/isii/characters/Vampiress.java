package isii.characters;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import isii.attacks.Attack;

public class Vampiress{
	
	private ImageIcon image;
	private static final int X = 500;
	private static final int Y = 260;
	private static final int WIDTH = 250;
	private static final int HEIGHT = 250;
	
	//TODO Implementarla en futuro
	public Vampiress(Attack ataque1, Attack ataque2, Attack ataque3) {
		
		this.image = new ImageIcon("Images\\Vampiresa.png");
	}
	
	public void startAttack(int ataque) {
		// TODO Sí el ataque se realiza con exito quitar vida a Heroina, siempre que no este protegida
	}
	
	public void paint(Graphics2D g) {
		g.drawImage(image.getImage(), X, Y, WIDTH, HEIGHT, null);
	}
	
	public synchronized void paintAttack(int numAttack, Graphics2D g) {
		//TODO Secuencia de ataques 1
	}
	


}
