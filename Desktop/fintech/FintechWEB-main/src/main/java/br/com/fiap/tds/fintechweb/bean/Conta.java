
package br.com.fiap.tds.fintechweb.bean;

public abstract class Conta {

	private String cpf;
	private int id;
	private double saldo;
	private String nomeBanco;

	public Conta() {
	}

	public Conta(String cpf, int id, double saldo, String nomeBanco) {
		super();
		this.cpf = cpf;
		this.id = id;
		this.saldo = saldo;
		this.nomeBanco = nomeBanco;
	}

	public abstract void cadastrar(double saldo, String nomeBanco);

	public abstract Object consultar(int id);

	public abstract void deletar(int id);

	public abstract Object atualizar(int id, String nomeBanco);
	
	public abstract Object atualizarSaldo(int id, double saldo);

	

	public double getSaldo() {
		return saldo;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
