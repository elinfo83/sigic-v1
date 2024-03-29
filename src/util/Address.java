package util;

public class Address {
	
	private String rua;
	private String numCasa;
	private String cep;
	private String bairro;
	private String cidade;
	private String estado;
	private String complemento;
	
	public Address() {
		this("","","","","","","");
	}
	
	public Address(String rua, String numCasa, String cep, String bairro,
			String cidade, String estado, String complemento) {
		super();
		this.rua = rua;
		this.numCasa = numCasa;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.complemento = complemento;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getNumCasa() {
		return numCasa;
	}


	public void setNumCasa(String numCasa) {
		this.numCasa = numCasa;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
}
