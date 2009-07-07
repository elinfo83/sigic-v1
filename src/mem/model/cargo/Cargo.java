package mem.model.cargo;

import mem.model.documentos.Minuta;
import mem.model.integrantesIg.IntegranteIgreja;




public class Cargo {
	
	private String nome;
	private Minuta minuta; 
	private IntegranteIgreja ocupante;

	
	
	public Cargo(String nome) {
		this.nome = nome;
	}

	public Cargo() {
		this.nome = "";
		this.minuta = null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString(){
		return this.nome;
	}

	public Minuta getMinuta() {
		return minuta;
	}

	public void setMinuta(Minuta minuta) {
		this.minuta = minuta;
	}
	

	public IntegranteIgreja getOcupante() {
		return ocupante;
	}

	public void setOcupante(IntegranteIgreja ocupante) {
		this.ocupante = ocupante;
	}

}
