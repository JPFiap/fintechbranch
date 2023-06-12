package br.com.fiap.tds.fintechweb.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.tds.fintechweb.bean.Despesa;
import br.com.fiap.tds.fintechweb.dao.DespesaDAO;
import br.com.fiap.tds.fintechweb.exception.DBException;
import br.com.fiap.tds.fintechweb.singleton.FintechConnectionManager;

public class OracleDespesaDAO implements DespesaDAO {

	Connection conexao;

	@Override
	public void cadastrarDespesa(Despesa despesa) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();

			String sql = "INSERT INTO T_FNT_DESPESA (id_despesa, nr_cpf, nm_despesa, vl_despesa, qt_parcelas, ds_fixo, ds_despesa, dt_saida"
					+ ") VALUES  (SEQ_ID_DESPESA.nextval, ?, ?, ?, ?, ?, ?, ?)";

			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, despesa.getUsuario().getCpf());
			stmt.setString(2, despesa.getNome());
			stmt.setDouble(3, despesa.getValor());
			stmt.setInt(4, despesa.getQtdParcelas());
			stmt.setBoolean(5, despesa.isFixo());
			stmt.setString(6, despesa.getDescricao());

			Date dataSaida = new Date(despesa.getDtSaida().getTimeInMillis());
			stmt.setDate(7, dataSaida);

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar despesa.");

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
	public List<Despesa> listarDespesa() {
		List<Despesa> lista = new ArrayList<Despesa>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FNT_DESPESA");
			rs = stmt.executeQuery();

			while (rs.next()) {
				String cpf = rs.getString("NR_CPF");
				int id = rs.getInt("ID_DESPESA");
				String nome = rs.getString("NM_DESPESA");
				double vlDespesa = rs.getDouble("VL_DESPESA");
				int qtdParcelas = rs.getInt("QT_PARCELAS");
				boolean isFixo = rs.getBoolean("DS_FIXO");
				String descricao = rs.getString("DS_DESPESA");

				Date dtSaida = rs.getDate("DT_SAIDA");
				Calendar dataSaida = Calendar.getInstance();
				dataSaida.setTimeInMillis(dtSaida.getTime());

				Despesa despesa = new Despesa(cpf, id, nome, vlDespesa, descricao, qtdParcelas, isFixo, dataSaida);

				lista.add(despesa);
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
	public void atualizarDespesa(Despesa despesa) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			conexao.setAutoCommit(false);

			String sql = "UPDATE T_FNT_DESPESA SET NR_CPF = ?, ID_DESPESA = ?, NM_DESPESA = ?, VL_DESPESA = ?, QT_PARCELAS = ?, DS_FIXO = ?, DS_DESPESA = ?, DT_SAIDA = ?"
					+ ") VALUES  (?, ?, ?, ?, ?, ?, ?, ?)";

			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, despesa.getId());
			stmt.setString(2, despesa.getCpf());
			stmt.setString(3, despesa.getNome());
			stmt.setDouble(4, despesa.getValor());
			stmt.setInt(5, despesa.getQtdParcelas());
			stmt.setBoolean(6, despesa.isFixo());
			stmt.setString(7, despesa.getDescricao());

			Date dataSaida = new Date(despesa.getDtSaida().getTimeInMillis());
			stmt.setDate(8, dataSaida);

			stmt.executeUpdate();

			conexao.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar a despesa.");

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
	public void removerDespesa(int id) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FNT_DESPESA WHERE ID_DESPESA = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover despesa.");
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
	public Despesa buscarPorIdDespesa(int id) {
		Despesa despesa = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FNT_DESPESA WHERE ID_DESPESA = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				String cpf = rs.getString("NR_CPF");
				int idDb = rs.getInt("ID_DESPESA");
				String nome = rs.getString("NM_DESPESA");
				double vlDespesa = rs.getDouble("VL_DESPESA");
				int qtdParcelas = rs.getInt("QT_PARCELAS");
				boolean isFixo = rs.getBoolean("DS_FIXO");
				String descricao = rs.getString("DS_DESPESA");

				Date dtSaida = rs.getDate("DT_SAIDA");
				Calendar dataSaida = Calendar.getInstance();
				dataSaida.setTimeInMillis(dtSaida.getTime());

				despesa = new Despesa(cpf, idDb, nome, vlDespesa, descricao, qtdParcelas, isFixo, dataSaida);

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
		return despesa;
	}

}
