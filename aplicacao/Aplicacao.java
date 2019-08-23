package aplicacao;

import java.util.ArrayList;

import fabricas.ElementoGraficoFactory;
import repositorios.RepositoryFactory;

public class Aplicacao {

	private String tipoRepositoryFactory;
	private String tipoElementoGraficoFactory;
	private static Aplicacao soleInstance;
	
	private Aplicacao() {}
	
	public static Aplicacao getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new Aplicacao();
		}
		return soleInstance;
	}

	public void setTipoElementoGraficoFactory(String tipo) {
		this.tipoElementoGraficoFactory = tipo;
	}
	
	public String[] getTiposElementoGraficoFactory() {
		ArrayList<String> tipos = new ArrayList<String>();
		tipos.add("Texto");
		tipos.add("Imagem");
		return (String[]) tipos.toArray();
		
	}
	
	public RepositoryFactory getRepositoryFactory() {
		return null;
	}
	
	public void setTipoRepositoryFactory(String tipo) {
		this.tipoRepositoryFactory = tipo;
	}
	
	public String[] getTiposRepositoryFactory() {
		ArrayList<String> tipos = new ArrayList<String>();
		tipos.add("Memoria");
		tipos.add("BancoDadosRelacional");
		return (String[]) tipos.toArray();
	}

	public ElementoGraficoFactory getElementoGraficoFactory() {
		return null;
	}

}
