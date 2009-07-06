package mem.model.departamento;

import java.util.LinkedList;
import java.util.List;

import mem.model.documentos.DescricaoDepartamento;
import mem.model.integrantesIg.IntegranteIgreja;
import util.Date;

public class Department {
	
	private String code;
	private String nome;
	private Date dataCriacao;
	private List<IntegranteIgreja> components;
	private DescricaoDepartamento descricaoDepartamento;
	
	
	
	public Department() {
		this("",new LinkedList<IntegranteIgreja>(),new Date(),"",null);
	}
	
	public Department(String code, List<IntegranteIgreja> components,
			 Date dataCriacao, String nome,DescricaoDepartamento descricaoDepartamento) {
		
		this.code = code;
		this.components = components;
		this.dataCriacao = dataCriacao;
		this.nome = nome;
		this.descricaoDepartamento = descricaoDepartamento;
	}
	
	

	public DescricaoDepartamento getDescricaoDepartamento() {
		return descricaoDepartamento;
	}

	public void setDescricaoDepartamento(DescricaoDepartamento descricaoDepartamento) {
		this.descricaoDepartamento = descricaoDepartamento;
	}

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Date getDataCriacao() {
		return dataCriacao;
	}



	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}



	public List<IntegranteIgreja> getComponents() {
		return components;
	}


	public void setComponents(List<IntegranteIgreja> components) {
		this.components = components;
	}

		
	public String getCode() {
		return code;
	}
	
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String toString(){
		return code;
	}
}
