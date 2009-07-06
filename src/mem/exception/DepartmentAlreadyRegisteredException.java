package mem.exception;

public class DepartmentAlreadyRegisteredException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DepartmentAlreadyRegisteredException() {
		super("Departamento Já Cadastrado!");
	}

}
