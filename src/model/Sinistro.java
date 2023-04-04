package model;

import java.time.LocalDateTime;

/**
 * Classe que representa um sinistro sobre um bem segurdado vinculado a uma Apolice de Seguro
 */
public class Sinistro {
	private int codigoSinistro;
	private LocalDateTime dtOcorrencia;
	private ApoliceSeguro apoliceSeguro;
	
	/**
	 * Construtor da classe Sinistro que popula uma nova instancia dela.
	 * @param codigoSinistro o codigo do sinistro
	 * @param apoliceSeguro a apolice vinculada
	 * @param dtOcorrencia a data de ocorrencia do sinistro
	 */
	public Sinistro(int codigoSinistro, ApoliceSeguro apoliceSeguro, LocalDateTime dtOcorrencia) {
		this.codigoSinistro = codigoSinistro;
		this.apoliceSeguro = apoliceSeguro;
		this.dtOcorrencia = dtOcorrencia;
	}

	public int getCodigoSinistro() {
		return codigoSinistro;
	}

	public LocalDateTime getDtOcorrencia() {
		return dtOcorrencia;
	}
	
	public Sinistro setDtOcorrencia(LocalDateTime dtOcorrencia) {
		this.dtOcorrencia = dtOcorrencia;
		return this;
	}
	
	public ApoliceSeguro getApoliceSeguro() {
		return apoliceSeguro;
	}	
	
}
