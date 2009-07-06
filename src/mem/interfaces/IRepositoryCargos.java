package mem.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import mem.exception.CargoNoRegisteredException;
import mem.exception.InvalidDateException;
import mem.model.cargo.Cargo;

public interface IRepositoryCargos {

	public abstract void insert(Cargo cargo) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;

	public abstract void remove(String codCargo) throws SQLException,
			CargoNoRegisteredException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException;

	public abstract boolean exist(String codCargo) throws SQLException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException;

	public abstract void update(Cargo cargo) throws SQLException,
			CargoNoRegisteredException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException;

	public abstract Cargo find(String codCargo) throws SQLException,
			InvalidDateException, CargoNoRegisteredException, ClassNotFoundException, FileNotFoundException, IOException;
	
	public Cargo[] getCargos() throws SQLException, InvalidDateException, ClassNotFoundException, FileNotFoundException, IOException;

}