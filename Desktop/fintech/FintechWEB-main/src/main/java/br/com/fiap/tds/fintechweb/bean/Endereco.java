package br.com.fiap.tds.fintechweb.bean;

public class Endereco {

	private String cpf;
	private int cep;
	private int numero;
	private String complemento;

	public Endereco() {
	}

	public Endereco(String cpf, int cep, int numero, String complemento) {
		super();
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
		this.cpf = cpf;
	}
	
	public Endereco(String cpf, int cep, int numero) {
		super();
		this.cep = cep;
		this.numero = numero;
		this.cpf = cpf;
	}

	public int getCep() {
		return cep;
	}

	public int getNumero() {
		return numero;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
