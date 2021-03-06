package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import model.Usuario;





/**
 * Classe para Data Access Object 
 * @author Thiago Henrique Poiani
 * @author Thiago Silva Barros
 */
public class UsuarioDAO extends DAO {

	private Usuario usuario;

	/**
	 * Construtor da classe DAO, que instancia a classe Mysql
	 * @throws SQLException
	 */
	public UsuarioDAO(Usuario usuario) throws SQLException {
		super();
		this.usuario = usuario;
	}

	/**
	 * M�todo para autentica��o de usu�rio
	 * @return boolean
	 */
	public int auth() {		
		ResultSet result = null;

		// query
		String query = "SELECT * FROM " + this.usuario.getTable()
				+ " WHERE usuario = ? AND senha = md5(?) AND status = ?;";

		// verifica se tem conex�o com o banco
		if (this.connection != null && query != null && !query.isEmpty()) {
			try {
				// atribui a query ao SQL
				PreparedStatement statement = this.connection.prepareStatement(query);

				// seta os valores na consulta
				statement.setString(1, this.usuario.getUsuario());
				statement.setString(2, this.usuario.getSenha());
				statement.setString(3, String.valueOf('a'));

				// executa a query
				result = statement.executeQuery();

				// se existir resultado, retorna true
				if (result.next()) {
					return result.getInt(1);
				} else {
					return 0;
				}
			} catch (SQLException e) {
				return 0;
			}
		}
		return 0;
	}

	/**
	 * M�todo para salvar us�rio, podendo atualizar ou cadastrar
	 */
	@Override
	public void save() throws SQLException {
		if (this.connection != null) {
			if (usuario.getId() == 0) {
				create(usuario);
			} else {
				update(usuario);
			}
		}
	}

	/**
	 * M�todo para listagem
	 * Sem par�metros: consulta padr�o
	 * @return Vector<Vector<String>>
	 * @throws SQLException
	 */
	@Override
	public Vector<Vector<String>> read() throws SQLException {
		// matriz: vetor de vetor de string
		Vector<Vector<String>> dataVector = new Vector<Vector<String>>();

		ResultSet result = null;

		// query
		String query = "SELECT id, nome, cpf, usuario, email FROM " + usuario.getTable() 
				+ " WHERE status = 'a' ORDER BY nome;";

		// armazena e executa a query
		storage(query);
		result = execute();

		// enquanto tiver resultados
		while (result.next()) {
			// vetor de string
			Vector<String> data = new Vector<String>();

			// adiciona resultados aos �ndices do vetor de string
			data.add(result.getString(1));
			data.add(result.getString(2));
			data.add(result.getString(3));
			data.add(result.getString(4));
			data.add(result.getString(5));

			// adiciona o vetor de string na matriz
			dataVector.add(data);
		}

		// retorna matriz
		return dataVector;
	}

	/**
	 * M�todo para listagem
	 * Um par�metro: pesquisa livre
	 * @param where
	 * @return Vector<Vector<String>>
	 * @throws SQLException
	 */
	public Vector<Vector<String>> read(String where) throws SQLException {
		// matriz : vetor de vetor de string 
		Vector<Vector<String>> dataVector = new Vector<Vector<String>>();

		ResultSet result = null;

		// query concatenando a pesquisa realizada pelo usu�rio
		String query = "SELECT id, cpf, nome, usuario, email FROM " + usuario.getTable() 
				+ " WHERE status = 'a' AND (" 
				+ " nome LIKE '%" + where + "%' OR"
				+ " cpf LIKE '%" + where + "%' OR"
				+ " usuario LIKE '%" + where + "%' OR"
				+ " email LIKE '%" + where + "%')"
				+ " ORDER BY nome;";

		// armazena e executa a query
		storage(query);
		result = execute();

		// enquanto tiver resultados
		while (result.next()) {
			// vetor de string
			Vector<String> data = new Vector<String>();

			// adiciona resultados aos �ndices do vetor de string
			data.add(result.getString(1));
			data.add(result.getString(2));
			data.add(result.getString(3));
			data.add(result.getString(4));
			data.add(result.getString(5));

			// adiciona o vetor de string na matriz
			dataVector.add(data);
		}

		// retorna matriz
		return dataVector;
	}

	/**
	 * M�todo para listagem
	 * Dois par�metros: pesquisa livre com combobox
	 * @param where
	 * @return Vector<Vector<String>>
	 * @throws SQLException
	 */
	public Vector<Vector<String>> read(String where, String column) throws SQLException {
		// matriz : vetor de vetor de string
		Vector<Vector<String>> dataVector = new Vector<Vector<String>>();

		ResultSet result = null;

		// query concatenando apenas a consulta da combobox
		String query = "SELECT id, cpf, nome, usuario, email FROM " + usuario.getTable() 
				+ " WHERE status = 'a' AND " + column + " = '" + where + "'"
				+ " ORDER BY nome;";

		// armazena e executa a query
		storage(query);
		result = execute();

		// enquanto tiver resultados
		while (result.next()) {
			// vetor de string
			Vector<String> data = new Vector<String>();

			// adiciona resultados aos �ndices do vetor de string
			data.add(result.getString(1));
			data.add(result.getString(2));
			data.add(result.getString(3));
			data.add(result.getString(4));
			data.add(result.getString(5));

			// adiciona o vetor de string na matriz
			dataVector.add(data);
		}

		// retorna matriz
		return dataVector;
	}	
}