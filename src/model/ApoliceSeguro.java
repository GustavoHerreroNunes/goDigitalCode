package model;
public class ApoliceSeguro {

	private int numeroApolice;

	private String tipoApolice;

	private Contrato contrato;

	private Seguradora seguradora;
	
	private BemSegurado bemSegurado;

	public ApoliceSeguro buscarApolice(int numeroApolice) {
		return null;
	}
	
	public int getNumeroApolice() {
		return numeroApolice;
	}

	public void setNumeroApolice(int numeroApolice) {
		this.numeroApolice = numeroApolice;
	}

	public String getTipoApolice() {
		return tipoApolice;
	}

	public void setTipoApolice(String tipoApolice) {
		this.tipoApolice = tipoApolice;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public Seguradora getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	
	public BemSegurado getBemSegurado() {
		return bemSegurado;
	}

	public void setBemSegurado(BemSegurado bemSegurado) {
		this.bemSegurado = bemSegurado;
	}

}
