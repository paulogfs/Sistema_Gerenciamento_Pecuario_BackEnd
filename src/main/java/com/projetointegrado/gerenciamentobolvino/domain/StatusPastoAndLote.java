package com.projetointegrado.gerenciamentobolvino.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class StatusPastoAndLote implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String tempoInicial;
	private String tempoFinal;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "pasto_id")
	private Pasto pasto;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "lote_id")
	private Lote lote;

	public StatusPastoAndLote() {
		super();
	}

	public StatusPastoAndLote(Integer id, String tempoInicial, String tempoFinal, Pasto pasto, Lote lote) {
		super();
		this.id = id;
		this.tempoInicial = tempoInicial;
		this.tempoFinal = tempoFinal;
		this.pasto = pasto;
		this.lote = lote;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTempoInicial() {
		return tempoInicial;
	}

	public void setTempoInicial(String tempoInicial) {
		this.tempoInicial = tempoInicial;
	}

	public String getTempoFinal() {
		return tempoFinal;
	}

	public void setTempoFinal(String tempoFinal) {
		this.tempoFinal = tempoFinal;
	}

	public Pasto getPasto() {
		return pasto;
	}

	public void setPasto(Pasto pasto) {
		this.pasto = pasto;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
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
		StatusPastoAndLote other = (StatusPastoAndLote) obj;
		return Objects.equals(id, other.id);
	}
		
}
