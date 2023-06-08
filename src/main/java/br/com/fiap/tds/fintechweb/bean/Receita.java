package br.com.fiap.tds.fintechweb.bean;

import java.util.Date;

public class Receita extends Movimentacao {

	public Receita(String nome, double valor, String descricao) {
		super(nome, valor, descricao);
		// TODO Auto-generated constructor stub
	}

	private Date dtEntrada;

	public Date getDataEntrada() {
		return dtEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
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
