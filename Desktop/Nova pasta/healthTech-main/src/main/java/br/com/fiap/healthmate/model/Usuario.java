package br.com.fiap.healthmate.model;

import java.util.Collection;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_usuario")
public class Usuario {

	@Id
	@SequenceGenerator(name = "usuario", sequenceName = "sq_tb_usuario", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
	@Column(name = "id_usuario")
	private int id;

	@Column(name = "nr_cpf")
	@NotNull
	private String cpf;

	@Column(name = "nm_usuario")
	@NotNull
	private String nome;

	@Column(name = "dt_nascimento")
	@NotNull
	private Date dtNascimento;

	@Column(name = "nr_telefone")
	@NotNull
	private String telefone;

	@Column(name = "ds_sexo")
	@NotNull
	private String sexo;

	@Column(name = "tp_sanguineo")
	@NotNull
	private String tpSanguineo;

	@Column(name = "ds_senha")
	@NotNull
	private String senha;

	@OneToMany
	private Collection<Alergia> alergia;

	@OneToMany
	private Collection<Contato> contato;

	@OneToMany
	private Collection<Doenca> doenca;

	@OneToMany
	private Collection<Endereco> endereco;

	@OneToMany
	private Collection<Medicacao> medicacao;

	public Usuario() {
		super();
	}

	public Usuario(int id, String cpf, String nome, Date dtNascimento, String telefone, String sexo, String tpSanguineo,
			String senha) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.telefone = telefone;
		this.sexo = sexo;
		this.tpSanguineo = tpSanguineo;
		this.senha = senha;
	}

	public long getId() {
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTpSanguineo() {
		return tpSanguineo;
	}

	public void setTpSanguineo(String tpSanguineo) {
		this.tpSanguineo = tpSanguineo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
