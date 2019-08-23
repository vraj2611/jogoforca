package repositorios;

import dominio.Jogador;

public interface JogadorRepository {

	public void remover(Jogador jogador) throws RepositoryException;
	public void atualizar(Jogador jogador) throws RepositoryException;
	public void inserir(Jogador jogador) throws RepositoryException;
	public Jogador[] getPorNome(String nome);
	public Jogador getPorId(long id);
	
}
