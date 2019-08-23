package dominio;

public class Rodada extends ObjetoDominioImpl {

	private int maxPalavras = 3;
	private int maxErros = 10;
	private int pontosQuandoDescobreTodasAsPalavras = 100; 
	private int pontosPorLetraEcnoberta = 15;
	
	private Item[] itens;
	private Jogador jogador;
	
	public Rodada(long id, Item[] itens, Letra[] erradas, Jogador jogador, Boneco boneco) {
		super(id);
	}
	public Rodada(long id, Palavra[] palavra, Jogador jogador, Boneco boneco) {
		super(id);
	}
	
	public int getNumPalavras() {
		return itens.length;
	}
	
	public Palavra[] getPalavras() {
		
	}
	
	public Tema getTema() {
		
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
