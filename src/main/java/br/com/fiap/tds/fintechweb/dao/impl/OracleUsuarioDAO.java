package br.com.fiap.tds.fintechweb.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.tds.fintechweb.bean.Usuario;
import br.com.fiap.tds.fintechweb.dao.UsuarioDAO;
import br.com.fiap.tds.fintechweb.exception.DBException;
import br.com.fiap.tds.fintechweb.singleton.FintechConnectionManager;

public class OracleUsuarioDAO implements UsuarioDAO {

	Connection conexao;

	@Override
	public void cadastrarUsuario(Usuario usuario) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();

			String sql = "INSERT INTO T_FNT_USUARIO (nr_cpf, ds_email, cd_senha, nm_usuario, dt_nascimento, ds_sexo, ds_nacionalidade, nr_telefone"
					+ ") VALUES  (?, ?, ?, ?, ?, ?, ?, ?)";

			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, usuario.getCpf());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.setString(4, usuario.getNome());

			Date dataNascimento = new Date(usuario.getDataNasc().getTimeInMillis());
			stmt.setDate(5, dataNascimento);

			stmt.setString(6, String.valueOf(usuario.getSexo()));
			stmt.setString(7, usuario.getNacionalidade());
			stmt.setString(8, usuario.getTelefone());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar o usuário.");

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
	public List<Usuario> listarUsuario() {
		List<Usuario> lista = new ArrayList<Usuario>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FNT_USUARIO");
			rs = stmt.executeQuery();

			while (rs.next()) {
				String cpf = rs.getString("NR_CPF");
				String email = rs.getString("DS_EMAIL");
				String senha = rs.getString("CD_SENHA");
				String nome = rs.getString("NM_USUARIO");

				Date dataNasc = rs.getDate("DT_NASCIMENTO");
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTimeInMillis(dataNasc.getTime());

				String sexoString = rs.getString("DS_SEXO");
				char sexo = sexoString.charAt(0);

				String nacionalidade = rs.getString("DS_NACIONALIDADE");
				String telefone = rs.getString("NR_TELEFONE");

				Usuario usuario = new Usuario(cpf, nome, dataNascimento, sexo, nacionalidade, telefone, email, senha);

				lista.add(usuario);
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
	public void atualizarUsuario(Usuario usuario) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			conexao.setAutoCommit(false);

			String sql = "UPDATE T_FNT_USUARIO SET NR_CPF = ?, DS_EMAIL = ?, CD_SENHA = ?, NM_USUARIO = ?, DT_NASCIMENTO = ?, DS_SEXO = ?, DS_NACIONALIDADE = ?, NR_TELEFONE = ?"
					+ ") VALUES  (?, ?, ?, ?, ?, ?, ?, ?)";

			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, usuario.getCpf());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.setString(4, usuario.getNome());

			Date dataNascimento = new Date(usuario.getDataNasc().getTimeInMillis());
			stmt.setDate(5, dataNascimento);

			stmt.setString(6, String.valueOf(usuario.getSexo()));
			stmt.setString(7, usuario.getNacionalidade());
			stmt.setString(8, usuario.getTelefone());

			stmt.executeUpdate();

			conexao.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar o usuário.");

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
	public void removerUsuario(String cpf) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FNT_USUARIO WHERE NR_CPF = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cpf);

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover o usuario.");
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
	public Usuario buscarPorIdUsuario(String cpf) {
		Usuario usuario = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FNT_USUARIO WHERE NR_CPF = ?");
			stmt.setString(1, cpf);
			rs = stmt.executeQuery();

			if (rs.next()) {
				String cpfDb = rs.getString("NR_CPF");
				String email = rs.getString("DS_EMAIL");
				String senha = rs.getString("CD_SENHA");
				String nome = rs.getString("NM_USUARIO");

				Date dataNasc = rs.getDate("DT_NASCIMENTO");
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTimeInMillis(dataNasc.getTime());

				String sexoString = rs.getString("DS_SEXO");
				char sexo = sexoString.charAt(0);

				String nacionalidade = rs.getString("DS_NACIONALIDADE");
				String telefone = rs.getString("NR_TELEFONE");

				usuario = new Usuario(cpfDb, nome, dataNascimento, sexo, nacionalidade, telefone, email, senha);

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
		return usuario;
	}

}
