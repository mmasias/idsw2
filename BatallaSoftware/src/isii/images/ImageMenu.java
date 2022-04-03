package isii.images;

import javax.swing.ImageIcon;

public class ImageMenu {
	
	private ImageIcon background = new ImageIcon("Images\\background_menu.png");
	private ImageIcon title = new ImageIcon("Images\\title.png");
	
	private ImageIcon image_buttonPlay = new ImageIcon("Images\\Buttons\\Menu\\button_play.png");
	private ImageIcon image_buttonPlay_mouseEntered = new ImageIcon("Images\\Buttons\\Menu\\button_play_mouseEntered.png");
	private ImageIcon image_buttonNormal = new ImageIcon("Images\\Buttons\\Menu\\button_normal.png");
	private ImageIcon image_buttonNormal_mouseEntered = new ImageIcon("Images\\Buttons\\Menu\\button_normal_mouseEntered.png");
	private ImageIcon image_buttonHorde = new ImageIcon("Images\\Buttons\\Menu\\button_horde.png");
	private ImageIcon image_buttonHorde_mouseEntered = new ImageIcon("Images\\Buttons\\Menu\\button_horde_mouseEntered.png");
	private ImageIcon image_buttonBack = new ImageIcon("Images\\Buttons\\Menu\\button_back.png");
	private ImageIcon image_buttonBack_mouseEntered = new ImageIcon("Images\\Buttons\\Menu\\button_back_mouseEntered.png");
	private ImageIcon image_buttonExit = new ImageIcon("Images\\Buttons\\Menu\\button_exit.png");
	private ImageIcon image_buttonExit_mouseEntered = new ImageIcon("Images\\Buttons\\Menu\\button_exit_mouseEntered.png");
	
	public ImageIcon getImageTitle() {
		return this.title;
	}
	
	public ImageIcon getImageBackground() {
		return this.background;
	}
	
	public ImageIcon getImageButtonPlay(boolean entered) {
		if (entered) return this.image_buttonPlay_mouseEntered;
		else return this.image_buttonPlay;
	}
	
	public ImageIcon getImageButtonNormalMode(boolean entered) {
		if (entered) return this.image_buttonNormal_mouseEntered;
		else return this.image_buttonNormal;
	}
	
	public ImageIcon getImageButtonHordeMode(boolean entered) {
		if (entered) return this.image_buttonHorde_mouseEntered;
		else return this.image_buttonHorde;
	}
	
	public ImageIcon getImageButtonBack(boolean entered) {
		if (entered) return this.image_buttonBack_mouseEntered;
		else return this.image_buttonBack;
	}
	
	public ImageIcon getImageButtonExit(boolean entered) {
		if (entered) return this.image_buttonExit_mouseEntered;
		else return this.image_buttonExit;
	}
}
