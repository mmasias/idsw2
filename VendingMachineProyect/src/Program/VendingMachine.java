package Program;

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
	
	public String productString () {
		String result = "---------------------------------\n"
				+ "         Maquina"+machineNumber
				+"\n---------------------------------\n";
		
		result += "---------------------------------\n";
		result += "         Productos\n";
		result += "---------------------------------\n";
		
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
	

}
