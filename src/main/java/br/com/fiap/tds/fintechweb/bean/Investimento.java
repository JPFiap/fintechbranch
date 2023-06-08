package br.com.fiap.tds.fintechweb.bean;

import java.sql.Date;

public class Investimento extends Movimentacao {

	private String tipoInvestimento;
	private Date dtInvestimento;
	private double taxaRendimento;
	private double valorResgate;
	private Date dtResgate;
	private String statusInvestimento;
	
	public Investimento(String nome, double valor, String descricao, String tipoInvestimento, Date dtInvestimento,
			double taxaRendimento, double valorResgate, Date dtResgate, String statusInvestimento) {
		super(nome, valor, descricao);
		this.tipoInvestimento = tipoInvestimento;
		this.dtInvestimento = dtInvestimento;
		this.taxaRendimento = taxaRendimento;
		this.valorResgate = valorResgate;
		this.dtResgate = dtResgate;
		this.statusInvestimento = statusInvestimento;
	}
	
	// getters e setters
	public String getTipoInvestimento() {
		return tipoInvestimento;
	}
	
	public void setTipoInvestimento(String tipoInvestimento) {
		this.tipoInvestimento = tipoInvestimento;
	}
	
	public Date getDataInvestimento() {
		return dtInvestimento;
	}
	
	public void setDataInvestimento(Date dataInvestimento) {
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
	
	public Date getDataResgate() {
		return dtResgate;
	}
	
	public void setDataResgate(Date dataResgate) {
		this.dtResgate = dataResgate;
	}
	
	public String getStatusInvestimento() {
		return statusInvestimento;
	}
	
	public void setStatusInvestimento(String statusInvestimento) {
		this.statusInvestimento = statusInvestimento;
	}
	
	// métodos auxiliares
	
	public boolean verificarDisponibilidadeResgate() {
		return statusInvestimento.equals("Disponível para resgate");
	}
	
	// métodos sobrescritos
	
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
	
	// outros métodos públicos

	public double calcularRendimento() {
		// implementação do método para calcular o rendimento do investimento
		return this.getValor() * (this.getTaxaRendimento() / 100);
	}

	public void aplicar(double valorAplicacao) {
	    super.setValor(super.getValor() + valorAplicacao);
	}

	
	public boolean resgatar() {
		if (verificarDisponibilidadeResgate()) {
			super.setValor(super.getValor() - this.valorResgate);;
			this.statusInvestimento = "Resgatado";
			this.dtResgate = new Date(System.currentTimeMillis());
			return true;
		}
		return false;
	} 

}
