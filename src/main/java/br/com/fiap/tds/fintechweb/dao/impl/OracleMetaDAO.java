package br.com.fiap.tds.fintechweb.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.tds.fintechweb.bean.Meta;
import br.com.fiap.tds.fintechweb.dao.MetaDAO;
import br.com.fiap.tds.fintechweb.exception.DBException;
import br.com.fiap.tds.fintechweb.singleton.FintechConnectionManager;

public class OracleMetaDAO implements MetaDAO{

	Connection conexao;
	
	@Override
	public void cadastrarMeta(Meta meta) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();

			String sql = "INSERT INTO T_FNT_META (id_meta, nr_cpf, nm_meta, vl_meta, valor_atual, dt_deposito, dt_alvo, ds_meta"
					+ ") VALUES  (SEQ_ID_META.nextval, ?, ?, ?, ?, ?, ?, ?)";

			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, meta.getCpf());
			stmt.setString(2, meta.getNome());
			stmt.setDouble(3, meta.getValorMeta());
			stmt.setDouble(4, meta.getValorAtual());
			
			Date dataDeposito = new Date(meta.getDataDeposito().getTimeInMillis());
			stmt.setDate(5, dataDeposito);

			Date dataAlvo = new Date(meta.getDataAlvo().getTimeInMillis());
			stmt.setDate(6, dataAlvo);
			
			stmt.setString(7, meta.getDescricao());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar meta.");

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
	public List<Meta> listarMeta() {
		List<Meta> lista = new ArrayList<Meta>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FNT_META");
			rs = stmt.executeQuery();

			while (rs.next()) {
				String cpf = rs.getString("NR_CPF");
				int id = rs.getInt("ID_META");
				String nome = rs.getString("NM_META");
				double valorMeta = rs.getDouble("VL_META");
				double valorAtual = rs.getDouble("VALOR_ATUAL");

				Date dataDep = rs.getDate("DT_DEPOSITO");
				Calendar dataDeposito = Calendar.getInstance();
				dataDeposito.setTimeInMillis(dataDep.getTime());

				Date dataAlv = rs.getDate("DT_ALVO");
				Calendar dataAlvo= Calendar.getInstance();
				dataAlvo.setTimeInMillis(dataAlv.getTime());
				
				String descricao = rs.getString("DS_META");
				
				Meta meta= new Meta(id, cpf, nome, valorMeta, valorAtual, descricao, dataAlvo, dataDeposito);

				lista.add(meta);
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
	public void atualizarMeta(Meta meta) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			conexao.setAutoCommit(false);

			String sql = "UPDATE T_FNT_META SET NR_CPF = ?, ID_META = ?, NM_META = ?, VL_META = ?, VALOR_ATUAL = ?, DT_DEPOSITO = ?, DT_ALVO = ?, DS_META = ?"
					+ ") VALUES  (?, ?, ?, ?, ?, ?, ?, ?)";

			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, meta.getCpf());
			stmt.setInt(2, meta.getId());
			stmt.setString(3, meta.getNome());
			stmt.setDouble(4, meta.getValorMeta());
			stmt.setDouble(5, meta.getValorAtual());
			
			Date dataDeposito = new Date(meta.getDataDeposito().getTimeInMillis());
			stmt.setDate(6, dataDeposito);

			Date dataAlvo = new Date(meta.getDataAlvo().getTimeInMillis());
			stmt.setDate(7, dataAlvo);
			
			stmt.setString(8, meta.getDescricao());

			stmt.executeUpdate();

			conexao.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar a meta.");

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
	public void removerMeta(int id) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FNT_META WHERE ID_META = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover meta.");
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
	public Meta buscarPorIdMeta(int id) {
		Meta meta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FNT_META WHERE ID_META = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				String cpf = rs.getString("NR_CPF");
				int idDb = rs.getInt("ID_META");
				String nome = rs.getString("NM_META");
				double valorMeta = rs.getDouble("VL_META");
				double valorAtual = rs.getDouble("VALOR_ATUAL");

				Date dataDep = rs.getDate("DT_DEPOSITO");
				Calendar dataDeposito = Calendar.getInstance();
				dataDeposito.setTimeInMillis(dataDep.getTime());

				Date dataAlv = rs.getDate("DT_ALVO");
				Calendar dataAlvo= Calendar.getInstance();
				dataAlvo.setTimeInMillis(dataAlv.getTime());
				
				String descricao = rs.getString("DS_META");
				
				meta = new Meta(idDb, cpf, nome, valorMeta, valorAtual, descricao, dataAlvo, dataDeposito);

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
		return meta;
	}

}
