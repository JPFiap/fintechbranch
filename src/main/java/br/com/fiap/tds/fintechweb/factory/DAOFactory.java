package br.com.fiap.tds.fintechweb.factory;

import br.com.fiap.tds.fintechweb.dao.CartaoCreditoDAO;
import br.com.fiap.tds.fintechweb.dao.UsuarioDAO;
import br.com.fiap.tds.fintechweb.dao.impl.OracleCartaoCreditoDAO;
import br.com.fiap.tds.fintechweb.dao.impl.OracleUsuarioDAO;

public abstract class DAOFactory {

	public static CartaoCreditoDAO getCartaoCreditoDAO() {
		return new OracleCartaoCreditoDAO();
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}

}
