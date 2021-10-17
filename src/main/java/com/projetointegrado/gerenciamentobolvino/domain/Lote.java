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
public class Lote implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String dataCriacao;
	private String nomeLote;

	@OneToMany(mappedBy = "lote")
	private List<StatusPastoAndLote> statusPastoAndLotes = new ArrayList<>();
	
	@OneToMany(mappedBy = "lote")
	private List<StatusRacaoAndLote> statusRacaoAndLotes = new ArrayList<>();

	@OneToMany(mappedBy = "lote")
	private List<StatusBovinoAndLote> statusBovinoAndLotes = new ArrayList<>();
	
	public Lote() {
		super();
	}

	public Lote(Integer id, String dataCriacao, String nomeLote) {
		super();
		this.id = id;
		this.dataCriacao = dataCriacao;
		this.nomeLote = nomeLote;
	}
	
	public List<StatusBovinoAndLote> getStatusBovinoAndLotes() {
		return statusBovinoAndLotes;
	}

	public void setStatusBovinoAndLotes(List<StatusBovinoAndLote> statusBovinoAndLotes) {
		this.statusBovinoAndLotes = statusBovinoAndLotes;
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

	public String getNomeLote() {
		return nomeLote;
	}

	public void setNomeLote(String nomeLote) {
		this.nomeLote = nomeLote;
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
		Lote other = (Lote) obj;
		return Objects.equals(id, other.id);
	}

}
