package repositorios;

import java.util.HashSet;

import dominio.Jogador;
import dominio.Rodada;

public class MemoriaRodadaRepository implements RodadaRepository {

	private static MemoriaRodadaRepository soleInstance;
	private HashSet<Rodada> pool;
	
	private MemoriaRodadaRepository() {}
	
	public static MemoriaRodadaRepository getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new MemoriaRodadaRepository();
		}
		return soleInstance;
	}


	
	@Override
	public void remover(Rodada rodada) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Rodada rodada) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserir(Rodada rodada) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rodada[] getPorJogador(Jogador jogador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rodada getPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
