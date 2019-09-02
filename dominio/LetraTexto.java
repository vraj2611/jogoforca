package dominio;

import gui.ExibidorTexto;

public class LetraTexto extends Letra {

	public LetraTexto(char codigo) {
		super(codigo);
	}

	@Override
	public void exibir(Object contexto) {
		ExibidorTexto exib = (ExibidorTexto)contexto;
		exib.adicionar(this.toString().toUpperCase());
	}
}
