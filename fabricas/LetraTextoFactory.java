package fabricas;

import dominio.Letra;
import dominio.LetraTexto;

public class LetraTextoFactory extends LetraFactoryImpl {
	
	private static LetraTextoFactory soleInstance;
	
	private LetraTextoFactory() {}
	
	public static LetraTextoFactory getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new LetraTextoFactory();
		}
		return soleInstance;
	}
		
	protected Letra criarLetra(char codigo) {
		if(!Character.isDefined(codigo)) {
			codigo = new Character('*');
		}
		return new LetraTexto(codigo);
	}

}
