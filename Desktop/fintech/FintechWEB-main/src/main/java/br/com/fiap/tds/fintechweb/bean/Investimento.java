package br.com.fiap.tds.fintechweb.bean;

import java.util.Calendar;

public class Investimento extends Movimentacao {

	private String tipoInvestimento;
	private Calendar dtInvestimento;
	private double taxaRendimento; // não esta no DB, varia com a data
	private double valorResgate; // não esta no DB, varia com a data
	private Calendar dtResgate;
	private String statusInvestimento;

	public Investimento(String cpf, int id, String nome, double valor, String descricao, String tipoInvestimento,
			Calendar dtInvestimento, String statusInvestimento, double taxaRendimento, double valorResgate,
			Calendar dtResgate) {
		super(cpf, id, nome, valor, descricao);
		this.tipoInvestimento = tipoInvestimento;
		this.dtInvestimento = dtInvestimento;
		this.taxaRendimento = taxaRendimento;
		this.valorResgate = valorResgate;
		this.dtResgate = dtResgate;
		this.statusInvestimento = statusInvestimento;
	}

	public Investimento(String cpf, int id, String nome, double valor, String descricao, String tipoInvestimento,
			Calendar dtInvestimento, String statusInvestimento, Calendar dtResgate) {
		super(cpf, id, nome, valor, descricao);
		this.tipoInvestimento = tipoInvestimento;
		this.dtInvestimento = dtInvestimento;
		this.dtResgate = dtResgate;
		this.statusInvestimento = statusInvestimento;
	}

	public Investimento(String nome, double valor, String tipoInvestimento, Calendar dtInvestimento) {
		super();
		this.tipoInvestimento = tipoInvestimento;
		this.dtInvestimento = dtInvestimento;
		
	}

	
	public Investimento() {
		// TODO Auto-generated constructor stub
	}

	// getters e setters
	public String getTipoInvestimento() {
		return tipoInvestimento;
	}

	public void setTipoInvestimento(String tipoInvestimento) {
		this.tipoInvestimento = tipoInvestimento;
	}

	public Calendar getDataInvestimento() {
		return dtInvestimento;
	}

	public void setDataInvestimento(Calendar dataInvestimento) {
		this.dtInvestimento = dataInvestimento;
	}

	public double getTaxaRendimento() {
		return taxaRendimento;
	}

	public void setTaxaRendimento(double taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}

	public double getValorResgate() {
		return valorResgate;
	}

	public void setValorResgate(double valorResgate) {
		this.valorResgate = valorResgate;
	}

	public Calendar getDataResgate() {
		return dtResgate;
	}

	public void setDataResgate(Calendar dataResgate) {
		this.dtResgate = dataResgate;
	}

	public String getStatusInvestimento() {
		return statusInvestimento;
	}

	public void setStatusInvestimento(String statusInvestimento) {
		this.statusInvestimento = statusInvestimento;
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

	public boolean verificarDisponibilidadeResgate() {
		return statusInvestimento.equals("Disponível para resgate");
	}

	public double calcularRendimento() {
		return this.getValor() * (this.getTaxaRendimento() / 100);
	}

	public void aplicar(double valorAplicacao) {
		super.setValor(super.getValor() + valorAplicacao);
	}

}
