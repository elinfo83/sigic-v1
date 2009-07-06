package business;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import mem.exceptions.InvalidDateException;
import mem.exceptions.MemberAlreadyRegisteredException;
import mem.exceptions.MemberNoRegisterException;
import mem.interfaces.IRepositoryIntegrantesIgreja;
import mem.model.integrantesIg.IntegranteIgreja;

public class CadastroIntegrantesIgreja {

	private IRepositoryIntegrantesIgreja repository;

	public CadastroIntegrantesIgreja(IRepositoryIntegrantesIgreja repositoryMembers) {
		this.repository = repositoryMembers;
	}

	public void cadastrar(IntegranteIgreja member) throws SQLException, MemberAlreadyRegisteredException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException{
		if(this.repository.exist(member.getRg())){
			throw new MemberAlreadyRegisteredException();
		}else{
			this.repository.insert(member);
		}
	}

	public void delete(String rgMember) throws SQLException, MemberNoRegisterException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException{
		this.repository.remove(rgMember);
	}

	public boolean exist(String rgMember) throws SQLException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException{
		return this.repository.exist(rgMember);
	}

	public IntegranteIgreja find(String rgMember) throws SQLException, InvalidDateException, MemberNoRegisterException, ClassNotFoundException, FileNotFoundException, IOException{
		return this.repository.find(rgMember);
	}

	public void update(IntegranteIgreja member) throws SQLException, MemberNoRegisterException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException{
		this.repository.update(member);
	}
	
	public IntegranteIgreja[] getIntegranteIgreja() throws FileNotFoundException, SQLException, InvalidDateException, ClassNotFoundException, IOException{
		return this.repository.getIntegranteIgreja();
	}
}
