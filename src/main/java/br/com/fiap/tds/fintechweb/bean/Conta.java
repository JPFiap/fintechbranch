
package br.com.fiap.tds.fintechweb.bean;

public abstract class Conta {

	private double saldo;
	private String nomeBanco;
	
	
	public Conta() {
	}
	
	
	public Conta(double saldo, String nomeBanco) {
		super();
		this.saldo = saldo;
		this.nomeBanco = nomeBanco;
	}
	
	public abstract Object atualizarSaldo(double saldo);
	
	public abstract void cadastrarConta(double saldo, String nomeBanco);
	
	public double getSaldo() {
		return saldo;
	}
	
	public String getNomeBanco() {
		return nomeBanco;
	}
	
	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}
	
	
	
}
