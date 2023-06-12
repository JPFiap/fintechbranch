package br.com.fiap.tds.fintechweb.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.tds.fintechweb.bean.Usuario;
import br.com.fiap.tds.fintechweb.bo.EmailBO;
import br.com.fiap.tds.fintechweb.dao.UsuarioDAO;
import br.com.fiap.tds.fintechweb.exception.EmailException;
import br.com.fiap.tds.fintechweb.factory.DAOFactory;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO dao;
	private EmailBO bo;
  
	public LoginServlet() {
        dao = DAOFactory.getUsuarioDAO();
        bo = new EmailBO();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario();
		
		if (dao.validarUsuario(usuario)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", cpf);
			String mensagem = "Um login foi realizado";
			try {
				bo.enviarEmail(cpf, "Login Realizado", mensagem);
			} catch (EmailException e) {
				e.printStackTrace();
			}
		}else {
			request.setAttribute("erro", "Usuário e/ou senha inválidos");
		}
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
}