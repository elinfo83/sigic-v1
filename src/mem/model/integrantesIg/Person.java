package mem.model.integrantesIg;

import java.util.HashMap;

import util.Address;
import util.Date;
import util.Sexo;
import util.TelephonesTypes;

public class Person {
	
	private String nome;
	private String rg;
	private Date dataNascimento;
	private String nomePai;
	private String nomeMae;
	private String estadoCivil;
	private String email;
	private String naturalidade;
	private HashMap<TelephonesTypes,String> telefones;
	private Address endereco;
	private String pathPhoto;
	private Sexo sexo;
	
	
	
	public Person(String nome, String rg, Date date, String nomePai,
			String nomeMae, String estadoCivil,	String email, Address endereco, String pathPhoto, Sexo sexo, String naturalidade) {
		
		super();
		this.nome = nome;
		this.rg = rg;
		this.nomePai = nomePai;
		this.nomeMae = nomeMae;
		this.estadoCivil = estadoCivil;
		this.email = email;
		this.telefones = new HashMap<TelephonesTypes, String>();
		this.endereco = endereco;
		this.dataNascimento = date;
		this.pathPhoto = pathPhoto;
		this.sexo =sexo;
		this.naturalidade = naturalidade;
		
	}
		
	public String getNaturalidade() {
		return naturalidade;
	}
		
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
		
	public Sexo getSexo() {
		return sexo;
	}
	
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	public String getEmail() {
		return email;
	}	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPathPhoto() {
		return pathPhoto;
	}	
	
	public void setPathPhoto(String pathPhoto) {
		this.pathPhoto = pathPhoto;
	}
		
	public HashMap<TelephonesTypes, String> getTelefones() {
		return telefones;
	}	
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataAniversario) {
		this.dataNascimento = dataAniversario;
	}
	
	public void addTelefone(TelephonesTypes tipo, String numero){
		
		this.telefones.put(tipo, numero);		
	}
	
	public void removeTelefone(String numero){
		this.telefones.remove(numero);
	}
	
	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRg() {
		return rg;
	}
	
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
	public String getNomePai() {
		return nomePai;
	}
	
	
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	
	
	public String getNomeMae() {
		return nomeMae;
	}
	
	
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	
	
	public String getEstadoCivil() {
		return estadoCivil;
	}
	
	
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	
	public Address getEndereco() {
		return endereco;
	}
	
	
	public void setEndereco(Address endereco) {
		this.endereco = endereco;
	}
	
	public int getDiaAniversario() {
		return this.getDataNascimento().getDay();
	}
	
	public int getMesAniversario(){
		return this.getDataNascimento().getMonth();
	}
	
	
}
