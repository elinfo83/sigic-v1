package mem.model.documentos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import util.ConstantsSystem;

public class DescricaoDepartamento extends Documento {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DescricaoDepartamento(String conteudo, String nome) {
		super(conteudo, nome);
	}

	@Override
	public String getPath() {
		return ConstantsSystem.PATH_HIST_DEPS+ "\\" + this.getNome() + ".txt";
	}

	@Override
	public void register() throws FileNotFoundException, IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ConstantsSystem.PATH_HIST_DEPS+ "\\" + this.getNome() + ".txt"));
		out.writeObject(this);

	}
	
	public static DescricaoDepartamento getDescricaoDepartamento(String path) throws FileNotFoundException, IOException, ClassNotFoundException{
		File file = new File(path);
		if(file.isFile()){
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			return (DescricaoDepartamento) in.readObject();
		}
		return null;
	}

}
