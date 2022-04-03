package isii.program;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import isii.images.ImageMenu;
import isii.other.ButtonPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.BorderLayout;

public class MainJFrame extends JFrame {

	
	private static final long serialVersionUID = 1L;
	
	private ImageMenu image = new ImageMenu();
	
	private JPanel gameContentPanel;
	private ButtonPanel titlePanel = new ButtonPanel(image.getImageTitle());
	private ButtonPanel menuPanel = new ButtonPanel(image.getImageBackground());
	private NormalGame gamePanel;
	private ResultJPanel resultPanel;
	private JButton btn_play = new JButton();
	private JButton btn_normal = new JButton();
	private JButton btn_horde = new JButton();
	private JButton btn_back = new JButton();
	private JButton btn_exit = new JButton();
	private Dimension dimensionScreen;
	private ButtonPanel panel_buttonPlay = new ButtonPanel(image.getImageButtonPlay(false));
	private ButtonPanel panel_buttonNormalMode = new ButtonPanel(image.getImageButtonNormalMode(false));
	private ButtonPanel panel_buttonHordeMode = new ButtonPanel(image.getImageButtonHordeMode(false));
	private ButtonPanel panel_buttonBack = new ButtonPanel(image.getImageButtonBack(false));
	private ButtonPanel panel_buttonExit = new ButtonPanel(image.getImageButtonExit(false));
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainJFrame frame = new MainJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("deprecation")
	public MainJFrame() {
		//JFrame FULL SCREEN
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setCursor(Cursor.CROSSHAIR_CURSOR);
		
		dimensionScreen = Toolkit.getDefaultToolkit().getScreenSize();
		//Window Panel
		gameContentPanel = new JPanel();
		gameContentPanel.setBackground(new Color(240, 128, 128));
		gameContentPanel.setMaximumSize(this.getSize());
		setContentPane(gameContentPanel);
		gameContentPanel.setLayout(null);
		
		//Menu Panel
		menuPanel.setLayout(null);
		menuPanel.setBackground(SystemColor.activeCaption);
		gameContentPanel.add(menuPanel);
		this.menuPaneDimension(menuPanel);
		
		resultPanel = new ResultJPanel((dimensionScreen.width / 2) - (dimensionScreen.width / 2), (dimensionScreen.height / 2) - (dimensionScreen.height / 2), dimensionScreen.width, dimensionScreen.height, menuPanel, "YOU WIN");
		resultPanel.setVisible(false);
		gameContentPanel.add(resultPanel);
		
		//gamePanel = new GameJPanel((dimensionScreen.width / 2) - (dimensionScreen.width / 2), (dimensionScreen.height / 2) - (dimensionScreen.height / 2), dimensionScreen.width, dimensionScreen.height, resultPanel);
		
		gamePanel = new NormalGame((dimensionScreen.width / 2) - (dimensionScreen.width / 2), (dimensionScreen.height / 2) - (dimensionScreen.height / 2), dimensionScreen.width, dimensionScreen.height, resultPanel);
		
		//Button NEW GAME
		btn_play.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_play.setForeground(Color.WHITE);
		this.transparentButton(btn_play);
		btn_play.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseButtonEnteredExit(panel_buttonPlay, image.getImageButtonPlay(true));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				mouseButtonEnteredExit(panel_buttonPlay, image.getImageButtonPlay(false));
			}
		});
		
		btn_play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showSelectModePanels(true);
			}
		});
		
		//Button Normal Mode
		btn_normal.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_normal.setForeground(Color.WHITE);
		this.transparentButton(btn_normal);
		btn_normal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseButtonEnteredExit(panel_buttonNormalMode, image.getImageButtonNormalMode(true));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				mouseButtonEnteredExit(panel_buttonNormalMode, image.getImageButtonNormalMode(false));
			}
		});
		
		btn_normal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showSelectModePanels(false);
				menuPanel.setVisible(false);
				gamePanel = new NormalGame((dimensionScreen.width / 2) - (dimensionScreen.width / 2), (dimensionScreen.height / 2) - (dimensionScreen.height / 2), dimensionScreen.width, dimensionScreen.height, resultPanel);
				gameContentPanel.add(gamePanel);
				gamePanel.setVisible(true);
			}
		});
		
		btn_horde.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_horde.setForeground(Color.WHITE);
		this.transparentButton(btn_horde);
		btn_horde.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseButtonEnteredExit(panel_buttonHordeMode, image.getImageButtonHordeMode(true));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				mouseButtonEnteredExit(panel_buttonHordeMode, image.getImageButtonHordeMode(false));
			}
		});
		
		btn_horde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showSelectModePanels(false);
				menuPanel.setVisible(false);
				gamePanel = new NormalGame((dimensionScreen.width / 2) - (dimensionScreen.width / 2), (dimensionScreen.height / 2) - (dimensionScreen.height / 2), dimensionScreen.width, dimensionScreen.height, resultPanel);
				gameContentPanel.add(gamePanel);
				gamePanel.setVisible(true);
			}
		});
		
		//Button BACK
		btn_back.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_back.setForeground(Color.WHITE);
		this.transparentButton(btn_back);
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseButtonEnteredExit(panel_buttonBack, image.getImageButtonBack(true));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mouseButtonEnteredExit(panel_buttonBack, image.getImageButtonBack(false));
			}
		});
		
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showSelectModePanels(false);
			}
		});
		
		//Button EXIT
		btn_exit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_exit.setForeground(Color.WHITE);
		this.transparentButton(btn_exit);
		btn_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseButtonEnteredExit(panel_buttonExit, image.getImageButtonExit(true));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mouseButtonEnteredExit(panel_buttonExit, image.getImageButtonExit(false));
			}
		});
		
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//Button Play Panel
		panel_buttonPlay.setLayout(new BorderLayout(0, 0));
		panel_buttonPlay.setBackground(SystemColor.activeCaption);
		panel_buttonPlay.setBounds((dimensionScreen.width / 2) - ((int)(menuPanel.getWidth() * 0.2) / 2) - 200, (int) Component.CENTER_ALIGNMENT + (int) (menuPanel.getHeight() * 0.11) + 550, (int) (menuPanel.getWidth() * 0.2), (int) (menuPanel.getHeight() * 0.1));
		panel_buttonPlay.add(btn_play);
		menuPanel.add(panel_buttonPlay);
		
		//Button Normal Mode Panel
		panel_buttonNormalMode.setLayout(new BorderLayout(0, 0));
		panel_buttonNormalMode.setBackground(SystemColor.activeCaption);
		panel_buttonNormalMode.setBounds((dimensionScreen.width / 2) - ((int)(menuPanel.getWidth() * 0.2) / 2) - 200, (int) Component.CENTER_ALIGNMENT + (int) (menuPanel.getHeight() * 0.11) + 550, (int) (menuPanel.getWidth() * 0.2), (int) (menuPanel.getHeight() * 0.1));
		panel_buttonNormalMode.setVisible(false);
		panel_buttonNormalMode.add(btn_normal);
		menuPanel.add(panel_buttonNormalMode);
		
		//Button Horde Mode Panel
		panel_buttonHordeMode.setLayout(new BorderLayout(0, 0));
		panel_buttonHordeMode.setBackground(SystemColor.activeCaption);
		panel_buttonHordeMode.setBounds((dimensionScreen.width / 2) - ((int)(menuPanel.getWidth() * 0.2) / 2) - 200, (int) Component.CENTER_ALIGNMENT + panel_buttonNormalMode.getY() + (int)(menuPanel.getHeight() * 0.11), (int) (menuPanel.getWidth() * 0.2), (int) (menuPanel.getHeight() * 0.1));
		panel_buttonHordeMode.setVisible(false);
		panel_buttonHordeMode.add(btn_horde);
		menuPanel.add(panel_buttonHordeMode);
		
		//Button Back Panel
		panel_buttonBack.setLayout(new BorderLayout(0, 0));
		panel_buttonBack.setBackground(SystemColor.activeCaption);
		panel_buttonBack.setBounds((dimensionScreen.width / 2) - ((int)(menuPanel.getWidth() * 0.2) / 2) - 200, (int) Component.CENTER_ALIGNMENT + panel_buttonPlay.getY() + (int)(menuPanel.getHeight() * 0.11) * 2, (int) (menuPanel.getWidth() * 0.2), (int) (menuPanel.getHeight() * 0.1));
		panel_buttonBack.setVisible(false);
		panel_buttonBack.add(btn_back);
		menuPanel.add(panel_buttonBack);
		
		//Button Exit Panel
		panel_buttonExit.setLayout(new BorderLayout(0, 0));
		panel_buttonExit.setBackground(SystemColor.activeCaption);
		panel_buttonExit.setBounds((dimensionScreen.width / 2) - ((int)(menuPanel.getWidth() * 0.2) / 2) - 200, (int) Component.CENTER_ALIGNMENT + panel_buttonPlay.getY() + (int)(menuPanel.getHeight() * 0.11), (int) (menuPanel.getWidth() * 0.2), (int) (menuPanel.getHeight() * 0.1));
		panel_buttonExit.add(btn_exit);
		menuPanel.add(panel_buttonExit);
		
		titlePanel.setBounds((dimensionScreen.width / 2) - (1200 / 2) - 100, (dimensionScreen.height / 2) - (1200 / 2) - 50, 1200, 1200);
		menuPanel.add(titlePanel);
		
	}
	
	private void showSelectModePanels(boolean show) {
		panel_buttonPlay.setVisible(!show);
		panel_buttonExit.setVisible(!show);
		panel_buttonNormalMode.setVisible(show);
		panel_buttonHordeMode.setVisible(show);
		panel_buttonBack.setVisible(show);
	}

	private void mouseButtonEnteredExit(ButtonPanel panel, ImageIcon imageIcon) {
		panel.setImage(imageIcon);
	}
	
	private void transparentButton(JButton button) {
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
	}

	private void menuPaneDimension(JPanel panelMenu) {
		paneSize(panelMenu, dimensionScreen.width, dimensionScreen.height);
		paneLocation(panelMenu, 0, 0);
	}

	private void paneSize(JPanel panel, int width, int height) {
		panel.setBounds(new Rectangle(width, height));
	}
	
	private void paneLocation(JPanel panelMenu, int x, int y) {
		panelMenu.setLocation(x, y);
	}
}
