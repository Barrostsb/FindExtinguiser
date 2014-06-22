package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Vector;

import model.Extintor;
import model.Model;





/**
 * Classe para Data Access Object 
 * @author Thiago Henrique Poiani
 * @author Thiago Silva Barros
 */
public class ExtintorDAO extends DAO {

	Extintor extintor;

	/**
	 * Construtor da classe DAO, que instancia a classe Mysql
	 * @throws SQLException
	 */
	public ExtintorDAO(Extintor extintor) throws SQLException {
		super();
		this.extintor = extintor;
	}

	/**
	 * Método para salvar usário, podendo atualizar ou cadastrar
	 */
	@Override
	public void save() throws SQLException {
		if (this.connection != null) {
			if (extintor.getId() == 0) {
				create(extintor);
			} else {
				update(extintor);
			}
		}
	}

	/**
	 * Método responsável por inserir informações no banco de dados
	 * @param object
	 * @throws SQLException
	 */
	@Override
	public int create(Object object) throws SQLException {
		model = new Model();
		PreparedStatement statement = null;

		// array(key => value)
		HashMap<Integer, String> array = new HashMap<Integer, String>();

		int i = 0;
		String classe = object.getClass().toString().substring(12); // class model.Model => Model
		// para cada atributo do model faça: 
		for (Iterator<String> iterator = model.setters(classe).iterator(); 
				iterator.hasNext(); 
				) {
			// armazena o atributo
			String attribute = iterator.next();
			if (!attribute.equals("id") && !attribute.equals("status") && !attribute.equals("id_manutencao")) {
				// insere atributo no array(i => attribute)
				array.put(i, attribute);
				// concatena nas strings
				columns += attribute + COMMA;
				values += "?" + COMMA;
				i++;
			}
		}

		// remove as duas outras letras das strings
		columns = columns.substring(0, columns.length() - COMMA.length()); // id, nome, cpf
		values = values.substring(0, values.length() - COMMA.length()); // ?, ?, ?

		String query = "INSERT INTO " + model.__get("table", object)
				+ " (" + columns + ")"
				+ " VALUES (" + values + ");";

		// atribui a query ao SQL
		statement = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

		// para cada indice do array(key => value)
		for (Entry<Integer, String> index : array.entrySet()) {
			int indice = index.getKey() + 1;
			String valor = model.__get(index.getValue(), object);
			statement.setString(indice, String.valueOf(valor));
		}

		// executa query
		statement.executeUpdate();

		// retorna id
		ResultSet rs = statement.getGeneratedKeys();
		rs.next();
		return rs.getInt(1);
	}

	/**
	 * Método responsável por atualizar informações no banco de dados
	 * @param object
	 * @param id
	 * @throws SQLException
	 */
	@Override
	public void update(Object object) throws SQLException {
		model = new Model();
		PreparedStatement statement = null;

		String classe = object.getClass().toString().substring(12); // class model.Model => Model
		// para cada atributo do model faça: 

		for (Iterator<String> iterator = model.getters(classe).iterator(); 
				iterator.hasNext();) {
			// armazena o atributo
			String attribute = iterator.next();

			if (!attribute.equals("id") && !attribute.equals("status")) {
				// query
				String query = "UPDATE " + model.__get("table", object) + " SET " + attribute + " = ? "
						+ "WHERE " + model.__get("primaryKey", object) + " = ?; ";

				// atribui a query ao SQL
				statement = this.connection.prepareStatement(query);

				// seta o atributo e a restrição
				statement.setString(1, model.__get(attribute, object));
				statement.setInt(2, Integer.parseInt(model.__get(model.__get("primaryKey", object), object)));

				// executa query
				statement.executeUpdate();
			}
		}
	}

	/**
	 * Método para listagem
	 * Sem parâmetros: consulta padrão
	 * @return Vector<Vector<String>>
	 * @throws SQLException
	 */
	@Override
	public Vector<Vector<String>> read() throws SQLException {
		// matriz: vetor de vetor de string
		Vector<Vector<String>> dataVector = new Vector<Vector<String>>();

		ResultSet result = null;

		// query
		String query = "SELECT e.id, e.codigo, e.tipo,"
				+ " e.capacidade, m.data FROM " + extintor.getTable() + " e"
				+ " INNER JOIN manutencao m ON e.id_manutencao = m.id" 
				+ " WHERE e.status = 'a' ORDER BY e.codigo, m.data DESC;";

		// armazena e executa a query
		storage(query);
		result = execute();

		// enquanto tiver resultados
		while (result.next()) {
			// vetor de string
			Vector<String> data = new Vector<String>();

			// adiciona resultados aos índices do vetor de string
			data.add(result.getString(1));
			data.add(result.getString(2));

			switch (result.getString(3)) {
				case "a" : data.add("Água"); break;
				case "c" : data.add("CO2"); break;
				case "e" : data.add("Espuma Mecânica"); break;
				case "p" : data.add("Pó Químico"); break;
			}

			data.add(result.getString(4));
			data.add(result.getString(5));

			// adiciona o vetor de string na matriz
			dataVector.add(data);
		}

		// retorna matriz
		return dataVector;
	}

