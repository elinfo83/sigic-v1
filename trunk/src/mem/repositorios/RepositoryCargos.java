package mem.repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mem.exception.CargoNoRegisteredException;
import mem.exception.InvalidDateException;
import mem.interfaces.IRepositoryCargos;
import mem.model.cargo.Cargo;
import mem.model.documentos.Minuta;
import util.ConstantsSystem;

public class RepositoryCargos implements IRepositoryCargos {
	
	
	private Connection connection = null;
	private Statement statement = null;
	
	public RepositoryCargos() {
		
	}
	
	public void insert(Cargo cargo) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException{
		String insertCargo = "";
		
		this.connectBank();		
		
		insertCargo = "INSERT INTO cargos VALUES('" +
		cargo.getNome() + "', '" + cargo.getNome() + "', '" +cargo.getMinuta().getPath()+"');";
		
		this.statement.executeUpdate(insertCargo);
		cargo.getMinuta().register();
		
		this.closeConnection();
	}
	
	public void remove(String codCargo) throws SQLException, CargoNoRegisteredException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException{
		String deleteDep = "";
		
		if(exist(codCargo)){
			deleteDep = "DELETE FROM cargos WHERE codCargo = '" + codCargo + "';";
			
			this.connectBank();
			
			this.statement.executeUpdate(deleteDep);
			
			this.closeConnection();
			
		}else{
			throw new CargoNoRegisteredException();
		}
		
	}
	
	public boolean exist(String codCargo) throws SQLException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException{
		
		Cargo[] cargos = getCargos();
		
		for (int i = 0; i < cargos.length; i++) {
			if(cargos[i].getNome().equals(codCargo)){
				return true;
			}
		}
		
		return false;
	}
	
	public void update(Cargo cargo) throws SQLException, CargoNoRegisteredException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException{
		
		String updateCargo = "";
		
		if(exist(cargo.getNome())){
			updateCargo = "UPDATE cargos SET nome = '" + cargo.getNome() + "', minuta = '" + ConstantsSystem.PATH_MINUTAS + cargo.getNome()+ 
			"' WHERE codCargo = '" + cargo.getNome() + "';"; 
			
			this.connectBank();
			
			this.statement.executeUpdate(updateCargo);
			
			this.closeConnection();
		}else{
			throw new CargoNoRegisteredException();
		}
	}
	
	public Cargo find(String codCargo) throws SQLException, InvalidDateException, CargoNoRegisteredException, ClassNotFoundException, FileNotFoundException, IOException{	
		
		Cargo[] cargos = null;
		
		if(exist(codCargo)){
			cargos = this.getCargos();
			for (int i = 0; i < cargos.length; i++) {
				if(cargos[i].getNome().equals(codCargo)){
					return cargos[i];
				}
			}		
		}
		throw new CargoNoRegisteredException();
	}
	
	public Cargo[] getCargos() throws SQLException, InvalidDateException, ClassNotFoundException, FileNotFoundException, IOException{
		
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
			cargos[TAM] = createCargos(resultSetCargo); 
		} while (resultSetCargo.next() || TAM<0);
		
		
		this.closeConnection();
		
		return cargos;
	}
	
	private Cargo createCargos(ResultSet resultSetCargos) throws SQLException, InvalidDateException, FileNotFoundException, IOException, ClassNotFoundException {
		Cargo cargo = new Cargo();
		File file = new File((String)resultSetCargos.getObject(3));
		
		if(file.isFile()){
			ObjectInputStream input = new ObjectInputStream(new FileInputStream((String)resultSetCargos.getObject(3)));
			cargo.setMinuta((Minuta)input.readObject());
		}
		cargo.setNome((String)resultSetCargos.getObject(1));
		
		
		
		return cargo;
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
