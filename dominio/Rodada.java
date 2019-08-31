package dominio;

import java.util.HashSet;
import java.io.PrintStream;

public class Rodada extends ObjetoDominioImpl {
	
	private static int maxPalavras;
	private static int maxErros;
	private static int pontosQuandoDescobreTodasAsPalavras; 
	private static int pontosPorLetraEncoberta;
	
	private Jogador jogador;
	private Item[] itens;
	private Letra[] erradas;
	private PrintStream printStream;
	
	private static BonecoFactory bonecoFactory;
	
	public static int getMaxPalavras() {
		return maxPalavras;
	}
	
	public static void setMaxPalavras(int max) {
		maxErros = max;
	}
	
	public static int getMaxErros() {
		return maxErros;
	}
	
	public static void setMaxErros(int max) {
		maxErros = max;
	}
	
	public static int pontosQuandoDescobreTodasAsPalavras() {
		return pontosQuandoDescobreTodasAsPalavras;
	}
	
	public static void pontosQuandoDescobreTodasAsPalavras(int pontos) {
		pontosQuandoDescobreTodasAsPalavras = pontos;
	}
	
	public static int pontosPorLetraEncoberta() {
		return pontosPorLetraEncoberta;
	}
	
	public static void pontosPorLetraEncoberta(int pontos) {
		pontosPorLetraEncoberta = pontos;
	}
	
	public static void setBonecoFactory(BonecoFactory factory) {
		bonecoFactory = factory;
	}
	
	public static BonecoFactory getBonecoFactory() {
		return bonecoFactory;
	}
	
	public static Rodada criar(long id, Palavra[] palavras, Jogador jogador) {
		return new Rodada(id, palavras, jogador);
	}
	
	public static Rodada reconstituir(long id, Item[] itens, Letra[] erradas, Jogador jogador) {
		return new Rodada(id, itens, erradas, jogador);
	}
	
	private Rodada(long id, Palavra[] palavras, Jogador jogador) {
		super(id);
		this.jogador = jogador;
		int qtdPalavras = palavras.length;
		if (qtdPalavras > maxPalavras) {
			qtdPalavras = maxPalavras;
		}
		this.itens = new Item[qtdPalavras];
		for(int c = 0; c < qtdPalavras; c++) {
			this.itens[c] = Item.criar(id, palavras[c]);
		}
	}
	
	private Rodada(long id, Item[] itens, Letra[] erradas, Jogador jogador) {
		super(id);
		this.itens = itens;
		this.erradas = erradas;
		this.jogador = jogador;
	}
	
	public int getNumPalavras() {
		return itens.length;
	}
	
	public Palavra[] getPalavras() {
		Palavra[] palavras = new Palavra[this.itens.length];
		for(int c = 0; c < palavras.length; c++) {
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

	public void exibirPalavras() {
		for(int c = 0; c < this.itens.length; c++) {
			this.itens[c].getPalavra().exibir();
		}

	}
	
	public void exibirBoneco() {
		bonecoFactory.getBoneco().exibir(this.printStream, this.getQtdeErros());
	}
	
	public void exibirItens() {
		for(int c = 0; c < this.itens.length; c++) {
			this.itens[c].exibir();
		}		
	}
	
	public void arriscar(String[] palavras) {
		if (!this.encerrou()) {
			for(int i = 0; i < this.itens.length; i++) {
				this.itens[i].arriscar(palavras[i]);
			}
		}
		if(this.encerrou()) {
			this.jogador.setPontuacao(this.calcularPontos());
		}
	}
		
	public int getQtdeAcertos() {
		int acertos = 0;
		
		for(int i = 0; i < this.itens.length; i++) {
			acertos += this.itens[i].qtdeLetrasEncobertas();
		}
		
		return acertos;
	}
	
	public int getQtdeErros() {
		return this.erradas.length;
	}
	
	public int getQtdeTentativaRestantes() {
		return maxErros - this.getQtdeErros();
	}
	
	public boolean arriscou() {
		return this.itens[0].arriscou();
	}
	
	public boolean descobriu() {
		for(Item i : this.itens) {
			if (!i.descobriu()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean encerrou() {
		return this.descobriu() || this.arriscou() || this.erradas.length == maxErros;
	}
	
	public int calcularPontos() {
		if(!this.descobriu()) {
			return 0;
		}
		
		int qtdLetrasEncobertas = 0;
		for(Item i : this.itens) {
			qtdLetrasEncobertas += i.qtdeLetrasEncobertas();
		}
		return pontosQuandoDescobreTodasAsPalavras + (pontosPorLetraEncoberta * qtdLetrasEncobertas);
		
	}
	
	public Letra[] getErradas() {
		return this.erradas;
	}

	public Letra[] getCertas() {
		HashSet<Letra> certas = new HashSet<Letra>();
		for(Item i: this.itens) {
			for(Letra l : i.getLetrasDescobertas()) {
				certas.add(l);
			}
		}
		return (Letra[])certas.toArray();
	}

	public Letra[] getTentativas() {
		HashSet<Letra> tentativas = new HashSet<Letra>();
		for(Letra l : this.getCertas()) {
			tentativas.add(l);
		}
		for(Letra l : this.getErradas()) {
			tentativas.add(l);
		}
		return (Letra[])tentativas.toArray();
	}
	
	public void tentar(char codigo) {
		if (!this.encerrou()) {
			for(int c = 0; c < this.itens.length; c++) {
				this.itens[c].tentar(codigo);
			}
		}
		if(this.encerrou()) {
			this.jogador.setPontuacao(this.calcularPontos());
		}
	}

}
