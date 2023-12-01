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
@Table(name = "tbl_doenca")
public class Doenca {

	@Id
	@SequenceGenerator(name="doenca", sequenceName = "sq_tb_doenca", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="doenca")
	@Column(name = "id_doenca")
	private int id;
	
	@Column(name = "st_doenca")
	@NotNull
	private Boolean  possuiDoenca;
	

	@Column(name = "nm_doenca")
	private String nome;

	@Column(name = "ds_tratamento")
	private String tratamento;
	
	@JoinColumn(name = "id_doenca_usuario")
	@ManyToOne
	private Usuario usuario;

	

	public Doenca() {
		super();
	}
	
	

	public Doenca(int id, Boolean possuiDoenca, String nome, String tratamento) {
		super();
		this.id = id;
		this.possuiDoenca = possuiDoenca;
		this.nome = nome;
		this.tratamento = tratamento;
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

	public String getTratamento() {
		return tratamento;
	}

	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}

	public Boolean getPossuiDoenca() {
		return possuiDoenca;
	}

	public void setPossuiDoenca(Boolean possuiDoenca) {
		this.possuiDoenca = possuiDoenca;
	}
	
	
}
