package view;

import java.time.LocalDate;
import java.time.LocalDateTime;
import model.Cliente;
import model.Contrato;
import model.ApoliceSeguro;
import model.Sinistro;

public class ViewTesteApoliceSinistro {

	public static void main(String[] args) {
		LocalDate dtVigenciaPrevista = LocalDate.of(2025, 5, 05);
		
		Cliente cliente = new Cliente();
		cliente.setCnpj(12345);
		
		Contrato contrato = new Contrato(1, dtVigenciaPrevista, cliente);
		
		ApoliceSeguro apolice = new ApoliceSeguro(1, "Tipo Exemplo", contrato, null, null);
		
		LocalDateTime dtSinistro = LocalDateTime.now();
		Sinistro sinistroRegistrado = apolice.registrarSinistro(cliente.getCnpj(), dtSinistro);
		
		System.out.println("Contrato nº " + contrato.getNumeroContrato());
		System.out.println("Cliente CNPJ: " + cliente.getCnpj());
		System.out.println("Apolice - " + apolice.getTipoApolice());
		System.out.println("Sinistro (Data ocorrência): " + sinistroRegistrado.getDtOcorrencia());
		
		ApoliceSeguro apolice2 = ApoliceSeguro.buscarApolice(3);
		apolice2.getContrato().getCliente().setCnpj(9090);
		LocalDateTime dtSinistro2 = LocalDateTime.now();
		Sinistro sinistroRegistrado2 = apolice2.registrarSinistro(apolice2.getContrato().getCliente().getCnpj(), dtSinistro2);
		System.out.println("Contrato nº " + apolice2.getContrato().getNumeroContrato());
		System.out.println("Cliente CNPJ: " + apolice2.getContrato().getCliente().getCnpj());
		System.out.println("Apolice - " + apolice2.getTipoApolice());
		System.out.println("Sinistro (Data ocorrência): " + sinistroRegistrado2.getDtOcorrencia());

	}

}
