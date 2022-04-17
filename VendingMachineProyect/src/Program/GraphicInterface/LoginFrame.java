package Program.GraphicInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Program.VendingMachine;
import Program.VendingMachineManager;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JTextField tfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		contentPane.add(panel, "name_52094155512900");
		panel.setLayout(null);
		
		JButton btnLogIn = new JButton("Log-In\r\n");
		btnLogIn.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		btnLogIn.setBounds(284, 153, 89, 23);
		panel.add(btnLogIn);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(111, 87, 262, 20);
		panel.add(tfUsername);
		tfUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblUsername.setBounds(22, 88, 75, 14);
		panel.add(lblUsername);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(111, 122, 262, 20);
		panel.add(tfPassword);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblPassword.setBounds(22, 124, 75, 14);
		panel.add(lblPassword);
		
		JLabel lblTitle = new JLabel("ADMIN LOG-IN\r\n");
		lblTitle.setFont(new Font("Roboto Black", Font.BOLD, 40));
		lblTitle.setBounds(48, 21, 325, 41);
		panel.add(lblTitle);
		
		JLabel lblErrorLogIn = new JLabel("");
		lblErrorLogIn.setFont(new Font("Roboto Black", Font.PLAIN, 11));
		lblErrorLogIn.setBounds(22, 199, 392, 23);
		panel.add(lblErrorLogIn);
		
		
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				//Param: VendingMachines para buscar a los admins de cada máquina

				
			}
		});
		
	}
}
