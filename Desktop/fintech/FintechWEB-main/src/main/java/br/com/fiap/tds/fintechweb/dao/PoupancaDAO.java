package br.com.fiap.tds.fintechweb.dao;

import java.util.List;

import br.com.fiap.tds.fintechweb.bean.Poupanca;
import br.com.fiap.tds.fintechweb.exception.DBException;

public interface PoupancaDAO {
	public void cadastrarPoupanca(Poupanca poupanca) throws DBException;

	public List<Poupanca> listarPoupanca();

	public void atualizarPoupanca(Poupanca poupanca) throws DBException;

	public void removerPoupanca(int id) throws DBException;

	public Poupanca buscarPorIdPoupanca(int id);
}
