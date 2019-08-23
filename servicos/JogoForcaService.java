package servicos;

import java.util.Random;

import dominio.Boneco;
import dominio.Jogador;
import dominio.Palavra;
import dominio.Rodada;
import dominio.Tema;
import repositorios.PalavraRepository;
import repositorios.RodadaRepository;
import repositorios.TemaRepository;
import repositorios.RepositoryException;

public class JogoForcaService {

	private JogoForcaService soleInstance;
	
	private JogoForcaService(){}
	
	public JogoForcaService getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new JogoForcaService();
		}
		return soleInstance;
	}
	
	public Rodada novaRodada(Jogador jogador, Boneco boneco, TemaRepository temaRepository, PalavraRepository palavraRepository) {
		Random random = new Random();
		
		Tema[] temas = temaRepository.getTodos();
		Tema tema = temas[random.nextInt(temas.length) - 1];
		
		Palavra[] palavrasDoTema = palavraRepository.getPorTema(tema);
		
		int quantPalavras = random.nextInt(2) + 1;
		Palavra[] palavras = new Palavra[quantPalavras];
		
		for( int p = 0; p < quantPalavras; p++) {
			Palavra escolhida = null;
			while(escolhida == null && !palavras[p].equals(escolhida)) {
				escolhida = palavrasDoTema[random.nextInt(palavrasDoTema.length) - 1];
				palavras[p] = escolhida;
			}
		}
		
		return new Rodada(0, palavras, jogador, boneco);
	}
	
	public void novaPalavra(Palavra palavra, PalavraRepository repository) throws PalavraRepetidaException, RepositoryException {
		Palavra antiga = repository.getPalavra(palavra.toString());
		if (antiga.toString().equals((palavra.toString())) && antiga.getTema().equals(palavra.getTema())) {
			throw new PalavraRepetidaException(palavra);	
		}
		
		try {
			repository.inserir(palavra);
		} catch (Exception e) {
			throw new RepositoryException();
		}
	}
	
	public void salvarRodada(Rodada rodada, RodadaRepository repository) throws RepositoryException {		
		try {
			repository.inserir(rodada);
		} catch (Exception e) {
			throw new RepositoryException();
		}
	}
	
}
