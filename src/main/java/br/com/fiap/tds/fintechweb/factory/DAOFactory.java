package br.com.fiap.tds.fintechweb.factory;

import br.com.fiap.tds.fintechweb.dao.CartaoCreditoDAO;
import br.com.fiap.tds.fintechweb.dao.impl.OracleCartaoCreditoDAO;

public abstract class DAOFactory {

	public static CartaoCreditoDAO getCartaoCreditoDAO() {
		return new OracleCartaoCreditoDAO();
	}

}
