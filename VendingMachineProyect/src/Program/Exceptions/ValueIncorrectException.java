package Program.Exceptions;

public class ValueIncorrectException extends Exception {
	private static final long serialVersionUID = -7221754894956481852L;
	
	public ValueIncorrectException() {
		super();
	}
	
	@Override 
	public String getMessage() {
		return "The value is not correct";
	}

}
