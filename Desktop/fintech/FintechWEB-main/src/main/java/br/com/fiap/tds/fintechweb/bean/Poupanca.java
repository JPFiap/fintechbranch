package br.com.fiap.tds.fintechweb.bean;

import java.util.Date;

public class Poupanca extends Conta {

	final String tipoConta = "poupanca";
	private Date aniversario;
	private double rendimento;
	private Usuario usuario;

	public Poupanca() {
		super();
	}

	public Poupanca(String cpf, int id, double saldo, String nomeBanco, Date aniversario, double rendimento) {
		super();
		this.aniversario = aniversario;
		this.rendimento = rendimento;
	}
	
	public Poupanca(String cpf, int id, double saldo, String nomeBanco) {
		super(cpf, id, saldo, nomeBanco);
	}

	public Date getAniversario() {
		return aniversario;
	}
	
	public String getTipoConta() {
		return tipoConta;
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

	public double aplicarRendimento(double indiceRendimento) {
		return super.getSaldo() * indiceRendimento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
