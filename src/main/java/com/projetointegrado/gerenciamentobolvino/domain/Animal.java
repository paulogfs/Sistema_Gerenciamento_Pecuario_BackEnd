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
public class Animal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String brinco;
	private String raca;
	
	@OneToMany(mappedBy = "animal")
	private List<Peso> pesos = new ArrayList<>();

	@OneToMany(mappedBy = "animal")
	private List<HistoricoMedicacao> historicoMedicacaos = new ArrayList<>();
	
	@OneToMany(mappedBy = "animal")
	private List<StatusBovinoAndLote> statusBovinoAndLotes = new ArrayList<>();
	
	public Animal() {
		super();
	}

	public Animal(Integer id, String brinco, String raca) {
		super();
		this.id = id;
		this.brinco = brinco;
		this.raca = raca;
	}

	public List<StatusBovinoAndLote> getStatusBovinoAndLotes() {
		return statusBovinoAndLotes;
	}
	
	public void setStatusBovinoAndLotes(List<StatusBovinoAndLote> statusBovinoAndLotes) {
		this.statusBovinoAndLotes = statusBovinoAndLotes;
	}

	public List<HistoricoMedicacao> getHistoricoMedicacaos() {
		return historicoMedicacaos;
	}

	public void setHistoricoMedicacaos(List<HistoricoMedicacao> historicoMedicacaos) {
		this.historicoMedicacaos = historicoMedicacaos;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrinco() {
		return brinco;
	}

	public void setBrinco(String brinco) {
		this.brinco = brinco;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public List<Peso> getPesos() {
		return pesos;
	}

	public void setPesos(List<Peso> pesos) {
		this.pesos = pesos;
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
		Animal other = (Animal) obj;
		return id == other.id;
	}

}
