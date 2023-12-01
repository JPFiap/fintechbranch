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
@Table(name = "tbl_alergia")
public class Alergia {

	@Id
	@SequenceGenerator(name = "alergia", sequenceName = "sq_tb_alergia", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alergia")
	@Column(name = "id_alergia")
	private int id;

	@Column(name = "st_alergia")
	@NotNull
	private Boolean possuiAlergia;

	@Column(name = "nm_alergia")
	private String nome;

	@Column(name = "ds_sintoma")
	private String sintoma;
	
	@JoinColumn(name = "id_alergia_usuario")
	@ManyToOne
	private Usuario usuario;


	public Alergia() {
		super();
	}

	public Alergia(int id, Boolean possuiAlergia, String nome, String sintoma) {
		super();
		this.id = id;
		this.possuiAlergia = possuiAlergia;
		this.nome = nome;
		this.sintoma = sintoma;
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

	public String getSintoma() {
		return sintoma;
	}

	public void setSintoma(String sintomas) {
		this.sintoma = sintomas;
	}

	public Boolean getPossuiAlergia() {
		return possuiAlergia;
	}

	public void setPossuiAlergia(Boolean possuiAlergia) {
		this.possuiAlergia = possuiAlergia;
	}

	
}
