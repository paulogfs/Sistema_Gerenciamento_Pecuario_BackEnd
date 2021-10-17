package com.projetointegrado.gerenciamentobolvino.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HistoricoMedicacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String dataAplicacao;
	private float dosagem;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "animal_id")
	private Animal animal;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "medicacao_id")
	private Medicacao medicacao;

	public HistoricoMedicacao() {
		super();
	}

	public HistoricoMedicacao(Integer id, String dataAplicacao, float dosagem, Animal animal, Medicacao medicacao) {
		super();
		this.id = id;
		this.dataAplicacao = dataAplicacao;
		this.dosagem = dosagem;
		this.animal = animal;
		this.medicacao = medicacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(String dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}

	public float getDosagem() {
		return dosagem;
	}

	public void setDosagem(float dosagem) {
		this.dosagem = dosagem;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Medicacao getMedicacao() {
		return medicacao;
	}

	public void setMedicacao(Medicacao medicacao) {
		this.medicacao = medicacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoricoMedicacao other = (HistoricoMedicacao) obj;
		return Objects.equals(id, other.id);
	}
	
}
