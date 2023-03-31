package model;
public class Seguradora {

	private String nome;

	private int cnpj;

	private Contrato[] contrato;

	public Seguradora buscarSegudora(int cnpj) {
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public Contrato[] getContrato() {
		return contrato;
	}

	public void setContrato(Contrato[] contrato) {
		this.contrato = contrato;
	}

}
