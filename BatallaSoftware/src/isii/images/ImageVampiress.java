package isii.images;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class ImageVampiress implements ImageCharacter{

	private Image image_vampiress1 = new ImageIcon("Images\\Vampiress\\Halt\\Vampiress_Halt_1.png").getImage();
	private Image image_vampiress2 = new ImageIcon("Images\\Vampiress\\Halt\\Vampiress_Halt_2.png").getImage();
	private List<SpriteImage> listAttacks1 = new ArrayList<SpriteImage>();
	private List<SpriteImage> listAttacks2 = new ArrayList<SpriteImage>();
	private List<SpriteImage> listAttacks3 = new ArrayList<SpriteImage>();
	
	/**
	 * ATTACK 1 
	 * Numero de imagenes (23), 
	 * hasta que empieza a moverse a la izquierda imagen (7), 
	 * para de moverse a la izquierda hasta la (9), 
	 * empieza a moverse a la derecha (14) 
	 * y para de moverse a la derecha(16)
	 */
	
	private final int numSpritesAttack1 = 21;
	private final int numSpritesAttack1MovingLeft = 6;
	private final int numSpritesAttack1StopMovingLeft = 12;
	private final int numSpritesAttack1MovingRight = 17;
	private final int numSpritesAttack1StopMovingRight = 21;
	
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
	 * Numero de imagenes (23), 
	 * hasta que empieza a moverse a la izquierda imagen (7), 
	 * para de moverse a la izquierda hasta la (9), 
	 * empieza a moverse a la derecha (14) 
	 * y para de moverse a la derecha(16)
	 */
	private final int numSpritesAttack3 = 41;
	private final int numSpritesAttack3MovingLeft = 17;
	private final int numSpritesAttack3StopMovingLeft = 19;
	private final int numSpritesAttack3MovingRight = 25;
	private final int numSpritesAttack3StopMovingRight = 25;

	public ImageVampiress(int X, int Y, int WIDTH, int HEIGHT) {
		addListAttacks(numSpritesAttack1, numSpritesAttack1MovingLeft, numSpritesAttack1StopMovingLeft, numSpritesAttack1MovingRight, numSpritesAttack1StopMovingRight, "Images\\Vampiress\\Attack_1\\VampiresaAtaque1-", ".png", listAttacks1, X, X, Y, WIDTH, HEIGHT, 90, 70);
		addListAttacks(numSpritesAttack2, numSpritesAttack2MovingLeft, numSpritesAttack2StopMovingLeft, numSpritesAttack2MovingRight, numSpritesAttack2StopMovingRight, "Images\\Heroina\\Attack_2\\HeroinaAtaque2-", ".png", listAttacks2, X, X, Y, WIDTH, HEIGHT, 80, 50);
		addListAttacks(numSpritesAttack3, numSpritesAttack3MovingLeft, numSpritesAttack3StopMovingLeft, numSpritesAttack3MovingRight, numSpritesAttack3StopMovingRight, "Images\\Heroina\\Attack_3\\HeroinaAtaque3-", ".png", listAttacks3, X, X, Y, WIDTH, HEIGHT, 170, 0);
	}
	
	/**
	 * LLeno la lista con la imagen deseada y la posicion para mover la imagen
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
		for (int i = 1; i < numSpritesMovingLeft; i++) {
			listAttack.add(new SpriteImage(new ImageIcon(address + i + extension).getImage(), X, Y, WIDTH, HEIGHT));
		}
		for (int i = numSpritesMovingLeft; i < numSpritesStopMovingLeft; i++) {
			XFinal += stepsLeft;
			listAttack.add(new SpriteImage(new ImageIcon(address + i + extension).getImage(), XFinal, Y, WIDTH, HEIGHT));
		}
		for (int i = numSpritesStopMovingLeft; i < numSpritesMovingRight; i++) {
			listAttack.add(new SpriteImage(new ImageIcon(address + i + extension).getImage(), XFinal, Y, WIDTH, HEIGHT));
		}
		for (int i = numSpritesMovingRight; i < numSpritesStopMovingRight; i++) {
			XFinal -= stepsRight;
			listAttack.add(new SpriteImage(new ImageIcon(address + i + extension).getImage(), XFinal, Y, WIDTH, HEIGHT));
		}
		for (int i = numSpritesStopMovingRight; i <= numSprites; i++) {
			listAttack.add(new SpriteImage(new ImageIcon(address + i + extension).getImage(), X, Y, WIDTH, HEIGHT));
		}
	}
	
	/**
	 * Devuelve la postura inicial del ataque
	 * @param num
	 * @return
	 */
	@Override
	public synchronized Image getImageHalt(int num) {
		if (num == 1) return image_vampiress1;
		else return image_vampiress2;
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
		return this.image_vampiress1;
	}
}
