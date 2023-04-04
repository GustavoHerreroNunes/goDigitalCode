package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Contrato {

	private int numeroContrato;
	
	private String status = "Cadastrado";
	
	private LocalDate dtAssinatura;
	
	private LocalDate dtFimVigencia;

	private Cliente cliente;
	
	/* Construtor
	 * - Todo contrato precisa ter um número, uma data prevista de vigência
	 *  e um cliente*/
	public Contrato(int numeroContrato, LocalDate dtFimVigencia, Cliente cliente) {
		this.numeroContrato = numeroContrato;
		this.dtFimVigencia = dtFimVigencia;
		this.cliente = cliente;
	}
	
	/* CNPJ é Válido?
	 * - Verifica se o cnpj inserido corresponde ao do cliente deste contrato*/
	public boolean cnpjValido(int cnpjDesconhecido) {
		return (cnpjDesconhecido == cliente.getCnpj());
	}

	/* Assinar Contrato
	 * - Todo contrato deve ser assinado pelo mesmo cliente que o cadastrou
	 * - A data de assinatura não pode ser posterior ou no mesmo dia do fim
	 *  da vigência planejada no cadastro*/
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
	
	/* Solicitar Cancelamento
	 * - Apenas o cliente signatario do contrato pode solicitar seu cancelamento
	 * - Código base, no futuro faria uma chamada a classe DAO correspondente*/
	public void solicitarCancelamento(int cnpjSolicitante, String motivo) {
		if(cnpjValido(cnpjSolicitante)) {
			System.out.println("Sua solicitação foi enviada à Corretora. Em breve responderemos.");
		}
		System.out.println("Apenas o cliente signatario do contrato pode solicitar seu cancelamento.");
	}
	
	/* Cancelar Contrato
	 * - Apenas um funcionario do nível Administrador pode cancelar contrato
	 * - Código base, no futuro faria uma chamada a classe DAO correspondente*/
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
