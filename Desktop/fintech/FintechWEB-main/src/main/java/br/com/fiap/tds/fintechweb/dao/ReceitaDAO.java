package br.com.fiap.tds.fintechweb.dao;

import java.util.List;

import br.com.fiap.tds.fintechweb.bean.Receita;
import br.com.fiap.tds.fintechweb.exception.DBException;

public interface ReceitaDAO {
	
	public void cadastrarReceita(Receita receita) throws DBException;

	public List<Receita> listarReceita();

	public void atualizarReceita(Receita receita) throws DBException;

	public void removerReceita(int id) throws DBException;

	public Receita buscarPorIdReceita(int id);
}
