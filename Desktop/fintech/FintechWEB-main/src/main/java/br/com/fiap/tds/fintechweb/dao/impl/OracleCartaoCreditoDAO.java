package br.com.fiap.tds.fintechweb.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.tds.fintechweb.bean.CartaoCredito;
import br.com.fiap.tds.fintechweb.dao.CartaoCreditoDAO;
import br.com.fiap.tds.fintechweb.exception.DBException;
import br.com.fiap.tds.fintechweb.singleton.FintechConnectionManager;

public class OracleCartaoCreditoDAO implements CartaoCreditoDAO {

	Connection conexao;

	@Override
	public void cadastrarCartaoCredito(CartaoCredito cartaoCredito) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();

			String sql = "INSERT INTO T_FNT_CARTAO_CREDITO (id_cartao_credito, nr_cpf, nm_banco, nm_cartao, dt_fechamento, dt_vencimento, vl_limite"
					+ ") VALUES  (SEQ_ID_CARTAO_CREDITO.nextval,?, ?, ?, ?, ?, ?)";

			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, cartaoCredito.getCpf());
			stmt.setString(2, cartaoCredito.getNomeBanco());
			stmt.setString(3, cartaoCredito.getNome());

			Date dataFechamento = new Date(cartaoCredito.getDataFechamento().getTimeInMillis());
			stmt.setDate(4, dataFechamento);

			Date dataVencimento = new Date(cartaoCredito.getDataVencimento().getTimeInMillis());
			stmt.setDate(5, dataVencimento);

			stmt.setDouble(6, cartaoCredito.getLimite());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar o cartão de crédito.");

		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<CartaoCredito> listarCartaoCredito() {
		List<CartaoCredito> lista = new ArrayList<CartaoCredito>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FNT_CARTAO_CREDITO");
			rs = stmt.executeQuery();

			while (rs.next()) {
				String cpf = rs.getString("NR_CPF");
				int id = rs.getInt("ID_CARTAO_CREDITO");
				String nomeBanco = rs.getString("NM_BANCO");
				String nome = rs.getString("NM_CARTAO");

				java.sql.Date data = rs.getDate("DT_FECHAMENTO");
				Calendar dataFechamento = Calendar.getInstance();
				dataFechamento.setTimeInMillis(data.getTime());

				java.sql.Date dataVenc = rs.getDate("DT_VENCIMENTO");
				Calendar dataVencimento = Calendar.getInstance();
				dataVencimento.setTimeInMillis(dataVenc.getTime());

				double valorLimite = rs.getDouble("VL_LIMITE");

				CartaoCredito cartaoCredito = new CartaoCredito(cpf, id, nome, dataFechamento, dataVencimento,
						valorLimite, nomeBanco);

				lista.add(cartaoCredito);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public void removerCartaoCredito(int id) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FNT_CARTAO_CREDITO WHERE ID_CARTAO_CREDITO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover o cartão de crédito.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public CartaoCredito buscarPorIdCartaoCredito(int id) {
		CartaoCredito cartaoCredito = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FNT_CARTAO_CREDITO WHERE ID_CARTAO_CREDITO = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				String cpf = rs.getString("NR_CPF");
				int idCartao = rs.getInt("ID_CARTAO_CREDITO");
				String nomeBanco = rs.getString("NM_BANCO");
				String nome = rs.getString("NM_CARTAO");

				Date data = rs.getDate("DT_FECHAMENTO");
				Calendar dataFechamento = Calendar.getInstance();
				dataFechamento.setTimeInMillis(data.getTime());

				Date dataVenc = rs.getDate("DT_VENCIMENTO");
				Calendar dataVencimento = Calendar.getInstance();
				dataVencimento.setTimeInMillis(dataVenc.getTime());

				double valorLimite = rs.getDouble("VL_LIMITE");

				cartaoCredito = new CartaoCredito(cpf, idCartao, nome, dataFechamento, dataVencimento, valorLimite,
						nomeBanco);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cartaoCredito;
	}

	@Override
	public void atualizarCartaoCredito(CartaoCredito cartaoCredito) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			conexao.setAutoCommit(false);

			String sql = "UPDATE T_FNT_CARTAO_CREDITO SET NM_CARTAO = ?, DT_FECHAMENTO = ?, DT_VENCIMENTO = ?, VL_LIMITE = ?, NM_BANCO = ?, NR_CPF = ?  WHERE ID_CARTAO_CREDITO = ?";

			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, cartaoCredito.getNome());

			Date dataFechamento = new Date(cartaoCredito.getDataFechamento().getTimeInMillis());
			stmt.setDate(2, dataFechamento);

			Date dataVencimento = new Date(cartaoCredito.getDataVencimento().getTimeInMillis());
			stmt.setDate(3, dataVencimento);

			stmt.setDouble(4, cartaoCredito.getLimite());
			stmt.setString(5, cartaoCredito.getNomeBanco());
			stmt.setString(6, cartaoCredito.getCpf());
			stmt.setInt(7, cartaoCredito.getId());

			stmt.executeUpdate();

			conexao.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar o cartão de crédito.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
