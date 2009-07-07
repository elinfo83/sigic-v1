package mem.model.diretorias;

import java.util.HashMap;
import java.util.Iterator;

import mem.exception.CargoJaOcupadoException;
import mem.model.integrantesIg.IntegranteIgreja;
import util.Date;

public class Diretoria {
	
	private HashMap<String, IntegranteIgreja> diretoria;
	private Date anoAtuacao;
	private String idDep;

	public Diretoria(HashMap<String, IntegranteIgreja> diretoria) {
		this.diretoria = diretoria;
	}
	
	public Diretoria() {
		this(new HashMap<String, IntegranteIgreja>());
	}
	
	public void add(String idCargo, IntegranteIgreja ocupante) throws CargoJaOcupadoException{
		if(!this.diretoria.containsKey(idCargo)){
			this.diretoria.put(idCargo, ocupante);
		}else{
			throw new CargoJaOcupadoException();
		}
	}
	
	public void remove(String idCargo){
		this.diretoria.remove(idCargo);
	}
	
	public Date getAnoAtuacao() {
		return anoAtuacao;
	}

	public void setAnoAtuacao(Date anoAtuacao) {
		this.anoAtuacao = anoAtuacao;
	}
	
	public Iterator<String> getCargos(){
		return this.diretoria.keySet().iterator();
	}
	
	public IntegranteIgreja getOcupante(String idCargo){
		return this.diretoria.get(idCargo);
	}
	

	public String getIdDep() {
		return idDep;
	}

	public void setIdDep(String idDep) {
		this.idDep = idDep;
	}

}
