package fabricas;

import java.util.HashMap;

import dominio.Letra;
import dominio.LetraTexto;

public class LetraTextoFactory extends LetraFactoryImpl {

	private Letra encoberta;
	private HashMap<Character, Letra> pool;
	
	private static LetraTextoFactory soleInstance;
	
	private LetraTextoFactory() {}
	
	public static LetraTextoFactory getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new LetraTextoFactory();
		}
		return soleInstance;
	}
	
	@Override
	public Letra getLetra(char codigo) {
		if (!this.pool.containsKey(codigo)) {
			this.pool.put(codigo, new LetraTexto(codigo));
		}
		return this.pool.get(codigo);
	}

	@Override
	public Letra getLetraEncoberta() {
		if (encoberta == null) {
			this.encoberta = new LetraTexto(new Character('*'));
		}
		return this.encoberta;
	}

}
