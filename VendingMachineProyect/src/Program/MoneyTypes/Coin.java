package Program.MoneyTypes;

import Program.Exceptions.*;
import Program.Money;

public class Coin extends Money{

	public Coin(float value , int cuantity) throws ValueIncorrectException {
		super(value , cuantity);
		
		if(IncorrectValue(value)) {
			
			throw new ValueIncorrectException();
			
		}
	}
	
	public static boolean IncorrectValue(float value) {
		
		if(value == 0.05f || value == 0.2f || value == 0.5f|| value == 1f || value == 2f ) {
			return false;
		}else {
			return true;
		}
	}

}
