package com.projetointegrado.gerenciamentobolvino.dtos;

import com.projetointegrado.gerenciamentobolvino.domain.Pasto;

import java.io.Serializable;

public class PastoDTO implements Serializable {

    private Integer id;
    private String dataCriacao;
    private String nomePasto;

    public PastoDTO(Integer id, String dataCriacao, String nomePasto) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.nomePasto = nomePasto;
    }

    public PastoDTO(Pasto obj) {
        this.id = obj.getId();
        this.dataCriacao = obj.getDataCriacao();
        this.nomePasto = obj.getNomePasto();
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
}
