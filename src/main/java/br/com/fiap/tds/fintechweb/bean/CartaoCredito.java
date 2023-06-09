package br.com.fiap.tds.fintechweb.bean;

import java.util.Calendar;

public class CartaoCredito {

	private String cpf;
	private int id;
	private String nome;
	private String nomeBanco;
	private Calendar dataFechamento;
	private Calendar dataVencimento;
	private double limite;

	public CartaoCredito() {
		super();
	}

	public CartaoCredito(String cpf, int id, String nome, Calendar dataFechamento, Calendar dataVencimento,
			double limite, String nomeBanco) {
		super();
		this.cpf = cpf;
		this.id = id;
		this.nome = nome;
		this.dataFechamento = dataFechamento;
		this.dataVencimento = dataVencimento;
		this.limite = limite;
		this.nomeBanco = nomeBanco;
	}
	
	public CartaoCredito(String cpf, String nome, Calendar dataFechamento, Calendar dataVencimento,
			double limite, String nomeBanco) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataFechamento = dataFechamento;
		this.dataVencimento = dataVencimento;
		this.limite = limite;
		this.nomeBanco = nomeBanco;
	}


	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Calendar getDataFechamento() {
		return dataFechamento;
	}

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public double getLimite() {
		return limite;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public void setDataFechamento(Calendar dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
