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
public class StatusRacaoAndLote implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String tempoInicial;
	private String tempoFinal;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "racao_id")
	private Racao racao;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "lote_id")
	private Lote lote;

	public StatusRacaoAndLote() {
		super();
	}

	public StatusRacaoAndLote(Integer id, String tempoInicial, String tempoFinal, Racao racao, Lote lote) {
		super();
		this.id = id;
		this.tempoInicial = tempoInicial;
		this.tempoFinal = tempoFinal;
		this.racao = racao;
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

	public Racao getRacao() {
		return racao;
	}

	public void setRacao(Racao racao) {
		this.racao = racao;
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
		StatusRacaoAndLote other = (StatusRacaoAndLote) obj;
		return Objects.equals(id, other.id);
	}
	
}
