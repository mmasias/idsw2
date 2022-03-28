package isii.program;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import isii.attacks.Attack;
import isii.characters.Enemy;
import isii.characters.Energy;
import isii.characters.Heroine;
import isii.images.ImageGame;
import isii.other.ButtonPanel;

public class GameJPanel extends JPanel {
	
	private static final long serialVersionUID = -1618637094370141321L;
	
	private Heroine heroine;
	private Enemy vampiress;
	
	private Turn turn;
	
	private int numAttack = 0;
	private int energia = 150;
	private int vampiressEnergia = 150;
	
	private JProgressBar heroineEnergyBar = new JProgressBar();
	private JProgressBar vampiressEnergyBar = new JProgressBar();
	
	private JProgressBar heroineDurabilityBar_Weapon1 = new JProgressBar();
	private JProgressBar heroineDurabilityBar_Weapon2 = new JProgressBar();
	private JProgressBar heroineDurabilityBar_Weapon3 = new JProgressBar();
	
	private ImageGame image = new ImageGame();
	private ButtonPanel panelAttacks, panelDefend, panelPotion, panelWeapon1, panelWeapon2, panelWeapon3, panelBack, panelSettings, backgroundSettings, panelContinueSetting, panelExitSetting;
	private int x, y, width, height;
	private int xRec, yRec, widthRec = 836, heightRec = 79;
	
	private boolean openSettings = false;
	
	private Graphics2D g2d;
	private ResultJPanel resultPanel;
	
