package br.com.fiap.tds.fintechweb.dao;

import java.util.List;

import br.com.fiap.tds.fintechweb.bean.CartaoCredito;
import br.com.fiap.tds.fintechweb.exception.DBException;

public interface CartaoCreditoDAO {
	
	public void cadastrarCartaoCredito(CartaoCredito cartaoCredito) throws DBException;
	
	public List<CartaoCredito>listarCartaoCredito();
	
	public void atualizarCartaoCredito(CartaoCredito cartaoCredito) throws DBException;
	
	public void removerCartaoCredito(int id) throws DBException;;
	
	public CartaoCredito buscarPorIdCartaoCredito(int id);
}
