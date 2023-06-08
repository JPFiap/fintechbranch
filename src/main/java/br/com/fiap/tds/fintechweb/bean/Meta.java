package br.com.fiap.tds.fintechweb.bean;

import java.util.Date;

public class Meta {

	private String nome;
    private String descricao;
    private double valorMeta;
    private double valorAtual;
    private Date dataObjetivo;
    private Date dataDeposito;
    
    public Meta(String nome, double valorMeta, double valorAtual, String descricao, Date dataObjetivo, Date dataDeposito) {
        this.nome = nome;
        this.valorMeta = valorMeta;
        this.valorAtual = valorAtual;
        this.descricao = descricao;
        this.dataObjetivo = dataObjetivo;
        this.dataDeposito = dataDeposito;
    }

    // getters e setters
    
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
    
    public Date getDataObjetivo() {
        return dataObjetivo;
    }
    
    public void atualizarDataObjetivo(Date dataObjetivo) {
        this.dataObjetivo = dataObjetivo;
    }
    
	public Date getDataDeposito() {
		return dataDeposito;
	}

	public void setDataDeposito(Date dataDeposito) {
		this.dataDeposito = dataDeposito;
	}

    
    // outros métodos públicos
    
    public void atualizarValorAtual(double valor) {
        this.valorAtual += valor;
    }
    
    public double calcularDiferenca() {
        return this.valorMeta - this.valorAtual;
    }
}
