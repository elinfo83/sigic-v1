package mem.exception;

public class MemberAlreadyRegisteredException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public MemberAlreadyRegisteredException() {
		super("Membro Já Cadastrado!");
	}
}
