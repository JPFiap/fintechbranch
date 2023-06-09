package br.com.fiap.tds.fintechweb.bean;

public class Corrente extends Conta {

	final String tipoConta = "corrente";
	private double limite;
	private double juros;

	public Corrente() {
		super();
	}

	public Corrente(String cpf, int id, double saldo, String nomeBanco, double limite, double juros) {
		super(cpf, id, saldo, nomeBanco);
		this.limite = limite;
		this.juros = juros;
	}
	
	public Corrente(String cpf, int id, double saldo, String nomeBanco) {
		super(cpf, id, saldo, nomeBanco);
	}

	public double getLimite() {
		return limite;
	}

	public double getJuros() {
		return juros;
	}

	public String getTipoConta() {
		return tipoConta;
	}


	public void setLimite(double limite) {
		this.limite = limite;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}

	@Override
	public void cadastrar(double saldo, String nomeBanco) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object consultar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object atualizar(int id, String nomeBanco) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object atualizarSaldo(int id, double saldo) {
		// TODO Auto-generated method stub
		return null;
	}

	public double aplicarJuros(double indiceJuros) {
		double saldo = super.getSaldo();
		double saldoComJuros = saldo * indiceJuros;
		return saldo - saldoComJuros;

	}

}
