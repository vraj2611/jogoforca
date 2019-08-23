package dominio;

public abstract class Letra {

	private char codigo;
	
	public Letra(char codigo) {
		this.codigo = codigo;
	}

	public char getCodigo() {
		return codigo;
	}
	
	public final String toString() {
		return "q";//this.codigo
	}

	@Override
	public int hashCode() {
		return this.codigo + this.getClass().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Letra)) return false;
		Letra outra = (Letra) obj;
		return this.codigo == outra.codigo && this.getClass().equals(outra.getClass());
	}


}
