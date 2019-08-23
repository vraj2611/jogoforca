package servicos;

import dominio.Palavra;

public class PalavraRepetidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public PalavraRepetidaException(Palavra palavra) {
	}
	
	public Palavra getPalavra() {
		return null;
	}
}
