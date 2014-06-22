package model;

/**
 * @author Thiago Henrique Poiani
 * @author Thiago Silva Barros
 */
public class Manutencao extends Model {

	private int id;
	private String data;
	private char tipo;
	private String local;
	private int id_extintor;
	private int id_usuario;

	/**
	 * Cria objeto Manutencao
	 */
	public Manutencao() {
		super.primaryKey = "id";
		super.table = "manutencao";
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the tipo
	 */
	public char getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the local
	 */
	public String getLocal() {
		return local;
	}

	/**
	 * @param local the local to set
	 */
	public void setLocal(String local) {
		this.local = local;
	}

	/**
	 * @return the id_extintor
	 */
	public int getId_extintor() {
		return id_extintor;
	}

	/**
	 * @param id_extintor the id_extintor to set
	 */
	public void setId_extintor(int id_extintor) {
		this.id_extintor = id_extintor;
	}

	/**
	 * @return the id_usuario
	 */
	public int getId_usuario() {
		return id_usuario;
	}

	/**
	 * @param id_usuario the id_usuario to set
	 */
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	/**
	 * Método para validação de dados
	 * @throws Exception
	 */
	public void validate() throws Exception {
		// validação de campo: data
		if (this.data == null || this.data.equals("")) {
			throw new Exception("O campo Data não pode ser vazio");
		} 

		// validação de campo: local
		if (this.local.length() > 80) {
			throw new Exception("Tamanho de campo Local inválido.");
		}
	}

}
