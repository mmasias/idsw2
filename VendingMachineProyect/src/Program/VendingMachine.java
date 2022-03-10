package Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		Scanner sc = new Scanner(System.in);
		int aux;
		
		
		System.out.println("Monedas de 0.05 : ");
		aux = sc.nextInt();
		if(aux > 0) {
			result.add(new Money(0.05f , aux));
		}
		System.out.println("Monedas de 0.2 : ");
		aux = sc.nextInt();
		if(aux > 0) {
			result.add(new Money(0.2f , aux));
		}
		/*System.out.println("Monedas de 0.5 : ");
		aux = sc.nextInt();
		if(aux > 0) {
			result.add(new Money(0.5f , aux));
		}
		System.out.println("Monedas de 1 : ");
		aux = sc.nextInt();
		if(aux > 0) {
			result.add(new Money(1 , aux));
		}
		System.out.println("Monedas de 2 : ");
		aux = sc.nextInt();
		if(aux > 0) {
			result.add(new Money(2 , aux));
		}
		System.out.println("Billetes de 5 : ");
		aux = sc.nextInt();
		if(aux > 0) {
			result.add(new Money(5 , aux));
		}
		System.out.println("Billetes de 10 : ");
		aux = sc.nextInt();
		if(aux > 0) {
			result.add(new Money(10 , aux));
		}
		System.out.println("Billetes de 20 : ");
		aux = sc.nextInt();
		if(aux > 0) {
			result.add(new Money(20 , aux));
		}*/
		
		
		return result;
	}
	

}
