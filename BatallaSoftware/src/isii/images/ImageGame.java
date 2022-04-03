package isii.images;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageGame {
	
	private Image background = new ImageIcon("Images\\background.png").getImage();
	private ImageIcon background_settings = new ImageIcon("Images\\panel_settings.png");
	
	private Image image_info_heroine = new ImageIcon("Images\\panel_info_heroine.png").getImage();
	private Image image_info_heroine_horde = new ImageIcon("Images\\panel_info_heroine_horda.png").getImage();
	
	
	private ImageIcon image_settings = new ImageIcon("Images\\Buttons\\Game\\Settings\\button_setting.png");
	private ImageIcon image_settings_mouseEntered = new ImageIcon("Images\\Buttons\\Game\\Settings\\button_setting_mouseEntered.png");
	
	private ImageIcon image_buttonContinue_settings = new ImageIcon("Images\\Buttons\\Game\\Settings\\button_continueSetting.png");
	private ImageIcon image_buttonContinue_settings_mouseEntered = new ImageIcon("Images\\Buttons\\Game\\Settings\\button_continueSetting_mouseEntered.png");
	private ImageIcon image_buttonExit_settings = new ImageIcon("Images\\Buttons\\Game\\Settings\\button_exitSetting.png");
	private ImageIcon image_buttonExit_settings_mouseEntered = new ImageIcon("Images\\Buttons\\Game\\Settings\\button_exitSetting_mouseEntered.png");
	
	private ImageIcon image_buttonAttacks = new ImageIcon("Images\\Buttons\\Game\\button_attacks.png");
	private ImageIcon image_buttonAttacks_mouseEntered = new ImageIcon("Images\\Buttons\\Game\\button_attacks_mouseEntered.png");
	private ImageIcon image_buttonAttacks_disabled = new ImageIcon("Images\\Buttons\\Game\\button_attacks_disabled.png");
	
	private ImageIcon image_buttonDefend = new ImageIcon("Images\\Buttons\\Game\\button_defend.png");
	private ImageIcon image_buttonDefend_mouseEntered = new ImageIcon("Images\\Buttons\\Game\\button_defend_mouseEntered.png");
	private ImageIcon image_buttonDefend_disabled = new ImageIcon("Images\\Buttons\\Game\\button_defend_disabled.png");
	
	private ImageIcon image_buttonPotion = new ImageIcon("Images\\Buttons\\Game\\button_potion.png");
	private ImageIcon image_buttonPotion_mouseEntered = new ImageIcon("Images\\Buttons\\Game\\button_potion_mouseEntered.png");
	private ImageIcon image_buttonPotion_disabled = new ImageIcon("Images\\Buttons\\Game\\button_potion_disabled.png");
	
	private ImageIcon image_buttonWeapon1 = new ImageIcon("Images\\Buttons\\Game\\button_weapon1.png");
	private ImageIcon image_buttonWeapon1_mouseEntered = new ImageIcon("Images\\Buttons\\Game\\button_weapon1_mouseEntered.png");
	private ImageIcon image_buttonWeapon1_disabled = new ImageIcon("Images\\Buttons\\Game\\button_weapon1_disabled.png");
	
	private ImageIcon image_buttonWeapon2 = new ImageIcon("Images\\Buttons\\Game\\button_weapon2.png");
	private ImageIcon image_buttonWeapon2_mouseEntered = new ImageIcon("Images\\Buttons\\Game\\button_weapon2_mouseEntered.png");
	private ImageIcon image_buttonWeapon2_disabled = new ImageIcon("Images\\Buttons\\Game\\button_weapon2_disabled.png");
	
	private ImageIcon image_buttonWeapon3 = new ImageIcon("Images\\Buttons\\Game\\button_weapon3.png");
	private ImageIcon image_buttonWeapon3_mouseEntered = new ImageIcon("Images\\Buttons\\Game\\button_weapon3_mouseEntered.png");
	private ImageIcon image_buttonWeapon3_disabled = new ImageIcon("Images\\Buttons\\Game\\button_weapon3_disabled.png");
	
	private ImageIcon image_buttonBack = new ImageIcon("Images\\Buttons\\Game\\button_back.png");
	private ImageIcon image_buttonBack_mouseEntered = new ImageIcon("Images\\Buttons\\Game\\button_back_mouseEntered.png");
	
	public Image getImageBackground() {
		return this.background;
	}
	
	public ImageIcon getImageBackgrounSettings() {
		return this.background_settings;
	}
	
	public Image getImageInfoHeroine(boolean horde) {
		if (horde) return this.image_info_heroine_horde;
		else return this.image_info_heroine;
	}
	
	public ImageIcon getImageButtonContinueSetting(boolean entered) {
		if (entered) return this.image_buttonContinue_settings_mouseEntered;
		else return this.image_buttonContinue_settings;
	}
	
	public ImageIcon getImageButtonExitSetting(boolean entered) {
		if (entered) return this.image_buttonExit_settings_mouseEntered;
		else return this.image_buttonExit_settings;
	}
	
	public ImageIcon getImageButtonSettings(boolean entered) {
		if (entered) return this.image_settings_mouseEntered;
		else return this.image_settings;
	}
	
	public ImageIcon getImageButtonAttacks(boolean entered) {
		if (entered) return this.image_buttonAttacks_mouseEntered;
		else return this.image_buttonAttacks;
	}
	
	public ImageIcon getImageButtonAttacksDisabled() {
		return this.image_buttonAttacks_disabled;
	}

	public ImageIcon getImageButtonDefend(boolean entered) {
		if (entered) return this.image_buttonDefend_mouseEntered;
		else return this.image_buttonDefend;
	}
	
	public ImageIcon getImageButtonDefendDisabled() {
		return this.image_buttonDefend_disabled;
	}

	public ImageIcon getImageButtonPotion(boolean entered) {
		if (entered) return this.image_buttonPotion_mouseEntered;
		else return this.image_buttonPotion;
	}
	
	public ImageIcon getImageButtonPotionDisabled() {
		return this.image_buttonPotion_disabled;
	}
	
	public ImageIcon getImageButtomBack(boolean entered) {
		if (entered) return this.image_buttonBack_mouseEntered;
		else return this.image_buttonBack;
	}

	public ImageIcon getImageButtomWeapon(int num) {
		if (num == 1) return this.image_buttonWeapon1;
		else if (num == 2) return this.image_buttonWeapon2;
		else return this.image_buttonWeapon3;
	}
	
	public ImageIcon getImageButtomWeaponMouseEntered(int num) {
		if (num == 1) return this.image_buttonWeapon1_mouseEntered;
		else if (num == 2) return this.image_buttonWeapon2_mouseEntered;
		else return this.image_buttonWeapon3_mouseEntered;
	}
	
	public ImageIcon getImageButtomWeaponDisabled(int num) {
		if (num == 1) return this.image_buttonWeapon1_disabled;
		else if (num == 2) return this.image_buttonWeapon2_disabled;
		else return this.image_buttonWeapon3_disabled;
	}
	
}
