package Program;

public class Product {
	
	private String name;
	private float price;
	private int cuantity;
	
	
	public Product(String name, float price, int cuantity) {
		this.name = name;
		this.price = price;
		this.cuantity = cuantity;
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
		return cuantity;
	}


	public void setCuantity(int cuantity) {
		this.cuantity = cuantity;
	}
	
	public String toString() {
		return name + "			" + cuantity;
	}

}
