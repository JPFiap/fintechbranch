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
@WebServlet("/despesa")
public class DespesaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DespesaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String despesa = request.getParameter("despesa");
		String valorStr = request.getParameter("valor");
		String qtdParcelasStr = request.getParameter("qtdParcelas");
		String dsFixaStr = request.getParameter("dsFixa");
		String dtSaida = request.getParameter("dtSaida");
		
		
		double valor = Double.parseDouble(valorStr);
		int qtdParcelas = parseInt(qtdParcelasStr);
		boolean dsFixa = Boolean.parseBoolean(dsFixaStr);
		LocalDate date = LocalDate.parse(dtSaida, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		
		request.getRequestDispatcher("?.jsp").forward(request, response);
		
		
	
		
	
		
	}
	private int parseInt(String qtdParcelasStr) {
		// TODO Auto-generated method stub
		return 0;
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);*/
		
	
	}

