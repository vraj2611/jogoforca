package dominio;

public class BonecoTexto implements Boneco {

	private BonecoTexto() {}
	
	@Override
	public void exibir(int partes) {
		// TODO Auto-generated method stub
		
	}
	
	public BonecoTexto getSoleInstance() {
		BonecoTexto bonecoTexto = new BonecoTexto();
		return bonecoTexto;
	}

}
