package repositorios;

import dominio.Tema;

public class BDRTemaRepository implements TemaRepository {

	private static BDRTemaRepository soleInstance;
	
	private BDRTemaRepository() {}
	
	public static BDRTemaRepository getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new BDRTemaRepository();
		}
		return soleInstance;
	}

	
	@Override
	public void remover(Tema tema) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Tema tema) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserir(Tema tema) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tema[] getTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tema[] getPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tema getPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
