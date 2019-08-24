package dominio;

public class Rodada extends ObjetoDominioImpl {

	private int maxPalavras = 3;
	private int maxErros = 10;
	private int pontosQuandoDescobreTodasAsPalavras = 100; 
	private int pontosPorLetraEncoberta = 15;
	
	private Item[] itens;
	private Jogador jogador;
	private Letra[] erradas;
	private Boneco boneco;
	private Palavra[] palavra;
	
	public Rodada(long id, Item[] itens, Letra[] erradas, Jogador jogador, Boneco boneco) {
		super(id);
		this.itens = itens;
		this.erradas = erradas;
		this.jogador = jogador;
		this.boneco = boneco;
	}
	public Rodada(long id, Palavra[] palavra, Jogador jogador, Boneco boneco) {
		super(id);
		this.palavra = palavra;
		this.jogador = jogador;
		this.boneco = boneco; 
	}
	
	public int getNumPalavras() {
		return itens.length;
	}
	
	public Palavra[] getPalavras() {
		return this.palavra;
	}
	
	public Tema getTema() {
		return this.palavra[0].getTema();
	}
	
	public Jogador getJogador() {
		return this.jogador;
	}
	
	public int getQtdeAcertos() {
		int acertos = 0;
		
		for(int i=0; i < this.itens.length; i++) {
			acertos += this.itens[i].qtdeLetrasEncobertas();
		}
		
		return acertos;
	}
	
	public int getQtdeErros() {
		return this.erradas.length;
	}
	
	public int getQtdeTentativaRestantes() {
		
	}
	
	public boolean arriscou() {
		
	}
	
	public boolean descobriu() {
		
	}
	
	public boolean encerrou() {
		
	}
	
	public int calcularPontos() {
		
	}
	
	public Letra[] getErradas() {
		
	}

	public Letra[] getCertas() {
		
	}

	public Letra[] getTentativas() {
		
	}
	
	public void exibirPalavras() {
		
	}
	
	public void exibirBoneco() {
		
	}
	
	public void exibirItens() {
		
	}
	
	public void arriscar(String[] palavras) {
		
	}
	
	public void tentar(char codigo) {
		
	}
	


	
}
