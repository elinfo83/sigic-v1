package mem.exception;

public class InvalidDateException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidDateException(String message) {
		super("Data Inv�lida. " + message );
	}

}
