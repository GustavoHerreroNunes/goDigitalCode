package model;

import java.time.LocalDateTime;
import java.time.LocalDate;

/**
 * Classe que representa uma apolice de seguro vinculada a um contrato, uma seguradora e um bem segurado.
 */
public class ApoliceSeguro {

	private int numeroApolice;

	private String tipoApolice;

	private Contrato contrato;

	private Seguradora seguradora;
	
	private BemSegurado bemSegurado;
	
	/**
	 * Construtor da classe ApoliceSeguro que recebe os dados da apolice e verifica se o contrato esta valido.
	 * @param numeroApolice o numero da apolice
	 * @param tipoApolice o tipo da apolice
	 * @param contrato o contrato associado a apolice
	 * @param seguradora a seguradora responsavel pela apolice
	 * @param bemSegurado o bem segurado pela apolice
	 */
	public ApoliceSeguro(int numeroApolice, String tipoApolice, Contrato contrato, Seguradora seguradora, BemSegurado bemSegurado) {
		if(contrato.getStatus() != "Cancelado") {
			this.contrato = contrato;
			this.numeroApolice = numeroApolice;
			this.tipoApolice = tipoApolice;
			this.seguradora = seguradora;
			this.bemSegurado = bemSegurado;		
		}else
			System.out.println("Uma apólice não pode ser gerada para um contrato cancelado.");
	}
	
	/**
	 * Metodo que registra um sinistro para a apolice se o solicitante for o cliente do contrato.
	 * @param cnpjSolicitante o CNPJ do solicitante do sinistro
	 * @param dtOcorrencia a data e hora da ocorrencia do sinistro
	 * @return um objeto Sinistro se o registro for bem sucedido, ou null caso contrario
	 */
	public Sinistro registrarSinistro(int cnpjSolicitante, LocalDateTime dtOcorrencia) {
		if(cnpjSolicitante == contrato.getCliente().getCnpj()) {
			Sinistro sinistro = new Sinistro(1, this, dtOcorrencia);
			System.out.println("Sinistro registrado. Em breve entraremos em contato para decidir os próximos passos.");
			return sinistro;
		}
		System.out.println("Apenas o cliente signatário pode registrar um sinistro");
		return null;
	}

	/**
	 * Método estatico que busca uma apolice de seguro pelo seu numero.
	 * @param numeroApolice o numero da apolice a ser buscada
	 * @return um objeto ApoliceSeguro se a busca for bem sucedida, ou null caso contrario
	 */
	public static ApoliceSeguro buscarApolice(int numeroApolice) {
		
		LocalDate dtVigencia = LocalDate.of(2024, 03, 22);
		Cliente cliente = new Cliente();
		Contrato contrato = new Contrato(1, dtVigencia, cliente);
		
		Seguradora seguradora = new Seguradora();
		
		BemSegurado bemSegurado = new BemSegurado("CHJF-32");
		
		ApoliceSeguro apolice = new ApoliceSeguro(numeroApolice, "Tipo Exemplo", contrato, seguradora, bemSegurado);
		return apolice;
	}
	
	public int getNumeroApolice() {
		return numeroApolice;
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

	public Seguradora getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	
	public BemSegurado getBemSegurado() {
		return bemSegurado;
	}
}
