package br.com.fiap.tds.fintechweb.bean;

import java.util.Scanner;

public class Endereco {

	private String cep;
	private String bairro;
	private String logradouro;
	private int numero;
	private String cidade;
	private String estado;
	private String pais;
	private Cliente cliente;
	

	public Endereco() {
	}

	public Endereco(String cep, String bairro, String logradouro, int numero, String cidade, String estado,
			String pais) {
		super();
		this.cep = cep;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}

	public void cadastrarEndereco(String cep, String bairro, String logradouro, int numero, String cidade, String estado,
			String pais, Cliente cliente) {
		System.out.println("Endereço cadastrado com sucesso!");

	}

	public Endereco atualizarEndereco(String email, String senha) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Atualizar CEP");
		this.cep = sc.nextLine();
		System.out.println("Atualizar bairro:");
		this.bairro = sc.nextLine();
		System.out.println("Atualizar logradouro:");
		this.logradouro = sc.nextLine();
		System.out.println("Atualizar numero:");
		this.numero = sc.nextInt();
		System.out.println("Atualizar cidade:");
		this.cidade = sc.nextLine();
		System.out.println("Atualizar estado:");
		this.estado = sc.nextLine();
		System.out.println("Atualizar pais:");
		this.pais = sc.nextLine();
		sc.close();
		System.out.println("Dados atualizados com sucesso!");
		
	Endereco endereco = new Endereco();
		return endereco;
	
	}

	public String getCep() {
		return cep;
	}

	public String getBairro() {
		return bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getPais() {
		return pais;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
