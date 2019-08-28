package fabricas;

import repositorios.Repository;

public abstract class EntityFactory {

	private Repository repo;
	
	protected EntityFactory(Repository repository) {
		this.repo = repository;
	}
	
	protected Repository getRepository() {
		return this.repo;
	}
	
	protected long getProximoId() {
		return this.repo.getProximoId();
	}
}
