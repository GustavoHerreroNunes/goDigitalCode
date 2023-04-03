package model;

import java.time.LocalDateTime;

public class Sinistro {
	private int codigoSinistro;
	private LocalDateTime dtOcorrencia;
	private ApoliceSeguro apoliceSeguro;
	
	public Sinistro(int codigoSinistro, ApoliceSeguro apoliceSeguro) {
		this.codigoSinistro = codigoSinistro;
		this.apoliceSeguro = apoliceSeguro;
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
