package mem.interfaces;

import java.sql.SQLException;
import java.util.Iterator;

import mem.exception.UsuarioNoRegisteredException;
import mem.model.usuarios.Usuario;

public interface IRepositorioUsuario {

	public abstract void insert(Usuario usuario) throws ClassNotFoundException,
			SQLException;

	public abstract void remove(String usuario) throws ClassNotFoundException,
			SQLException, UsuarioNoRegisteredException;

	public abstract boolean exist(String usuario)
			throws ClassNotFoundException, SQLException;

	public abstract void update(Usuario usuario) throws ClassNotFoundException,
			SQLException, UsuarioNoRegisteredException;

	public abstract Usuario find(String usuario) throws ClassNotFoundException,
			SQLException, UsuarioNoRegisteredException;

	public abstract Iterator<Usuario> getUsuario() throws SQLException,
			ClassNotFoundException;

}