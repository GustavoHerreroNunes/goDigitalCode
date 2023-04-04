package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe que representa um contrato de seguro vinculado a um cliente
 */
public class Contrato {

	private int numeroContrato;
	
	private String status = "Cadastrado";
	
	private LocalDate dtAssinatura;
	
	private LocalDate dtFimVigencia;

	private Cliente cliente;
	
	/**
     * Construtor da classe Contrato
     * @param numeroContrato numero do contrato
     * @param dtFimVigencia data de fim da vigencia do contrato
     * @param cliente objeto da classe Cliente
     */
	public Contrato(int numeroContrato, LocalDate dtFimVigencia, Cliente cliente) {
		this.numeroContrato = numeroContrato;
		this.dtFimVigencia = dtFimVigencia;
		this.cliente = cliente;
	}
	
	/**
     * Metodo que verifica se um CNPJ e valido para o contrato
     * @param cnpjDesconhecido CNPJ a ser verificado
     * @return booleano indicando se o CNPJ e valido ou nao
     */
	public boolean cnpjValido(int cnpjDesconhecido) {
		return (cnpjDesconhecido == cliente.getCnpj());
	}

	/**
     * Metodo que assina o contrato se o CNPJ for valido e a data de fim de vigencia nao tiver passado
     * @param cnpjAssinante CNPJ do assinante do contrato
     * @return booleano indicando se o contrato foi assinado ou nao
     */
	public boolean assinarContrato(int cnpjAssinante) {
		if(cnpjValido(cnpjAssinante)) {
			LocalDate dtHoje = LocalDate.now();
			
			if(!dtHoje.isAfter(dtFimVigencia) || dtHoje.isEqual(dtFimVigencia)) {
				status = "Assinado";
				dtAssinatura = dtHoje;
				return true;				
			}
		}
		return false;
	}
	
	/**
     * Metodo que solicita o cancelamento do contrato se o CNPJ for valido
     * @param cnpjSolicitante CNPJ do solicitante do cancelamento
     * @param motivo motivo do cancelamento
     */
	public void solicitarCancelamento(int cnpjSolicitante, String motivo) {
		if(cnpjValido(cnpjSolicitante)) {
			System.out.println("Sua solicitação foi enviada à Corretora. Em breve responderemos.");
		}
		System.out.println("Apenas o cliente signatario do contrato pode solicitar seu cancelamento.");
	}
	
	/**
     * Metodo que cancela o contrato se o funcionario da corretora for administrador
     * @param funcionario objeto da classe FuncionarioCorretora
     */
	public void cancelar(FuncionarioCorretora funcionario) {
		if(funcionario.getNivelUsuario() == "Admin") {
			status = "Cancelado";
			System.out.println("Contrato cancelado");
		}
		System.out.println("Apenas um administrador pode fazer essa operação.");
	}

	public String getStatus() {
		return status;
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
	
	public String getDtAssinatura() {
		return dtAssinatura.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public String getDtFimVigencia() {
		return dtFimVigencia.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public void setDtVigencia(LocalDate dtFimVigencia) {
		this.dtFimVigencia = dtFimVigencia;
	}

}
