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
@Table(name = "tbl_contato")
public class Contato {

	@Id
	@SequenceGenerator(name="contato", sequenceName = "sq_tb_contato", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="contato")
	@Column(name = "id_contato")
	private int id;

	@Column(name = "nm_contato")
	@NotNull
	private String nome;

	@Column(name = "nr_telefone")
	@NotNull
	private String telefone;


	@Column(name = "ds_parentesco")
	private String parentesco;

	@Column(name = "ds_proximidade")
	private String proximidade;
	
	@JoinColumn(name = "id_contato_usuario")
	@ManyToOne
	private Usuario usuario;


	public Contato() {
		super();
	}

	
	
	public Contato(int id, String nome, String telefone, String parentesco, String proximidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.parentesco = parentesco;
		this.proximidade = proximidade;
	}



	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getProximidade() {
		return proximidade;
	}

	public void setProximidade(String proximidade) {
		this.proximidade = proximidade;
	}

}
