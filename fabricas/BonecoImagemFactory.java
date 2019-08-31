package fabricas;

import dominio.Boneco;
import dominio.BonecoFactory;

public class BonecoImagemFactory implements BonecoFactory {

	private static BonecoImagemFactory soleInstance;
	
	private BonecoImagemFactory() {}
	
	public static BonecoImagemFactory getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new BonecoImagemFactory();
		}
		return soleInstance;
	}
	
	@Override
	public Boneco getBoneco() {
		return soleInstance.getBoneco();
	}

	
	
}
