package Program;

import java.util.List;
import java.util.Scanner;
import java.util.Random;

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
		this.setBroken(false);
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
		return isBroken();
	}

	public void setBroken(boolean broken) {
		this.broken = broken;
	}
	
	public boolean checkMachineStuck() {
		return isBroken();
	}

	public void setStuck(boolean stuck) {
		this.stuck = stuck;
	}
	
	

	
	//-------------METODOS DE MAQUINA ROTA Y MAQUINA ATASCADA-------------
	
	public void machineGetsStuck() {
		
		Random random = new Random();
		final int i = random.nextInt(99);
		
		if(i > 97) {								//Percentage --> 3%
			this.setStuck(true);
		}
		else {
			this.setStuck(false);
		}
	}
	
	public boolean isStuck() {
		return stuck;
	}
	
	public void machineBreaksDown() {
		
		Random random = new Random();
		final int i = random.nextInt(99);
		if(i > 96) {								//Percentage --> 4%
			this.setBroken(true);
		}
		else {
			this.setBroken(false);
		}
	}
	
	public boolean isBroken() {
		return broken;
	}
	
	
	//-------------METODOS DE PRODUCTOS-------------
	
	public Product getSpecificProduct(int id) {

		for(Product current : products) {
			if(current.getId() == id) {
				return current;
			}
		}
		
		return null;
	}
	
	public int getQuantityOfSpecificProduct(int id) {

		for(Product current : products) {
			if(current.getId() == id) {
				return current.getCuantity();
			}
		}
		
		return 0;
	}
	
	public int getTotalAmountProducts() {
		int result = 0;
		for(Product current : products) {
			result += current.getCuantity();
		}
		
		return result;
	}

	public void addProduct(int id, int quantity) {
		
		for(Product current : products) {
			if(current.getId() == id) {
				current.setCuantity(current.getCuantity() + quantity);
			}
		}
		
	}
	
	public void removeProduct(int id) {
		
		for(Product current : products) {
			if(current.getId() == id) {
				current.setCuantity(current.getCuantity() - 1);
			}
		}	
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
	
	//-------------METODOS DE DINERO-------------

	public static Double calculeTotalValue(List<Money> moneyList) {
		
		Double result = moneyList.stream()
				.mapToDouble(x -> x.getTotalValue())
				.sum();
		
		return result;
	}
	
	
	public int getQuantityOfSpecificCuerrencyType(Money[] money, float value) {
		
		int result = 0;
		
		for(Money c : money) {
			if(c.getValue() == value) {
				result += c.getCuantity();	
			}
		}
		
		return result;
	}
	
	public float getTotalMoneyInMachine(Money[] money) {
		
		float result = 0;
		
		for(Money c : money) {
			
			result += (float) c.getValue() * c.getCuantity();	
		}
		
		return result;
	}

	public boolean IntroduceMoney(float value, int quantity, Money[] money) {
	
		if(value == 0.05f || value == 0.2f || value == 0.5f || value == 1 || value == 2 || value == 5 || value == 10 || value == 20) {
			for(Money m : money) {
				if(m.getValue() == value) {
					if(quantity > 0) {
						m.setCuantity(m.getCuantity() + quantity);
					}else if(m.getCuantity() > quantity && quantity < 0 && m.getCuantity() > 0) {
						m.setCuantity(m.getCuantity() + quantity);	
					}
				}
			}
			return true;
			
		}else {
			return false;
		}	
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
}
