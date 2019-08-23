package fabricas;

import java.util.HashSet;

import dominio.Letra;

public abstract class LetraFactoryImpl implements LetraFactory {

	private HashSet<Letra> pool;
	private Letra encoberta;
	
	protected Letra criarLetra(char codigo) {
		return null;
		
	}
}
