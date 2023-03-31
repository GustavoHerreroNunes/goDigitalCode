package model;
public class Contrato {

	private boolean estaAssinado;

	private int numeroContrato;

	private Cliente cliente;

	public boolean getEstaAssinado() {
		return estaAssinado;
	}

	public void setEstaAssinado(boolean estaAssinado) {
		this.estaAssinado = estaAssinado;
	}

	public int getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(int numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
