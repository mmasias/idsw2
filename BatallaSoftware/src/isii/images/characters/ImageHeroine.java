package isii.images.characters;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import isii.other.Dimension;

public class ImageHeroine implements ImageCharacter{
	
	private Image image_heroine1 = new ImageIcon("Images\\Heroina\\Halt\\Heroine_1.png").getImage();
	private Image image_heroine2 = new ImageIcon("Images\\Heroina\\Halt\\Heroine_2.png").getImage();
	private Image image_heroineFainting = new ImageIcon("Images\\Heroina\\Halt\\desmayo.png").getImage();
	private Image image_heroineDefend = new ImageIcon("Images\\Heroina\\HeroinaBloqueo.png").getImage();
	
	private List<SpriteImage> listAttacks1 = new ArrayList<SpriteImage>();
	private List<SpriteImage> listAttacks2 = new ArrayList<SpriteImage>();
	private List<SpriteImage> listAttacks3 = new ArrayList<SpriteImage>();
	private List<SpriteImage> listPotion = new ArrayList<SpriteImage>();
	
	/**
	 * ATTACK 1 
	 * Numero de imagenes (23), 
	 * hasta que empieza a moverse a la izquierda imagen (7), 
	 * para de moverse a la izquierda hasta la (9), 
	 * empieza a moverse a la derecha (14) 
	 * y para de moverse a la derecha(16)
	 */
	
	private final int numSpritesAttack1 = 23;
	private final int numSpritesAttack1MovingLeft = 7;
	private final int numSpritesAttack1StopMovingLeft = 9;
	private final int numSpritesAttack1MovingRight = 14;
	private final int numSpritesAttack1StopMovingRight = 16;
	
	/**
	 * ATTACK 2
	 * Numero de imagenes (37), 
	 * hasta que empieza a moverse a la izquierda imagen (18), 
	 * para de moverse a la izquierda hasta la (21), 
	 * empieza a moverse a la derecha (23) 
	 * y para de moverse a la derecha(28)
	 */
	private final int numSpritesAttack2 = 37;
	private final int numSpritesAttack2MovingLeft = 18;
	private final int numSpritesAttack2StopMovingLeft = 21;
	private final int numSpritesAttack2MovingRight = 23;
	private final int numSpritesAttack2StopMovingRight = 28;
	
	/**
	 * ATTACK 3 
	 * Numero de imagenes (41), 
	 * hasta que empieza a moverse a la izquierda imagen (17), 
	 * para de moverse a la izquierda hasta la (19), 
	 * empieza a moverse a la derecha (25) 
	 * y para de moverse a la derecha(25)
	 */
	private final int numSpritesAttack3 = 41;
	private final int numSpritesAttack3MovingLeft = 17;
	private final int numSpritesAttack3StopMovingLeft = 19;
	private final int numSpritesAttack3MovingRight = 25;
	private final int numSpritesAttack3StopMovingRight = 25;

	public ImageHeroine(Dimension dimension) {
		this.addListAttacks(numSpritesAttack1, numSpritesAttack1MovingLeft, numSpritesAttack1StopMovingLeft, numSpritesAttack1MovingRight, numSpritesAttack1StopMovingRight, 
				"Images\\Heroina\\Attack_1\\HeroinaAtaque1-", ".png", listAttacks1, dimension.getX(), dimension.getX(), dimension.getY(), dimension.getWidth(), dimension.getHeight(), 160, 120);
		this.addListAttacks(numSpritesAttack2, numSpritesAttack2MovingLeft, numSpritesAttack2StopMovingLeft, numSpritesAttack2MovingRight, numSpritesAttack2StopMovingRight, 
				"Images\\Heroina\\Attack_2\\HeroinaAtaque2-", ".png", listAttacks2, dimension.getX(), dimension.getX(), dimension.getY(), dimension.getWidth(), dimension.getHeight(), 110, 50);
		this.addListAttacks(numSpritesAttack3, numSpritesAttack3MovingLeft, numSpritesAttack3StopMovingLeft, numSpritesAttack3MovingRight, numSpritesAttack3StopMovingRight, 
				"Images\\Heroina\\Attack_3\\HeroinaAtaque3-", ".png", listAttacks3, dimension.getX(), dimension.getX(), dimension.getY(), dimension.getWidth(), dimension.getHeight(), 190, 0);
		this.addListAttacks(this.listPotion, 1, 13, dimension.getX(), dimension.getY(), dimension.getWidth(), dimension.getHeight(), "Images\\Heroina\\Potion\\HeroinaPocion", ".png", 0);
	}
	
