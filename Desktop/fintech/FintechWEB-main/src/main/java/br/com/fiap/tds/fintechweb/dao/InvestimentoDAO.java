package br.com.fiap.tds.fintechweb.dao;

import java.util.List;

import br.com.fiap.tds.fintechweb.bean.Investimento;
import br.com.fiap.tds.fintechweb.exception.DBException;

public interface InvestimentoDAO {
	
	public void cadastrarInvestimento(Investimento investimento) throws DBException;

	public List<Investimento> listarInvestimento();

	public void atualizarInvestimento(Investimento investimento) throws DBException;

	public void removerInvestimento(int id) throws DBException;

	public Investimento buscarPorIdInvestimento(int id);
}
