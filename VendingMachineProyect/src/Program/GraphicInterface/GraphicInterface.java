package Program.GraphicInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import javax.swing.border.MatteBorder;

public class GraphicInterface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphicInterface frame = new GraphicInterface();
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
	public GraphicInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setVisible(false);
		backgroundPanel.setBackground(new Color(255, 255, 255));
		contentPane.add(backgroundPanel, BorderLayout.CENTER);
		backgroundPanel.setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(30, 144, 255));
		titlePanel.setBounds(0, 0, 783, 149);
		backgroundPanel.add(titlePanel);
		
		JLabel lblTitle = new JLabel("VENIDNG MACHINE\r\n");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Roboto Black", Font.PLAIN, 52));
		titlePanel.add(lblTitle);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(null);
		panel.setForeground(new Color(255, 255, 255));
		panel.setBounds(232, 176, 337, 149);
		backgroundPanel.add(panel);
		
		JButton btnComprarMenu_1 = new JButton("BUY NOW!");
		btnComprarMenu_1.setBorderPainted(false);
		btnComprarMenu_1.setBackground(new Color(153, 204, 102));
		btnComprarMenu_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnComprarMenu_1.setAlignmentY(Component.TOP_ALIGNMENT);
		btnComprarMenu_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnComprarMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnComprarMenu_1.setFont(new Font("Roboto", Font.PLAIN, 61));
		panel.add(btnComprarMenu_1);
		
		JLabel lblNewLabel = new JLabel("Log-In as an Administrator");
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 11));
		panel.add(lblNewLabel);
		
		JButton btnAdminMenu = new JButton("I'm an Administrator");
		btnAdminMenu.setBackground(new Color(204, 255, 204));
		btnAdminMenu.setBorderPainted(false);
		btnAdminMenu.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnAdminMenu.setFont(new Font("Roboto", Font.PLAIN, 11));
		panel.add(btnAdminMenu);
		
		JPanel MachinesPanel = new JPanel();
		contentPane.add(MachinesPanel, BorderLayout.WEST);
	}
}
