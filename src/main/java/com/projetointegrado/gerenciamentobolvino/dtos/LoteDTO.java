package com.projetointegrado.gerenciamentobolvino.dtos;

import com.projetointegrado.gerenciamentobolvino.domain.Lote;

import java.io.Serializable;

public class LoteDTO implements Serializable {

    private Integer id;
    private String dataCriacao;
    private String nomeLote;

    public LoteDTO(Integer id, String dataCriacao, String nomeLote) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.nomeLote = nomeLote;
    }

    public LoteDTO(Lote obj) {
        this.id = obj.getId();
        this.dataCriacao = obj.getDataCriacao();
        this.nomeLote = obj.getNomeLote();
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
}
