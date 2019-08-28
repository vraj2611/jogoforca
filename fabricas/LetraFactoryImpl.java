package fabricas;

import java.util.HashMap;

import dominio.Letra;
import dominio.LetraFactory;

public abstract class LetraFactoryImpl implements LetraFactory {

	protected HashMap<Character, Letra> pool;
	protected Letra encoberta;
	
	protected Letra criarLetra(char codigo) {
		return null;
	}

	@Override
	public final Letra getLetra(char codigo) {
		if (!this.pool.containsKey(codigo)) {
			this.pool.put(codigo, this.criarLetra(codigo));
		}
		return this.pool.get(codigo);
	}
	
	@SuppressWarnings("null")
	@Override
	public final Letra getLetraEncoberta() {
		if (encoberta == null) {
			this.encoberta = this.criarLetra((Character) null);
		}
		return this.encoberta;
	}
	
}
