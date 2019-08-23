package repositorios;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import dominio.Palavra;
import dominio.Tema;

public class MemoriaPalavraRepository implements PalavraRepository {

	private static MemoriaPalavraRepository soleInstance;
	private HashMap<Long, Palavra> pool;
	
	private MemoriaPalavraRepository() {}
	
	public static MemoriaPalavraRepository getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new MemoriaPalavraRepository();
		}
		return soleInstance;
	}

	@Override
	public void inserir(Palavra palavra) throws RepositoryException {
		if(this.pool.containsKey(palavra.getId())){
			throw new RepositoryException();
		}
		this.pool.put(palavra.getId(), palavra);
	}

	@Override
	public void remover(Palavra palavra) throws RepositoryException {
		if(!this.pool.containsKey(palavra.getId())){
			throw new RepositoryException();
		}
		this.pool.remove(palavra.getId());
	}

	@Override
	public void atualizar(Palavra palavra) throws RepositoryException {
		this.remover(palavra);
		this.inserir(palavra);
	}

	@Override
	public Palavra getPorId(long id) {
		return this.pool.get(id);
	}
	
	@Override
	public long getProximoId() {
		Long max = (long) 1;
		Iterator<Palavra> palavras = this.pool.values().iterator();
		while(palavras.hasNext()) {
			Long id = palavras.next().getId();
			if ( id > max) {
				max = id ;
			}
		}
		return max + 1;
	}

	@Override
	public Palavra getPalavra(String palavra) {
		Iterator<Palavra> palavras = this.pool.values().iterator();
		while(palavras.hasNext()) {
			Palavra palavraObj = palavras.next();
			if (palavraObj.toString().equals(palavra)) {
				return palavraObj;
			}
		}
		return null; 
		
	}

	@Override
	public Palavra[] getTodas() {
		return (Palavra[])this.pool.values().toArray();
	}

	@Override
	public Palavra[] getPorTema(Tema tema) {
		HashSet<Palavra> palavrasDoTema = new HashSet<Palavra>();
		Iterator<Palavra> palavras = this.pool.values().iterator();
		while(palavras.hasNext()) {
			Palavra palavraObj = palavras.next();
			if (palavraObj.getTema().equals(tema)) {
				palavrasDoTema.add(palavraObj);
			}
		}
		return (Palavra[])palavrasDoTema.toArray(); 
	}

}
