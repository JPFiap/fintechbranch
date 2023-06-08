package br.com.fiap.tds.fintechweb.bean;

import java.util.Calendar;

public class CartaoCredito {

	private int id;
	private String nome;
	private Calendar dataFechamento;
	private Calendar dataVencimento;
	private double limite;
	private String nomeBanco;
	private String cpf;
	private int idAnexo;
	
	
	

	public CartaoCredito() {
		super();
	}

	public CartaoCredito(int id, String nome, Calendar dataFechamento, Calendar dataVencimento, double limite,
			String nomeBanco, String cpf, int idAnexo) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataFechamento = dataFechamento;
		this.dataVencimento = dataVencimento;
		this.limite = limite;
		this.nomeBanco = nomeBanco;
		this.cpf = cpf;
		this.idAnexo = idAnexo;
	}
	
	
	public void cadastrarCartao(int id, String nome, Calendar dataFechamento, Calendar dataVencimento, double limite,
			String nomeBanco, String cpf) {
		System.out.println("Cartão cadastrado com sucesso!");
		}
	
	public void deletarCartao(CartaoCredito cartao) {
		System.out.println("Cartão"  + cartao.getNome() + "removido com sucesso!");
	}
	
	
	public void atualizarCartao() {
		
	}
	
	public void consultarCartao() {
		
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdAnexo() {
		return idAnexo;
	}

	public void setDataFechamento(Calendar dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public void setIdAnexo(int idAnexo) {
		this.idAnexo = idAnexo;
	}

}
