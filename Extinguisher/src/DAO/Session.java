package DAO;

/**
 * Dados da Sess�o
 * @author Thiago Henrique Poiani
 * @author Thiago Silva Barros
 */
public final class Session {

	private static int id;
	private static String usuario;

	private Session() {}

	/**
	 * @return the id
	 */
	public static int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public static void setId(int id) {
		Session.id = id;
	}

	/**
	 * @return the usuario
	 */
	public static String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public static void setUsuario(String usuario) {
		Session.usuario = usuario;
	}
}
