package dominio;

public class BonecoImagem implements Boneco {

	private BonecoImagem() {}

	@Override
	public void exibir(int partes) {
		
	}
	
	
	public BonecoImagem getSoleInstance() {
		BonecoImagem bonecoImagem = new BonecoImagem();
		return bonecoImagem;
	}
	
}
