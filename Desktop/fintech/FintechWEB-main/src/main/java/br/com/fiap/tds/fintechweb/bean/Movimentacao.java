package br.com.fiap.tds.fintechweb.bean;

public abstract class Movimentacao {

	private int id;
	private String cpf;
	private String nome;
	private double valor;
	private String descricao;
	private Usuario usuario;

	public Movimentacao(String cpf, int id, String nome, double valor, String descricao) {
		super();
		this.cpf = cpf;
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.descricao = descricao;
	}

	public Movimentacao(String cpf,int id, String nome, double valor) {
		super();
		this.cpf = cpf;
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}
	public Movimentacao() {
		
	}
		
	public abstract void cadastrar();

	public abstract Object consultar(int id);

	public abstract void deletar(int id);

	public abstract Object atualizar(int id);

	public String getNome() {
		return nome;
	}

	public double getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
