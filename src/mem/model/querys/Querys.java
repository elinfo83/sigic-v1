package mem.model.querys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mem.exception.InvalidDateException;
import mem.model.cargo.Cargo;
import mem.model.departamento.Department;
import mem.model.integrantesIg.IntegranteIgreja;
import util.ConstantsSystem;
import util.Date;

public class Querys {
	
	private Connection connection;
	private Statement statement;
	
	
	
	public  Cargo[] getCargo() throws ClassNotFoundException, SQLException{
		String queryCargos = "SELECT * FROM cargos;";
		Cargo[] cargos = null;
		ResultSet resultSetCargo = null;
		int TAM = 0;
		
		
		this.connectBank();
		resultSetCargo = statement.executeQuery(queryCargos);
		while(resultSetCargo.next()){
			TAM++;
		}
		cargos = new Cargo[TAM];
		resultSetCargo.first();
		if (TAM==0) {
			this.closeConnection();
			return cargos;
		}
		
		do {
			TAM--;
			cargos[TAM] = createCargo(resultSetCargo); 
		} while (resultSetCargo.next() || TAM<0);
		
		
		this.closeConnection();
		
		return cargos;
	}
	
	
	private Cargo createCargo(ResultSet resultSetCargo) throws SQLException{
		Cargo cargo = new Cargo();
		
		cargo.setNome((String)resultSetCargo.getObject(1));
		cargo.setMinuta(null);
		
		return cargo;
		
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
	
	public  IntegranteIgreja[] getIntegranteIgreja() throws SQLException, InvalidDateException, ClassNotFoundException{
		
		
		String queryIntIg = "";
		IntegranteIgreja[] deps = null;
		int TAM = 0;
		
		/*SELECT C.Nome, TC.Descricao
		 FROM Cliente C
		 INNER JOIN TipoCliente TC
		 ON (TC.TipoCliente=C.TipoCliente)
		 */
		queryIntIg = "SELECT I.rg, D.nome FROM dadosPessoais D " +
				"INNER JOIN integrantesIgreja I ON (D.rg = I.rg);";
		
		this.connectBank();
		
		ResultSet resultSetIntIg = this.statement.executeQuery(queryIntIg);
		while(resultSetIntIg.next()){
			TAM++;
		}
		deps = new IntegranteIgreja[TAM];
		resultSetIntIg.first();
		if (TAM==0) {
			this.closeConnection();
			return deps;
		}
		
		do {
			TAM--;
			deps[TAM] = createIntegranteIgreja(resultSetIntIg); 
		} while (resultSetIntIg.next() || TAM<0);
		
		
		this.closeConnection();
		
		return deps;
	}
	
	private IntegranteIgreja createIntegranteIgreja(ResultSet resultSetDep) throws SQLException, InvalidDateException {
		IntegranteIgreja intIg = new IntegranteIgreja();
		
		intIg.setRg((String)resultSetDep.getObject(1));
		intIg.setNome((String)resultSetDep.getObject(2));
		
		
		return intIg;
	}
	
	public static String getQueryViewDep(String dep){
		String query = "";
		
		query = "SELECT rg, nome, dataNascimento, email FROM dadosPessoais" +
		
		"WHERE rg IN ( SELECT rg FROM integrantesDep " +
		"WHERE codDep = '" + dep + "');";
		
		return query;
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
