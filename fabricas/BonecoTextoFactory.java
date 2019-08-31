package fabricas;

import dominio.Boneco;
import dominio.BonecoFactory;

public class BonecoTextoFactory implements BonecoFactory {

	private static BonecoTextoFactory soleInstance;
	
	private BonecoTextoFactory() {}
	
	public static BonecoTextoFactory getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new BonecoTextoFactory();
		}
		return soleInstance;
	}

	@Override
	public Boneco getBoneco() {
		return soleInstance.getBoneco();
	}

	
}
