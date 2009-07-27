package facade;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;

import mem.exception.CargoAlreadyRegistredException;
import mem.exception.CargoNoRegisteredException;
import mem.exception.DepartmentAlreadyRegisteredException;
import mem.exception.DepartmentNoRegisteredException;
import mem.exception.InvalidDateException;
import mem.exception.MemberAlreadyRegisteredException;
import mem.exception.MemberNoRegisterException;
import mem.exception.UserAlreadyRegisteredException;
import mem.exception.UsuarioNoRegisteredException;
import mem.model.cargo.Cargo;
import mem.model.departamento.Department;
import mem.model.integrantesIg.IntegranteIgreja;
import mem.model.usuarios.Usuario;
import mem.repositorios.RepositorioUsuarios;
import mem.repositorios.RepositoryCargos;
import mem.repositorios.RepositoryDepartament;
import mem.repositorios.RepositoryIntegrantesIgreja;
import business.CadastroCargos;
import business.CadastroDepartment;
import business.CadastroIntegrantesIgreja;
import business.CadastroUsuarios;

public class Facade {

	private CadastroIntegrantesIgreja cadastroIntegranteIgreja;
	private CadastroDepartment cadastroDepartment;
	private CadastroCargos cadastroCargo;
	private CadastroUsuarios cadastroUsuarios;
	
	public Facade() {
		this.cadastroIntegranteIgreja = new CadastroIntegrantesIgreja(new RepositoryIntegrantesIgreja());
		this.cadastroDepartment = new CadastroDepartment(new RepositoryDepartament());
		this.cadastroCargo = new CadastroCargos(new RepositoryCargos());
		this.cadastroUsuarios = new CadastroUsuarios(new RepositorioUsuarios());
	}

	public synchronized void cadastrar(Cargo cargo) throws CargoAlreadyRegistredException, SQLException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException {
		this.cadastroCargo.cadastrar(cargo);
	}
	public synchronized void cadastrar(IntegranteIgreja member) throws SQLException, MemberAlreadyRegisteredException, DepartmentNoRegisteredException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException{

		if (this.existDepartment(member.getCodDep())) {
			this.cadastroIntegranteIgreja.cadastrar(member);
		} else {
			throw new DepartmentNoRegisteredException();
		}
	}

	public synchronized void cadastrar(Department department) throws SQLException, DepartmentAlreadyRegisteredException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException, DepartmentNoRegisteredException {
		this.cadastroDepartment.cadastrar(department);
	}
	
	public synchronized void cadastrar(Usuario usuario) throws ClassNotFoundException, SQLException, UserAlreadyRegisteredException  {
		this.cadastroUsuarios.cadastrar(usuario);
	}
	
	public synchronized void deleteCargo(String codCargo) throws SQLException, CargoNoRegisteredException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException {
		this.cadastroCargo.remove(codCargo);
	}
	
	public synchronized void deleteIntegranteIgreja(String rgmem) throws SQLException, MemberNoRegisterException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException{
		this.cadastroIntegranteIgreja.delete(rgmem);
	}

	public synchronized void deleteDepartment(String codDep) throws SQLException, DepartmentNoRegisteredException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException{
		this.cadastroDepartment.delete(codDep);
	}
	
	public synchronized void deleteUsuario(String usuario) throws ClassNotFoundException, SQLException, UsuarioNoRegisteredException {
		this.cadastroUsuarios.delete(usuario);
	}

	public synchronized boolean existCargo(String codCargo) throws SQLException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException{
		return this.cadastroCargo.exist(codCargo);
	}
	
	public synchronized boolean existIntegranteIgreja(String rgmem) throws SQLException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException {
		return this.cadastroIntegranteIgreja.exist(rgmem);
	}

	public synchronized boolean existDepartment(String codDep) throws SQLException, ClassNotFoundException, InvalidDateException, FileNotFoundException, DepartmentNoRegisteredException, IOException {
		return this.cadastroDepartment.exist(codDep);
	}
	
	public synchronized boolean existUsuario(String usuario) throws ClassNotFoundException, SQLException {
		return this.cadastroUsuarios.exist(usuario);
	}

	public synchronized void update(Cargo cargo) throws SQLException, CargoNoRegisteredException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException{
		this.cadastroCargo.update(cargo);
	}
	
	public synchronized void update(IntegranteIgreja member) throws SQLException, MemberNoRegisterException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException {
		this.cadastroIntegranteIgreja.update(member);
	}

	public synchronized void update(Department department) throws SQLException, DepartmentNoRegisteredException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException {
		this.cadastroDepartment.update(department);
	}
	
	public synchronized void update(Usuario usuario) throws ClassNotFoundException, SQLException, UsuarioNoRegisteredException {
		this.cadastroUsuarios.update(usuario);
	}

	public synchronized Cargo findCargo(String codCargo) throws SQLException, InvalidDateException, CargoNoRegisteredException, ClassNotFoundException, FileNotFoundException, IOException{
		return this.cadastroCargo.find(codCargo);
	}
	
	public synchronized IntegranteIgreja findIntegranteIgreja(String rgmem) throws SQLException, InvalidDateException, MemberNoRegisterException, ClassNotFoundException, FileNotFoundException, IOException {
		return this.cadastroIntegranteIgreja.find(rgmem);
	}

	public synchronized Department findDepartment(String codDep) throws SQLException, InvalidDateException, DepartmentNoRegisteredException, ClassNotFoundException, FileNotFoundException, IOException {
		return this.cadastroDepartment.find(codDep);
	}
	
	public synchronized Usuario findUsuario(String usuario) throws ClassNotFoundException, SQLException, UsuarioNoRegisteredException  {
		return this.cadastroUsuarios.find(usuario);
	}

	public synchronized Cargo[] getCargos() throws FileNotFoundException, SQLException, InvalidDateException, ClassNotFoundException, IOException{
		return this.cadastroCargo.getCargos();
	}
	
	public synchronized Department[] getDepartment() throws FileNotFoundException, SQLException, InvalidDateException, ClassNotFoundException, DepartmentNoRegisteredException, IOException{
		return this.cadastroDepartment.getDeps();
	}
	
	public synchronized Iterator<IntegranteIgreja> getIntegranteIgreja() throws FileNotFoundException, SQLException, InvalidDateException, ClassNotFoundException, IOException{
		return this.cadastroIntegranteIgreja.getIntegranteIgreja();
	}
	
	public synchronized Iterator<IntegranteIgreja> getIntegranteIgrejaByDate() throws FileNotFoundException, SQLException, InvalidDateException, ClassNotFoundException, IOException{
		return this.cadastroIntegranteIgreja.getIntegranteIgrejaByDate();
	}
	
	public synchronized Iterator<Usuario> getUsuarios() throws SQLException, ClassNotFoundException{
		return this.cadastroUsuarios.getUsuarios();
	}
	
	

}
