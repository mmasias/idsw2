package Program;

public class Product {
	
	private String name;
	private float price;
	private int quantity;
	private int id;
	
	public Product(String name, float price, int cuantity , int id) {
		this.name = name;
		this.price = price;
		this.quantity = cuantity;
		this.id = id;
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
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return name + "			" + quantity;
	}
	
	public String toStringShowingId() {
		return name + "			" + id;
	}

}
