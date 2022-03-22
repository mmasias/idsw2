package isii.program;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

import isii.JClass.ButtonPanel;

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
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.BorderLayout;

public class MainJFrame extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel gameContentPanel;
	private JPanel menuPanel = new JPanel();
	private GameJPanel gamePanel;
	private JButton btn_newGame = new JButton("NEW GAME");
	private JButton btn_continue = new JButton("CONTINUE");
	private JButton btn_exit = new JButton("EXIT");
	private Dimension dimensionScreen;
	private ButtonPanel panel_buttonNewGame = new ButtonPanel(new ImageIcon("Images\\fondoBotonRPG.png"));
	private ButtonPanel panel_buttonContinue = new ButtonPanel(new ImageIcon("Images\\fondoBotonRPG.png"));
	private ButtonPanel panel_buttonExit = new ButtonPanel(new ImageIcon("Images\\fondoBotonRPG.png"));
	

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
	public MainJFrame() {
		//JFrame FULL SCREEN
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setUndecorated(true);
		
		//Window Panel
		gameContentPanel = new JPanel();
		gameContentPanel.setBackground(new Color(240, 128, 128));
		gameContentPanel.setMaximumSize(this.getSize());
		setContentPane(gameContentPanel);
		gameContentPanel.setLayout(null);
		
		dimensionScreen = Toolkit.getDefaultToolkit().getScreenSize();
		gamePanel = new GameJPanel((dimensionScreen.width / 2) - (dimensionScreen.width / 2), (dimensionScreen.height / 2) - (dimensionScreen.height / 2), dimensionScreen.width, dimensionScreen.height);
		gamePanel.setVisible(false);
		gameContentPanel.add(gamePanel);
		
		
		//Menu Panel
		menuPanel.setLayout(null);
		menuPanel.setBackground(SystemColor.activeCaption);
		gameContentPanel.add(menuPanel);
		this.menuPaneDimension(menuPanel);
		
		//Button NEW GAME
		btn_newGame.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_newGame.setForeground(Color.WHITE);
		this.transparentButton(btn_newGame);
		btn_newGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseButtonEntered(btn_newGame);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				mouseButtonExited(btn_newGame);
			}
		});
		
		btn_newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(false);
				gamePanel.setVisible(true);
				
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
				if (btn_continue.isEnabled()) mouseButtonEntered(btn_continue);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				if (btn_continue.isEnabled()) mouseButtonExited(btn_continue);
			}
		});
		
		//Button EXIT
		btn_exit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_exit.setForeground(Color.WHITE);
		this.transparentButton(btn_exit);
		btn_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseButtonEntered(btn_exit);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mouseButtonExited(btn_exit);
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
		panel_buttonNewGame.setBounds((int) Component.CENTER_ALIGNMENT + (int) (menuPanel.getWidth() * 0.25), (int) Component.CENTER_ALIGNMENT + (int) (menuPanel.getHeight() * 0.2), (int) (menuPanel.getWidth() * 0.5), (int) (menuPanel.getHeight() * 0.2));
		panel_buttonNewGame.add(btn_newGame);
		menuPanel.add(panel_buttonNewGame);
		
		//Button Continue Panel
		panel_buttonContinue.setLayout(new BorderLayout(0, 0));
		panel_buttonContinue.setBackground(SystemColor.activeCaption);
		panel_buttonContinue.setBounds((int) Component.CENTER_ALIGNMENT + (int) (menuPanel.getWidth() * 0.25), (int) Component.CENTER_ALIGNMENT + panel_buttonNewGame.getY() + (int)(menuPanel.getHeight() * 0.21), (int) (menuPanel.getWidth() * 0.5), (int) (menuPanel.getHeight() * 0.2));
		panel_buttonContinue.add(btn_continue);
		menuPanel.add(panel_buttonContinue);
		
		//Button Exit Panel
		panel_buttonExit.setLayout(new BorderLayout(0, 0));
		panel_buttonExit.setBackground(SystemColor.activeCaption);
		panel_buttonExit.setBounds((int) Component.CENTER_ALIGNMENT + (int) (menuPanel.getWidth() * 0.25), (int) Component.CENTER_ALIGNMENT + panel_buttonNewGame.getY() + (int)(menuPanel.getHeight() * 0.21) * 2, (int) (menuPanel.getWidth() * 0.5), (int) (menuPanel.getHeight() * 0.2));
		panel_buttonExit.add(btn_exit);
		menuPanel.add(panel_buttonExit);
		
		
	}

	//Underline text when mouse Entered
	@SuppressWarnings("deprecation")
	private void mouseButtonEntered(JButton button) {
		Font font = button.getFont();
		Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		button.setFont(font.deriveFont(attributes));
		this.setCursor(Cursor.HAND_CURSOR);
	}
	
	//Remove underline text when mouse Exit
	@SuppressWarnings("deprecation")
	private void mouseButtonExited(JButton button) {
		Font font = button.getFont();
		Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
		attributes.put(TextAttribute.UNDERLINE, -1);
		button.setFont(font.deriveFont(attributes));
		this.setCursor(Cursor.DEFAULT_CURSOR);
	}

	private void transparentButton(JButton button) {
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
	}

	private void menuPaneDimension(JPanel panelMenu) {
		//dimensionScreen = Toolkit.getDefaultToolkit().getScreenSize();
		paneSize(panelMenu, (int) (dimensionScreen.width * 0.45), (int) (dimensionScreen.height * 0.75)); // Menu WIDTH 45%, HEIGHT 75% of the window
		paneLocation(panelMenu, (dimensionScreen.width / 2) - (panelMenu.getWidth() / 2), (dimensionScreen.height / 2) - (panelMenu.getHeight() / 2));
	}

	private void paneSize(JPanel panel, int width, int height) {
		panel.setBounds(new Rectangle(width, height));
	}
	
	private void paneLocation(JPanel panelMenu, int x, int y) {
		panelMenu.setLocation(x, y);
	}
}
