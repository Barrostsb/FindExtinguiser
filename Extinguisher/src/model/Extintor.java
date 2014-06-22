package model;

import java.sql.ResultSet;

import DAO.ExtintorDAO;



/**
 * @author Thiago Henrique Poiani
 * @author Thiago Silva Barros
 */
public class Extintor extends Model {
	private int id;
	private String codigo;
	private char tipo;
	private String capacidade;
	private char status;
	private int id_usuario;
	private int id_manutencao;

	/**
	 * Cria objeto Extintor
	 */
	public Extintor() {
		super.primaryKey = "id";
		super.table = "extintor";
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
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	 * @return the capacidade
	 */
	public String getCapacidade() {
		return capacidade;
	}

	/**
	 * @param capacidade the capacidade to set
	 */
	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}

	/**
	 * @return the status
	 */
	public char getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(char status) {
		this.status = status;
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
	 * @return the id_manutencao
	 */
	public int getId_manutencao() {
		return id_manutencao;
	}

	/**
	 * @param id_manutencao the id_manutencao to set
	 */
	public void setId_manutencao(int id_manutencao) {
		this.id_manutencao = id_manutencao;
	}

	public void validate() throws Exception {
		ExtintorDAO business = new ExtintorDAO(this);
		ResultSet result = null;
		String query = "";

		// validação de campo: codigo
		if (this.codigo == null || this.codigo.isEmpty()) {
			throw new Exception("O campo Código não pode ser vazio");
		}

		if (this.codigo.length() > 8) {
			throw new Exception("Tamanho de campo Código inválido.");
		}

		query = (this.id == 0) ? "SELECT * FROM " + getTable() + " WHERE codigo = '" + this.codigo + "'": 
			"SELECT * FROM " + getTable() + " WHERE codigo = '" + this.codigo + "' AND id <> " + this.id;

		business.storage(query);
		result = business.execute();

		if (result.next()){
			throw new Exception("Esse Código já está cadastrado no sistema.");
		}

		// validação de campo: capacidade
		if (this.capacidade.length() > 5) {
			throw new Exception("Tamanho de campo Capacidade inválido.");
		}
	}
}
