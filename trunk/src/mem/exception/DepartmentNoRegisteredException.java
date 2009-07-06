package mem.exception;

public class DepartmentNoRegisteredException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DepartmentNoRegisteredException() {
		super("Departamento não cadastrado!");
	}

}
