package br.com.fiap.tds.fintechweb.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.tds.fintechweb.bean.Investimento;
import br.com.fiap.tds.fintechweb.dao.InvestimentoDAO;
import br.com.fiap.tds.fintechweb.exception.DBException;

/**
 * Servlet implementation class CartaoCreditoServlet
 */
@WebServlet("/investimento")
public class InvestimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private InvestimentoDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InvestimentoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String nmInvestimento = request.getParameter("investimento");
			String valorStr = request.getParameter("valor");
			String tipo = request.getParameter("tipo");
			String dtInvestimento = request.getParameter("dtInvestimento");

			double valor = Double.parseDouble(valorStr);
			LocalDate date = LocalDate.parse(dtInvestimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			Investimento investimento = new Investimento();
			dao.cadastrarInvestimento(investimento);

			request.setAttribute("msg", "Investimento cadastrado!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro-investimentos.jsp").forward(request, response);

	}
}
