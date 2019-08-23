package dominio;

public class Item extends ObjetoDominioImpl {

	private boolean[] posicoesDescobertas;
	private String palavraArriscada = null;
	private Palavra palavra;
	
	public Item(int id, Palavra palavra, int[] posicoesDescobertas, String palavraArriscada) {
		super(id);
		this.palavra = palavra;
		//this.posicoesDescobertas = posicoesDescobertas;
		this.palavraArriscada = palavraArriscada;
	}
	
	public Item(int id, Palavra palavra) {
		super(id);
		this.palavra = palavra;
		
	}

	public Palavra getPalavra() {
		return this.palavra;
	}

	public String getPalavraArriscada() {
		return this.palavraArriscada;
	}
	
	void arriscar(String palavra) {
		if(this.palavraArriscada.isEmpty()) { 
			this.palavraArriscada = palavra;
		}
	}
	
	boolean tentar(char codigo) {
		if (this.palavra.tentar(codigo).length > 0) {
			return true;
		}
		return false;
	}
	
	public void exibir() {
		this.palavra.exibir();
	}
	
	public boolean acertou() {
		return this.palavra.comparar(this.palavraArriscada);
	}

	
	public boolean arriscou() {
		return this.palavraArriscada == null;
	}
	
	public boolean descobriu() {
		return this.acertou() || this.getLetrasEncobertas().length == 0;
	}
	
	public int calcularPontosLetrasEncobertas(int valorPorLetraEncoberta) {
		return valorPorLetraEncoberta * this.qtdeLetrasEncobertas();
	}
	
	public int qtdeLetrasEncobertas() {
		return this.getLetrasEncobertas().length;
	}
	
	public Letra[] getLetrasEncobertas() {
		
	}
	
	public Letra[] getLetrasDescobertas() {
		
	}

}
