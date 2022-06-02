package br.com.alura.gerenciador.servlet.mvc.model;

public class Usuario {
	private String login;
	private String senha;

	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean isIgualLoginESenha(String usuario, String senha) {
		if (!login.equals(this.login))
			return false;
		if (!senha.equals(this.senha))
			return false;
		return true;
	}

}
