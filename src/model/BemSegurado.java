package model;
public class BemSegurado {

	private String idItem;
	
	private String nomeItem;

	private String tipoItem;

	private ApoliceSeguro apoliceSeguro;
	
	/* Construtor
	 * - Todo contrato precisa ter um id do item*/	
	public BemSegurado(String idItem) {
		this.idItem = idItem;
	}

	public String getIdItem() {
		return idItem;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}
	
	public String getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
	}

	public ApoliceSeguro getApoliceSeguro() {
		return apoliceSeguro;
	}

	public void setApoliceSeguro(ApoliceSeguro apoliceSeguro) {
		this.apoliceSeguro = apoliceSeguro;
	}
}
