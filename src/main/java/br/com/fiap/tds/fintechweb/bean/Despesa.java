package br.com.fiap.tds.fintechweb.bean;

import java.sql.Date;

public class Despesa extends Movimentacao {

	public Despesa(String nome, double valor, String descricao, int qtdParcelas, boolean fixo,
			Date dtSaida, int parcelaAtual) {
		super(nome, valor, descricao);
		this.qtdParcelas = qtdParcelas;
		this.fixo = fixo;
		this.dtSaida = dtSaida;
		this.parcelaAtual = parcelaAtual;
	}

	private int qtdParcelas;
	private boolean fixo;
	private Date dtSaida;
	private int parcelaAtual;
	
	public int getQtdParcelas() {
		return qtdParcelas;
	}

	public boolean isFixo() {
		return fixo;
	}

	public void setQtdParcelas(int qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}

	public void setFixo(boolean fixo) {
		this.fixo = fixo;
	}


	public Date getDtVencimento() {
		return dtSaida;
	}

	public void setDtVencimento(Date dtSaida) {
		this.dtSaida = dtSaida;
	}

	public int getParcelaAtual() {
		return parcelaAtual;
	}

	public void setParcelaAtual(int parcelaAtual) {
		this.parcelaAtual = parcelaAtual;
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
	
	public int calcularParcelasRestantes() {
		if (qtdParcelas == 0) {
			return 0;
		}
		int parcelasRestantes = qtdParcelas - parcelaAtual;
		return parcelasRestantes > 0 ? parcelasRestantes : 0;
	}


}
