package repositorios;

import java.util.HashSet;

import dominio.Tema;

public class MemoriaTemaRepository implements TemaRepository {

	private static MemoriaTemaRepository soleInstance;
	private HashSet<Tema> pool;
	
	private MemoriaTemaRepository() {}
	
	public static MemoriaTemaRepository getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new MemoriaTemaRepository();
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
