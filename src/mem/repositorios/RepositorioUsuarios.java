package mem.repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;

import mem.exception.UsuarioNoRegisteredException;
import mem.interfaces.IRepositorioUsuario;
import mem.model.usuarios.Usuario;
import util.ConstantsSystem;

public class RepositorioUsuarios implements IRepositorioUsuario {

	private Connection connection = null;
	private Statement statement = null;

	public RepositorioUsuarios() {

	}

	
	public void insert(Usuario usuario) throws ClassNotFoundException, SQLException {
		String insertUsuario = "";

		this.connectBank();		

		insertUsuario = "INSERT INTO usuariosAut VALUES('" +
		usuario.getUsuario() + "', '" + usuario.getSenha() + "', " +usuario.getNivel()+");";

		this.statement.executeUpdate(insertUsuario);


		this.closeConnection();
	}

	
	public void remove(String usuario) throws ClassNotFoundException, SQLException, UsuarioNoRegisteredException {
		String deleteUsuario = "";

		if(exist(usuario)){
			deleteUsuario = "DELETE FROM cargos WHERE codCargo = '" + usuario + "';";

			this.connectBank();

			this.statement.executeUpdate(deleteUsuario);

			this.closeConnection();

		}else{
			throw new UsuarioNoRegisteredException();
		}

	}

	
	public boolean exist(String usuario) throws ClassNotFoundException, SQLException {

		String query = "SELECT * FROM usuariosAut " +
		"WHERE usuario = '" +usuario +"'";
		boolean resp = false;
		System.out.println(query);

		this.connectBank();
		ResultSet resultSet = this.statement.executeQuery(query);
		resp = resultSet.next();
		this.closeConnection();
		return resp;
	}

	
	public void update(Usuario usuario) throws ClassNotFoundException, SQLException, UsuarioNoRegisteredException {

		String updateUsuario = "";

		if(exist(usuario.getUsuario())){
			updateUsuario = "UPDATE usuariosAut SET usuario = '" + usuario.getUsuario() + "', senha = '" + usuario.getSenha()+ 
			"', nivel = " +usuario.getNivel()+ " WHERE usuario = '" + usuario.getUsuario() + "';"; 

			this.connectBank();

			this.statement.executeUpdate(updateUsuario);

			this.closeConnection();
		}else{
			throw new UsuarioNoRegisteredException();
		}
	}

	
	public Usuario find(String usuario) throws ClassNotFoundException, SQLException, UsuarioNoRegisteredException{	

		Iterator<Usuario> iterator = getUsuario();
		Usuario usuario2 = null;
		if(exist(usuario)){
				while(iterator.hasNext()){
					usuario2 = iterator.next();
					if(usuario2.getUsuario().equals(usuario)){
						return usuario2;
					}
				}
			
		}
		throw new UsuarioNoRegisteredException();
	}

	
	public Iterator<Usuario> getUsuario() throws SQLException, ClassNotFoundException{

		String queryCargos = "SELECT * FROM usuariosAut;";
		LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
		ResultSet resultSetUsuario = null;
		


		this.connectBank();
		resultSetUsuario = statement.executeQuery(queryCargos);
		
		while(resultSetUsuario.next()){
			usuarios.add(createUsuario(resultSetUsuario));
		}
		
		this.closeConnection();

		return usuarios.iterator();
	}

	private Usuario createUsuario(ResultSet resultSetUsuarios) throws SQLException  {
		Usuario user = new Usuario("","",3);
				
		user.setUsuario((String)resultSetUsuarios.getObject(1));
		user.setSenha((String)resultSetUsuarios.getObject(2));
		user.setNivel((Integer)resultSetUsuarios.getObject(3));

		return user;
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
