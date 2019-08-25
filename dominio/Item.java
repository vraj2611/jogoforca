package dominio;

import java.util.HashSet;

public class Item extends ObjetoDominioImpl {

	private boolean[] posicoesDescobertas;
	private String palavraArriscada = null;
	private Palavra palavra;
	
	public Item(int id, Palavra palavra) {
		super(id);
		this.palavra = palavra;
		this.posicoesDescobertas = new boolean[this.palavra.getTamanho()];
		for(int p = 0; p < this.palavra.getTamanho(); p++) {
			this.posicoesDescobertas[p] = false;
		}
	}
	
	public Item(int id, Palavra palavra, boolean[] posicoesDescobertas, String palavraArriscada) {
		super(id);
		this.palavra = palavra;
		this.posicoesDescobertas = posicoesDescobertas;
		this.palavraArriscada = palavraArriscada;
	}
	
	public Palavra getPalavra() {
		return this.palavra;
	}

	public String getPalavraArriscada() {
		return this.palavraArriscada;
	}
	
	void arriscar(String palavra) {
		if(!this.arriscou()) { 
			this.palavraArriscada = palavra;
		}
	}

	public boolean arriscou() {
		return this.palavraArriscada != null;
	}
	
	public void exibir() {
		this.palavra.exibir();
	}
	
	public boolean acertou() {
		return this.palavra.comparar(this.palavraArriscada);
	}

	public boolean descobriu() {
		return this.acertou() || this.getLetrasEncobertas().length == 0;
	}
	
	public int calcularPontosLetrasEncobertas(int valorPorLetraEncoberta) {
		return valorPorLetraEncoberta * this.qtdeLetrasEncobertas();
	}
	
	boolean tentar(char codigo) {
		int[] acertos = this.palavra.tentar(codigo);
		for(int c = 0; c < acertos.length; c++) {
			this.posicoesDescobertas[acertos[c]] = true;
		}
		return acertos.length > 0;
	}

	public int qtdeLetrasEncobertas() {
		int qtd = 0;
		for(int c = 0; c < this.posicoesDescobertas.length; c++) {
			if (!this.posicoesDescobertas[c]) {
				qtd++;
			}
		}
		return qtd;
	}
	
	public Letra[] getLetrasEncobertas(){
		HashSet<Letra> letrasEncobertas = new HashSet<Letra>();
		for(int c = 0; c < this.palavra.getTamanho(); c++) {
			if(!this.posicoesDescobertas[c]) {
				letrasEncobertas.add(this.palavra.getLetra(c));
			}
		}	
		return (Letra[])letrasEncobertas.toArray();
	}
	
	public Letra[] getLetrasDescobertas() {
		HashSet<Letra> letrasDescobertas = new HashSet<Letra>();
		for(int c = 0; c < this.palavra.getTamanho(); c++) {
			if(this.posicoesDescobertas[c]) {
				letrasDescobertas.add(this.palavra.getLetra(c));
			}
		}	
		return (Letra[])letrasDescobertas.toArray();
	}

}
