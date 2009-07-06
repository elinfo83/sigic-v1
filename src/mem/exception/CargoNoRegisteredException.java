package mem.exception;

public class CargoNoRegisteredException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CargoNoRegisteredException() {
		super("Cargo não Cadastrado!");
	}

}
