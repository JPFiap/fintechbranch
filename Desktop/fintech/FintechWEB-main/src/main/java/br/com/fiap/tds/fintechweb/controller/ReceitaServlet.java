package br.com.fiap.tds.fintechweb.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DespesaServlet
 */
@WebServlet("/receita")
public class ReceitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReceitaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String receita = request.getParameter("receita");
		String valorStr = request.getParameter("valor");
		String dtEntrada = request.getParameter("dtEntrada");
		String dsReceita = request.getParameter("dsReceita");

		double valor = Double.parseDouble(valorStr);
		LocalDate date = LocalDate.parse(dtEntrada, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		request.getRequestDispatcher("cadastro-receitas.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub doGet(request, response);
	 */

}
