package br.com.fiap.tds.fintechweb.teste;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.tds.fintechweb.bean.CartaoCredito;
import br.com.fiap.tds.fintechweb.dao.CartaoCreditoDAO;
import br.com.fiap.tds.fintechweb.exception.DBException;
import br.com.fiap.tds.fintechweb.factory.DAOFactory;

public class TesteCartaoCreditoDAO {

	public static void main(String[] args) {
		CartaoCreditoDAO dao = DAOFactory.getCartaoCreditoDAO();

		// Cadastrar produto
		CartaoCredito cartaoCredito = new CartaoCredito("47854898756", "Nu", Calendar.getInstance(),
				Calendar.getInstance(), 7000.00, "Nubank");

		try {
			dao.cadastrarCartaoCredito(cartaoCredito);
			System.out.println("Cartão de crédito cadastrado");
		} catch (DBException e) {
			e.printStackTrace();
		}

		// Buscar e atualizar produto
		cartaoCredito = dao.buscarPorIdCartaoCredito(6);
		System.out.println(cartaoCredito);
		cartaoCredito.setNomeBanco("Santander");
		cartaoCredito.setNome("Santandereles");

		try {
			dao.atualizarCartaoCredito(cartaoCredito);
			System.out.println("Cartão de crédito atualizado.");
		} catch (DBException e) {
			e.printStackTrace();
		}

		// Listar produtos
		List<CartaoCredito> lista = dao.listarCartaoCredito();

		for (CartaoCredito cartao : lista) {
			System.out.println(cartao.getNome() + " " + cartao.getNomeBanco());
		}
		
		//Remover um produto
		try {
			dao.removerCartaoCredito(3);
			System.out.println("Cartão de crédito removido.");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

}
