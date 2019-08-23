package repositorios;

import dominio.Jogador;
import dominio.Rodada;

public interface RodadaRepository {
	
	public void remover(Rodada rodada) throws RepositoryException;
	public void atualizar(Rodada rodada) throws RepositoryException;
	public void inserir(Rodada rodada) throws RepositoryException;
	public Rodada[] getPorJogador(Jogador jogador);
	public Rodada getPorId(long id);
	
}
