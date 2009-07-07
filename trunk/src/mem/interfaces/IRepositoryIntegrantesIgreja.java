package mem.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;

import mem.exception.InvalidDateException;
import mem.exception.MemberNoRegisterException;
import mem.model.integrantesIg.IntegranteIgreja;

public interface IRepositoryIntegrantesIgreja {

	public abstract void insert(IntegranteIgreja member) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;

	public abstract void remove(String rgMember) throws SQLException,
			MemberNoRegisterException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException;

	public abstract boolean exist(String rgMember) throws SQLException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException;

	public abstract void update(IntegranteIgreja member) throws SQLException, MemberNoRegisterException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException;

	public abstract IntegranteIgreja find(String rgMember) throws SQLException, InvalidDateException, MemberNoRegisterException, ClassNotFoundException, FileNotFoundException, IOException;

	public abstract Iterator<IntegranteIgreja> getIntegranteIgreja() throws SQLException, InvalidDateException, ClassNotFoundException, FileNotFoundException, IOException;
}