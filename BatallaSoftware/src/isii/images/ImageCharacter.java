package isii.images;

import java.awt.Image;

public interface ImageCharacter {
	public Image getImageHalt(int num);
	public SpriteImage getImage(int numAttack, int numSprite);
	public int getNumSprites(int numAttack);
	public Image getImageFainting();
}
