package br.com.fiap.tds.fintechweb.dao;

import java.util.List;

import br.com.fiap.tds.fintechweb.bean.Conta;
import br.com.fiap.tds.fintechweb.exception.DBException;

	public interface ContaDAO {
	
	public void cadastrarConta(Conta conta) throws DBException;
	
	public List<Conta>listarConta();
	
	public void atualizarConta(Conta conta) throws DBException;
	
	public void removerConta(int id) throws DBException;
	
	public Conta buscarPorIdConta(int id);
}
