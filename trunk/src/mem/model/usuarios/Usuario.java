package mem.model.usuarios;

public class Usuario {
	
	private String usuario;
	private String senha;
	private int nivel;
	
	public Usuario(String usuario, String senha, int nivel) {
		this.usuario = usuario;
		this.senha = senha;
		this.nivel = nivel;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
}
