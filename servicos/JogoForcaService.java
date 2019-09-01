package servicos;

import dominio.Jogador;
import dominio.Palavra;
import dominio.Rodada;
import fabricas.RodadaFactory;
import repositorios.PalavraRepository;
import repositorios.RodadaRepository;
import repositorios.RepositoryException;

public class JogoForcaService {

	private static JogoForcaService soleInstance;

	private static PalavraRepository palavraRepository;
	private static RodadaRepository rodadaRepository;
	private static RodadaFactory rodadaFactory;

	public static void createSoleInstance(PalavraRepository palavraRepository, RodadaRepository rodadaRepository, RodadaFactory rodadaFactory){
		soleInstance = new JogoForcaService(palavraRepository, rodadaRepository, rodadaFactory);
	}

	public static JogoForcaService getSoleInstance() {
		return soleInstance;
	}
	
	private JogoForcaService(PalavraRepository palavraRepository, RodadaRepository rodadaRepository, RodadaFactory rodadaFactory){
		JogoForcaService.palavraRepository = palavraRepository;
		JogoForcaService.rodadaFactory = rodadaFactory;
		JogoForcaService.rodadaRepository = rodadaRepository;
	}
	
	public void novaPalavra(Palavra palavra) throws PalavraRepetidaException, RepositoryException {
		Palavra antiga = palavraRepository.getPalavra(palavra.toString());
		if (antiga.toString().equals((palavra.toString())) && antiga.getTema().equals(palavra.getTema())) {
			throw new PalavraRepetidaException(palavra);	
		}
		
		try {
			palavraRepository.inserir(palavra);
		} catch (Exception e) {
			throw new RepositoryException();
		}
	}

	public Rodada novaRodada(Jogador jogador) {
		return rodadaFactory.getRodada(jogador);
	}
		
	public void salvarRodada(Rodada rodada) throws RepositoryException {		
		try {
			rodadaRepository.inserir(rodada);
		} catch (Exception e) {
			throw new RepositoryException();
		}
	}
	
}
