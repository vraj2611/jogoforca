package dominio;

import java.util.ArrayList;
import fabricas.LetraFactory;

public class Palavra extends ObjetoDominioImpl {
	
	private Tema tema;
	private Letra encoberta;
	private Letra[] letras;
	
	
	public Palavra(long id, String palavra, Tema tema, LetraFactory factory) {
		super(id);
		this.tema = tema;
		this.encoberta = factory.getLetraEncoberta();
		for(int c = 0; c < palavra.length(); c++) {
			this.letras[c] = factory.getLetra(palavra.charAt(c));
		}
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
				letra.exibir();
			} else {
				this.encoberta.exibir();
			}
			
		}	
	}
	
	public void exibir() {
		for(int c = 0; c < this.letras.length ; c++) {
			Letra letra = this.letras[c];
			letra.exibir();
		}
	}
	
	public Letra getLetra(int posicao) {
		return this.letras[posicao];
	}
	
	public Letra[] getLetras() {
		return this.letras;
	}
	
}
