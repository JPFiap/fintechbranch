package br.com.fiap.tds.fintechweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.tds.fintechweb.bean.Endereco;
import br.com.fiap.tds.fintechweb.dao.EnderecoDAO;
import br.com.fiap.tds.fintechweb.exception.DBException;
import br.com.fiap.tds.fintechweb.singleton.FintechConnectionManager;

public class OracleEnderecoDAO implements EnderecoDAO {

	Connection conexao;

	@Override
	public void cadastrarEndereco(Endereco endereco) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();

			String sql = "INSERT INTO T_FNT_ENDERECO (nr_cpf, nr_cep, nr_residencia, ds_complemento"
					+ ") VALUES  (?, ?, ?, ?)";

			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, endereco.getCpf());
			stmt.setInt(2, endereco.getCep());
			stmt.setInt(3, endereco.getNumero());
			stmt.setString(4, endereco.getComplemento());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar o endereço.");

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
	public List<Endereco> listarEndereco() {
		List<Endereco> lista = new ArrayList<Endereco>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FNT_ENDERECO");
			rs = stmt.executeQuery();

			while (rs.next()) {
				String cpf = rs.getString("NR_CPF");
				int cep = rs.getInt("NR_CEP");
				int numero = rs.getInt("NR_RESIDENCIA");
				String complemento = rs.getString("DS_COMPLEMENTO");
				
				Endereco endereco = new Endereco(cpf, cep, numero, complemento);

				lista.add(endereco);
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
	public void atualizarEndereco(Endereco endereco) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			conexao.setAutoCommit(false);

			String sql = "UPDATE T_FNT_ENDERECO SET NR_CPF = ?, NR_CEP = ?, NR_RESIDENCIA = ?, DS_COMPLEMENTO = ?"
					+ ") VALUES  (?, ?, ?, ?)";

			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, endereco.getCpf());
			stmt.setInt(2, endereco.getCep());
			stmt.setInt(3, endereco.getNumero());
			stmt.setString(4, endereco.getComplemento());

			stmt.executeUpdate();

			conexao.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar o endereço.");

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
	public void removerEndereco(String cpf) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FNT_ENDERECO WHERE NR_CPF = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cpf);

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover o endereço.");
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
	public Endereco buscarPorCpfEndereco(String cpf) {
		Endereco endereco = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FNT_ENDERECO WHERE NR_CPF = ?");
			stmt.setString(1, cpf);
			rs = stmt.executeQuery();

			if (rs.next()) {
				String cpfDb = rs.getString("NR_CPF");
				int cep = rs.getInt("NR_CEP");
				int numero = rs.getInt("NR_RESIDENCIA");
				String complemento = rs.getString("DS_COMPLEMENTO");

				endereco = new Endereco(cpfDb, cep, numero, complemento);

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
		return endereco;
	}

}
