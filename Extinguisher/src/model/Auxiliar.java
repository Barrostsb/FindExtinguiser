package model;

/**
 * @author Thiago Henrique Poiani
 * @author Thiago Silva Barros
 */
public class Auxiliar extends Usuario {
	private char tipo; // Flag: 'a', 'e'

	/**
	 * @return the tipo
	 */
	@Override
	public char getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	@Override
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
}
