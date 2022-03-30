package Program;

public class Product {
	
	private String name;
	private float price;
	private int quantity;
	
	
	public Product(String name, float price, int cuantity) {
		this.name = name;
		this.price = price;
		this.quantity = cuantity;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public int getCuantity() {
		return quantity;
	}


	public void setCuantity(int cuantity) {
		this.quantity = cuantity;
	}
	
	public String toString() {
		return name + "			" + quantity;
	}
	

}
