package fabricas;

import dominio.Letra;

public class LetraImagemFactory extends LetraFactoryImpl {

	private static LetraImagemFactory soleInstance;
	
	private LetraImagemFactory() {}
	
	public static LetraImagemFactory getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new LetraImagemFactory();
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
