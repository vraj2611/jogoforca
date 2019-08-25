package dominio;

public class Rodada extends ObjetoDominioImpl {

	private int maxPalavras = 3;
	private int maxErros = 10;
	private int pontosQuandoDescobreTodasAsPalavras = 100; 
	private int pontosPorLetraEncoberta = 15;
	
	private Item[] itens;
	private Jogador jogador;
<<<<<<< HEAD
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
=======
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
>>>>>>> be503b8bb78eb49654da9540503daf5804646dd3
	}
	
	public int getNumPalavras() {
		return itens.length;
	}
	
	public Palavra[] getPalavras() {
<<<<<<< HEAD
		int qtd = this.itens.length;
		Palavra[] palavras = new Palavra[qtd];
		for(int c = 0; c < qtd; c++) {
			palavras[c] = this.itens[c].getPalavra();
		}
		return palavras;
	}
	
	public Tema getTema() {
		return this.itens[0].getPalavra().getTema();
=======
		return this.palavra;
	}
	
	public Tema getTema() {
		return this.palavra[0].getTema();
>>>>>>> be503b8bb78eb49654da9540503daf5804646dd3
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
