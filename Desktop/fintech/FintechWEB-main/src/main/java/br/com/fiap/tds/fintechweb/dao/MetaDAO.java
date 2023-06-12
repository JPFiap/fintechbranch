package br.com.fiap.tds.fintechweb.dao;

import java.util.List;

import br.com.fiap.tds.fintechweb.bean.Meta;
import br.com.fiap.tds.fintechweb.exception.DBException;

public interface MetaDAO {

	public void cadastrarMeta(Meta meta) throws DBException;

	public List<Meta> listarMeta();

	public void atualizarMeta(Meta meta) throws DBException;

	public void removerMeta(int id) throws DBException;

	public Meta buscarPorIdMeta(int id);
}
