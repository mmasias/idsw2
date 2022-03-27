package isii.images;

import javax.swing.ImageIcon;

public class ImageMenu {
	
	private ImageIcon background = new ImageIcon("Images\\background_menu.png");
	private ImageIcon title = new ImageIcon("Images\\title.png");
	
	private ImageIcon image_buttonNewGame = new ImageIcon("Images\\Buttons\\Menu\\button_newGame.png");
	private ImageIcon image_buttonNewGame_mouseEntered = new ImageIcon("Images\\Buttons\\Menu\\button_newGame_mouseEntered.png");
	private ImageIcon image_buttonContinue = new ImageIcon("Images\\Buttons\\Menu\\button_continue.png");
	private ImageIcon image_buttonContinue_mouseEntered = new ImageIcon("Images\\Buttons\\Menu\\button_continue_mouseEntered.png");
	private ImageIcon image_buttonExit = new ImageIcon("Images\\Buttons\\Menu\\button_exit.png");
	private ImageIcon image_buttonExit_mouseEntered = new ImageIcon("Images\\Buttons\\Menu\\button_exit_mouseEntered.png");
	
	public ImageIcon getImageTitle() {
		return this.title;
	}
	
	public ImageIcon getImageBackground() {
		return this.background;
	}
	
	public ImageIcon getImageButtonNewGame(boolean entered) {
		if (entered) return this.image_buttonNewGame_mouseEntered;
		else return this.image_buttonNewGame;
	}
	
	public ImageIcon getImageButtonContinue(boolean entered) {
		if (entered) return this.image_buttonContinue_mouseEntered;
		else return this.image_buttonContinue;
	}
	
	public ImageIcon getImageButtonExit(boolean entered) {
		if (entered) return this.image_buttonExit_mouseEntered;
		else return this.image_buttonExit;
	}
}
