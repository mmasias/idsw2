package Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

import Program.MoneyTypes.*;

public class VendingMachine {
	
	private int machineNumber;
	private Product[] products;
	private Money[] money;
	private boolean stuck;
	private boolean broken;
	private List<Administrator> administrators = new ArrayList();
	
	public VendingMachine(int machineNumber, Product[] products, Money[] money, List<Administrator> administrators) {
		this.machineNumber = machineNumber;
		this.products = products;
		this.money = money;
		this.stuck = false;
		this.broken = false;
		this.administrators = administrators;
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
	
	public boolean checkMachineBroken() {
		return broken;
	}

	public void setBroken(boolean broken) {
		this.broken = broken;
	}
	
	public boolean checkMachineStuck() {
		return broken;
	}

	public void setStuck(boolean stuck) {
		this.stuck = stuck;
	}
	
	public boolean buyProduct(String product , List<Money> money) {
		
		machineGetsStuck();
		machineBreaksDown();
		
		if(!broken || !stuck ) {
			Double amount = calculeTotalValue(money);
			//Sacar producto
			
			for(Product current : products) {
				if(product.equals(current.getName()) && amount > current.getPrice()) {
					
					addMoney(money);
					return true;
				}
			}
			
			return false;
		}else {
			System.out.println("La máquina no se encuentra disponible");
			return false;
		}

		
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
	
	public void machineGetsStuck() {
		
		Random random = new Random();
		final int i = random.nextInt(99);
		if(i > 97) {
			this.stuck = true;
		}
		else {
			this.stuck = false;
		}
	}
	
	public void machineBreaksDown() {
		
		Random random = new Random();
		final int i = random.nextInt(99);
		if(i > 96) {
			this.broken = true;
		}
		else {
			this.broken = false;
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
	
	public void LogIn() {
		
		Scanner scanner = new Scanner(System.in);
		
		String result =  "---------------------------------\n";
		result += "         Introduce tu usuario:";
		result += "---------------------------------\n";
		final String username = scanner.nextLine();
		
		result +=  "---------------------------------\n";
		result += "         Introduce tu contraseña:";
		result += "---------------------------------\n";
		final String password = scanner.nextLine();
		
		scanner.close();
		System.out.println(result);	
		
		checkLogIn(username, password);
	}
	
	private boolean checkLogIn(String username, String password) {
		
		boolean result = false;
		for(Administrator a : administrators) {
			if(username.equals(a.getUsername()) && password.equals(a.getPassword())) {
				result = true;
			}
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
	
	public String machineStuckString () {
		
		String result =  "---------------------------------\n";
		result += "         La máquina se ha atascado, por favor agitela para desatascarla ";
		result += "---------------------------------\n";

		
		return result;
	}
	
	public String unstuckMachineString () {
		
		
		String result =  "---------------------------------\n";
		result += "         El técnico ha arreglado la máquina con éxito			";
		result += "---------------------------------\n";
			
		return result;
	}
	
	public String machineBrokenString () {
		
		String result =  "---------------------------------\n";
		result += "         La máquina se ha averiado, por favor espere a que un técnico venga a desatascarla 		";
		result += "---------------------------------\n";
		
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
