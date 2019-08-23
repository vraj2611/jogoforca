package aplicacao;

import java.util.ArrayList;

import fabricas.ElementoGraficoFactory;
import fabricas.ElementoGraficoImagemFactory;
import fabricas.ElementoGraficoTextoFactory;
import repositorios.BDRRepositoryFactory;
import repositorios.MemoriaRepositoryFactory;
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
	
	public String[] getTiposRepositoryFactory() {
		ArrayList<String> tipos = new ArrayList<String>();
		tipos.add("Memoria");
		tipos.add("BancoDadosRelacional");
		return (String[]) tipos.toArray();
	}

	public void setTipoRepositoryFactory(String tipo) {
		this.tipoRepositoryFactory = tipo;
	}
	
	public RepositoryFactory getRepositoryFactory() {
		RepositoryFactory factory = null;
		String tipo = this.tipoRepositoryFactory;
		
		if (tipo.equals("Memoria")) {
			factory = MemoriaRepositoryFactory.getSoleInstance();
		}
		
		if (tipo.equals("BancoDadosRelacional")) {
			factory = BDRRepositoryFactory.getSoleInstance();
		}
		
		return factory;
	}
	
	
	public String[] getTiposElementoGraficoFactory() {
		ArrayList<String> tipos = new ArrayList<String>();
		tipos.add("Texto");
		tipos.add("Imagem");
		return (String[]) tipos.toArray();	
	}
	
	public void setTipoElementoGraficoFactory(String tipo) {
		this.tipoElementoGraficoFactory = tipo;
	}
	
	
	public ElementoGraficoFactory getElementoGraficoFactory() {
		ElementoGraficoFactory factory = null;
		String tipo = this.tipoElementoGraficoFactory;
		
		if(tipo.equals("Texto")) {
			factory = ElementoGraficoTextoFactory.getSoleInstance();
		}
		
		if(tipo.equals("Imagem")) {
			factory = ElementoGraficoImagemFactory.getSoleInstance();
		}
		
		return factory;
	}

}
