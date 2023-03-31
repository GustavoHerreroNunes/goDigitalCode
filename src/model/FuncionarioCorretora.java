package model;
public class FuncionarioCorretora extends Usuario {

	private String dataNascimento;

	private String nivelUsuario;

	public void incluir() {

	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNivelUsuario() {
		return nivelUsuario;
	}

	public void setNivelUsuario(String nivelUsuario) {
		this.nivelUsuario = nivelUsuario;
	}
}
