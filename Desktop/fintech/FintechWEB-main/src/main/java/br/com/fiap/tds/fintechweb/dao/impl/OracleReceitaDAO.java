package br.com.fiap.tds.fintechweb.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.tds.fintechweb.bean.Receita;
import br.com.fiap.tds.fintechweb.dao.ReceitaDAO;
import br.com.fiap.tds.fintechweb.exception.DBException;
import br.com.fiap.tds.fintechweb.singleton.FintechConnectionManager;

public class OracleReceitaDAO implements ReceitaDAO {
	Connection conexao;

	public void cadastrarReceita(Receita receita) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();

			String sql = "INSERT INTO T_FNT_RECEITA (id_receita, nr_cpf, nm_receita, vl_receita, dt_entrada_receita, ds_receita"
					+ ") VALUES  (SEQ_ID_RECEITA.nextval, ?, ?, ?, ?, ?)";

			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, receita.getCpf());
			stmt.setString(2, receita.getNome());
			stmt.setDouble(3, receita.getValor());

			Date dataDate = new Date(receita.getDataEntrada().getTimeInMillis());
			stmt.setDate(4, dataDate);

			stmt.setString(5, receita.getDescricao());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar a receita.");

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
	public List<Receita> listarReceita() {
		List<Receita> lista = new ArrayList<Receita>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FNT_RECEITA");
			rs = stmt.executeQuery();

			while (rs.next()) {
				String cpf = rs.getString("NR_CPF");
				int id = rs.getInt("ID_RECEITA");
				String nome = rs.getString("NM_RECEITA");
				Double valor = rs.getDouble("VL_RECEITA");
				String descricao = rs.getString("DS_RECEITA");

				Date dtEntra = rs.getDate("DT_ENTRADA_RECEITA");
				Calendar dtEntrada = Calendar.getInstance();
				dtEntrada.setTimeInMillis(dtEntra.getTime());

				Receita receita = new Receita(cpf, id, nome, valor, descricao, dtEntrada);

				lista.add(receita);
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

	public void atualizarReceita(Receita receita) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			conexao.setAutoCommit(false);

			String sql = "UPDATE T_FNT_RECEITA SET NR_CPF = ?, ID_RECEITA = ?, NM_RECEITA = ?, VL_RECEITA = ?, DT_ENTRADA_RECEITA = ?, DS_RECEITA = ?"
					+ ") VALUES  (?, ?, ?, ?, ?, ?)";

			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, receita.getCpf());
			stmt.setInt(2, receita.getId());
			stmt.setString(3, receita.getNome());
			stmt.setDouble(4, receita.getValor());

			Date dataDate = new Date(receita.getDataEntrada().getTimeInMillis());
			stmt.setDate(5, dataDate);

			stmt.setString(6, receita.getDescricao());

			stmt.executeUpdate();

			conexao.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar a receita.");

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
	public void removerReceita(int id) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FNT_RECEITA WHERE ID_RECEITA = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover a receita.");
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
	public Receita buscarPorIdReceita(int id) {
		Receita receita = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FNT_RECEITA WHERE ID_RECEITA = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				String cpf = rs.getString("NR_CPF");
				int idDb = rs.getInt("ID_RECEITA");
				String nome = rs.getString("NM_RECEITA");
				Double valor = rs.getDouble("VL_RECEITA");
				String descricao = rs.getString("DS_RECEITA");

				Date dtEntra = rs.getDate("DT_ENTRADA_RECEITA");
				Calendar dtEntrada = Calendar.getInstance();
				dtEntrada.setTimeInMillis(dtEntra.getTime());

				receita = new Receita(cpf, idDb, nome, valor, descricao, dtEntrada);

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
		return receita;
	}
}