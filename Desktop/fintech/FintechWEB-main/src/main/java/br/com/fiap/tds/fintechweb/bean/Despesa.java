package br.com.fiap.tds.fintechweb.bean;

import java.util.Calendar;

public class Despesa extends Movimentacao {

	private int qtdParcelas;
	private boolean fixo;
	private Calendar dtSaida;
	private int parcelaAtual;
	private Usuario usuario;

	public Despesa(String cpf, int id, String nome, double valor, String descricao, int qtdParcelas, boolean fixo,
			Calendar dtSaida, int parcelaAtual) {
		super(cpf, id, nome, valor, descricao);
		this.qtdParcelas = qtdParcelas;
		this.fixo = fixo;
		this.dtSaida = dtSaida;
		this.parcelaAtual = parcelaAtual;
	}

	public Despesa(String cpf, int id, String nome, double valor, int qtdParcelas, boolean fixo, Calendar dtSaida,
			int parcelaAtual) {
		super(cpf, id, nome, valor);
		this.qtdParcelas = qtdParcelas;
		this.fixo = fixo;
		this.dtSaida = dtSaida;
		this.parcelaAtual = parcelaAtual;
	}

	public Despesa(String cpf, int id, String nome, double valor, String descricao, int qtdParcelas, boolean fixo, Calendar dtSaida) {
		super(cpf, id, nome, valor, descricao);
		this.qtdParcelas = qtdParcelas;
		this.fixo = fixo;
		this.dtSaida = dtSaida;
	}

	public Despesa(String cpf, int id, String nome, double valor) {
		super(cpf, id, nome, valor);
	}

	public int getQtdParcelas() {
		return qtdParcelas;
	}

	public boolean isFixo() {
		return fixo;
	}

	public void setQtdParcelas(int qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}

	public void setFixo(boolean fixo) {
		this.fixo = fixo;
	}

	public Calendar getDtSaida() {
		return dtSaida;
	}

	public void setDtSaida(Calendar dtSaida) {
		this.dtSaida = dtSaida;
	}

	public int getParcelaAtual() {
		return parcelaAtual;
	}

	public void setParcelaAtual(int parcelaAtual) {
		this.parcelaAtual = parcelaAtual;
	}

	@Override
	public void cadastrar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletar(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object atualizar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object consultar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int calcularParcelasRestantes() {
		if (qtdParcelas == 0) {
			return 0;
		}
		int parcelasRestantes = qtdParcelas - parcelaAtual;
		return parcelasRestantes > 0 ? parcelasRestantes : 0;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
