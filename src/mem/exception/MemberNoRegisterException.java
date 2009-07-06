package mem.exception;

public class MemberNoRegisterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MemberNoRegisterException() {
		super("Membro não Cadastrado!");
	}

}
