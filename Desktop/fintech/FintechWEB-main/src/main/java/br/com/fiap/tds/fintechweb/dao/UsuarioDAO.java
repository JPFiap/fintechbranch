package br.com.fiap.tds.fintechweb.dao;

import java.util.List;

import br.com.fiap.tds.fintechweb.bean.Usuario;
import br.com.fiap.tds.fintechweb.exception.DBException;

public interface UsuarioDAO {

	public void cadastrarUsuario(Usuario usuario) throws DBException;

	public List<Usuario> listarUsuario();

	public void atualizarUsuario(Usuario usuario) throws DBException;

	public void removerUsuario(String cpf) throws DBException;

	public Usuario buscarPorIdUsuario(String cpf);

	public boolean validarUsuario(Usuario usuario);
}
