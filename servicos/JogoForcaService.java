package servicos;

import aplicacao.Aplicacao;
import dominio.Boneco;
import dominio.Jogador;
import dominio.Palavra;
import dominio.Rodada;
import repositorios.PalavraRepository;
import repositorios.RepositoryException;
import repositorios.RodadaRepository;
import repositorios.TemaRepository;

public class JogoForcaService {

	private JogoForcaService soleInstance;
	
	private JogoForcaService(){}
	
	public JogoForcaService getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new JogoForcaService();
		}
		return soleInstance;
	}
	
	public Rodada novaRodada(Jogador jogador, Boneco boneco, TemaRepository temaRepository, PalavraRepository palavraRepository);
	public void novaPalavra(Palavra palavra, PalavraRepository repository) throws PalavraRepetidaException;
	public void salvarRodada(Rodada rodada, RodadaRepository repository) throws RepositoryException;
	
}
