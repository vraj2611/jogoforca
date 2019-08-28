package aplicacao;

import dominio.Palavra;
import dominio.Rodada;
import fabricas.ElementoGraficoFactory;
import fabricas.ElementoGraficoImagemFactory;
import fabricas.ElementoGraficoTextoFactory;
import fabricas.JogadorFactory;
import fabricas.JogadorFactoryImpl;
import fabricas.PalavraFactory;
import fabricas.PalavraFactoryImpl;
import fabricas.RodadaFactory;
import fabricas.RodadaSorteioFactory;
import fabricas.TemaFactory;
import fabricas.TemaFactoryImpl;
import repositorios.BDRRepositoryFactory;
import repositorios.MemoriaRepositoryFactory;
import repositorios.RepositoryFactory;
import servicos.JogoForcaService;

public class Aplicacao {
	
	private final String[] TIPOS_REPOSITORY_FACTORY = {"memoria", "relacional"};
	private final String[] TIPOS_ELEMENTO_GRAFICO_FACTORY = {"texto", "imagem"};
	private final String[] TIPOS_RODADA_FACTORY = {"sorteio"};
	
	private String tipoRepositoryFactory = this.TIPOS_REPOSITORY_FACTORY[0];
	private String tipoElementoGraficoFactory = this.TIPOS_ELEMENTO_GRAFICO_FACTORY[0];
	private String tipoRodadaFactory = this.TIPOS_RODADA_FACTORY[0];
	
	private static Aplicacao soleInstance;
	
	private Aplicacao() {}
	
	public static Aplicacao getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new Aplicacao();
		}
		return soleInstance;
	}
	
	public String[] getTiposRepositoryFactory() {
		return this.TIPOS_REPOSITORY_FACTORY; 
	}

	public void setTipoRepositoryFactory(String tipo) {
		this.tipoRepositoryFactory = tipo;
		this.setup();
	}
	
	public RepositoryFactory getRepositoryFactory() {
		RepositoryFactory factory = null;
		String tipo = this.tipoRepositoryFactory;
		
		if (tipo.equals("memoria")) {
			factory = MemoriaRepositoryFactory.getSoleInstance();
		}
		
		if (tipo.equals("relacional")) {
			factory = BDRRepositoryFactory.getSoleInstance();
		}
		
		return factory;
	}
	

	public String[] getTiposElementoGraficoFactory() {
		return this.TIPOS_ELEMENTO_GRAFICO_FACTORY;	
	}
	
	public void setTipoElementoGraficoFactory(String tipo) {
		this.tipoElementoGraficoFactory = tipo;
		this.setup();
	}

	public ElementoGraficoFactory getElementoGraficoFactory() {
		ElementoGraficoFactory factory = null;
		String tipo = this.tipoElementoGraficoFactory;
		
		if(tipo.equals("texto")) {
			factory = ElementoGraficoTextoFactory.getSoleInstance();
		}
		
		if(tipo.equals("imagem")) {
			factory = ElementoGraficoImagemFactory.getSoleInstance();
		}
		
		return factory;
	}
	
	
	public String[] getTiposRodadaFactory() {
		return this.TIPOS_RODADA_FACTORY;
	}
	
	public void setTipoRodadaFactory(String tipo) {
		this.tipoRodadaFactory = tipo;
		this.setup();
	}
	
	public RodadaFactory getRodadaFactory() {
		RodadaFactory factory = null;
		if (this.tipoRodadaFactory.equals("sorteio")) {
			factory = RodadaSorteioFactory.getSoleInstance();
		};
		return factory;
	}
	
	public TemaFactory getTemaFactory() {
		return TemaFactoryImpl.getSoleInstance();
	}
	
	public PalavraFactory getPalavraFactory() {
		return PalavraFactoryImpl.getSoleInstance();
	}
	
	public JogadorFactory getJogadorFactory() {
		return JogadorFactoryImpl.getSoleInstance(); 
	}
	
	public void setup() {
		RepositoryFactory repo = this.getRepositoryFactory();
		TemaFactoryImpl.createSoleInstance(repo.getTemaRepository());
		PalavraFactoryImpl.createSoleInstance(repo.getPalavraRepository());
		JogadorFactoryImpl.createSoleInstance(repo.getJogadorRepository());
		RodadaSorteioFactory.createSoleInstance(
				repo.getRodadaRepository(), repo.getPalavraRepository(), repo.getTemaRepository());
		
		JogoForcaService.createSoleInstance(
			repo.getPalavraRepository(), repo.getRodadaRepository(), this.getRodadaFactory());
		
		ElementoGraficoFactory egf = this.getElementoGraficoFactory();
		Palavra.setLetraFactory(egf);
		Rodada.setBonecoFactory(egf);
	}
}
