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
public class Peso implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String dataPesagem;
	private float peso;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "animal_id")
	private Animal animal;

	public Peso() {
		super();
	}

	public Peso(Integer id, String dataPesagem, float peso, Animal animal) {
		super();
		this.id = id;
		this.dataPesagem = dataPesagem;
		this.peso = peso;
		this.animal = animal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataPesagem() {
		return dataPesagem;
	}

	public void setDataPesagem(String dataPesagem) {
		this.dataPesagem = dataPesagem;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
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
		Peso other = (Peso) obj;
		return id == other.id;
	}

}
