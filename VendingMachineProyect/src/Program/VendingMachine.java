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
	private List<Administrator> administrators = new ArrayList<Administrator>();
	
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
			System.out.println("La m�quina no se encuentra disponible");
			return false;
		}

		
	}
	
	public void refillMoney() {
		
	}
	
	public void refillProduct() {
		
		productString();
		
		final Scanner scanner = new Scanner(System.in);
		
		System.out.println("Escribir producto deseado : ");
		final String product = scanner.nextLine();
		
		for(Product current : products) {
			
			if(product.equals(current.getName())) {
				
				int quantity = 0;
				do {
					System.out.println("Escribir la cantidad a rellenar del producto: ");
					quantity = scanner.nextInt();
					
				}while(quantity <= 0);	
				current.setCuantity(quantity);
			}
		}
		scanner.close();
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
	
	public boolean checkIfSomeoneLogedIn() {
		boolean logedIn = false;
		for(Administrator a : administrators) {
			if(a.isLogedIn()) {
				logedIn = true;
			}
		}
		return logedIn;
	}
	
	public Administrator getAdministratorLogedIn() {
		Administrator result = null;
		for(Administrator a : administrators) {
			if(a.isLogedIn()) {
				result = a;
			}
		}
		return result;
	}
	
	public void logOutAdminLogedIn() {
		for(Administrator a : administrators) {
			if(a.isLogedIn()) {
				a.setLogedIn(false);
			}
		}
	}
	
	public void machineGetsStuck() {
		
		Random random = new Random();
		final int i = random.nextInt(99);
		if(i > 97) {
			this.stuck = true;
			machineStuckString();
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
			machineBrokenString();
		}
		else {
			this.broken = false;
		}
	}

	public String productString () {
		String result = "---------------------------------\n"
				+ "         Maquina "+machineNumber
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
	
	public String LogIn() {
		
		final Scanner scanner = new Scanner(System.in);
		
		String result =  "---------------------------------\n";
		result += "         Introduce tu usuario:\n";
		result += "---------------------------------\n";
		System.out.print(result);
		final String username = scanner.nextLine();
		
		String result2 =  "---------------------------------\n";
		result2 += "         Introduce tu contrase�a:\n";
		result2 += "---------------------------------\n";
		System.out.print(result2);
		final String password = scanner.nextLine();
		
		scanner.close();
		System.out.println(result);	
		
		final boolean correctLogIn = checkLogIn(username, password);
		if(correctLogIn) {
			return "Bienvenido " + getAdministratorLogedIn().getName() + getAdministratorLogedIn().getSurname() + "!";
		}else{
			return "Lo sentimos, pero el usuario o contrase�a que has introducido es incorrecto";
		}
	}
	
	private boolean checkLogIn(String username, String password) {
		
		boolean result = false;
		for(Administrator a : administrators) {
			if(username.equals(a.getUsername()) && password.equals(a.getPassword())) {
				result = true;
				a.setLogedIn(true);
			}
		}
		return result;
	}

	public String toString() {
		
		String result = "---------------------------------\n"
				+ "         Maquina "+machineNumber
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
		result += "         La m�quina se ha atascado, por favor agitela para desatascarla ";
		result += "---------------------------------\n";

		
		return result;
	}
	
	public String unstuckMachineString () {
		
		String result =  "---------------------------------\n";
		result += "         La m�quina se ha atascado, por favor agitela para desatascarla ";
		result += "---------------------------------\n";

		final Scanner scanner = new Scanner(System.in);
		
		System.out.println("Pulsa cualquier tecla para desatascar la m�quina");
		result += "---------------------------------\n";
		scanner.nextLine();
		
		scanner.close();
		
		return result;
	}
	
	public String machineBrokenString () {
		
		String result =  "---------------------------------\n";
		result += "         La m�quina se ha averiado, por favor espere a que un t�cnico venga a desatascarla 		";
		result += "---------------------------------\n";
		
		return result;
	}
	
	public String repairMachineString () {
		
		String result =  "---------------------------------\n";
		result += "         Arreglando la m�quina			";
		result += "---------------------------------\n";
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		result +=  "---------------------------------\n";
		result += "         El t�cnico ha arreglado la m�quina con �xito			";
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
		final Scanner scanner = new Scanner(System.in);
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
		final Scanner scanner = new Scanner(System.in);
		
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