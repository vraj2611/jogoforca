package repositorios;

import java.util.HashMap;
import java.util.Iterator;

import dominio.Tema;

public class MemoriaTemaRepository implements TemaRepository {

	private static MemoriaTemaRepository soleInstance;
	private HashMap<Long, Tema> pool;
	
	private MemoriaTemaRepository() {}
	
	public static MemoriaTemaRepository getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new MemoriaTemaRepository();
		}
		return soleInstance;
	}

	@Override
	public void inserir(Tema tema) throws RepositoryException {
		if(this.pool.containsKey(tema.getId())) {
			throw new RepositoryException();
		}
		this.pool.put(tema.getId(), tema);	
	}
	
	@Override
	public void remover(Tema tema) throws RepositoryException {
		if(!this.pool.containsKey(tema.getId())) {
			throw new RepositoryException();
		}
		this.pool.remove(tema.getId());
	}

	@Override
	public void atualizar(Tema tema) throws RepositoryException {
		this.remover(tema);
		this.inserir(tema);
	}

	@Override
	public Tema[] getTodos() {
		return (Tema[])this.pool.values().toArray();
	}

	@Override
	public Tema getPorNome(String nome) {
		Iterator<Tema> temas = this.pool.values().iterator();
		while(temas.hasNext()) {
			Tema tema = temas.next();
			if (tema.getNome().equals(nome)) {
				return tema;
			}
		}
		return null;
	}

	@Override
	public Tema getPorId(long id) {
		return this.pool.get(id);
	}

	@Override
	public long getProximoId() {
		Long max = (long) 1;
		Iterator<Tema> temas = this.pool.values().iterator();
		while(temas.hasNext()) {
			Long id = temas.next().getId(); 
			if ( id > max) {
				max = id;
			}
		}
		return max + 1;
	}

}