	public GameJPanel(int x, int y, int width, int height, ResultJPanel resultPanel) {
		this.setLayout(null);
		this.x = x; this.y = y; this.width = width; this.height= height;
		this.setBounds(x, y, width, height);
		this.setBackground(Color.GREEN);
		this.xRec = (width / 2) - (widthRec / 2);
		this.yRec = (height / 2) - (heightRec / 2) + 190;
		
		this.resultPanel = resultPanel;
		
		//Panel Attacks
		panelAttacks = new ButtonPanel(image.getImageButtonAttacks(false));
		panelAttacks.setBounds(xRec, yRec, widthRec, heightRec);
		addMouseListenerEnteredExit(panelAttacks, image.getImageButtonAttacks(true), image.getImageButtonAttacks(false));
		panelAttacks.addMouseListener(new MouseAdapter() { //TODO Porfavor Marco del futuro quitame los actionListener del Constructor y metelos en un método, queda muy feo el codigo :) 
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
		panelDefend.addMouseListener(new MouseAdapter() { //TODO Porfavor Marco del futuro quitame los actionListener del Constructor y metelos en un método, queda muy feo el codigo :) 
			@Override
			public void mouseClicked(MouseEvent e) {
				if (turn.getTurn() == 0  && !openSettings) {
					heroine.setDefend(true);
					turn.changeTurn();
					numAttack = newAttack();
					vampiress.yourTurn(numAttack, heroine);
					hideAllPanel();
				}
			}
		});
		this.add(panelDefend, -1);
		
		//Panel Potion
		panelPotion = new ButtonPanel(image.getImageButtonPotion(false));
		panelPotion.setBounds(xRec, yRec + (2 * 89), widthRec, heightRec);
		addMouseListenerEnteredExit(panelPotion, image.getImageButtonPotion(true), image.getImageButtonPotion(false));
		panelPotion.addMouseListener(new MouseAdapter() { //TODO Porfavor Marco del futuro quitame los actionListener del Constructor y metelos en un método, queda muy feo el codigo :) 
			@Override
			public void mouseClicked(MouseEvent e) {
				if (turn.getTurn() == 0  && !openSettings) {
					heroine.setDrinkPotion(true);
					heroine.setDoAction(true);
					heroine.printAnimationPotion();
					heroine.yourTurn(numAttack, heroine);
					turn.changeTurn();
					numAttack = newAttack();
					vampiress.yourTurn(numAttack, heroine);
					hideAllPanel();
				}
			}
		});
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
		panelBack.addMouseListener(new MouseAdapter() { //TODO Porfavor Marco del futuro quitame los actionListener del Constructor y metelos en un método, queda muy feo el codigo :) 
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
		panelSettings.addMouseListener(new MouseAdapter() { //TODO Porfavor Marco del futuro quitame los actionListener del Constructor y metelos en un método, queda muy feo el codigo :) 
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
		backgroundSettings.setBounds(0, 0, width, height);
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
				//panelContinueSetting.setVisible(false);
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
		
	}

	@Override
	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2d = (Graphics2D) g;
		g2d.drawImage(image.getImageBackground(), x, y, width, height, null);
		if (heroine.getEnergy().isDead()) {
			this.setVisible(false);
			resultPanel.setText("GAME OVER");
			resultPanel.setVisible(true);
		} else if (vampiress.getEnergy().isDead()) {
			this.setVisible(false);
			resultPanel.setText("YOU WIN");
			resultPanel.setVisible(true);
		}
		paintHeroine(g2d);
		paintVampiress(g2d);
		g2d.drawImage(image.getImageInfoHeroine(), 0, 0, null);
		//if (openSettings) g2d.drawImage(image.getImageBackgrounSettings().getImage(), x, y, width, height, null);
		this.repaint();
	}
	
	private synchronized void paintHeroine(Graphics2D g) {
		if (turn.getTurn() == 0 && heroine.isDoAction()) {
			if (!heroine.isAttackFinish()) heroine.paintAttack(numAttack, g);
			else if (vampiress.getEnergy().isEnergyFinished() && heroine.getEnergy().isEnergyFinished()) {
				turn.changeTurn();
				numAttack = newAttack();
				vampiress.yourTurn(numAttack, heroine);
			} else heroine.paint(g);
		}
		else heroine.paint(g);
	}
	
	private synchronized void paintVampiress(Graphics2D g) {
		if (turn.getTurn() == 1) {
			if (!vampiress.isAttackFinish()) vampiress.paintAttack(numAttack, g);
			else if (heroine.getEnergy().isEnergyFinished() && vampiress.getEnergy().isEnergyFinished()) {
				turn.changeTurn();
				heroine.setDefend(false);
				heroine.setDoAction(true);
				if (!heroine.isDrinkPotion() && !heroine.getEnergy().isFainting()) {
					heroine.setDoAction(false);
					showAttackPanels(false);
				} else heroine.yourTurn(numAttack, vampiress);
			}
			else vampiress.paint(g);
		}
		else vampiress.paint(g);
	}
	

	private int newAttack() {
		return new Random().nextInt(3) + 1;
	}

	private void createHeroine() {
		Attack attack1 = new Attack(7, 50, 100, heroineDurabilityBar_Weapon1);
		Attack attack2 = new Attack(15, 25, 100, heroineDurabilityBar_Weapon2);
		Attack attack3 = new Attack(30, 12, 100, heroineDurabilityBar_Weapon3);
		Energy heroineEnergy = new Energy(energia, 30, heroineEnergyBar);
		heroine = new Heroine(attack1, attack2, attack3, heroineEnergy);
		turn = new Turn(2, heroine);
	}
	
	private void createVampiress() {
		Attack attack1 = new Attack(5, 90);
		Attack attack2 = new Attack(10, 60);
		Attack attack3 = new Attack(20, 40);
		Energy vampiressEnergy = new Energy(vampiressEnergia, 20, vampiressEnergyBar);
		vampiress = new Enemy(attack1, attack2, attack3, vampiressEnergy);
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
			@Override
			public void mouseClicked(MouseEvent e) {
				if (turn.getTurn() == 0  && !openSettings) {
					heroine.setDoAction(true);
					numAttack = nAttack;
					heroine.yourTurn(numAttack, vampiress);
					hideAllPanel();
				}
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
	
	private void showAttackPanels(boolean show) {
		showAttackPanels(panelAttacks, image.getImageButtonAttacks(false), !show);
		showAttackPanels(panelDefend, image.getImageButtonDefend(false), !show);
		showAttackPanels(panelPotion, image.getImageButtonPotion(false), !show);
		showAttackPanels(panelWeapon1, image.getImageButtomWeapon(1), show);
		showAttackPanels(panelWeapon2, image.getImageButtomWeapon(2), show);
		showAttackPanels(panelWeapon3, image.getImageButtomWeapon(3), show);
		showAttackPanels(panelBack, image.getImageButtomBack(false), show);
	}
	
	private void showAttackPanels(ButtonPanel panel, ImageIcon imageButtom, boolean show) {
		panel.setVisible(show);
		panel.setImage(imageButtom);
	}
	
	private void hideAllPanel() {
		panelAttacks.setVisible(false);
		panelDefend.setVisible(false);
		panelPotion.setVisible(false);
		panelWeapon1.setVisible(false);
		panelWeapon2.setVisible(false);
		panelWeapon3.setVisible(false);
		panelBack.setVisible(false);
	}
	
	private void addAttributes() {
		addAttributesProgressBar(heroineEnergyBar, 0, 150, energia, 395, 25, +728, 212, Color.RED);
		addAttributesProgressBar(vampiressEnergyBar, 0, 60, vampiressEnergia, 395, 25, -728, 212, Color.RED);
		add(vampiressEnergyBar);
		add(heroineEnergyBar);
		
		addAttributesProgressBar(heroineDurabilityBar_Weapon1, 0, 100, 100, 220, 25, +810, 317, Color.BLUE);
		addAttributesProgressBar(heroineDurabilityBar_Weapon2, 0, 100, 100, 220, 25, +810, 347, Color.BLUE);
		addAttributesProgressBar(heroineDurabilityBar_Weapon3, 0, 100, 100, 220, 25, +810, 379, Color.BLUE);
		add(heroineDurabilityBar_Weapon1);
		add(heroineDurabilityBar_Weapon2);
		add(heroineDurabilityBar_Weapon3);
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
