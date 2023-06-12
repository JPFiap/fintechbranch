package br.com.fiap.tds.fintechweb.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.tds.fintechweb.bean.Investimento;
import br.com.fiap.tds.fintechweb.dao.InvestimentoDAO;
import br.com.fiap.tds.fintechweb.exception.DBException;
import br.com.fiap.tds.fintechweb.singleton.FintechConnectionManager;

public class OracleInvestimentoDAO implements InvestimentoDAO {
	Connection conexao;

	public void cadastrarInvestimento(Investimento investimento) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();

			String sql = "INSERT INTO T_FNT_INVESTIMENTO (id_investimento, nr_cpf, nm_investimento, vl_investido, tipo_investimento, dt_investimento, st_investimento, dt_resgate, ds_investimento"
					+ ") VALUES  (SEQ_ID_INVEST.nextval, ?, ?, ?, ?, ?, ?, ?,?)";

			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, investimento.getCpf());
			stmt.setString(2, investimento.getNome());
			stmt.setDouble(3, investimento.getValor());
			stmt.setString(4, investimento.getTipoInvestimento());

			Date dataDate = new Date(investimento.getDataInvestimento().getTimeInMillis());
			stmt.setDate(5, dataDate);

			stmt.setString(6, investimento.getStatusInvestimento());

			Date dataDate1 = new Date(investimento.getDataResgate().getTimeInMillis());
			stmt.setDate(7, dataDate1);

			stmt.setString(8, investimento.getDescricao());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar o investimento.");

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
	public List<Investimento> listarInvestimento() {
		List<Investimento> lista = new ArrayList<Investimento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FNT_INVESTIMENTO");
			rs = stmt.executeQuery();

			while (rs.next()) {
				String cpf = rs.getString("NR_CPF");
				int id = rs.getInt("ID_INVESTIMENTO");
				String nome = rs.getString("NM_INVESTIMENTO");
				Double valor = rs.getDouble("VL_INVESTIDO");
				String tipoInvestimento = rs.getString("TIPO_INVESTIMENTO");

				Date dtInvest = rs.getDate("DT_INVESTIMENTO");
				Calendar dtInvestimento = Calendar.getInstance();
				dtInvestimento.setTimeInMillis(dtInvest.getTime());

				String status = rs.getString("ST_INVESTIMENTO");

				Date dtResg = rs.getDate("DT_RESGATE");
				Calendar dtResgate = Calendar.getInstance();
				dtResgate.setTimeInMillis(dtResg.getTime());

				String descricao = rs.getString("DS_INVESTIMENTO");

				Investimento investimento = new Investimento(cpf, id, nome, valor, descricao, tipoInvestimento,
						dtInvestimento, status, dtResgate);

				lista.add(investimento);
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

	public void atualizarInvestimento(Investimento investimento) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			conexao.setAutoCommit(false);

			String sql = "UPDATE T_FNT_INVESTIMENTO SET NR_CPF = ?, ID_INVESTIMENTO = ?, NM_INVESTIMENTO = ?, VL_INVESTIDO = ?, TIPO_INVESTIMENTO = ?, DT_INVESTIMENTO = ?, ST_INVESTIMENTO = ?, DT_RESGATE = ?, DS_INVESTIMENTO = ?"
					+ ") VALUES  (?, ?, ?, ?, ?, ?, ?, ?)";

			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, investimento.getCpf());
			stmt.setString(2, investimento.getNome());
			stmt.setDouble(3, investimento.getValor());
			stmt.setString(4, investimento.getTipoInvestimento());

			Date dataDate = new Date(investimento.getDataInvestimento().getTimeInMillis());
			stmt.setDate(5, dataDate);

			stmt.setString(6, investimento.getStatusInvestimento());

			Date dataDate1 = new Date(investimento.getDataResgate().getTimeInMillis());
			stmt.setDate(7, dataDate1);

			stmt.setString(8, investimento.getDescricao());

			stmt.executeUpdate();

			conexao.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar o investimento.");

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
	public void removerInvestimento(int id) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FNT_INVESTIMENTO WHERE ID_INVESTIMENTO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover o investimento.");
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
	public Investimento buscarPorIdInvestimento(int id) {
		Investimento investimento = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FNT_INVESTIMENTO WHERE ID_INVESTIMENTO = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				String cpf = rs.getString("NR_CPF");
				int idDb = rs.getInt("ID_INVESTIMENTO");
				String nome = rs.getString("NM_INVESTIMENTO");
				Double valor = rs.getDouble("VL_INVESTIDO");
				String tipoInvestimento = rs.getString("TIPO_INVESTIMENTO");

				Date dtInvest = rs.getDate("DT_INVESTIMENTO");
				Calendar dtInvestimento = Calendar.getInstance();
				dtInvestimento.setTimeInMillis(dtInvest.getTime());

				String status = rs.getString("ST_INVESTIMENTO");

				Date dtResg = rs.getDate("DT_RESGATE");
				Calendar dtResgate = Calendar.getInstance();
				dtResgate.setTimeInMillis(dtResg.getTime());

				String descricao = rs.getString("DS_INVESTIMENTO");

				investimento = new Investimento(cpf, idDb, nome, valor, descricao, tipoInvestimento, dtInvestimento,
						status, dtResgate);

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
		return investimento;
	}
}
