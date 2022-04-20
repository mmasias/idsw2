package Program.GraphicInterface;

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
import java.awt.Point;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GraphicInterface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8892693841881076365L;
	private JPanel contentPane;
	private JTextField tfMoney;
	private JTextField tfProdcuts;

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
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel buyOrLogInPanel = new JPanel();
		buyOrLogInPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		buyOrLogInPanel.setOpaque(true);
		buyOrLogInPanel.setLocation(new Point(1, 5));
		buyOrLogInPanel.setBackground(new Color(255, 255, 255));
		contentPane.add(buyOrLogInPanel, "name_9769166799700");
		
		JPanel titlePanel = new JPanel();
		titlePanel.setVisible(false);
		titlePanel.setBackground(new Color(30, 144, 255));
		titlePanel.setLayout(null);
		
		JLabel lblTitle = new JLabel("VENIDING MACHINE\r\n");
		lblTitle.setBounds(151, 34, 485, 62);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Roboto Black", Font.PLAIN, 52));
		titlePanel.add(lblTitle);
		
		JPanel buyPanel = new JPanel();
		buyPanel.setBackground(new Color(255, 255, 255));
		buyPanel.setBorder(null);
		buyPanel.setForeground(new Color(255, 255, 255));
		
		JButton btnComprarMenu_1 = new JButton("BUY NOW!");
		btnComprarMenu_1.setBorderPainted(false);
		btnComprarMenu_1.setBackground(new Color(153, 204, 102));
		btnComprarMenu_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnComprarMenu_1.setAlignmentY(Component.TOP_ALIGNMENT);
		btnComprarMenu_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnComprarMenu_1.setFont(new Font("Roboto", Font.PLAIN, 61));
		buyPanel.add(btnComprarMenu_1);
		
		JLabel lblNewLabel = new JLabel("Log-In as an Administrator");
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 11));
		buyPanel.add(lblNewLabel);
		
		JButton btnAdminMenu = new JButton("I'm an Administrator");

		btnAdminMenu.setBackground(new Color(204, 255, 204));
		btnAdminMenu.setBorderPainted(false);
		btnAdminMenu.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnAdminMenu.setFont(new Font("Roboto", Font.PLAIN, 11));
		buyPanel.add(btnAdminMenu);
		GroupLayout gl_buyOrLogInPanel = new GroupLayout(buyOrLogInPanel);
		gl_buyOrLogInPanel.setHorizontalGroup(
			gl_buyOrLogInPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 783, GroupLayout.PREFERRED_SIZE)
				.addGroup(Alignment.TRAILING, gl_buyOrLogInPanel.createSequentialGroup()
					.addContainerGap(229, Short.MAX_VALUE)
					.addComponent(buyPanel, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
					.addGap(217))
		);
		gl_buyOrLogInPanel.setVerticalGroup(
			gl_buyOrLogInPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buyOrLogInPanel.createSequentialGroup()
					.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(buyPanel, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(130))
		);
		buyOrLogInPanel.setLayout(gl_buyOrLogInPanel);
		
		JPanel rechargeMoneyPanel = new JPanel();
		rechargeMoneyPanel.setBackground(new Color(153, 204, 255));
		rechargeMoneyPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(rechargeMoneyPanel, "name_9907318158100");
		rechargeMoneyPanel.setLayout(null);
		
		JPanel contentRechargeMoneyPanel = new JPanel();
		contentRechargeMoneyPanel.setBackground(new Color(255, 255, 255));
		contentRechargeMoneyPanel.setBounds(0, 134, 783, 345);
		rechargeMoneyPanel.add(contentRechargeMoneyPanel);
		contentRechargeMoneyPanel.setLayout(null);
		
		JLabel lbl1 = new JLabel("1\u20AC");
		lbl1.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lbl1.setBounds(21, 147, 34, 14);
		contentRechargeMoneyPanel.add(lbl1);
		
		JLabel lbl2 = new JLabel("2\u20AC");
		lbl2.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lbl2.setBounds(21, 183, 34, 14);
		contentRechargeMoneyPanel.add(lbl2);
		
		JLabel lbl05 = new JLabel("0,5\u20AC");
		lbl05.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lbl05.setBounds(21, 112, 34, 14);
		contentRechargeMoneyPanel.add(lbl05);
		
		JLabel lbl02 = new JLabel("0,2\u20AC");
		lbl02.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lbl02.setBounds(21, 78, 34, 14);
		contentRechargeMoneyPanel.add(lbl02);
		
		JLabel lbl005 = new JLabel("0,05\u20AC");
		lbl005.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lbl005.setBounds(21, 42, 34, 14);
		contentRechargeMoneyPanel.add(lbl005);
		
		JLabel lbl5 = new JLabel("5\u20AC");
		lbl5.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lbl5.setBounds(21, 220, 34, 14);
		contentRechargeMoneyPanel.add(lbl5);
		
		JLabel lbl10 = new JLabel("10\u20AC");
		lbl10.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lbl10.setBounds(21, 262, 34, 14);
		contentRechargeMoneyPanel.add(lbl10);
		
		JLabel lbl20 = new JLabel("20\u20AC");
		lbl20.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lbl20.setBounds(21, 303, 34, 14);
		contentRechargeMoneyPanel.add(lbl20);
		
		tfMoney = new JTextField();
		tfMoney.setBounds(563, 112, 74, 18);
		contentRechargeMoneyPanel.add(tfMoney);
		tfMoney.setColumns(10);
		
		JButton btnAdditionMoney = new JButton("+");
		btnAdditionMoney.setBorder(null);
		btnAdditionMoney.setBackground(new Color(255, 51, 51));
		btnAdditionMoney.setForeground(new Color(0, 0, 0));
		btnAdditionMoney.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		btnAdditionMoney.setBounds(659, 112, 39, 19);
		contentRechargeMoneyPanel.add(btnAdditionMoney);
		
		JButton btnReduceMoney = new JButton("-");
		btnReduceMoney.setForeground(Color.BLACK);
		btnReduceMoney.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		btnReduceMoney.setBorder(null);
		btnReduceMoney.setBackground(new Color(0, 204, 255));
		btnReduceMoney.setBounds(514, 112, 39, 19);
		contentRechargeMoneyPanel.add(btnReduceMoney);
		
		JLabel lblSelectCurrency = new JLabel("Select the currency:");
		lblSelectCurrency.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblSelectCurrency.setBounds(248, 112, 112, 14);
		contentRechargeMoneyPanel.add(lblSelectCurrency);
		
		JLabel lblQ005 = new JLabel("0");
		lblQ005.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblQ005.setBounds(89, 43, 34, 14);
		contentRechargeMoneyPanel.add(lblQ005);
		
		JLabel lblQ02 = new JLabel("0");
		lblQ02.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblQ02.setBounds(89, 79, 34, 14);
		contentRechargeMoneyPanel.add(lblQ02);
		
		JLabel lblQ05 = new JLabel("0");
		lblQ05.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblQ05.setBounds(89, 113, 34, 14);
		contentRechargeMoneyPanel.add(lblQ05);
		
		JLabel lblQ1 = new JLabel("0");
		lblQ1.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblQ1.setBounds(89, 148, 34, 14);
		contentRechargeMoneyPanel.add(lblQ1);
		
		JLabel lblQ2 = new JLabel("0");
		lblQ2.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblQ2.setBounds(89, 184, 34, 14);
		contentRechargeMoneyPanel.add(lblQ2);
		
		JLabel lblQ5 = new JLabel("0");
		lblQ5.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblQ5.setBounds(89, 221, 34, 14);
		contentRechargeMoneyPanel.add(lblQ5);
		
		JLabel lblQ10 = new JLabel("0");
		lblQ10.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblQ10.setBounds(89, 263, 34, 14);
		contentRechargeMoneyPanel.add(lblQ10);
		
		JLabel lblQ20 = new JLabel("0");
		lblQ20.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblQ20.setBounds(89, 304, 34, 14);
		contentRechargeMoneyPanel.add(lblQ20);
		
		JLabel lblCurrency = new JLabel("Currency");
		lblCurrency.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblCurrency.setBounds(10, 11, 51, 14);
		contentRechargeMoneyPanel.add(lblCurrency);
		
		JLabel lblMoneyQuantity = new JLabel("Quantity");
		lblMoneyQuantity.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblMoneyQuantity.setBounds(82, 12, 51, 14);
		contentRechargeMoneyPanel.add(lblMoneyQuantity);
		
		JLabel lblMachineMoney = new JLabel("Machine X");
		lblMachineMoney.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblMachineMoney.setBounds(706, 11, 67, 14);
		contentRechargeMoneyPanel.add(lblMachineMoney);
		//lblMachineMoney.setText("");
		
		JComboBox cbCurrency = new JComboBox();
		cbCurrency.setModel(new DefaultComboBoxModel(new String[] {"0,05\u20AC", "0,2\u20AC", "0,5\u20AC", "1\u20AC", "2\u20AC", "5\u20AC", "10\u20AC", "20\u20AC"}));
		cbCurrency.setBounds(370, 112, 134, 19);
		contentRechargeMoneyPanel.add(cbCurrency);
		
		JButton btnAddMoney = new JButton("Add\r\n");
		btnAddMoney.setBorder(null);
		btnAddMoney.setBackground(new Color(153, 255, 153));
		btnAddMoney.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		btnAddMoney.setBounds(708, 109, 65, 23);
		contentRechargeMoneyPanel.add(btnAddMoney);
		
		JLabel lbl€ = new JLabel("\u20AC");
		lbl€.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lbl€.setBounds(639, 113, 17, 14);
		contentRechargeMoneyPanel.add(lbl€);
		
		JPanel titleRechargeMoneyPanel = new JPanel();
		titleRechargeMoneyPanel.setLayout(null);
		titleRechargeMoneyPanel.setBackground(new Color(153, 204, 255));
		titleRechargeMoneyPanel.setBounds(0, 0, 783, 134);
		rechargeMoneyPanel.add(titleRechargeMoneyPanel);
		
		JLabel lblNewLabel_1 = new JLabel("RECHARGE MONEY");
		lblNewLabel_1.setFont(new Font("Roboto Black", Font.PLAIN, 60));
		lblNewLabel_1.setBounds(114, -11, 539, 157);
		titleRechargeMoneyPanel.add(lblNewLabel_1);
		
		JPanel rechargeProductsPanel = new JPanel();
		rechargeProductsPanel.setLayout(null);
		rechargeProductsPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		rechargeProductsPanel.setBackground(new Color(153, 204, 255));
		contentPane.add(rechargeProductsPanel, "name_54518782135900");
		
		JPanel contentRechargeMoneyPanel_1 = new JPanel();
		contentRechargeMoneyPanel_1.setLayout(null);
		contentRechargeMoneyPanel_1.setBackground(Color.WHITE);
		contentRechargeMoneyPanel_1.setBounds(0, 134, 783, 345);
		rechargeProductsPanel.add(contentRechargeMoneyPanel_1);
		
		JLabel lblP4 = new JLabel("Drink");
		lblP4.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblP4.setBounds(10, 148, 58, 14);
		contentRechargeMoneyPanel_1.add(lblP4);
		
		JLabel lblP3 = new JLabel("Snack");
		lblP3.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblP3.setBounds(10, 113, 58, 14);
		contentRechargeMoneyPanel_1.add(lblP3);
		
		JLabel lblP2 = new JLabel("Chocolate");
		lblP2.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblP2.setBounds(10, 79, 58, 14);
		contentRechargeMoneyPanel_1.add(lblP2);
		
		JLabel lblP1 = new JLabel("Cookies");
		lblP1.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblP1.setBounds(10, 43, 58, 14);
		contentRechargeMoneyPanel_1.add(lblP1);
		
		tfProdcuts = new JTextField();
		tfProdcuts.setColumns(10);
		tfProdcuts.setBounds(563, 112, 74, 18);
		contentRechargeMoneyPanel_1.add(tfProdcuts);
		
		JButton btnAdditionP = new JButton("+");
		btnAdditionP.setForeground(Color.BLACK);
		btnAdditionP.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		btnAdditionP.setBorder(null);
		btnAdditionP.setBackground(new Color(255, 51, 51));
		btnAdditionP.setBounds(647, 111, 39, 19);
		contentRechargeMoneyPanel_1.add(btnAdditionP);
		
		JButton btnReduceP = new JButton("-");
		btnReduceP.setForeground(Color.BLACK);
		btnReduceP.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		btnReduceP.setBorder(null);
		btnReduceP.setBackground(new Color(0, 204, 255));
		btnReduceP.setBounds(514, 112, 39, 19);
		contentRechargeMoneyPanel_1.add(btnReduceP);
		
		JLabel lblSelectProduct = new JLabel("Select the prodcut:");
		lblSelectProduct.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblSelectProduct.setBounds(248, 112, 112, 14);
		contentRechargeMoneyPanel_1.add(lblSelectProduct);
		
		JLabel lblP1quantity = new JLabel("0");
		lblP1quantity.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblP1quantity.setBounds(89, 43, 34, 14);
		contentRechargeMoneyPanel_1.add(lblP1quantity);
		
		JLabel lblP2quantity = new JLabel("0");
		lblP2quantity.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblP2quantity.setBounds(89, 79, 34, 14);
		contentRechargeMoneyPanel_1.add(lblP2quantity);
		
		JLabel lblP3quantity = new JLabel("0");
		lblP3quantity.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblP3quantity.setBounds(89, 113, 34, 14);
		contentRechargeMoneyPanel_1.add(lblP3quantity);
		
		JLabel lblP4quantity = new JLabel("0");
		lblP4quantity.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblP4quantity.setBounds(89, 148, 34, 14);
		contentRechargeMoneyPanel_1.add(lblP4quantity);
		
		JLabel lblTypesProdcuts = new JLabel("Product");
		lblTypesProdcuts.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblTypesProdcuts.setBounds(10, 11, 51, 14);
		contentRechargeMoneyPanel_1.add(lblTypesProdcuts);
		
		JLabel lblQuantityProdcuts = new JLabel("Quantity");
		lblQuantityProdcuts.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblQuantityProdcuts.setBounds(82, 12, 51, 14);
		contentRechargeMoneyPanel_1.add(lblQuantityProdcuts);
		
		JLabel lblMachineP = new JLabel("Machine X");
		lblMachineP.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblMachineP.setBounds(706, 11, 67, 14);
		contentRechargeMoneyPanel_1.add(lblMachineP);
		
		JComboBox cbProducts = new JComboBox();
		cbProducts.setModel(new DefaultComboBoxModel(new String[] {"Cookies", "Chocolate", "Snack", "Drink"}));
		cbProducts.setBounds(370, 112, 134, 19);
		contentRechargeMoneyPanel_1.add(cbProducts);
		
		JButton btnAddProduts = new JButton("Add\r\n");
		btnAddProduts.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		btnAddProduts.setBorder(null);
		btnAddProduts.setBackground(new Color(153, 255, 153));
		btnAddProduts.setBounds(708, 109, 65, 23);
		contentRechargeMoneyPanel_1.add(btnAddProduts);
		
		JPanel titleRechargeMoneyPanel_1 = new JPanel();
		titleRechargeMoneyPanel_1.setLayout(null);
		titleRechargeMoneyPanel_1.setBackground(new Color(153, 204, 255));
		titleRechargeMoneyPanel_1.setBounds(0, 0, 783, 134);
		rechargeProductsPanel.add(titleRechargeMoneyPanel_1);
		
		JLabel lblTitleRechargeProdcuts = new JLabel("RECHARGE PRODUCTS");
		lblTitleRechargeProdcuts.setFont(new Font("Roboto Black", Font.PLAIN, 60));
		lblTitleRechargeProdcuts.setBounds(57, -11, 658, 157);
		titleRechargeMoneyPanel_1.add(lblTitleRechargeProdcuts);
		
		JPanel selectMachinePanel = new JPanel();
		contentPane.add(selectMachinePanel, "name_55195384123100");
		
		
		//Events listeners
		
		//BuyOrLoginPanel
		
		btnAdminMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame lf = new LoginFrame();
				buyOrLogInPanel.setVisible(false);
				rechargeMoneyPanel.setVisible(false);
				rechargeProductsPanel.setVisible(false);
				selectMachinePanel.setVisible(true);	//Añadir aquí que hasta que no se cirre la pestaña del login no se pueda seleccionar la máquina
			}
		});
		
		btnComprarMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buyOrLogInPanel.setVisible(false);
				rechargeMoneyPanel.setVisible(false);
				rechargeProductsPanel.setVisible(false);
				selectMachinePanel.setVisible(true);
			}
		});
	}
}
