package br.com.fiap.tds.fintechweb.dao;

import java.util.List;

import br.com.fiap.tds.fintechweb.bean.Despesa;
import br.com.fiap.tds.fintechweb.exception.DBException;

public interface DespesaDAO {
	
	public void cadastrarDespesa(Despesa despesa) throws DBException;

	public List<Despesa> listarDespesa();

	public void atualizarDespesa(Despesa despesa) throws DBException;

	public void removerDespesa(int id) throws DBException;

	public Despesa buscarPorIdDespesa(int id);
}
