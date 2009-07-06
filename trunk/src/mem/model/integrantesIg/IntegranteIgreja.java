package mem.model.integrantesIg;

import java.util.List;

import mem.model.cargo.Cargo;
import mem.model.documentos.Documento;
import mem.model.documentos.Historico;
import util.Address;
import util.Date;
import util.Sexo;

public class IntegranteIgreja extends Person{
	
	private IntegrantesIgrejaTypes type;
	private Date dataBatismo;
	private Date dataConversao;
	private String codDep;
	private Historico historico;
	private List<Cargo> cargosOcupados; 
	private String titulo;
	
	

	public IntegranteIgreja() {
		super("","",new Date(),"","","","",new Address(),"",Sexo.MASCULINO,"");
		this.dataBatismo = new Date();
		this.dataConversao = new Date();
		this.codDep = "";
		this.historico = null;
		this.type = null;
		this.cargosOcupados = null;
		this.titulo = ""; 
	}
	
	
	public IntegranteIgreja(String nome,String rg, Date dateAniversario,
			String nomePai, String nomeMae, String estadoCivil, String email,
			Address endereco, String pathPhoto,Date dataBatismo, Date dataConversao, String codDep, IntegrantesIgrejaTypes type, Sexo sexo
			,List<Cargo> cargos, String naturalidade, Historico historico, String titulo) {
		super(nome,rg, dateAniversario, nomePai, nomeMae, estadoCivil, email,endereco, pathPhoto, sexo, naturalidade);
		
		this.dataBatismo = dataBatismo;
		this.dataConversao = dataConversao;
		this.codDep = codDep;
		this.type = type;
		this.historico = historico;
		this.cargosOcupados = cargos;
		this.titulo = titulo;
	}
	
	

	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public List<Cargo> getCargosOcupados() {
		return cargosOcupados;
	}

	public void setCargosOcupados(List<Cargo> cargosOcupados) {
		this.cargosOcupados = cargosOcupados;
	}
	
	public Documento getHistorico() {
		return historico;
	}

	public IntegrantesIgrejaTypes getType() {
		return type;
	}

	public void setType(IntegrantesIgrejaTypes type) {
		this.type = type;
	}

	public String getCodDep() {
		return codDep;
	}

	public void setCodDep(String codDep) {
		this.codDep = codDep;
	}

	public Date getDataBatismo() {
		return dataBatismo;
	}

	public void setDataBatismo(Date dataBatismo) {
		this.dataBatismo = dataBatismo;
	}

	public Date getDataConversao() {
		return dataConversao;
	}

	public void setDataConversao(Date dataConversao) {
		this.dataConversao = dataConversao;
	}

	public void setHistorico(Historico historico) {
		this.historico = historico;
	}

}
