package br.com.fiap.tds.fintechweb.bean;

import java.util.Calendar;

public class Meta {

	private String cpf;
	private int id;
	private String nome;
	private String descricao;
	private double valorMeta;
	private double valorAtual;
	private Calendar dataAlvo;
	private Calendar dataDeposito;

	public Meta() {

	}

	public Meta(int id, String cpf, String nome, double valorMeta, double valorAtual, String descricao,
			Calendar dataAlvo, Calendar dataDeposito) {
		this.cpf = cpf;
		this.id = id;
		this.nome = nome;
		this.valorMeta = valorMeta;
		this.valorAtual = valorAtual;
		this.descricao = descricao;
		this.dataAlvo = dataAlvo;
		this.dataDeposito = dataDeposito;
	}
	
	public Meta(int id, String cpf, String nome, double valorMeta) {
		this.cpf = cpf;
		this.id = id;
		this.nome = nome;
		this.valorMeta = valorMeta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorMeta() {
		return valorMeta;
	}

	public void setValorMeta(double valorMeta) {
		this.valorMeta = valorMeta;
	}

	public double getValorAtual() {
		return valorAtual;
	}

	public void setValorAtual(double valorAtual) {
		this.valorAtual = valorAtual;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataAlvo() {
		return dataAlvo;
	}

	public void atualizarDataAlvo(Calendar dataAlvo) {
		this.dataAlvo = dataAlvo;
	}

	public Calendar getDataDeposito() {
		return dataDeposito;
	}

	public void setDataDeposito(Calendar dataDeposito) {
		this.dataDeposito = dataDeposito;
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
