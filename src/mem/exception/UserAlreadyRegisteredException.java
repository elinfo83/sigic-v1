package mem.exception;

public class UserAlreadyRegisteredException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyRegisteredException() {
		super("Usu�rio j� cadastrado!");
	}
	
}
