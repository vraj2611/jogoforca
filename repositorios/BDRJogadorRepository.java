package repositorios;

import dominio.Jogador;

public class BDRJogadorRepository implements JogadorRepository {


	private static BDRJogadorRepository soleInstance;
	
	private BDRJogadorRepository() {}
	
	public static BDRJogadorRepository getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new BDRJogadorRepository();
		}
		return soleInstance;
	}

	
	@Override
	public void remover(Jogador jogador) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Jogador jogador) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserir(Jogador jogador) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Jogador getPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jogador getPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getProximoId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
