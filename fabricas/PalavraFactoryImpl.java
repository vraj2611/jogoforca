package fabricas;

import dominio.Palavra;
import dominio.Tema;
import repositorios.PalavraRepository;
import repositorios.Repository;


public class PalavraFactoryImpl extends EntityFactory implements PalavraFactory {

	private static PalavraFactoryImpl soleInstance;
	
	private PalavraFactoryImpl(PalavraRepository repository) {
		super(repository);
	}

	public static PalavraFactoryImpl getSoleInstance() {
		return soleInstance;
	}
	
	public static void createSoleInstance(PalavraRepository repository){
		soleInstance = new PalavraFactoryImpl(repository);
	}
	
	@Override
	public Palavra getPalavra(String nome, Tema tema) {
		return null;
	}

	private PalavraRepository getPalavraRepository() {
		return (PalavraRepository) this.getRepository();
	}

}	

