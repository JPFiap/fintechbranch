package br.com.fiap.healthmate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_endereco")
public class Endereco {

	@Id
	@SequenceGenerator(name = "endereco", sequenceName = "sq_tb_endereco", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco")
	@Column(name = "id_endereco")
	private int id;

	@Column(name = "ds_estado")
	@NotNull
	private String estado;

	@Column(name = "nm_cidade")
	@NotNull
	private String cidade;

	@Column(name = "nr_cep")
	@NotNull
	private String cep;

	@Column(name = "ds_logradouro")
	@NotNull
	private String logradouro;

	@JoinColumn(name = "id_endereco_usuario")
	@ManyToOne
	private Usuario usuario;

	public Endereco() {
		super();
	}

	public Endereco(int id, String estado, String cidade, String cep, String logradouro) {
		super();
		this.id = id;
		this.estado = estado;
		this.cidade = cidade;
		this.cep = cep;
		this.logradouro = logradouro;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

}