	/**
	 * Método para listagem
	 * Um parâmetro: pesquisa livre
	 * @param where
	 * @return Vector<Vector<String>>
	 * @throws SQLException
	 */
	public Vector<Vector<String>> read(String where) throws SQLException {
		// matriz : vetor de vetor de string 
		Vector<Vector<String>> dataVector = new Vector<Vector<String>>();

		ResultSet result = null;

		// query concatenando a pesquisa realizada pelo usuário
		String query = "SELECT e.id, e.codigo, e.tipo,"
				+ " e.capacidade, m.data FROM " + extintor.getTable() + " e"
				+ " INNER JOIN manutencao m ON e.id_manutencao = m.id" 
				+ " WHERE e.status = 'a' AND (" 
				+ " e.codigo LIKE '%" + where + "%' OR" 
				+ " e.tipo LIKE '%" + where + "%' OR"
				+ " e.capacidade LIKE '%" + where + "%' OR"
				+ " m.data LIKE '%" + where + "%')"
				+ " ORDER BY e.codigo, m.data DESC;";

		// armazena e executa a query
		storage(query);
		result = execute();

		// enquanto tiver resultados
		while (result.next()) {
			// vetor de string
			Vector<String> data = new Vector<String>();

			// adiciona resultados aos índices do vetor de string
			data.add(result.getString(1));
			data.add(result.getString(2));

			switch (result.getString(3)) {
				case "a" : data.add("Água"); break;
				case "c" : data.add("CO2"); break;
				case "e" : data.add("Espuma Mecânica"); break;
				case "p" : data.add("Pó Químico"); break;
			}

			data.add(result.getString(4));
			data.add(result.getString(5));

			// adiciona o vetor de string na matriz
			dataVector.add(data);
		}

		// retorna matriz
		return dataVector;
	}

	/**
	 * Método para listagem
	 * Dois parâmetros: pesquisa livre com combobox
	 * @param where
	 * @return Vector<Vector<String>>
	 * @throws SQLException
	 */
	public Vector<Vector<String>> read(String where, String type) throws SQLException {
		// matriz : vetor de vetor de string
		Vector<Vector<String>> dataVector = new Vector<Vector<String>>();

		ResultSet result = null;

		String query = "";
		if (where == null) {
			query = "SELECT e.id, e.codigo, e.tipo,"
					+ " e.capacidade, m.data FROM " + extintor.getTable() + " e"
					+ " INNER JOIN manutencao m ON e.id_manutencao = m.id" 
					+ " WHERE e.status = 'a' " 
					+ " AND e.tipo = '" + type + "'"
					+ " ORDER BY e.codigo, m.data DESC;";
		} else {
			query = "SELECT e.id, e.codigo, e.tipo,"
					+ " e.capacidade, m.data FROM " + extintor.getTable() + " e"
					+ " INNER JOIN manutencao m ON e.id_manutencao = m.id" 
					+ " WHERE e.status = 'a'" 
					+ " AND e.tipo = '" + type + "' AND (" 
					+ " e.codigo LIKE '%" + where + "%' OR" 
					+ " e.tipo LIKE '%" + where + "%' OR"
					+ " e.capacidade LIKE '%" + where + "%' OR"
					+ " m.data LIKE '%" + where + "%')"
					+ " ORDER BY e.codigo, m.data DESC;";
		}

		// armazena e executa a query
		storage(query);
		result = execute();

		// enquanto tiver resultados
		while (result.next()) {
			// vetor de string
			Vector<String> data = new Vector<String>();

			// adiciona resultados aos índices do vetor de string
			data.add(result.getString(1));
			data.add(result.getString(2));

			switch (result.getString(3)) {
				case "a" : data.add("Água"); break;
				case "c" : data.add("CO2"); break;
				case "e" : data.add("Espuma Mecânica"); break;
				case "p" : data.add("Pó Químico"); break;
			}

			data.add(result.getString(4));
			data.add(result.getString(5));

			// adiciona o vetor de string na matriz
			dataVector.add(data);
		}

		// retorna matriz
		return dataVector;
	}	
}