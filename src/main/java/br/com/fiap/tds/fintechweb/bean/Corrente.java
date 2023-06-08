package br.com.fiap.tds.fintechweb.bean;

public class Corrente extends Conta{

	public Corrente(double saldo, String nomeBanco) {
		super(saldo, nomeBanco);
	}
	
	private double limite;
	private double juros;
	
	public Corrente() {
	
	}
	
	public Corrente(double limite, double juros) {
		super();
		this.limite = limite;
		this.juros = juros;
	}
	
	public double aplicarJuros() {
		double porcentagemJuros = 0.2;
		double saldo = super.getSaldo();
		double saldoComJuros = saldo * porcentagemJuros;
		return saldo - saldoComJuros;

	}
	
	@Override
	public Object atualizarSaldo(double saldo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cadastrarConta(double saldo, String nomeBanco) {
		// TODO Auto-generated method stub
		
	}

	public double getLimite() {
		return limite;
	}
	public double getJuros() {
		return juros;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	public void setJuros(double juros) {
		this.juros = juros;
	}	
	
}
