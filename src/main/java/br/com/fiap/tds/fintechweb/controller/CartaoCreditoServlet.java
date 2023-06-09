package br.com.fiap.tds.fintechweb.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.tds.fintechweb.bean.CartaoCredito;
import br.com.fiap.tds.fintechweb.dao.CartaoCreditoDAO;
import br.com.fiap.tds.fintechweb.exception.DBException;

/**
 * Servlet implementation class CartaoCreditoServlet
 */
@WebServlet("/cartao")
public class CartaoCreditoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CartaoCreditoDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartaoCreditoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<CartaoCredito> lista = dao.listarCartaoCredito();
		request.setAttribute("cartoes", lista);
		request.getRequestDispatcher("lista-cartoes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Recuperar o CPF da sessão do usuário
			HttpSession session = request.getSession();
			String cpf = (String) session.getAttribute("cpf");

			// Recuperar as informações do formulário
			String nome = request.getParameter("nome");
			String nomeBanco = request.getParameter("nomeBanco");

			SimpleDateFormat dataFec = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataFechamento = Calendar.getInstance();
			dataFechamento.setTime(dataFec.parse(request.getParameter("dataFechamento")));

			SimpleDateFormat dataVenc = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataVencimento = Calendar.getInstance();
			dataVencimento.setTime(dataVenc.parse(request.getParameter("dataVencimento")));

			String limiteStr = request.getParameter("limite");
			double limite = Double.parseDouble(limiteStr);

			// Criar o objeto de CartaoCredito com as informações fornecidas
			CartaoCredito cartao = new CartaoCredito(cpf, nome, dataFechamento, dataVencimento, limite, nomeBanco);
			dao.cadastrarCartaoCredito(cartao);

			// Redirecionar para uma página de confirmação ou exibir uma mensagem de sucesso
			response.sendRedirect("cadastrousuario.jsp");

		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
//		request.getRequestDispatcher("cadastrousuario.jsp").forward(request, response);
	}

}
