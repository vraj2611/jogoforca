package teste;

import java.util.HashMap;
import java.util.Iterator;

import dominio.Palavra;
import dominio.Tema;
import repositorios.PalavraRepository;
import repositorios.RepositoryException;
import repositorios.TemaRepository;

public abstract class LotePalavras {

	public static void inserirPalavras(TemaRepository temaRepo, PalavraRepository pRepo) {
		
		HashMap<String, String[]> mapa = new HashMap<String, String[]>();
		
		String[] p1 = {"Classe", "Objeto", "Metodo", "Heranca", "Poliformismo", "Singleton", "Factory", "Repository"};
		mapa.put("Programação OO", p1);

		String[] p2 = {"Fiat", "Ford", "Audi", "Ferrari", "McLaren"};
		mapa.put("Carros", p2);		

		String[] p3 = {"Vilmar", "Luidi", "Lucas", "Tiago", "Ciro", "Patrick"};
		mapa.put("Alunos do Mark", p3);		

		try {
			Iterator<String> temas = mapa.keySet().iterator();
			while(temas.hasNext()) {
				Tema tema = Tema.criar(temaRepo.getProximoId(), temas.next());
					temaRepo.inserir(tema);
				
				String[] palavras = mapa.get(tema.getNome());
				for(String p : palavras) {
					Palavra palavra = Palavra.criar(pRepo.getProximoId(), p, tema);
					pRepo.inserir(palavra);
				}
			}
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		
	}
}
