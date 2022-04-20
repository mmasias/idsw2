package Program;

public class Money {
	
	private float value;
	private int quantity;
	
	public Money(float value , int cuantity) {
		this.value = value;
		this.quantity = cuantity;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public int getCuantity() {
		return quantity;
	}

	public void setCuantity(int cuantity) {
		this.quantity = cuantity;
	}
	
	public float getTotalValue() {
		return getValue() * getCuantity();
	}
	
	@Override
	public String toString() {
		return value + "€			" + quantity;
	}

	public static boolean IncorrectValue(float value) {
		return false;
	}
	

}
