package dominio;

import java.util.ArrayList;

public class Palavra extends ObjetoDominioImpl {
	
	private static LetraFactory letraFactory;
	
	private Tema tema;
	private Letra encoberta;
	private Letra[] letras;
	
	public static void setLetraFactory(LetraFactory factory) {
		letraFactory = factory;
	}
	
	public static LetraFactory getLetraFactory() {
		return letraFactory;
	}
	
	private Palavra(long id, String palavra, Tema tema) {
		super(id);
		this.tema = tema;
		this.encoberta = letraFactory.getLetraEncoberta();
		this.encoberta.toString();
		this.letras = new Letra[palavra.length()];
		for(int c = 0; c < palavra.length(); c++) {
			this.letras[c] = letraFactory.getLetra(palavra.charAt(c));
		}
	}
	
	public static Palavra criar(long id, String palavra, Tema tema) {
		return new Palavra(id, palavra, tema);
	}
	
	public static Palavra reconstituir(long id, String palavra, Tema tema) {
		return new Palavra(id, palavra, tema);
	}
	
	public int getTamanho() {
		return letras.length;
	}
	
	public boolean comparar(String palavra) {
		if (this.letras.length != palavra.length()) {
			return false;
		}
		
		for(int c = 0; c < palavra.length(); c++) {
			if (this.letras[c].getCodigo() != palavra.charAt(c)) {
				return false;
			}
		}
		
		return true;
	}
	
	public Tema getTema() {
		return this.tema;
	}
	
	public int[] tentar(char codigo) {
		ArrayList<Integer> posicoesList  = new ArrayList<Integer>();
		for(int c = 0; c < this.letras.length ; c++) {
			if (codigo == this.letras[c].getCodigo()) {
				posicoesList.add(c);
			}
		}
		
		int[] posicoes = new int[posicoesList.size()];
		for (int c = 0; c < posicoesList.size() ; c++) {
			posicoes[c] = posicoesList.get(c);
		}

		return posicoes;
	}
	
	public void exibir(boolean[] posicoes) {
		for(int c = 0; c < posicoes.length ; c++) {
			if (posicoes[c]) {
				Letra letra = this.letras[c];
				letra.exibir(null);
			} else {
				this.encoberta.exibir(null);
			}
			
		}	
	}
	
	public void exibir() {
		for(int c = 0; c < this.letras.length ; c++) {
			Letra letra = this.letras[c];
			letra.exibir(null);
		}
	}
	
	public Letra getLetra(int posicao) {
		return this.letras[posicao];
	}
	
	public Letra[] getLetras() {
		return this.letras;
	}
	
	public String toString() {
		char[] palavra = new char[this.letras.length];
		for (int c = 0 ; c < this.letras.length; c++)
			palavra[c] = this.letras[c].getCodigo();
		return String.copyValueOf(palavra);
	}
	
}
