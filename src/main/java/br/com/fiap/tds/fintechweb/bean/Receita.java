package br.com.fiap.tds.fintechweb.bean;

import java.util.Date;

public class Receita extends Movimentacao {

	private Date dtEntrada;

	public Receita(String cpf, int id, String nome, double valor, String descricao, Date dtEntrada) {
		super(cpf, id, nome, valor, descricao);
		this.dtEntrada = dtEntrada;
	}

	public Receita(String cpf, int id, String nome, double valor, Date dtEntrada) {
		super(cpf, id, nome, valor);
		this.dtEntrada = dtEntrada;
	}

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
