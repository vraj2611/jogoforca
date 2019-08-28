package fabricas;

import java.util.Random;

import dominio.Jogador;
import dominio.Palavra;
import dominio.Rodada;
import dominio.Tema;
import repositorios.RodadaRepository;

public class RodadaSorteioFactory extends RodadaFactoryImpl implements RodadaFactory {

	private static RodadaSorteioFactory soleInstance;
	
	private RodadaSorteioFactory(){
		super(repository);
	}
	
	public static RodadaSorteioFactory getSoleInstance() {
		return null;
	}
	
	public static void createSoleInstance(RodadaRepository repository){
		soleInstance = new RodadaSorteioFactory(repository);
	}

	@Override
	public Rodada getRodada(Jogador jogador) {
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

	
}
