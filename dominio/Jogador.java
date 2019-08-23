package dominio;

public class Jogador extends ObjetoDominioImpl{
	private String nome;
	private int pontuacao = 0;
	
	
	public Jogador(long id, String nome, int pontuacao) {
		super(id);
		this.nome = nome;
		this.pontuacao = pontuacao;
	}

	public Jogador(long id, String nome) {
		super(id);
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	
}
