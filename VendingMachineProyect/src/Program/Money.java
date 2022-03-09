package Program;

public class Money {
	
	private float value;
	private int cuantity;
	
	public Money(float value , int cuantity) {
		this.value = value;
		this.cuantity = cuantity;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public int getCuantity() {
		return cuantity;
	}

	public void setCuantity(int cuantity) {
		this.cuantity = cuantity;
	}
	
	public float getTotalValue() {
		return getValue() * getCuantity();
	}
	
	@Override
	public String toString() {
		return value + "€			" + cuantity;
	}
	

}
