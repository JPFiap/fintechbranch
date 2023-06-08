package br.com.fiap.tds.fintechweb.bean;

import java.util.Date;

public class Poupanca extends Conta {

	private Date aniversario;
	private double rendimento;

	public Poupanca(double saldo, String nomeBanco) {
		super(saldo, nomeBanco);
	}

	public Poupanca(Date aniversario, double rendimento) {
		super();
		this.aniversario = aniversario;
		this.rendimento = rendimento;
	}

	
	public Poupanca() {
		super();
	}
	
	public double aplicarRendimento() {
		double valorRendimento = 0.5;
		return super.getSaldo() * valorRendimento;
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

	public Date getAniversario() {
		return aniversario;
	}

	public double getRendimento() {
		return rendimento;
	}

	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}

	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}
}
