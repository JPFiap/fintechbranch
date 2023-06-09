package br.com.fiap.tds.fintechweb.dao;

import java.util.List;

import br.com.fiap.tds.fintechweb.bean.Endereco;
import br.com.fiap.tds.fintechweb.exception.DBException;

public interface EnderecoDAO {
	
	public void cadastrarEndereco(Endereco endereco) throws DBException;
	
	public List<Endereco>listarEndereco();
	
	public void atualizarEndereco(Endereco endereco) throws DBException;
	
	public void removerEndereco(String cpf) throws DBException;
	
	public Endereco buscarPorCpfEndereco(String cpf);

}
