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
public class Venda implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private float valorArroba;
	private String dataVenda;
	private String registroComprador;
	private float valorLote;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Venda() {
		super();
	}

	public Venda(Integer id, float valorArroba, String dataVenda, String registroComprador, float valorLote,
			Usuario usuario) {
		super();
		this.id = id;
		this.valorArroba = valorArroba;
		this.dataVenda = dataVenda;
		this.registroComprador = registroComprador;
		this.valorLote = valorLote;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getValorArroba() {
		return valorArroba;
	}

	public void setValorArroba(float valorArroba) {
		this.valorArroba = valorArroba;
	}

	public String getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getRegistroComprador() {
		return registroComprador;
	}

	public void setRegistroComprador(String registroComprador) {
		this.registroComprador = registroComprador;
	}

	public float getValorLote() {
		return valorLote;
	}

	public void setValorLote(float valorLote) {
		this.valorLote = valorLote;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		Venda other = (Venda) obj;
		return Objects.equals(id, other.id);
	}
	
}
