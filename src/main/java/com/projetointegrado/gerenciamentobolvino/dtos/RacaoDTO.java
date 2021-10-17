package com.projetointegrado.gerenciamentobolvino.dtos;

import com.projetointegrado.gerenciamentobolvino.domain.Racao;

import java.io.Serializable;

public class RacaoDTO implements Serializable {

    private Integer id;
    private String ingredientes;
    private String dataCriacao;

    public RacaoDTO(Integer id, String ingredientes, String dataCriacao) {
        this.id = id;
        this.ingredientes = ingredientes;
        this.dataCriacao = dataCriacao;
    }

    public RacaoDTO(Racao obj) {
        this.id = obj.getId();
        this.ingredientes = obj.getIngredientes();
        this.dataCriacao = obj.getDataCriacao();
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
}
