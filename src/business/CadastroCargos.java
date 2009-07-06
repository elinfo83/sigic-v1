package business;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import mem.exception.CargoAlreadyRegistredException;
import mem.exception.CargoNoRegisteredException;
import mem.exception.InvalidDateException;
import mem.interfaces.IRepositoryCargos;
import mem.model.cargo.Cargo;

public class CadastroCargos {

	private IRepositoryCargos repositoryCargos;

	public CadastroCargos(IRepositoryCargos repositoryCargos) {
		this.repositoryCargos = repositoryCargos;
	}
	
	public void cadastrar(Cargo cargo) throws CargoAlreadyRegistredException, SQLException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException{
		if (exist(cargo.getNome())) {
			throw new CargoAlreadyRegistredException();
		} else {
			this.repositoryCargos.insert(cargo);
		}
	}
	
	public void remove(String codCargo) throws SQLException, CargoNoRegisteredException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException{
		this.repositoryCargos.remove(codCargo);
	}
	
	public boolean exist(String codCargo) throws SQLException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException {
		return this.repositoryCargos.exist(codCargo);
	}
	
	public void update(Cargo cargo) throws SQLException, CargoNoRegisteredException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException {
		this.repositoryCargos.update(cargo);
	}
	
	public Cargo find(String codCargo) throws SQLException, InvalidDateException, CargoNoRegisteredException, ClassNotFoundException, FileNotFoundException, IOException {
		return this.repositoryCargos.find(codCargo);
	}
	
	public Cargo[] getCargos() throws FileNotFoundException, SQLException, InvalidDateException, ClassNotFoundException, IOException{
		return this.repositoryCargos.getCargos();
	}
}
