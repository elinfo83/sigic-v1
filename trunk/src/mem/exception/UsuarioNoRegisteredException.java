package mem.exception;

public class UsuarioNoRegisteredException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public UsuarioNoRegisteredException() {
		super("Usuario e não Cadastrado!");
	}

}
