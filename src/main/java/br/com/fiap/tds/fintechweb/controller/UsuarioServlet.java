package br.com.fiap.tds.fintechweb.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.tds.fintechweb.bean.Usuario;
import br.com.fiap.tds.fintechweb.dao.UsuarioDAO;
import br.com.fiap.tds.fintechweb.exception.DBException;
import br.com.fiap.tds.fintechweb.factory.DAOFactory;

/**
 * Servlet implementation class UsuarioServlet
 */

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getUsuarioDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nome = request.getParameter("name");
			String email = request.getParameter("email");
			String telefone = request.getParameter("phone");
			String cpf = request.getParameter("cpf");

			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataNasc = Calendar.getInstance();
			dataNasc.setTime(format.parse(request.getParameter("birthDate")));

			String nacionalidade = request.getParameter("nationality");
			String senha = request.getParameter("password");

			Usuario usuario = new Usuario(cpf, nome, dataNasc, nacionalidade, telefone, email, senha);
			dao.cadastrarUsuario(usuario);

			request.setAttribute("msg", "Usu�rio cadastrado com sucesso!");

		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		request.getRequestDispatcher("cadastrousuario.jsp").forward(request, response);

	}

}
