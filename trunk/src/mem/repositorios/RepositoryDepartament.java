package mem.repositorios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import mem.exception.DepartmentNoRegisteredException;
import mem.exception.InvalidDateException;
import mem.interfaces.IRepositoryDepartment;
import mem.model.departamento.Department;
import mem.model.documentos.Historico;
import mem.model.integrantesIg.IntegranteIgreja;
import mem.model.integrantesIg.IntegrantesIgrejaTypes;
import util.ConstantsSystem;
import util.Date;
import util.Sexo;

public class RepositoryDepartament implements IRepositoryDepartment {
	
	
	private Connection connection = null;
	private Statement statement = null;
	
	public RepositoryDepartament() {
		
	}
	
	public void insert(Department dep) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException{
		
		String insertDep = "";
		
		this.connectBank();
		
		insertDep = "INSERT INTO departamentos (codDep,nome,sigla,dataCriacao,pathDescricao) VALUES ('" + dep.getCode() + "','" +
		dep.getNome() + "','" + dep.getCode() + "','" + 
		dep.getDataCriacao().toString()+ "','" + 
		dep.getDescricaoDepartamento().getPath()+ "')"; 
		dep.getDescricaoDepartamento().register();
		System.out.println(insertDep);
		
		statement.executeUpdate(insertDep);
		this.closeConnection();
		
	}
	
	public void remove(String codDep) throws SQLException, DepartmentNoRegisteredException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException{
		
		String deleteDep = "";
		String updateIntDeps = "";
		if(exist(codDep)){
			deleteDep = "DELETE FROM departamentos WHERE codDep = '" + codDep + "'";
			updateIntDeps = "UPDATE integrantesDep SET codDep = \"\" WHERE codDep = '" +codDep+ "'";
			
			
			this.connectBank();
			
			this.statement.executeUpdate(deleteDep);
			this.statement.executeUpdate(updateIntDeps);
			
			this.closeConnection();
			
		}else{
			throw new DepartmentNoRegisteredException();
		}
	}
	
	public boolean exist(String codDep) throws SQLException, ClassNotFoundException, InvalidDateException, FileNotFoundException, DepartmentNoRegisteredException, IOException{
		
		String query = "SELECT codDep FROM departamentos " +
		"WHERE codDep = '" +codDep +"'";
		boolean resp = false;
		
		this.connectBank();
		ResultSet resultSet = this.statement.executeQuery(query);
		resp = resultSet.next();
		this.closeConnection();
		return resp;
	}
	
