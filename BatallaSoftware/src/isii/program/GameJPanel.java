package isii.program;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import isii.attacks.Attack;
import isii.characters.Character;
import isii.images.ImageHeroine;
import isii.images.ImageVampiress;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class GameJPanel extends JPanel {

	private static final long serialVersionUID = 4334436276445130638L;
	
	//private Image image_actionPanel = new ImageIcon("Images\\marco_acciones.png").getImage();
	private Image image_info_heroine = new ImageIcon("Images\\panel_info_heroine.png").getImage();
	
	private ImageIcon image_buttonWeapon1 = new ImageIcon("Images\\button_weapon1.png");
	private ImageIcon image_buttonWeapon1_mouseEntered = new ImageIcon("Images\\button_weapon1_mouseEntered.png");
	private ImageIcon image_buttonWeapon1_disabled = new ImageIcon("Images\\button_weapon1_disabled.png");
	private ImageIcon image_buttonWeapon2 = new ImageIcon("Images\\button_weapon2.png");
	private ImageIcon image_buttonWeapon2_mouseEntered = new ImageIcon("Images\\button_weapon2_mouseEntered.png");
	private ImageIcon image_buttonWeapon2_disabled = new ImageIcon("Images\\button_weapon2_disabled.png");
	private ImageIcon image_buttonWeapon3 = new ImageIcon("Images\\button_weapon3.png");
	private ImageIcon image_buttonWeapon3_mouseEntered = new ImageIcon("Images\\button_weapon3_mouseEntered.png");
	private ImageIcon image_buttonWeapon3_disabled = new ImageIcon("Images\\button_weapon3_disabled.png");
	
	private ButtonPanel panelWeapon1 =  new ButtonPanel(image_buttonWeapon1);
	private ButtonPanel panelWeapon2 =  new ButtonPanel(image_buttonWeapon2);
	private ButtonPanel panelWeapon3 =  new ButtonPanel(image_buttonWeapon3);
	
	private Character heroine;
	private Character vampiress;
	//private Vampiress vampiresa = new Vampiress(new Attack(5, 90, 100), new Attack(10, 60, 100), new Attack(20, 40, 100));
	private ImageIcon background = new ImageIcon("Images\\background.png");
	private int x;
	private int y;
	private int width;
	private int height;
	
	//private final int actionPanelWidth = 984;
	//private final int actionPanelHeight = 340;
	
	private int xRec;
	private int yRec;
	private int widthRec = 836;
	private int heightRec = 79;
	
	private int numAttack = 0;
	
	private Graphics2D g2d;
	
	//Heroine
	private JProgressBar heroineEnergyBar;
	private JProgressBar heroineDurabilityBar_Weapon1;
	private JProgressBar heroineDurabilityBar_Weapon2;
	private JProgressBar heroineDurabilityBar_Weapon3;
	
	//Vampiress
	private JProgressBar vampiressEnergyBar;
	private JProgressBar vampiressDurabilityBar_Weapon1;
	private JProgressBar vampiressDurabilityBar_Weapon2;
	private JProgressBar vampiressDurabilityBar_Weapon3;

	public GameJPanel(int x, int y, int width, int height) {
		this.setLayout(null);
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height= height;
		this.setBounds(x, y, width, height);
		this.setBackground(Color.GREEN);
		this.xRec = (width / 2) - (widthRec / 2);
		this.yRec = (height / 2) - (heightRec / 2) + 190;
		
		//Panel 1
		panelWeapon1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelMouseEntered(panelWeapon1, image_buttonWeapon1_mouseEntered);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelMouseExited(panelWeapon1, image_buttonWeapon1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMouseClicked(1);
			}
		});
		panelWeapon1.setBounds(xRec, yRec, widthRec, heightRec);
		panelWeapon1.setLayout(new BorderLayout(0, 0));
		this.add(panelWeapon1);
		
		//Panel 2
		panelWeapon2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelMouseEntered(panelWeapon2, image_buttonWeapon2_mouseEntered);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelMouseExited(panelWeapon2, image_buttonWeapon2);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMouseClicked(2);
				
			}
		});
		panelWeapon2.setBounds(xRec, yRec + 89, widthRec, heightRec);
		this.add(panelWeapon2);
		
		//Panel 3
		panelWeapon3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelMouseEntered(panelWeapon3, image_buttonWeapon3_mouseEntered);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelMouseExited(panelWeapon3, image_buttonWeapon3);
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMouseClicked(3);
			}
		});
		panelWeapon3.setBounds(xRec, yRec + (2 * 89), widthRec, heightRec);
		this.add(panelWeapon3);
		
		//Heroine energy
		
		/**
		 * JProgressBar
		 * Minimum
		 * Maximum
		 * Energy
		 * Width
		 * Height
		 * Direction
		 */
		int maximumEnergyHeroine = 150;
		heroineEnergyBar = new JProgressBar();
		addAttributesProgressBar(heroineEnergyBar, 0, maximumEnergyHeroine, maximumEnergyHeroine, 395, 25, +728, 212, Color.RED); 
		add(heroineEnergyBar);
		
		heroineDurabilityBar_Weapon1 = new JProgressBar();
		heroineDurabilityBar_Weapon2 = new JProgressBar();
		heroineDurabilityBar_Weapon3 = new JProgressBar();
		
		//Durability-Heroine ProgressBar
		addAttributesProgressBar(heroineDurabilityBar_Weapon1, 0, 100, 100, 220, 25, +810, 317, Color.BLUE);
		addAttributesProgressBar(heroineDurabilityBar_Weapon2, 0, 100, 100, 220, 25, +810, 347, Color.BLUE);
		addAttributesProgressBar(heroineDurabilityBar_Weapon3, 0, 100, 100, 220, 25, +810, 379, Color.BLUE);
		add(heroineDurabilityBar_Weapon1);
		add(heroineDurabilityBar_Weapon2);
		add(heroineDurabilityBar_Weapon3);
		
		//Create Heroine
		int heroineX = 1000;
		int heroineY = 120;
		int heroineWidth = 400;
		int heroineHeight = 400;
		heroine = new Character(new Attack(7, 50, 100, heroineDurabilityBar_Weapon1), 
				new Attack(15, 25, 100, heroineDurabilityBar_Weapon2), 
				new Attack(30, 12, 100, heroineDurabilityBar_Weapon3), 
				heroineX, heroineY, heroineWidth, heroineHeight, 
				new ImageHeroine(heroineX, heroineY, heroineWidth, heroineHeight), maximumEnergyHeroine, heroineEnergyBar);
		
		//Vampiress energy
		int maximumEnergyVampiress = 60;
		vampiressEnergyBar = new JProgressBar();
		addAttributesProgressBar(vampiressEnergyBar, 0, maximumEnergyVampiress, maximumEnergyVampiress, 395, 25, -728, 212, Color.RED);
		add(vampiressEnergyBar);
		
		//Durability-Vampiress
		vampiressDurabilityBar_Weapon1 = new JProgressBar();
		vampiressDurabilityBar_Weapon2 = new JProgressBar();
		vampiressDurabilityBar_Weapon3 = new JProgressBar();
		addAttributesProgressBar(vampiressDurabilityBar_Weapon1, 0, 100, 100, 220, 25, -810 + 170, 317, Color.BLUE);
		addAttributesProgressBar(vampiressDurabilityBar_Weapon2, 0, 100, 100, 220, 25, -810 + 170, 347, Color.BLUE);
		addAttributesProgressBar(vampiressDurabilityBar_Weapon3, 0, 100, 100, 220, 25, -810 + 170, 379, Color.BLUE);
		add(vampiressDurabilityBar_Weapon1);
		add(vampiressDurabilityBar_Weapon2);
		add(vampiressDurabilityBar_Weapon3);
		
		int vampiressX = 500;
		int vampiressY = 260;
		int vampiressWidth = 250;
		int vampiressHeight = 250;
		vampiress = new Character(new Attack(5, 90, 100, vampiressDurabilityBar_Weapon1), 
				new Attack(10, 60, 100, vampiressDurabilityBar_Weapon2), 
				new Attack(20, 40, 100, vampiressDurabilityBar_Weapon3), 
				vampiressX, vampiressY, vampiressWidth, vampiressHeight, 
				new ImageVampiress(vampiressX, vampiressY, vampiressWidth, vampiressHeight), maximumEnergyVampiress, vampiressEnergyBar);
		
	}
	
	/**
	 * Metedo sobre escrito para pintar los elementos que yo quiera en la pantalla
	 */
	@Override
	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2d = (Graphics2D) g;
		g2d.drawImage(background.getImage(), x, y, width, height, null);
		if (numAttack == 0) heroine.paint(g2d);
		else {
			if (!heroine.isAttackFinish()) heroine.paintAttack(numAttack, g2d);
			else {
				enabledPanels();
			}
		}
		vampiress.paint(g2d);
		//g2d.drawImage(image_actionPanel, (width / 2) - (actionPanelWidth / 2), 650, actionPanelWidth, actionPanelHeight, null);
		g2d.drawImage(image_info_heroine, 0, 0, null);
		this.repaint();
	}
	
	
	/*private synchronized void damageEnemy() {
		heroina.getSuccessDamage(1);
	}*/

	public void setAttack(int numAttack) {
		this.numAttack = numAttack;
	}
	
	private void startAttack(int numAttack) {
		setAttack(numAttack);
		heroine.setAttackFinish(false);
		heroine.startAttack(numAttack, vampiress.getEnergy());
		
	}
	
	private void panelMouseClicked(int numAttack) {
		if (panelWeapon1.isEnabled() && panelWeapon2.isEnabled() && panelWeapon3.isEnabled()) {
			disabledPanels();
			startAttack(numAttack);
		}
	}

	private void panelMouseExited(ButtonPanel panelWeapon, ImageIcon image_buttonWeapon) {
		if (panelWeapon1.isEnabled() && panelWeapon2.isEnabled() && panelWeapon3.isEnabled()) panelWeapon.setImage(image_buttonWeapon);
	}

	private void panelMouseEntered(ButtonPanel panelWeapon, ImageIcon image_buttonWeapon_mouseEntered) {
		if (panelWeapon1.isEnabled() && panelWeapon2.isEnabled() && panelWeapon3.isEnabled()) panelWeapon.setImage(image_buttonWeapon_mouseEntered);
	}

	/**
	 * Metodo que lo utilizo para permitir que se pueda interactuar con los paneles
	 */
	private void enabledPanels() {
		numAttack = 0;
		panelWeapon1.setImage(image_buttonWeapon1);
		panelWeapon2.setImage(image_buttonWeapon2);
		panelWeapon3.setImage(image_buttonWeapon3);
		panelWeapon1.setEnabled(true);
		panelWeapon2.setEnabled(true);
		panelWeapon3.setEnabled(true);
	}
	
	/**
	 * Metodo que lo utilizo para bloquear la interaccion con los paneles y no lanzar mas de un ataque
	 */
	private void disabledPanels() {
		panelWeapon1.setImage(image_buttonWeapon1_disabled);
		panelWeapon2.setImage(image_buttonWeapon2_disabled);
		panelWeapon3.setImage(image_buttonWeapon3_disabled);
		panelWeapon1.setEnabled(false);
		panelWeapon2.setEnabled(false);
		panelWeapon3.setEnabled(false);
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
