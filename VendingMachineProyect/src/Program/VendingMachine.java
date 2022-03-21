package Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Program.MoneyTypes.*;

public class VendingMachine {
	
	private int machineNumber;
	private Product[] products;
	private Money[] money;
	
	public VendingMachine(int machineNumber, Product[] products, Money[] money) {
		this.machineNumber = machineNumber;
		this.products = products;
		this.money = money;
	}

	public int getMachineNumber() {
		return machineNumber;
	}

	public void setMachineNumber(int machineNumber) {
		this.machineNumber = machineNumber;
	}

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}

	public Money[] getMoney() {
		return money;
	}

	public void setMoney(Money[] money) {
		this.money = money;
	}
	
	public boolean buyProduct(String product , List<Money> money) {
		
		
		Double amount = calculeTotalValue(money);
		//Sacar producto
		
		for(Product current : products) {
			if(product.equals(current.getName()) && amount > current.getPrice()) {
				
				addMoney(money);
				return true;
			}
		}
		
		return false;
		
	}
	
	
	
	private void addMoney(List<Money> moneyList) {
		for(Money currentList : moneyList) {
			for(Money currentArray : money) {
				if(currentList.getValue() == currentArray.getValue()) {
					currentArray.setCuantity(currentArray.getCuantity() + currentList.getCuantity());
				}
			}
		}
		
	}

	public String productString () {
		String result = "---------------------------------\n"
				+ "         Maquina"+machineNumber
				+"\n---------------------------------\n";
		
		result += "---------------------------------\n";
		result += "         Productos\n";
		result += "---------------------------------\n";
		for(Product current : products) {
			result += current.toString() + "\n";
		}
		
		
		return result;
	}
	
	public String moneyString () {
		
		String result =  "---------------------------------\n";
		result += "         Dinero\n";
		result += "---------------------------------\n";
		
		result += "Valor  			 Cantidad\n";
		
		for(Money current : money) {
			result += current.toString() + "\n";
		}
		
		
		return result;
	}
	
	public String toString() {
		
		String result = "---------------------------------\n"
				+ "         Maquina"+machineNumber
				+"\n---------------------------------\n";
		
		result += "---------------------------------\n";
		result += "         Productos\n";
		result += "---------------------------------\n";


		result += "Nombre  			 Cantidad\n";
		
		for(Product current : products) {
			result += current.toString() + "\n";
		}
		
		
		result += "---------------------------------\n";
		result += "         Dinero\n";
		result += "---------------------------------\n";
		
		result += "Valor  			 Cantidad\n";
		
		for(Money current : money) {
			result += current.toString() + "\n";
		}
		
		return result;
	}
	
	public static Double calculeTotalValue(List<Money> moneyList) {
		
		Double result = moneyList.stream()
				.mapToDouble(x -> x.getTotalValue())
				.sum();
		
		return result;
	}

	public static List<Money> IntroduceMoney() {
		
		List<Money> result = new ArrayList<Money>();
		Scanner scanner = new Scanner(System.in);
		boolean IDontHaveToExit = true;
		
		do {
			System.out.println("---------------------------------");
			System.out.println("1 - Moneda");
			System.out.println("2 - Billete");
			System.out.println("3 - Ya esta");
			System.out.println("Seleccionar opcion : ");
			
			int option = scanner.nextInt();
			
			IDontHaveToExit = IntroduceSingleMoney(option , result);
		
			
		}while(IDontHaveToExit);
		
		scanner.close();
		return result;
	}

	private static boolean IntroduceSingleMoney(int option, List<Money> result) {
		
		float amount;
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			if(option == 1) {
				
				System.out.println("---------------------------------");
				System.out.println("Valor de la moneda : ");
				amount = scanner.nextFloat();
				Coin e = new Coin(amount , 1);
				result.add(e);
				
			}else if(option == 2) {
				System.out.println("---------------------------------");
				System.out.println("Valor del billete: ");
				amount = scanner.nextFloat();
				result.add(new Note(amount , 1));
				
			}else if(option == 3) {
				scanner.close();
				return false;
			}else {
				System.out.println("---------------------------------");
				System.out.println("       NUMERO INCORRECTO");
				System.out.println("---------------------------------");
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		scanner.close();
		return true;
		
	}
	

}
