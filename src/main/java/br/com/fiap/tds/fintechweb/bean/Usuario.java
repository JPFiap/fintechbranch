package br.com.fiap.tds.fintechweb.bean;

import java.util.Date;

public class Usuario {

	private String email;
	private String senha;
	private Cliente cliente;
	
	
	public Usuario() {	
	}

	public Usuario(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public void cadastrarUsuario(String email, String senha) {
		  this.email = email;
		  this.senha = senha;
		System.out.println("Cadastro simplicado do usuário realizado com sucesso!");

	}

	public void cadastrarUsuario(String cpf, String nome, Date dataNasc, char sexo, String nacionalidade,
			String nomeSocial, String telefone, String email, String senha) {
		Cliente cliente = new Cliente();
//		cliente.setCpf(cpf);
//		cliente.setNome(nome);
//		cliente.setDataNasc(dataNasc);
//		cliente.setNacionalidade(nacionalidade);
//		cliente.setSexo(sexo);
//		cliente.setNomeSocial(nomeSocial);
//		cliente.setTelefone(telefone);
//		cliente.setEmail(email);
//		cliente.setSenha(senha);
		
		cliente.cadastrarCliente(cpf, nome, dataNasc, sexo, nacionalidade, nomeSocial, telefone, email, senha);

		System.out.println("Cadastro completo do usuário realizado com sucesso!");

	}

	public void logarUsuario(String email, String senha) {
		System.out.println("Usuario logado");

	}

	public void deletarUsuario(String email, String senha) {
		setEmail(null);
		setSenha(null);
		System.out.println("Usuario deletado com sucesso");

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
