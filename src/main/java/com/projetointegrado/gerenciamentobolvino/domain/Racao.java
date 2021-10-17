package com.projetointegrado.gerenciamentobolvino.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Racao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String ingredientes;
	private String dataCriacao;

	@OneToMany(mappedBy = "racao")
	private List<StatusRacaoAndLote> statusRacaoAndLotes = new ArrayList<>();

	public Racao() {
		super();
	}

	public Racao(Integer id, String ingredientes, String dataCriacao) {
		super();
		this.id = id;
		this.ingredientes = ingredientes;
		this.dataCriacao = dataCriacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public List<StatusRacaoAndLote> getStatusRacaoAndLotes() {
		return statusRacaoAndLotes;
	}

	public void setStatusRacaoAndLotes(List<StatusRacaoAndLote> statusRacaoAndLotes) {
		this.statusRacaoAndLotes = statusRacaoAndLotes;
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
		Racao other = (Racao) obj;
		return Objects.equals(id, other.id);
	}

}
