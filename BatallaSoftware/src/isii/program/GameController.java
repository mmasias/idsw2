package isii.program;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import isii.attacks.Attack;
import isii.characters.Vampiress;
import isii.characters.Heroine;
import isii.characters.energy.Energy;
import isii.images.ImageGame;
import isii.other.ButtonPanel;
import isii.other.Dimensions;

public class GameController extends JPanel {

	private static final long serialVersionUID = -1618637094370141321L;
	
	protected Heroine heroine;
	protected Vampiress vampiress_1, vampiress_2, vampiress_3;
	
	protected Turn turn;
	
	protected int numAttack;
	private int heroineEnergy;
	private int vampiressEnergy;
	protected int numPlayers;
	
	private JProgressBar heroineEnergyBar = new JProgressBar();
	private JProgressBar vampiress1EnergyBar = new JProgressBar();
	private JProgressBar vampiress2EnergyBar = new JProgressBar();
	private JProgressBar vampiress3EnergyBar = new JProgressBar();
	
	private JProgressBar heroineDurabilityBar_Weapon1 = new JProgressBar();
	private JProgressBar heroineDurabilityBar_Weapon2 = new JProgressBar();
	private JProgressBar heroineDurabilityBar_Weapon3 = new JProgressBar();
	
	protected ImageGame image = new ImageGame();
	protected ButtonPanel panelAttacks, panelDefend, panelPotion, panelWeapon1, panelWeapon2, panelWeapon3, panelBack, panelSettings, backgroundSettings, panelContinueSetting, panelExitSetting;
	
	private int x, y, width, height;
	private int xRec, yRec, widthRec = 836, heightRec = 79;
	
	protected boolean openSettings = false;
	protected boolean horde;
	
	private Graphics2D g2d;
	protected ResultJPanel resultPanel;

	public GameController(int x, int y, int width, int height, ResultJPanel resultPanel, boolean horde) {
		this.setLayout(null);
		this.x = x; this.y = y; this.width = width; this.height= height;
		this.setBounds(x, y, width, height);
		this.setBackground(Color.GREEN);
		this.xRec = (width / 2) - (widthRec / 2);
		this.yRec = (height / 2) - (heightRec / 2) + 190;
		
		this.resultPanel = resultPanel;
		
		numAttack = 1;
		vampiressEnergy = 60;
		this.numPlayers = horde ? 4 : 2;
		this.horde = horde;
		this.heroineEnergy = horde ? 250 : 150;
		
		panelAttacks = new ButtonPanel(image.getImageButtonAttacks(false));
		panelAttacks.setBounds(xRec, yRec, widthRec, heightRec);
		addMouseListenerEnteredExit(panelAttacks, image.getImageButtonAttacks(true), image.getImageButtonAttacks(false));
		panelAttacks.addMouseListener(new MouseAdapter() { 
			@Override
			public void mouseClicked(MouseEvent e) {
				if (turn.getTurn() == 0  && !openSettings) {
					showAttackPanels(true);
				}
			}
		});
		this.add(panelAttacks, -1);
		
		//Panel Defend
		panelDefend = new ButtonPanel(image.getImageButtonDefend(false));
		panelDefend.setBounds(xRec, yRec + 89, widthRec, heightRec);
		addMouseListenerEnteredExit(panelDefend, image.getImageButtonDefend(true), image.getImageButtonDefend(false));
		this.add(panelDefend, -1);
				
		//Panel Potion
		panelPotion = new ButtonPanel(image.getImageButtonPotion(false));
		panelPotion.setBounds(xRec, yRec + (2 * 89), widthRec, heightRec);
		addMouseListenerEnteredExit(panelPotion, image.getImageButtonPotion(true), image.getImageButtonPotion(false));
		this.add(panelPotion, -1);
		
		//Panel Weapon 1
		panelWeapon1 =  new ButtonPanel(image.getImageButtomWeapon(1)); 
		panelWeapon1.setBounds(xRec, yRec, widthRec, heightRec);
		panelWeapon1.setVisible(false);
		mouseListenerHeroineButtoms(panelWeapon1, 1, image.getImageButtomWeaponMouseEntered(1), image.getImageButtomWeapon(1));
		this.add(panelWeapon1, -1);
		
		//Panel Weapon 2
		panelWeapon2 =  new ButtonPanel(image.getImageButtomWeapon(2)); 
		panelWeapon2.setBounds(xRec, yRec + 89, widthRec, heightRec);
		panelWeapon2.setVisible(false);
		mouseListenerHeroineButtoms(panelWeapon2, 2, image.getImageButtomWeaponMouseEntered(2), image.getImageButtomWeapon(2));
		this.add(panelWeapon2, -1);
		
		//Panel Weapon 3
		panelWeapon3 =  new ButtonPanel(image.getImageButtomWeapon(3));
		panelWeapon3.setBounds(xRec, yRec + (2 * 89), widthRec, heightRec);
		panelWeapon3.setVisible(false);
		mouseListenerHeroineButtoms(panelWeapon3, 3, image.getImageButtomWeaponMouseEntered(3), image.getImageButtomWeapon(3));
		this.add(panelWeapon3, -1);
		
		//Panel Back
		panelBack = new ButtonPanel(image.getImageButtomBack(false));
		panelBack.setBounds((width / 2) - (161 / 2) + 400, (height / 2) - (44 / 2) + 500, 161, 44);
		panelBack.setVisible(false);
		addMouseListenerEnteredExit(panelBack, image.getImageButtomBack(true), image.getImageButtomBack(false));
		panelBack.addMouseListener(new MouseAdapter() { 
			@Override
			public void mouseClicked(MouseEvent e) {
				if (turn.getTurn() == 0  && !openSettings) {
					showAttackPanels(false);
				}
			}
		});
		this.add(panelBack, -1);
		
		//Panel Settings
		panelSettings = new ButtonPanel(image.getImageButtonSettings(false));
		panelSettings.setBounds((width / 2) - (60 / 2) + 900, (height / 2) - (60 / 2) - 490, 60, 60);
		//addMouseListenerEnteredExit(panelSettings, image.getImageButtonSettings(true), image.getImageButtonSettings(false));
		panelSettings.addMouseListener(new MouseAdapter() { 
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSettings.setImage(image.getImageButtonSettings(true));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelSettings.setImage(image.getImageButtonSettings(false));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				openSettings = true;
				backgroundSettings.setVisible(true);
			}
		});
		this.add(panelSettings);
		
