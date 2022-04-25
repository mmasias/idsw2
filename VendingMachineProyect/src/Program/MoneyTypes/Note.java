package Program.MoneyTypes;

import Program.Money;
import Program.Exceptions.ValueIncorrectException;

public class Note extends Money{

	public Note(float value , int cuantity) throws ValueIncorrectException {
		super(value , cuantity);
		
		if(IncorrectValue(value)) {
			
			throw new ValueIncorrectException();
			
		}
	}
	
	public static boolean IncorrectValue(float value) {
		if(value == 20f || value == 10f || value == 5f ) {
			return false;
		}else {
			return true;
		}
	}

}
