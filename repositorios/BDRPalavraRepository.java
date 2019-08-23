package repositorios;

import dominio.Palavra;
import dominio.Tema;

public class BDRPalavraRepository implements PalavraRepository {


	private static BDRPalavraRepository soleInstance;
	
	private BDRPalavraRepository() {}
	
	public static BDRPalavraRepository getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new BDRPalavraRepository();
		}
		return soleInstance;
	}

	
	@Override
	public long getProximoId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Palavra getPalavra(String palavra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Palavra[] getTodas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Palavra[] getPorTema(Tema tema) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Palavra getPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Palavra palavra) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Palavra palavra) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserir(Palavra palavra) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

}
