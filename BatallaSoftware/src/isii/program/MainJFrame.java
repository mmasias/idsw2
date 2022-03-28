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
	private GameJPanel gamePanel;
	private ResultJPanel resultPanel;
	private JButton btn_newGame = new JButton();
	private JButton btn_continue = new JButton();
	private JButton btn_exit = new JButton();
	private Dimension dimensionScreen;
	private ButtonPanel panel_buttonNewGame = new ButtonPanel(image.getImageButtonNewGame(false));
	private ButtonPanel panel_buttonContinue = new ButtonPanel(image.getImageButtonContinue(false));
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
		
		gamePanel = new GameJPanel((dimensionScreen.width / 2) - (dimensionScreen.width / 2), (dimensionScreen.height / 2) - (dimensionScreen.height / 2), dimensionScreen.width, dimensionScreen.height, resultPanel);
		
		//Button NEW GAME
		btn_newGame.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_newGame.setForeground(Color.WHITE);
		this.transparentButton(btn_newGame);
		btn_newGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseButtonEnteredExit(panel_buttonNewGame, image.getImageButtonNewGame(true));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				mouseButtonEnteredExit(panel_buttonNewGame, image.getImageButtonNewGame(false));
			}
		});
		
		btn_newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(false);
				gamePanel = new GameJPanel((dimensionScreen.width / 2) - (dimensionScreen.width / 2), (dimensionScreen.height / 2) - (dimensionScreen.height / 2), dimensionScreen.width, dimensionScreen.height, resultPanel);
				gameContentPanel.add(gamePanel);
				gamePanel.setVisible(true);
				//resultPanel.setVisible(true);
			}
		});
		
		//Button Continue
		btn_continue.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_continue.setEnabled(false);
		btn_continue.setForeground(Color.WHITE);
		this.transparentButton(btn_continue);
		btn_continue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (btn_continue.isEnabled()) mouseButtonEnteredExit(panel_buttonContinue, image.getImageButtonContinue(true));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				if (btn_continue.isEnabled()) mouseButtonEnteredExit(panel_buttonContinue, image.getImageButtonContinue(true));
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
		panel_buttonNewGame.setLayout(new BorderLayout(0, 0));
		panel_buttonNewGame.setBackground(SystemColor.activeCaption);
		panel_buttonNewGame.setBounds((dimensionScreen.width / 2) - ((int)(menuPanel.getWidth() * 0.2) / 2) - 200, (int) Component.CENTER_ALIGNMENT + (int) (menuPanel.getHeight() * 0.11) + 550, (int) (menuPanel.getWidth() * 0.2), (int) (menuPanel.getHeight() * 0.1));
		panel_buttonNewGame.add(btn_newGame);
		menuPanel.add(panel_buttonNewGame);
		
		//Button Continue Panel
		panel_buttonContinue.setLayout(new BorderLayout(0, 0));
		panel_buttonContinue.setBackground(SystemColor.activeCaption);
		panel_buttonContinue.setBounds((dimensionScreen.width / 2) - ((int)(menuPanel.getWidth() * 0.2) / 2) - 200, (int) Component.CENTER_ALIGNMENT + panel_buttonNewGame.getY() + (int)(menuPanel.getHeight() * 0.11), (int) (menuPanel.getWidth() * 0.2), (int) (menuPanel.getHeight() * 0.1));
		panel_buttonContinue.add(btn_continue);
		menuPanel.add(panel_buttonContinue);
		
		//Button Exit Panel
		panel_buttonExit.setLayout(new BorderLayout(0, 0));
		panel_buttonExit.setBackground(SystemColor.activeCaption);
		panel_buttonExit.setBounds((dimensionScreen.width / 2) - ((int)(menuPanel.getWidth() * 0.2) / 2) - 200, (int) Component.CENTER_ALIGNMENT + panel_buttonNewGame.getY() + (int)(menuPanel.getHeight() * 0.11) * 2, (int) (menuPanel.getWidth() * 0.2), (int) (menuPanel.getHeight() * 0.1));
		panel_buttonExit.add(btn_exit);
		menuPanel.add(panel_buttonExit);
		
		titlePanel.setBounds((dimensionScreen.width / 2) - (1200 / 2) - 100, (dimensionScreen.height / 2) - (1200 / 2) - 50, 1200, 1200);
		menuPanel.add(titlePanel);
		
	}
	
	/*@Override
	public void paint(Graphics g) {
		super.paintComponents(g);
		g.drawImage(image.getImageTitle().getImage(), (dimensionScreen.width / 2) - (500 / 2), (dimensionScreen.height / 2) - (500 / 2), 500, 500, null);
	}*/

	private void mouseButtonEnteredExit(ButtonPanel panel, ImageIcon imageIcon) {
		panel.setImage(imageIcon);
	}
	
	private void transparentButton(JButton button) {
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
	}

	private void menuPaneDimension(JPanel panelMenu) {
		paneSize(panelMenu, dimensionScreen.width, dimensionScreen.height); // Menu WIDTH 45%, HEIGHT 75% of the window
		paneLocation(panelMenu, 0, 0);
	}

	private void paneSize(JPanel panel, int width, int height) {
		panel.setBounds(new Rectangle(width, height));
	}
	
	private void paneLocation(JPanel panelMenu, int x, int y) {
		panelMenu.setLocation(x, y);
	}
}