		backgroundSettings = new ButtonPanel(image.getImageBackgrounSettings());
		backgroundSettings.setLayout(null);
		backgroundSettings.setBounds(0, 0, width, height-1);
		backgroundSettings.setVisible(false);
		this.add(backgroundSettings, 0);
		
		panelContinueSetting = new ButtonPanel(image.getImageButtonContinueSetting(false));
		panelContinueSetting.setBounds((backgroundSettings.getWidth() / 2) - (300 / 2), (backgroundSettings.getHeight() / 2) - (100 / 2) - 100, 300, 100);
		//panelContinueSetting.setVisible(false);
		panelContinueSetting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelContinueSetting.setImage(image.getImageButtonContinueSetting(true));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelContinueSetting.setImage(image.getImageButtonContinueSetting(false));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				openSettings = false;
				backgroundSettings.setVisible(false);
			}
		});
		backgroundSettings.add(panelContinueSetting);
		
		panelExitSetting = new ButtonPanel(image.getImageButtonExitSetting(false));
		panelExitSetting.setBounds((backgroundSettings.getWidth() / 2) - (300 / 2), (backgroundSettings.getHeight() / 2) - (100 / 2) + 10, 300, 100);
		//panelExitSetting.setVisible(false);
		panelExitSetting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelExitSetting.setImage(image.getImageButtonExitSetting(true));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelExitSetting.setImage(image.getImageButtonExitSetting(false));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		backgroundSettings.add(panelExitSetting);
		
		addAttributes();
		createHeroine();
		createVampiress();
		if (horde) createHorde();
	}
	
	@Override
	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2d = (Graphics2D) g;
		g2d.drawImage(image.getImageBackground(), x, y, width, height, null);
		paintCharacters(g2d);
		g2d.drawImage(image.getImageInfoHeroine(horde), 0, 0, null);
		if (openSettings) paintFillRect(g2d);
		this.repaint();
	}
	
	private void paintCharacters(Graphics2D g) {
		heroine.paint(g);
		vampiress_1.paint(g);
		if (horde) paintHordeMode(g);
	}

	private void paintHordeMode(Graphics2D g) {
		vampiress_2.paint(g);
		vampiress_3.paint(g);
	}
	
	private void paintFillRect(Graphics2D g) {
		g.setColor(new Color(26, 37, 39));
		g.fillRect(width, (height - 10), -width, (height - 10));
	}
	
	private void createHeroine() {
		Attack attack1 = new Attack(7, 50, 100, heroineDurabilityBar_Weapon1); //TODO Cambia el success a 50, 100 es para pruebas
		Attack attack2 = new Attack(15, 25, 100, heroineDurabilityBar_Weapon2);
		Attack attack3 = new Attack(30, 12, 100, heroineDurabilityBar_Weapon3);
		Energy heroineEnergy = new Energy(this.heroineEnergy, 30, heroineEnergyBar);
		heroine = new Heroine(attack1, attack2, attack3, heroineEnergy);
		turn = new Turn(numPlayers, heroine);
	}
	
	private void createVampiress() {
		Attack attack1 = new Attack(5, 90);
		Attack attack2 = new Attack(10, 60);
		Attack attack3 = new Attack(20, 40);
		Energy vampiressEnergy = new Energy(this.vampiressEnergy, 20, vampiress1EnergyBar);
		vampiress_1 = new Vampiress(attack1, attack2, attack3, vampiressEnergy, Dimensions.enemy1Dimension());
	}
	
	private void createHorde() {
		Energy vampiressEnergy2 = new Energy(vampiressEnergy, 20, vampiress2EnergyBar);
		vampiress_2 = new Vampiress(new Attack(5, 90), new Attack(10, 60), new Attack(20, 40), vampiressEnergy2, Dimensions.enemy2Dimension());
		
		Energy vampiressEnergy3 = new Energy(vampiressEnergy, 20, vampiress3EnergyBar);
		vampiress_3 = new Vampiress(new Attack(5, 90), new Attack(10, 60), new Attack(20, 40), vampiressEnergy3, Dimensions.enemy3Dimension());
	}
	
	protected synchronized void showAttackPanels(boolean show) {
		showAttackPanels(panelAttacks, image.getImageButtonAttacks(false), !show);
		showAttackPanels(panelDefend, image.getImageButtonDefend(false), !show);
		showAttackPanels(panelPotion, image.getImageButtonPotion(false), !show);
		showAttackPanels(panelWeapon1, image.getImageButtomWeapon(1), show);
		showAttackPanels(panelWeapon2, image.getImageButtomWeapon(2), show);
		showAttackPanels(panelWeapon3, image.getImageButtomWeapon(3), show);
		showAttackPanels(panelBack, image.getImageButtomBack(false), show);
	}
	
	protected synchronized void hideAllPanel() {
		panelAttacks.setVisible(false);
		panelDefend.setVisible(false);
		panelPotion.setVisible(false);
		panelWeapon1.setVisible(false);
		panelWeapon2.setVisible(false);
		panelWeapon3.setVisible(false);
		panelBack.setVisible(false);
	}
	
	private void mouseListenerHeroineButtoms(ButtonPanel panelWeapon, int nAttack, ImageIcon imageButtomWeaponMouseEntered, ImageIcon imageButtomWeapon) {
		panelWeapon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (turn.getTurn() == 0  && !openSettings) panelWeapon.setImage(imageButtomWeaponMouseEntered);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (turn.getTurn() == 0  && !openSettings) panelWeapon.setImage(imageButtomWeapon);
			}
		});
	}
	
	private void addMouseListenerEnteredExit(ButtonPanel panel, ImageIcon image_button_mouseEntered, ImageIcon image_button) {
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (turn.getTurn() == 0  && !openSettings) panel.setImage(image_button_mouseEntered);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (turn.getTurn() == 0  && !openSettings) panel.setImage(image_button);
			}
		});
	}
	
	private void showAttackPanels(ButtonPanel panel, ImageIcon imageButtom, boolean show) {
		panel.setVisible(show);
		panel.setImage(imageButtom);
	}
	
	private void addAttributes() {
		addAttributesProgressBar(heroineEnergyBar, 0, heroineEnergy, heroineEnergy, 395, 25, +728, 212, Color.RED);
		addAttributesProgressBar(vampiress1EnergyBar, 0, 60, vampiressEnergy, 395, 25, -728, 212, Color.RED);
		add(vampiress1EnergyBar);
		add(heroineEnergyBar);
		
		addAttributesProgressBar(heroineDurabilityBar_Weapon1, 0, 100, 100, 220, 25, +810, 317, Color.BLUE);
		addAttributesProgressBar(heroineDurabilityBar_Weapon2, 0, 100, 100, 220, 25, +810, 347, Color.BLUE);
		addAttributesProgressBar(heroineDurabilityBar_Weapon3, 0, 100, 100, 220, 25, +810, 379, Color.BLUE);
		add(heroineDurabilityBar_Weapon1);
		add(heroineDurabilityBar_Weapon2);
		add(heroineDurabilityBar_Weapon3);
		
		if (horde) addAttributesHorde();
	}
	
	private void addAttributesHorde() {
		addAttributesProgressBar(vampiress2EnergyBar, 0, 60, vampiressEnergy, 395, 25, -728, 212 + 108, Color.RED);
		addAttributesProgressBar(vampiress3EnergyBar, 0, 60, vampiressEnergy, 395, 25, -728, 212 + 218, Color.RED);
		add(vampiress2EnergyBar);
		add(vampiress3EnergyBar);
	}

	private void addAttributesProgressBar(JProgressBar bar, int minimum, int maximum, int value, int width, int height, int x, int y, Color color) {
		bar.setMinimum(minimum);
		bar.setMaximum(maximum);
		bar.setValue(value);
		bar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bar.setForeground(color);
		bar.setStringPainted(true);
		bar.setBorderPainted(false);
		bar.setBackground(Color.WHITE);
		bar.setBounds((this.width / 2) - (width / 2) + x, (this.height / 2) - (height / 2) + y, width, height);
	}

}
