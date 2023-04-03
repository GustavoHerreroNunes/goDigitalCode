package view;

import model.Contrato;
import model.Cliente;
import model.FuncionarioCorretora;
import java.time.LocalDate;

public class ViewTesteContrato {

	public static void main(String[] args) {
		LocalDate dtVigenciaPrevista = LocalDate.of(2025, 5, 05);
		
		Cliente cliente = new Cliente();
		cliente.setCnpj(12345);
		
		Contrato contrato = new Contrato(1, dtVigenciaPrevista, cliente);
		System.out.println("Data de vigência: " + contrato.getDtFimVigencia());
		System.out.println("CNPJ cliente: " + contrato.getCliente().getCnpj());
		System.out.println("Número do contrato: " + contrato.getNumeroContrato());

		Cliente falsoCliente = new Cliente();
		falsoCliente.setCnpj(22222);
		
		boolean contratoAssinado = contrato.assinarContrato(cliente.getCnpj());
		System.out.println("Assinou? " + contratoAssinado);
		System.out.println("Quando foi assinado? " + contrato.getDtAssinatura());
		System.out.println("Status " + contrato.getStatus());
		
		FuncionarioCorretora funcionario = new FuncionarioCorretora();
		funcionario.setNivelUsuario("Admin");
		
		FuncionarioCorretora outroFuncionario = new FuncionarioCorretora();
		outroFuncionario.setNivelUsuario("Dev");
		
		contrato.solicitarCancelamento(falsoCliente.getCnpj(), "Cansei de vocês.");
		contrato.cancelar(outroFuncionario);
	}

}
