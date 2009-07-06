package mem.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import mem.exception.DepartmentNoRegisteredException;
import mem.exception.InvalidDateException;
import mem.model.departamento.Department;

public interface IRepositoryDepartment {
	
	public abstract void insert(Department dep) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;
	
	public abstract void remove(String codDep) throws SQLException,
	DepartmentNoRegisteredException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException;
	
	public abstract boolean exist(String codDep) throws SQLException, ClassNotFoundException, InvalidDateException, FileNotFoundException, DepartmentNoRegisteredException, IOException;
	
	public abstract void update(Department dep) throws SQLException,
	DepartmentNoRegisteredException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException;
	
	public abstract Department find(String codDep) throws SQLException,
	InvalidDateException, DepartmentNoRegisteredException, ClassNotFoundException, FileNotFoundException, IOException;
	
	public  Department[] getDeps() throws SQLException, InvalidDateException, ClassNotFoundException, FileNotFoundException, 
	DepartmentNoRegisteredException, IOException;
	
	public  Department[] getDepsWithoutIntIg() throws SQLException, InvalidDateException, ClassNotFoundException;
	
}