package mem.exception;

public class CargoJaOcupadoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public CargoJaOcupadoException() {
		super("N�o pode haver 02 membros para o mesmo cargo!");
	}

	
}
