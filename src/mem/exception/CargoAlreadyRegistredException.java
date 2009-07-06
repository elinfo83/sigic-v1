package mem.exception;

public class CargoAlreadyRegistredException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CargoAlreadyRegistredException() {
		super("Cargo já CAdastrado!");
	}

}
