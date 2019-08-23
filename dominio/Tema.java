package dominio;

public class Tema extends ObjetoDominioImpl{

	private String nome;


	public Tema(long id, String nome) {
		super(id);
		this.nome = nome;
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
