package isii.images.characters;

import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

public interface ImageCharacter {
	public Image getImageHalt(int num);
	public SpriteImage getImage(int numAttack, int numSprite);
	public int getNumSprites(int numAttack);
	public Image getImageFainting();
	public default int addListAttacks(List<SpriteImage> list, int numSpriteStart, int numSpriteFinal, int X, int Y, int WIDTH, int HEIGHT, String address, String extension, int steps) {
		for (int i = numSpriteStart; i < numSpriteFinal; i++) {
			X += steps;
			list.add(new SpriteImage(new ImageIcon(address + i + extension).getImage(), X, Y, WIDTH, HEIGHT));
		}
		return X;
	}
}
