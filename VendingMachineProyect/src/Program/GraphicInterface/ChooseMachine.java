package Program.GraphicInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import Program.*;
import Program.Exceptions.ValueIncorrectException;
import Program.MoneyTypes.Coin;
import Program.MoneyTypes.Note;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JTextField;

public class ChooseMachine extends JFrame {
	private static final long serialVersionUID = 3142390317093997510L;
	
	private static JPanel ChooseMachinePane;
	private static JPanel PrintProductInformation;
	private static JPanel IntroduceAmountPane;
	
	
	private JPanel contentPane;
	private static VendingMachine currentVendingMachine;
	private static Product productToBuy;
	private static VendingMachine[] OperativeMachines;
	private JTextField TotalAmountText;
	private JTextField productsInformationText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		OperativeMachines = MainProgram.getEnabledMachines();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseMachine frame = new ChooseMachine();
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
	public ChooseMachine() {
		
		
		//Creation of the panels and the general settings
		
		InitializationOfPanels();
		
		SetChooseMachineWindow();
		
		SetPrintProductInformation();
		
		SetIntroduceAmountPane();
		
		
		
		
		
		
	}
	
	
	private static JTextPane textPane;
	//Method to initialice the content of choose machine window
	
	private void SetPrintProductInformation() {
		
				JLabel lblNewLabel_1 = new JLabel("Products information");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
				PrintProductInformation.add(lblNewLabel_1, BorderLayout.NORTH);
				
				JPanel MachineInformation = new JPanel();
				PrintProductInformation.add(MachineInformation, BorderLayout.CENTER);
				
				textPane = new JTextPane();
				MachineInformation.add(textPane);
				
				
				JPanel ButtomsToMove = new JPanel();
				PrintProductInformation.add(ButtomsToMove, BorderLayout.SOUTH);
				ButtomsToMove.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				
				JButton btnNewButton_10 = new JButton("Come back");
				btnNewButton_10.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ChooseMachinePane.setVisible(true);
						PrintProductInformation.setVisible(false);
						IntroduceAmountPane.setVisible(false);
					}
				});
				ButtomsToMove.add(btnNewButton_10);
				
				JLabel lblNewLabel_3 = new JLabel("Product number");
				ButtomsToMove.add(lblNewLabel_3);
				
				productsInformationText = new JTextField();
				ButtomsToMove.add(productsInformationText);
				productsInformationText.setColumns(10);
				
				JButton btnNewButton_11 = new JButton("Accept");
				btnNewButton_11.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						//Si el producto existe en la maquina , se pasa a la siguiente ventana
						
						int productId= Integer.parseInt(productsInformationText.getText());
						productToBuy = currentVendingMachine.getSpecificProduct(productId);
						if(productToBuy != null) {
							ChooseMachinePane.setVisible(false);
							PrintProductInformation.setVisible(false);
							IntroduceAmountPane.setVisible(true);
						}
					}
				});
				ButtomsToMove.add(btnNewButton_11);
		
	}
	
	//Method to initialice the content of choose machine window
	
	private void SetChooseMachineWindow() {
		
		
		JLabel lblNewLabel = new JLabel("Choose machine");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
		ChooseMachinePane.add(lblNewLabel);
		
		JPanel MachineOptions = new JPanel();
		ChooseMachinePane.add(MachineOptions);
		MachineOptions.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
		
		JButton Machine1Button = new JButton("Machine 1");
		Machine1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChooseMachinePane.setVisible(false);
				PrintProductInformation.setVisible(true);
				IntroduceAmountPane.setVisible(false);
				
				
				currentVendingMachine = OperativeMachines[0];
				textPane.setText(currentVendingMachine.toStringOnlyProducts());
				System.out.println(currentVendingMachine);
			}
		});
		MachineOptions.add(Machine1Button);
		
		JButton Machine2Button = new JButton("Machine 2");
		Machine2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChooseMachinePane.setVisible(false);
				PrintProductInformation.setVisible(true);
				IntroduceAmountPane.setVisible(false);
				
				currentVendingMachine = OperativeMachines[1];
				System.out.println(currentVendingMachine);
			}
		});
		MachineOptions.add(Machine2Button);
		
		JButton Machine3Button = new JButton("Machine 3");
		Machine3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChooseMachinePane.setVisible(false);
				PrintProductInformation.setVisible(true);
				IntroduceAmountPane.setVisible(false);
				
				currentVendingMachine = OperativeMachines[2];
				System.out.println(currentVendingMachine);
			}
		});
		MachineOptions.add(Machine3Button);
	}
	
	//Method to initialice the content of introduce amount window
	
	private void SetIntroduceAmountPane() {
		
		JLabel lblNewLabel_1_1 = new JLabel("Introduce amount");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
		IntroduceAmountPane.add(lblNewLabel_1_1, BorderLayout.NORTH);
		
		JPanel Buttoms = new JPanel();
		IntroduceAmountPane.add(Buttoms, BorderLayout.CENTER);
		
		
		//Almacen de dinero para meter a las maquinas
		List<Money> moneyToIntroduce = new ArrayList<Money>();
		
		//----------------------------Botones de añadir dinero-----------------------------
		
		JButton btnNewButton = new JButton("0.05 Coin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					SendMoneyToVendingMachine(new Coin(0.05f, 10) , moneyToIntroduce);
				} catch (ValueIncorrectException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

			
		});
		Buttoms.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("0.2 Coin");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					moneyToIntroduce.add(new Coin(0.2f, 1));
					TotalAmountText.setText(VendingMachine.calculeTotalValue(moneyToIntroduce).toString());
				} catch (ValueIncorrectException e) {
					e.printStackTrace();
				}
			}
		});
		Buttoms.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("0.5 Coin");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					moneyToIntroduce.add(new Coin(0.5f, 1));
					TotalAmountText.setText(VendingMachine.calculeTotalValue(moneyToIntroduce).toString());
				} catch (ValueIncorrectException e) {
					e.printStackTrace();
				}
			}
		});
		Buttoms.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("1 Coin");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					moneyToIntroduce.add(new Coin(1, 1));
					TotalAmountText.setText(VendingMachine.calculeTotalValue(moneyToIntroduce).toString());
				} catch (ValueIncorrectException e) {
					e.printStackTrace();
				}
			}
		});
		Buttoms.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("2 Coin");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					moneyToIntroduce.add(new Coin(2, 1));
					TotalAmountText.setText(VendingMachine.calculeTotalValue(moneyToIntroduce).toString());
				} catch (ValueIncorrectException e) {
					e.printStackTrace();
				}
			}
		});
		Buttoms.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("5 Note");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					moneyToIntroduce.add(new Note(5, 1));
					TotalAmountText.setText(VendingMachine.calculeTotalValue(moneyToIntroduce).toString());
				} catch (ValueIncorrectException e) {
					e.printStackTrace();
				}
			}
		});
		Buttoms.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("10 Note");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					moneyToIntroduce.add(new Note(10, 1));
					TotalAmountText.setText(VendingMachine.calculeTotalValue(moneyToIntroduce).toString());
				} catch (ValueIncorrectException e) {
					e.printStackTrace();
				}
			}
		});
		Buttoms.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("20 Note");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					moneyToIntroduce.add(new Note(20, 1));
					TotalAmountText.setText(VendingMachine.calculeTotalValue(moneyToIntroduce).toString());
				} catch (ValueIncorrectException e) {
					e.printStackTrace();
				}
			}
		});
		Buttoms.add(btnNewButton_7);
		
		//--------------------------------------------------------
		
		JPanel Total = new JPanel();
		IntroduceAmountPane.add(Total, BorderLayout.SOUTH);
		Total.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_8 = new JButton("Come back");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChooseMachinePane.setVisible(false);
				PrintProductInformation.setVisible(true);
				IntroduceAmountPane.setVisible(false);
			}
		});
		Total.add(btnNewButton_8);
		
		JLabel lblNewLabel_2 = new JLabel("Total : ");
		Total.add(lblNewLabel_2);
		
		TotalAmountText = new JTextField();
		Total.add(TotalAmountText);
		TotalAmountText.setColumns(10);
		
		JButton btnNewButton_9 = new JButton("Accept");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				double totalAmountIntroduced = Float.parseFloat(TotalAmountText.getText());
				
				if(totalAmountIntroduced >= productToBuy.getPrice()) {
					currentVendingMachine.addMoney(moneyToIntroduce);
					currentVendingMachine.removeProduct(productToBuy.getId());
				}
				
				
				
			}
		});
		Total.add(btnNewButton_9);
	}
	
	private void SendMoneyToVendingMachine(Money money, List<Money> moneyToIntroduce) throws ValueIncorrectException {
		
		moneyToIntroduce.add(money);
		TotalAmountText.setText(VendingMachine.calculeTotalValue(moneyToIntroduce).toString());
		
	}
	
	
	//Method to initialice all the panels and set their settings
	
	private void InitializationOfPanels() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		//PANEL CREATION
		
		//ChooseMachinePanel
		
		ChooseMachinePane = new JPanel();
		contentPane.add(ChooseMachinePane, "name_2929736530442100");
		
		//PrintProductsPanel
		
		PrintProductInformation = new JPanel();
		contentPane.add(PrintProductInformation, "name_2929736579834000");
		PrintProductInformation.setLayout(new BorderLayout(0, 0));
		
		//IntroduceAmountPane
		
		IntroduceAmountPane = new JPanel();
		contentPane.add(IntroduceAmountPane, "name_2929736620635600");
		IntroduceAmountPane.setLayout(new BorderLayout(0, 0));
		
	}

}