	/**
	 * LLeno la lista con la imagen deseada, de esta forma me guardo las animaciones
	 * con su posicion y sprite correcpondiente. Por eso hay tanto for. Le digo de donde a donde hay que ir.
	 * @param numSprites
	 * @param numSpritesMovingLeft
	 * @param numSpritesStopMovingLeft
	 * @param numSpritesMovingRight
	 * @param numSpritesStopMovingRight
	 * @param address
	 * @param extension
	 * @param listAttack
	 * @param X
	 * @param XFinal
	 * @param Y
	 * @param WIDTH
	 * @param HEIGHT
	 */
	private void addListAttacks(int numSprites, int numSpritesMovingLeft, int numSpritesStopMovingLeft, int numSpritesMovingRight, int numSpritesStopMovingRight, String address, String extension, List<SpriteImage> listAttack, int X, int XFinal, int Y, int WIDTH, int HEIGHT, int stepsLeft, int stepsRight) {
		this.addListAttacks(listAttack, 1, numSpritesMovingLeft, X, Y, WIDTH, HEIGHT, address, extension, 0);
		XFinal = this.addListAttacks(listAttack, numSpritesMovingLeft, numSpritesStopMovingLeft, XFinal, Y, WIDTH, HEIGHT, address, extension, -stepsLeft);
		this.addListAttacks(listAttack, numSpritesStopMovingLeft, numSpritesMovingRight, XFinal, Y, WIDTH, HEIGHT, address, extension, 0);
		this.addListAttacks(listAttack, numSpritesMovingRight, numSpritesStopMovingRight, XFinal, Y, WIDTH, HEIGHT, address, extension, +stepsRight);
		this.addListAttacks(listAttack, numSpritesStopMovingRight, numSprites + 1, X, Y, WIDTH, HEIGHT, address, extension, 0);
	}
	
	/**
	 * Devuelve la postura inicial del ataque
	 * @param num
	 * @return
	 */
	@Override
	public synchronized Image getImageHalt(int num) {
		if (num == 1) return image_heroine1;
		else return image_heroine2;
	}
	
	/**
	 * Introducir el num real del sprite, es decir, si es la primera imagen introducir 1,
	 * si es la última introducir 23. El propio método ya maneja la variable.
	 * @param numAttack
	 * @return Image
	 * @throws Exception 
	 */
	@Override
	public synchronized SpriteImage getImage(int numAttack, int numSprite) {
		if (numAttack == 1) return listAttacks1.get(numSprite - 1);
		else if (numAttack == 2) return listAttacks2.get(numSprite - 1);
		else if (numAttack == 3) return listAttacks3.get(numSprite - 1);
		else return null;
	}
	
	/**
	 * Devuelve el numero de sprites que tiene el ataque para sincronizarlos
	 * @param numAttack
	 * @return
	 * @throws Exception 
	 */
	@Override
	public synchronized int getNumSprites(int numAttack) {
		if (numAttack == 1) return numSpritesAttack1;
		else if (numAttack == 2) return numSpritesAttack2;
		else if (numAttack == 3) return numSpritesAttack3;
		else return 0;
	}
	
	@Override
	public synchronized Image getImageFainting() {
		return this.image_heroineFainting;
	}
	
	public synchronized Image getImageDefend() {
		return this.image_heroineDefend;
	}
	
	public synchronized Image getImagePotion(int numSprite) { 
		return listPotion.get(numSprite - 1).getImage();
	}
}
