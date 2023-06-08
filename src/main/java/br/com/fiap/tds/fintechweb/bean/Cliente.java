package br.com.fiap.tds.fintechweb.bean;

import java.util.Date;
import java.util.Scanner;

public class Cliente {

	private String cpf;
	private String nome;
	private Date dataNasc;
	private char sexo;
	private String nacionalidade;
	private String nomeSocial;
	private String telefone;
	private Usuario usuario;
	private String email;
	private String senha;

	public Cliente() {

	}

	public Cliente(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public void cadastrarCliente(String cpf, String nome, Date dataNasc, char sexo, String nacionalidade,
			String nomeSocial, String telefone, String email, String senha) {
		System.out.println("Cliente cadastrado  com sucesso!");
	}


	
	public Cliente atualizarCliente(String email, String senha) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Informar novo e-mail:");
		this.email = sc.nextLine();
		System.out.println("Informar nova senha:");
		this.senha = sc.nextLine();
		sc.close();
		System.out.println("Dados atualizados com sucesso" +  email +  senha);
		Cliente cliente = new Cliente(email, senha);
		return cliente;

	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public char getSexo() {
		return sexo;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
