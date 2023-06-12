package br.com.fiap.tds.fintechweb.bean;

import java.util.Calendar;

public class Receita extends Movimentacao {

	private Calendar dtEntrada;

	public Receita(String cpf, int id, String nome, double valor, String descricao, Calendar dtEntrada) {
		super(cpf, id, nome, valor, descricao);
		this.dtEntrada = dtEntrada;
	}

	public Receita(String cpf, int id, String nome, double valor, Calendar dtEntrada) {
		super(cpf, id, nome, valor);
		this.dtEntrada = dtEntrada;
	}

	public Calendar getDataEntrada() {
		return dtEntrada;
	}

	public void setDataEntrada(Calendar dataEntrada) {
		this.dtEntrada = dataEntrada;
	}

	@Override
	public void cadastrar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletar(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object atualizar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object consultar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}