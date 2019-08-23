package dominio;

import fabricas.LetraFactory;

public class Palavra extends ObjetoDominioImpl{
	
	private Tema tema;
	private LetraFactory factory;
	private Letra[] encoberta;
	
	
	public Palavra(long id, String palavra, Tema tema, LetraFactory factory) {
		super(id);
		this.tema = tema;
		this.factory = factory;
	}
	
	public int getTamanho() {
		
	}
	
	public boolean comparar(String palavra) {

	}
	
	public Tema getTema() {
		
	}
	
	public int[] tentar(char codigo) {
		
	}
	
	public void exibir(boolean[] posicoes) {
		
	}
	
	public void exibir() {
		
	}
	public Letra[] getLetra(int posicao) {
		
	}
	
	public Letra[] getLetras() {
		
	}
	
}
