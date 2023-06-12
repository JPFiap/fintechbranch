package br.com.fiap.tds.fintechweb.factory;

import br.com.fiap.tds.fintechweb.dao.CartaoCreditoDAO;
import br.com.fiap.tds.fintechweb.dao.DespesaDAO;
import br.com.fiap.tds.fintechweb.dao.InvestimentoDAO;
import br.com.fiap.tds.fintechweb.dao.ReceitaDAO;
import br.com.fiap.tds.fintechweb.dao.UsuarioDAO;
import br.com.fiap.tds.fintechweb.dao.impl.OracleCartaoCreditoDAO;
import br.com.fiap.tds.fintechweb.dao.impl.OracleDespesaDAO;
import br.com.fiap.tds.fintechweb.dao.impl.OracleInvestimentoDAO;
import br.com.fiap.tds.fintechweb.dao.impl.OracleReceitaDAO;
import br.com.fiap.tds.fintechweb.dao.impl.OracleUsuarioDAO;

public abstract class DAOFactory {

	public static CartaoCreditoDAO getCartaoCreditoDAO() {
		return new OracleCartaoCreditoDAO();
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}

	public static DespesaDAO getDespesaDAO() {
		return new OracleDespesaDAO();
	}
	public static ReceitaDAO getReceitaDAO() {
		return new OracleReceitaDAO();
	}
	public static InvestimentoDAO getInvestimentoDAO() {
		return new OracleInvestimentoDAO();
	}
}
