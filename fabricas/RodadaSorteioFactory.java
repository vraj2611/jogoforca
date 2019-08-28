package fabricas;

import java.util.Random;

import dominio.Jogador;
import dominio.Palavra;
import dominio.Rodada;
import dominio.Tema;
import repositorios.PalavraRepository;
import repositorios.RodadaRepository;
import repositorios.TemaRepository;

public class RodadaSorteioFactory extends RodadaFactoryImpl implements RodadaFactory {

	private static RodadaSorteioFactory soleInstance;
	
	private RodadaSorteioFactory(RodadaRepository repository, PalavraRepository palavraRepository, TemaRepository temaRepository){
		super(repository, palavraRepository, temaRepository);
	}
	
	public static RodadaSorteioFactory getSoleInstance() {
		return soleInstance;
	}
	
	public static void createSoleInstance(RodadaRepository repository, PalavraRepository palavraRepository, TemaRepository temaRepository){
		soleInstance = new RodadaSorteioFactory(repository, palavraRepository, temaRepository);
	}

	@Override
	public Rodada getRodada(Jogador jogador) {
		Random random = new Random();
		
		Tema[] temas = this.getTemaRepository().getTodos();
		Tema tema = temas[random.nextInt(temas.length) - 1];
		
		Palavra[] palavrasDoTema = this.getPalavraRepository().getPorTema(tema);
		
		int quantPalavras = random.nextInt(2) + 1;
		Palavra[] palavras = new Palavra[quantPalavras];
		
		for( int p = 0; p < quantPalavras; p++) {
			Palavra escolhida = null;
			while(escolhida == null && !palavras[p].equals(escolhida)) {
				escolhida = palavrasDoTema[random.nextInt(palavrasDoTema.length) - 1];
				palavras[p] = escolhida;
			}
		}
		return Rodada.criar(this.getProximoId() , palavras, jogador);
	
	}

	
}
