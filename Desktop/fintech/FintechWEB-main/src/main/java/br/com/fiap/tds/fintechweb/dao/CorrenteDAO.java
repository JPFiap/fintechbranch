package br.com.fiap.tds.fintechweb.dao;

import java.util.List;

import br.com.fiap.tds.fintechweb.bean.Corrente;
import br.com.fiap.tds.fintechweb.exception.DBException;

public interface CorrenteDAO {
	public void cadastrarCorrente(Corrente corrente) throws DBException;

	public List<Corrente> listarCorrente();

	public void atualizarCorrente(Corrente corrente) throws DBException;

	public void removerCorrente(int id) throws DBException;

	public Corrente buscarPorIdCorrente(int id);
}
