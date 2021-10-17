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
public class Pasto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String dataCriacao;
	private String nomePasto;
	
	@OneToMany(mappedBy = "lote")
	private List<StatusPastoAndLote> statusPastoAndLotes = new ArrayList<>();

	public Pasto() {
		super();
	}

	public Pasto(Integer id, String dataCriacao, String nomePasto) {
		super();
		this.id = id;
		this.dataCriacao = dataCriacao;
		this.nomePasto = nomePasto;
	}

	public List<StatusPastoAndLote> getStatusPastoAndLotes() {
		return statusPastoAndLotes;
	}

	public void setStatusPastoAndLotes(List<StatusPastoAndLote> statusPastoAndLotes) {
		this.statusPastoAndLotes = statusPastoAndLotes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getNomePasto() {
		return nomePasto;
	}

	public void setNomePasto(String nomePasto) {
		this.nomePasto = nomePasto;
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
		Pasto other = (Pasto) obj;
		return Objects.equals(id, other.id);
	}
		
}
