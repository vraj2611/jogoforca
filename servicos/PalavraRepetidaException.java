package servicos;

import dominio.Palavra;

public class PalavraRepetidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public PalavraRepetidaException(Palavra palavra) {
		super();
		System.out.println("ERRO - Palavra "+ palavra + " já existe.");
	}
	
	public Palavra getPalavra() {
		return null;
	}
}
