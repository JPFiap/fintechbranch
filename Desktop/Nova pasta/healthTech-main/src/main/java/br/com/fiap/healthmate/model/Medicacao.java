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
@Table(name = "tbl_medicacao")
public class Medicacao {
	
	@Id
	@SequenceGenerator(name="medicacao", sequenceName = "sq_tb_medicacao", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="medicacao")
	@Column(name = "id_medicamento")
	private int id;
	
	@Column(name = "st_medicacao")
	@NotNull
	private Boolean  possuiMedicacao;
	
	
	public Boolean getPossuiMedicacao() {
		return possuiMedicacao;
	}

	public void setPossuiMedicacao(Boolean possuiMedicacao) {
		this.possuiMedicacao = possuiMedicacao;
	}

	@Column(name = "nm_medicacao")
	private String nome;
	
	@Column(name = "ds_uso")
	private String uso;
	
	@JoinColumn(name = "id_medicacao_usuario")
	@ManyToOne
	private Usuario usuario;


	public Medicacao() {
		super();
	}
	
	

	public Medicacao(int id, Boolean possuiMedicacao, String nome, String uso) {
		super();
		this.id = id;
		this.possuiMedicacao = possuiMedicacao;
		this.nome = nome;
		this.uso = uso;
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

	public String getUso() {
		return uso;
	}

	public void setUso(String uso) {
		this.uso = uso;
	}
	
	

}
