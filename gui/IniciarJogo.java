package gui;

import java.io.IOException;

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
import repositorios.RepositoryException;
import repositorios.TemaRepository;
import servicos.JogoForcaService;
import teste.LotePalavras;
import servicos.KeyBoardService;

public class IniciarJogo {

	public static void main(String[] args) {

		Aplicacao app = Aplicacao.getSoleInstance();
		JogoForcaService appServ =JogoForcaService.getSoleInstance();
		JogadorFactory jogadorServ = app.getJogadorFactory();

		LotePalavras.inserirPalavras(
			app.getRepositoryFactory().getTemaRepository(),
			app.getRepositoryFactory().getPalavraRepository());
		
		Jogador j1 = jogadorServ.getJogador("Vilmar");
		Rodada r = appServ.novaRodada(j1);
		ExibidorTexto contexto = new ExibidorTexto();
		String opcao;
		
		while(true) {
			contexto.mostrarTelaJogo(r);
			opcao = KeyBoardService.readline();
			if(opcao.equals("0")) {
				try {
					appServ.salvarRodada(r);
				} catch (RepositoryException e) {
					e.printStackTrace();
				}
				break;
			}
			
			if( opcao.length() == 1) {
				r.tentar(opcao.charAt(0));
			} else {
				r.arriscar(opcao.split(" "));
			}	
			
			if(r.encerrou() && opcao.equals("1"))
				try {
				appServ.salvarRodada(r);
				} catch (RepositoryException e) {
					e.printStackTrace();
				}
				r = appServ.novaRodada(j1);
		}
		System.out.println("Saiu do Jogo");
	}
}	