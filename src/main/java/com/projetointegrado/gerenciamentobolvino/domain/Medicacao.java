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
public class Medicacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String periodicidade;
	private String produtoUtilizado;
	private String loteMedicacao;
	
	@OneToMany(mappedBy = "medicacao")
	private List<HistoricoMedicacao> historicoMedicacaos = new ArrayList<>();

	public Medicacao() {
		super();
	}

	public Medicacao(Integer id, String periodicidade, String produtoUtilizado, String loteMedicacao) {
		super();
		this.id = id;
		this.periodicidade = periodicidade;
		this.produtoUtilizado = produtoUtilizado;
		this.loteMedicacao = loteMedicacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPeriodicidade() {
		return periodicidade;
	}

	public void setPeriodicidade(String periodicidade) {
		this.periodicidade = periodicidade;
	}

	public String getProdutoUtilizado() {
		return produtoUtilizado;
	}

	public void setProdutoUtilizado(String produtoUtilizado) {
		this.produtoUtilizado = produtoUtilizado;
	}

	public String getLoteMedicacao() {
		return loteMedicacao;
	}

	public void setLoteMedicacao(String loteMedicacao) {
		this.loteMedicacao = loteMedicacao;
	}

	public List<HistoricoMedicacao> getHistoricoMedicacaos() {
		return historicoMedicacaos;
	}

	public void setHistoricoMedicacaos(List<HistoricoMedicacao> historicoMedicacaos) {
		this.historicoMedicacaos = historicoMedicacaos;
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
		Medicacao other = (Medicacao) obj;
		return Objects.equals(id, other.id);
	}
		
}
