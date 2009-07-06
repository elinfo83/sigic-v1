package business;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import mem.exceptions.DepartmentAlreadyRegisteredException;
import mem.exceptions.DepartmentNoRegisteredException;
import mem.exceptions.InvalidDateException;
import mem.interfaces.IRepositoryDepartment;
import mem.model.department.Department;

public class CadastroDepartment {
	private IRepositoryDepartment repository;
	
	public CadastroDepartment(IRepositoryDepartment repository) {
		this.repository = repository;
	}
	
	public void cadastrar(Department department) throws SQLException, DepartmentAlreadyRegisteredException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException, DepartmentNoRegisteredException{
		if(!this.repository.exist(department.getCode())){
			this.repository.insert(department);
		}else{
			throw new DepartmentAlreadyRegisteredException();
		}
	}
	
	public void delete(String codDep) throws SQLException, DepartmentNoRegisteredException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException{
		this.repository.remove(codDep);
	}
	
	public boolean exist(String codDep) throws SQLException, ClassNotFoundException, InvalidDateException, FileNotFoundException, DepartmentNoRegisteredException, IOException{
		return this.repository.exist(codDep);
	}
	
	public Department find(String codDep) throws SQLException, InvalidDateException, DepartmentNoRegisteredException, ClassNotFoundException, FileNotFoundException, IOException{
		return this.repository.find(codDep);
	}
	
	public void update(Department department) throws SQLException, DepartmentNoRegisteredException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException{
		this.repository.update(department);
	}
	
	public Department[] getDeps() throws FileNotFoundException, SQLException, InvalidDateException, ClassNotFoundException, DepartmentNoRegisteredException, IOException{
		return this.repository.getDeps();
	}
}
