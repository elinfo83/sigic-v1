package business;

import java.sql.SQLException;
import java.util.Iterator;

import mem.exception.UserAlreadyRegisteredException;
import mem.exception.UsuarioNoRegisteredException;
import mem.interfaces.IRepositorioUsuario;
import mem.model.usuarios.Usuario;

public class CadastroUsuarios {

private IRepositorioUsuario repository;
	
	public CadastroUsuarios(IRepositorioUsuario repository) {
		this.repository = repository;
	}
	
	public void cadastrar(Usuario usuario) throws ClassNotFoundException, SQLException, UserAlreadyRegisteredException{
		if(!this.repository.exist(usuario.getUsuario())){
			this.repository.insert(usuario);
		}else{
			throw new UserAlreadyRegisteredException();
		}
	}
	
	public void delete(String usuario) throws ClassNotFoundException, SQLException, UsuarioNoRegisteredException{
		this.repository.remove(usuario);
	}
	
	public boolean exist(String usuario) throws ClassNotFoundException, SQLException{
		return this.repository.exist(usuario);
	}
	
	public Usuario find(String usuario) throws ClassNotFoundException, SQLException, UsuarioNoRegisteredException{
		return this.repository.find(usuario);
	}
	
	public void update(Usuario usuario) throws ClassNotFoundException, SQLException, UsuarioNoRegisteredException{
		this.repository.update(usuario);
	}
	
	public Iterator<Usuario> getUsuarios() throws SQLException, ClassNotFoundException {
		return this.repository.getUsuario();
	}
}
