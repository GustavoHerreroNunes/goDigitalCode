package model;
public class ApoliceSeguro {

	private int numeroApolice;

	private String tipoApolice;

	private Contrato contrato;

	private Seguradora seguradora;
	
	private BemSegurado bemSegurado;
	
	/* Construtor
	 * - Toda apólice gerada no sistema precisa de todos os seus atributos populados sempre
	 * - Nenhuma apólice pode ser gerada para um contrato cancelado*/
	public ApoliceSeguro(int numeroApolice, String tipoApolice, Contrato contrato, Seguradora seguradora, BemSegurado bemSegurado) {
		if(contrato.getStatus() != "Cancelado") {
			this.numeroApolice = numeroApolice;
			this.tipoApolice = tipoApolice;
			this.seguradora = seguradora;
			this.bemSegurado = bemSegurado;			
		}else
			System.out.println("Uma apólice não pode ser gerada para um contrato cancelado.");
	}
	
	public void registrarSinistro(int cnpjSolicitante) {
		if(cnpjSolicitante == contrato.getCliente().getCnpj()) {
			System.out.println("Sinistro registrado. Em breve entraremos em contato para decidir os próximos passos.");
		}
	}

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
