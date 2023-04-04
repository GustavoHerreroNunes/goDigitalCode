package model;

/**
 * Classe que representa um bem segurado em uma apolice de seguro
 */
public class BemSegurado {

	private String idItem;
	
	private String nomeItem;

	private String tipoItem;

	private ApoliceSeguro apoliceSeguro;
	
	/**
     * Construtor da classe BemSegurado
     * @param idItem código de identificacao do item segurado
     */
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
