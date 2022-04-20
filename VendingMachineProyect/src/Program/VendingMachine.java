package Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

import Program.MoneyTypes.*;

public class VendingMachine {
	
	private int machineNumber;
	private Product[] products;		//Es una Agregación entre VendingMachine y Prodcuts
	private Money[] money;			//Es una Agregación entre VendingMachine y Money
	private boolean stuck;
	private boolean broken;
	
	public VendingMachine(int machineNumber, Product[] products, Money[] money, List<Administrator> administrators) {
		this.machineNumber = machineNumber;
		this.products = products;				
		this.money = money;
		this.stuck = false;
		this.broken = false;
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
	
	
	public void addMoney(List<Money> moneyList) {
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
	
	public String toStringOnlyProducts() {
		
		String result="---------------------------------\n";
		result += "         Productos\n";
		result += "---------------------------------\n";


		result += "Nombre  			 Numero\n";
		
		for(Product current : products) {
			result += current.toStringShowingId() + "\n";
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
		result += "         La máquina se ha atascado, por favor agitela para desatascarla ";
		result += "---------------------------------\n";

		final Scanner scanner = new Scanner(System.in);
		
		System.out.println("Pulsa cualquier tecla para desatascar la máquina");
		result += "---------------------------------\n";
		scanner.nextLine();
		
		scanner.close();
		
		return result;
	}
	
	public String machineBrokenString () {
		
		String result =  "---------------------------------\n";
		result += "         La máquina se ha averiado, por favor espere a que un técnico venga a desatascarla 		";
		result += "---------------------------------\n";
		
		return result;
	}
	
	public String repairMachineString () {
		
		String result =  "---------------------------------\n";
		result += "         Arreglando la máquina			";
		result += "---------------------------------\n";
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		result +=  "---------------------------------\n";
		result += "         El técnico ha arreglado la máquina con éxito			";
		result += "---------------------------------\n";
			
		return result;
	}
	

	
	public static Double calculeTotalValue(List<Money> moneyList) {
		
		Double result = moneyList.stream()
				.mapToDouble(x -> x.getTotalValue())
				.sum();
		
		return result;
	}
	
	public void IntroduceListMoney(List<Money> moneyList) {
		for(Money current : moneyList) {
			if(!Money.IncorrectValue(current.getValue())) {
				current.setCuantity(current.getCuantity()+1);
			}
		}
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

	public Product getSpecificProduct(int id) {

		for(Product current : products) {
			if(current.getId() == id) {
				return current;
			}
		}
		
		return null;
	}

	public void removeProduct(int id) {
		
		for(Product current : products) {
			if(current.getId() == id) {
				current.setCuantity(current.getCuantity() - 1);
			}
		}
		
	}
	

}
