package model;
public abstract class Usuario {

	private String nome;

	private String email;

	private String senha;

	public void incluir() {

	}

	public Usuario buscaUsuario(int email) {
		return null;
	}

	public void alteraSenha(String novaSenha) {
		this.setSenha(novaSenha);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
