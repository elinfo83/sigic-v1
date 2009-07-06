package mem.model.documentos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public abstract class Documento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String nome;
	protected String conteudo;
	
	public Documento(String conteudo, String nome) {
		this.conteudo = conteudo;
		
		this.nome = nome;
	}
	
	public String getConteudo() {
		return conteudo;
	}
	
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public abstract String getPath();
	
	public abstract void register() throws FileNotFoundException, IOException;
	
		
	/*
	public String getPathMinutas(){
		return ConstantsSystem.PATH_MINUTAS+ "\\" + this.nome + ".txt";
	}
	
	public String getPathregisterHistDep(){
		return ConstantsSystem.PATH_HIST_DEPS+ "\\" + this.nome + ".txt";
	}
	
	public String getPathHistIntIg(){
		return ConstantsSystem.PATH_HISTORICOS+ "\\" + this.nome + ".txt";
	}*/
	/*
	public void registerMinuta(){
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ConstantsSystem.PATH_MINUTAS+ "\\" + this.nome + ".txt"));
			out.writeObject(this);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void registerHistDep(){
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ConstantsSystem.PATH_HIST_DEPS+ "\\" + this.nome + ".txt"));
			out.writeObject(this);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void registerHistIntIg(){
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ConstantsSystem.PATH_HISTORICOS+ "\\" + this.nome + ".txt"));
			out.writeObject(this);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	
}
