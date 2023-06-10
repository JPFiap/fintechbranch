package br.com.fiap.tds.fintechweb.bean;

import java.util.Calendar;

import br.com.fiap.tds.fintechweb.util.CriptografiaUtils;

public class Usuario {

	private String cpf;
	private String nome;
	private Calendar dataNasc;
	private char sexo;
	private String nacionalidade;
	private String telefone;
	private String email;
	private String senha;

	public Usuario() {

	}

	public Usuario(String cpf, String email, String senha, String nome, Calendar dataNasc) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.email = email;
		this.senha = senha;
	}


	public Usuario(String cpf, String nome, Calendar dataNasc, String nacionalidade, String telefone, String email,
			String senha) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.nacionalidade = nacionalidade;
		this.telefone = telefone;
		this.email = email;
		setSenha(senha);
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public Calendar getDataNasc() {
		return dataNasc;
	}

	public char getSexo() {
		return sexo;
	}

	public String getNacionalidade() {
		return nacionalidade;
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

	public void setDataNasc(Calendar dataNasc) {
		this.dataNasc = dataNasc;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
		try {
			this.senha = CriptografiaUtils.criptografar(senha);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
