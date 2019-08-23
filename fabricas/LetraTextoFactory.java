package fabricas;

import dominio.Letra;

public class LetraTextoFactory extends LetraFactoryImpl {

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Letra getLetraEncoberta() {
		// TODO Auto-generated method stub
		return null;
	}

}
