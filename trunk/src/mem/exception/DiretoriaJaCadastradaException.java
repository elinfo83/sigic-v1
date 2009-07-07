package mem.exception;

public class DiretoriaJaCadastradaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DiretoriaJaCadastradaException() {
		super("Diretoria já cadastrada!");
	}
}
