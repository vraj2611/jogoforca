package repositorios;

import dominio.Palavra;
import dominio.Tema;

public interface PalavraRepository extends DomainRepository {

	public void remover(Palavra palavra) throws RepositoryException;
	public void atualizar(Palavra palavra) throws RepositoryException;
	public void inserir(Palavra palavra) throws RepositoryException;
	public Palavra getPalavra(String palavra);
	public Palavra[] getTodas();
	public Palavra[] getPorTema(Tema tema);
	public Palavra getPorId(long id);
	
	
}
