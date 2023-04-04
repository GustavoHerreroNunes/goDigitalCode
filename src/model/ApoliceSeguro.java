package model;

import java.time.LocalDateTime;
import java.time.LocalDate;

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
			this.contrato = contrato;
			this.numeroApolice = numeroApolice;
			this.tipoApolice = tipoApolice;
			this.seguradora = seguradora;
			this.bemSegurado = bemSegurado;		
		}else
			System.out.println("Uma apólice não pode ser gerada para um contrato cancelado.");
	}
	
	/* Registrar Sinistro
	 * - Apenas o cliente signatário do contrato pode resgistrar um sinistro a ele relacionado
	 * - Código base, no futuro faria uma chamada a classe DAO correspondente*/
	public Sinistro registrarSinistro(int cnpjSolicitante, LocalDateTime dtOcorrencia) {
		if(cnpjSolicitante == contrato.getCliente().getCnpj()) {
			Sinistro sinistro = new Sinistro(1, this, dtOcorrencia);
			System.out.println("Sinistro registrado. Em breve entraremos em contato para decidir os próximos passos.");
			return sinistro;
		}
		System.out.println("Apenas o cliente signatário pode registrar um sinistro");
		return null;
	}

	/* Buscar Apólice
	 * - Por meio da classe ApoliceSeguro será possível buscar por seguros cadastrados
	 * e obter um objeto correspondente
	 * - Código base, no futuro faria uma chamada a classe DAO correspondente*/
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
