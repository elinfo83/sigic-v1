package mem.model.documentos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import util.ConstantsSystem;

public class Historico extends Documento {
	
	
	
	public Historico(String conteudo, String nome) {
		super(conteudo, nome);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getPath() {
		
		return ConstantsSystem.PATH_HISTORICOS+ "\\" + this.getNome() + ".txt";
	}
	
	@Override
	public void register() throws FileNotFoundException, IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ConstantsSystem.PATH_HISTORICOS+ "\\" + this.getNome() + ".txt"));
		out.writeObject(this);
		
	}
	
	public static Historico getHistorico(String path) throws FileNotFoundException, IOException, ClassNotFoundException{
		File file = new File(path);
		if(file.isFile()){
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			return (Historico) in.readObject();
		}
		return null;
	}
	
}
