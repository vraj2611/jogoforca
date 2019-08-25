package dominio;

public class Rodada extends ObjetoDominioImpl {

	private int maxPalavras = 3;
	private int maxErros = 10;
	private int pontosQuandoDescobreTodasAsPalavras = 100; 
	private int pontosPorLetraEncoberta = 15;
	
	private Item[] itens;
	private Jogador jogador;
	private Boneco boneco;
	
	public Rodada(long id, Item[] itens, Letra[] erradas, Jogador jogador, Boneco boneco) {
		super(id);
		this.jogador = jogador;
		this.boneco = boneco;
		this.itens = itens;
	}
	public Rodada(long id, Palavra[] palavra, Jogador jogador, Boneco boneco) {
		super(id);
		this.jogador = jogador;
		this.boneco = boneco;
	}
	
	public int getNumPalavras() {
		return itens.length;
	}
	
	public Palavra[] getPalavras() {
		int qtd = this.itens.length;
		Palavra[] palavras = new Palavra[qtd];
		for(int c = 0; c < qtd; c++) {
			palavras[c] = this.itens[c].getPalavra();
		}
		return palavras;
	}
	
	public Tema getTema() {
		return this.itens[0].getPalavra().getTema();
	}
	
	public Jogador getJogador() {
		return this.jogador;
	}
	
	public int getQtdeAcertos() {
		
	}
	
	public int getQtdeErros() {
		
	}
	
	public int getQtdeTentativaRestantes() {
		
	}
	
	public boolean arriscou() {
		this.itens[0].arriscou();
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
		for(int c = 0; c < this.itens.length; c++) {
			this.itens[c].getPalavra().exibir();
		}

	}
	
	public void exibirBoneco() {
		this.boneco.exibir(this.getQtdeErros());
	}
	
	public void exibirItens() {
		for(int c = 0; c < this.itens.length; c++) {
			this.itens[c].exibir();
		}		
	}
	
	public void arriscar(String[] palavras) {
		
	}
	
	public void tentar(char codigo) {
		for(int c = 0; c < this.itens.length; c++) {
			this.itens[c].tentar(codigo);
		}
	}

}
