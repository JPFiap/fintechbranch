package br.com.fiap.tds.fintechweb.dao;

import java.util.List;

import br.com.fiap.tds.fintechweb.bean.Movimentacao;
import br.com.fiap.tds.fintechweb.exception.DBException;

public interface MovimentacaoDAO {
	public void cadastrarMovimentacao(Movimentacao movimentacao) throws DBException;

	public List<Movimentacao> listarMovimentacao();

	public void atualizarMovimentacao(Movimentacao movimentacao) throws DBException;

	public void removerMovimentacao(int id) throws DBException;

	public Movimentacao buscarPorIdMovimentacao(int id);
}
