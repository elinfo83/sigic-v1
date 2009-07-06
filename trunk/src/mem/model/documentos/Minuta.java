package mem.model.documentos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import util.ConstantsSystem;

public class Minuta extends Documento {
	
	private static final long serialVersionUID = 4327624672251224770L;

	public Minuta(String conteudo, String nome) {
		super(conteudo, nome);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return ConstantsSystem.PATH_MINUTAS+ "\\" + this.getNome() + ".txt";
	}

	@Override
	public void register() throws FileNotFoundException, IOException {
		
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ConstantsSystem.PATH_MINUTAS+ "\\" + this.getNome() + ".txt"));
			out.writeObject(this);
		
	}

}