	public void update(Department dep) throws SQLException, DepartmentNoRegisteredException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException{
		
		String updateDep = "";
		if(exist(dep.getCode())){
			updateDep = "UPDATE departamentos SET nome = '" + dep.getNome() + "', sigla = '" + dep.getCode() + 
			"', dataCriacao = '" + dep.getDataCriacao()+ "' WHERE codDep = '" + dep.getCode() + "';"; 
			
			this.connectBank();
			
			this.statement.executeUpdate(updateDep);
			
			this.closeConnection();
		}else{
			throw new DepartmentNoRegisteredException();
		}
	}
	//Olhar esse metodo 23/03/09
	public Department find(String codDep) throws SQLException, InvalidDateException, DepartmentNoRegisteredException, ClassNotFoundException, FileNotFoundException, IOException{
		
		String queryDep = "";
		String queryDadosPessoais = "";
		
		LinkedList<IntegranteIgreja> componentes = null;
		Department department = null;
		
		ResultSet resultSetDep = null;
		
		ResultSet resultSetDadosPessoais = null;
		
		
		if(exist(codDep)){
			
			Class.forName(ConstantsSystem.JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(ConstantsSystem.DATABASE_URL, ConstantsSystem.USER, ConstantsSystem.PASSWORD);;
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			componentes = new LinkedList<IntegranteIgreja>();
			department = new Department();
			
			queryDep = "SELECT * FROM departamentos WHERE codDep = '" + codDep + "';";
			
			
			queryDadosPessoais =  "SELECT D.rg, D.nome, D.dataNascimento, D.estadoCivil, D.pathPhoto, D.email, D.sexo, D.naturalidade," +
			" I.tipo, I.dataConversao, I.dataBatismo, I.pathHistorico FROM " +
			"(dadosPessoais D INNER JOIN integrantesDep ID ON (D.rg = ID.rg)) INNER JOIN integrantesIgreja I ON (ID.rg = I.rg)" +
			"WHERE ID.codDep = '" +  codDep + "' ORDER BY ID.rg;";
			
			this.connectBank();
			
			resultSetDep = statement.executeQuery(queryDep);
			
			resultSetDep.next();
			department.setCode((String)resultSetDep.getObject(1));
			department.setNome((String)resultSetDep.getObject(2));
			department.setDataCriacao(new Date((String)resultSetDep.getObject(4)));
			
			resultSetDadosPessoais = this.statement.executeQuery(queryDadosPessoais);			
			
			while(resultSetDadosPessoais.next()){
				componentes.add(createMember(resultSetDadosPessoais));
			}
			
			department.setComponents(componentes);
			
			this.closeConnection();
			
			return department;
		}else{
			throw new DepartmentNoRegisteredException();
		}
	}
	
	public  Department[] getDeps() throws SQLException, InvalidDateException, ClassNotFoundException, FileNotFoundException, DepartmentNoRegisteredException, IOException{
		
		
		String queryDep = "";
		Department[] deps = null;
		int TAM = 0;
		
		queryDep = "SELECT * FROM departamentos;";
		this.connectBank();
		
		ResultSet resultSetDep = this.statement.executeQuery(queryDep);
		while(resultSetDep.next()){
			TAM++;
		}
		deps = new Department[TAM];
		resultSetDep.first();
		if (TAM==0) {
			this.closeConnection();
			return deps;
		}
		
		do {
			TAM--;
			//verificar essa chamada
			deps[TAM] = createDepartment(resultSetDep); 
		} while (resultSetDep.next() || TAM>=1);
		
		
		this.closeConnection();		
		return deps;
	}
	
	private Department createDepartment(ResultSet resultSetDep) throws SQLException, InvalidDateException, DepartmentNoRegisteredException, ClassNotFoundException, FileNotFoundException, IOException {
		String codDep = "";
		String queryDadosPessoais = "";
		Class.forName(ConstantsSystem.JDBC_DRIVER);
		Connection connection = DriverManager.getConnection(ConstantsSystem.DATABASE_URL, ConstantsSystem.USER, ConstantsSystem.PASSWORD);;
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
		LinkedList<IntegranteIgreja> componentes = new LinkedList<IntegranteIgreja>();
		Department department = new Department();
		ResultSet resultSetDadosIntegranteIg = null;
		
		
		
		codDep = (String)resultSetDep.getObject(1);
		department.setCode(codDep);
		department.setNome((String)resultSetDep.getObject(2));
		department.setDataCriacao(new Date((String)resultSetDep.getObject(4)));
		//department.setDescricaoDepartamento(DescricaoDepartamento.getDescricaoDepartamento((String)resultSetDep.getObject(5)));
		
		queryDadosPessoais = "SELECT D.rg, D.nome, D.dataNascimento, D.estadoCivil, D.pathPhoto, D.email, D.sexo, D.naturalidade," +
		" I.tipo, I.dataConversao, I.dataBatismo, I.pathHistorico FROM " +
		"(dadosPessoais D INNER JOIN integrantesDep ID ON (D.rg = ID.rg)) INNER JOIN integrantesIgreja I ON (ID.rg = I.rg)" +
		"WHERE ID.codDep = '" +  codDep + "' ORDER BY ID.rg;";
		
		resultSetDadosIntegranteIg = statement.executeQuery(queryDadosPessoais);
		
		while(resultSetDadosIntegranteIg.next()){
			componentes.add(createMember(resultSetDadosIntegranteIg));
		}
		department.setComponents(componentes);
		statement.close();
		connection.close();
		return department;
	}
	
	private IntegranteIgreja createMember(ResultSet resultSetDadosIntegranteIg)throws SQLException, InvalidDateException, FileNotFoundException, IOException, ClassNotFoundException {
		IntegrantesIgrejaTypes type = null;
		Sexo sexo = null;
		IntegranteIgreja intIg = new IntegranteIgreja();
		
		if (((String) resultSetDadosIntegranteIg.getObject(9)).equals("MEMBRO")) {
			type = IntegrantesIgrejaTypes.MEMBRO;
		} else {
			type = IntegrantesIgrejaTypes.CONGREGADO;
		}
		
		if (((String) resultSetDadosIntegranteIg.getObject(7)).equals("MASCULINO")) {
			sexo = Sexo.MASCULINO;
		} else {
			sexo = Sexo.FEMININO;
		}
		
		intIg.setRg((String)resultSetDadosIntegranteIg.getObject(1));
		intIg.setNome((String) resultSetDadosIntegranteIg.getObject(2));
		intIg.setType(type);			
		intIg.setDataNascimento(new Date((String)resultSetDadosIntegranteIg.getObject(3)));
		intIg.setEstadoCivil((String)resultSetDadosIntegranteIg.getObject(4));
		intIg.setPathPhoto((String) resultSetDadosIntegranteIg.getObject(5));
		intIg.setEmail((String)resultSetDadosIntegranteIg.getObject(6));			
		intIg.setSexo(sexo);
		intIg.setNaturalidade((String) resultSetDadosIntegranteIg.getObject(8));
		
		intIg.setDataConversao(new Date((String)resultSetDadosIntegranteIg.getObject(10)));
		intIg.setDataBatismo(new Date((String)resultSetDadosIntegranteIg.getObject(11)));			
		intIg.setHistorico(Historico.getHistorico((String)resultSetDadosIntegranteIg.getObject(12)));
		
		return intIg;
	}
	
	
	public  Department[] getDepsWithoutIntIg() throws SQLException, InvalidDateException, ClassNotFoundException{
		
		
		String queryDep = "";
		Department[] deps = null;
		int TAM = 0;
		
		queryDep = "SELECT * FROM departamentos;";
		
		this.connectBank();
		
		ResultSet resultSetDep = this.statement.executeQuery(queryDep);
		while(resultSetDep.next()){
			TAM++;
		}
		deps = new Department[TAM];
		resultSetDep.first();
		if (TAM==0) {
			this.closeConnection();
			return deps;
		}
		
		do {
			TAM--;
			deps[TAM] = createDepartmentWithoutIntIg(resultSetDep); 
		} while (resultSetDep.next() || TAM<0);
		
		
		this.closeConnection();
		
		return deps;
	}
	
	private Department createDepartmentWithoutIntIg(ResultSet resultSetDep) throws SQLException, InvalidDateException {
		Department dep = new Department();
		
		dep.setCode((String)resultSetDep.getObject(1));
		dep.setNome((String)resultSetDep.getObject(2));
		dep.setDataCriacao(new Date((String)resultSetDep.getObject(4)));
		
		return dep;
	}
	
	private void connectBank() throws ClassNotFoundException, SQLException{
		Class.forName(ConstantsSystem.JDBC_DRIVER);
		connection = DriverManager.getConnection(ConstantsSystem.DATABASE_URL, ConstantsSystem.USER, ConstantsSystem.PASSWORD);
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	}
	
	private void closeConnection() throws SQLException{
		this.statement.close();
		this.connection.close();
	}
}
