package gui;

import aplicacao.Aplicacao;
import dominio.Jogador;
import dominio.Letra;
import dominio.LetraFactory;
import dominio.Palavra;
import dominio.Rodada;
import dominio.Tema;
import fabricas.JogadorFactory;
import repositorios.JogadorRepository;
import repositorios.PalavraRepository;
import repositorios.TemaRepository;
import servicos.JogoForcaService;
import teste.LotePalavras;

public class IniciarJogo {

	public static void main(String[] args) {

		Aplicacao app = Aplicacao.getSoleInstance();
		JogoForcaService appServ =JogoForcaService.getSoleInstance();
		JogadorFactory jogadorServ = app.getJogadorFactory();
		LotePalavras.inserirPalavras(
			app.getRepositoryFactory().getTemaRepository(),
			app.getRepositoryFactory().getPalavraRepository());
		
		TemaRepository temaRepo = app.getRepositoryFactory().getTemaRepository();
		PalavraRepository palavraRepo = app.getRepositoryFactory().getPalavraRepository();
		LetraFactory lFact = app.getElementoGraficoFactory();
		
		Jogador j1 = jogadorServ.getJogador("Vilmar");
		Jogador j2 = jogadorServ.getJogador("Luidi");
		Jogador j3 = jogadorServ.getJogador("Vilmar");
		JogadorRepository jrepo = app.getRepositoryFactory().getJogadorRepository();
		
		
		Jogador jz = jrepo.inserir(j1);
		System.out.println(jz);
		Rodada r = appServ.novaRodada(j);
		Palavra[] ps = r.getPalavras();
		for (Palavra p : ps) {
			p.toString();
		}
		

		
		/*
		Tema[] temas = temaRepo.getTodos();
		for(Tema t : temas) {
			System.out.println(t.getNome());
			Palavra[] ps = palavraRepo.getPorTema(t);
			for (Palavra p : ps) {
				System.out.println("  - "+p);
			}
		}
		*/
		
		}

}
