package br.com.fiap.tds.fintechweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tds.fintechweb.bean.Corrente;
import br.com.fiap.tds.fintechweb.dao.CorrenteDAO;
import br.com.fiap.tds.fintechweb.exception.DBException;
import br.com.fiap.tds.fintechweb.singleton.FintechConnectionManager;

public class OracleCorrenteDAO implements CorrenteDAO {

	Connection conexao;

	@Override
	public void cadastrarCorrente(Corrente corrente) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();

			String sql = "INSERT INTO T_FNT_CONTA (id_conta, nr_cpf, tipo_conta, nm_banco, vl_saldo"
					+ ") VALUES  (SEQ_ID_CONTA.nextval, ?, ?, ?, ?)";

			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, corrente.getCpf());
			stmt.setString(2, corrente.getTipoConta());
			stmt.setString(3, corrente.getNomeBanco());
			stmt.setDouble(4, corrente.getSaldo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar o conta corrente.");

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
	public List<Corrente> listarCorrente() {
		List<Corrente> lista = new ArrayList<Corrente>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FNT_CONTA WHERE TIPO_CONTA = ?");
			stmt.setString(1, "corrente");
			rs = stmt.executeQuery();

			while (rs.next()) {
				String cpf = rs.getString("NR_CPF");
				int id = rs.getInt("ID_CONTA");
//				String tipoConta = rs.getString("TIPO_CONTA");
				String nomeBanco = rs.getString("NM_BANCO");
				double vlSaldo = rs.getDouble("VL_SALDO");

				Corrente corrente = new Corrente(cpf, id, vlSaldo, nomeBanco);

				lista.add(corrente);
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
	public void atualizarCorrente(Corrente corrente) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			conexao.setAutoCommit(false);

			String sql = "UPDATE T_FNT_CONTA SET NR_CPF = ?, ID_CONTA = ?, TIPO_CONTA = ?, NM_BANCO = ?, VL_SALDO = ?"
					+ ") VALUES  (?, ?, ?, ?, ?)";

			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, corrente.getCpf());
			stmt.setInt(2, corrente.getId());
			stmt.setString(3, corrente.getTipoConta());
			stmt.setDouble(4, corrente.getSaldo());

			stmt.executeUpdate();

			conexao.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar o conta corrente.");

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
	public void removerCorrente(int id) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FNT_CONTA WHERE ID_CONTA = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover a conta corrente.");
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
	public Corrente buscarPorIdCorrente(int id) {
		Corrente corrente = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FNT_CONTA WHERE ID_CONTA = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				String cpf = rs.getString("NR_CPF");
				int idDb = rs.getInt("ID_CONTA");
//				String tipoConta = rs.getString("TIPO_CONTA");
				String nomeBanco = rs.getString("NM_BANCO");
				double vlSaldo = rs.getDouble("VL_SALDO");

				corrente = new Corrente(cpf, idDb, vlSaldo, nomeBanco);

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
		return corrente;
	}

}
