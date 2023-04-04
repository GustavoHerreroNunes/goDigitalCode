package model;

import java.time.LocalDateTime;

public class Sinistro {
	private int codigoSinistro;
	private LocalDateTime dtOcorrencia;
	private ApoliceSeguro apoliceSeguro;
	
	/* Construtor
	 * - Todo sinistro gerado no sistema precisa de todos os seus atributos populados sempre*/
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
