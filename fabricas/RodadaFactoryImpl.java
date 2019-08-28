package fabricas;

import repositorios.PalavraRepository;
import repositorios.Repository;
import repositorios.RodadaRepository;

public abstract class RodadaFactoryImpl extends EntityFactory implements RodadaFactory {

	private static PalavraRepository palavraRepository;
	private static RodadaRepository rodadaRepository;
	private static RodadaFactory rodadaFactory;
	
	
	protected RodadaFactoryImpl(PalavraRepository palavraRepository, RodadaRepository rodadaRepository, RodadaFactory rodadaFactory){		
		super(rodadaRepository);
		RodadaFactoryImpl.palavraRepository = palavraRepository;
		RodadaFactoryImpl.rodadaFactory = rodadaFactory;
		RodadaFactoryImpl.rodadaRepository = rodadaRepository;

	}

}
