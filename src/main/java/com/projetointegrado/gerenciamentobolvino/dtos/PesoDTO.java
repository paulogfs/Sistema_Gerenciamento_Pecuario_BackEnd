package com.projetointegrado.gerenciamentobolvino.dtos;

import com.projetointegrado.gerenciamentobolvino.domain.Peso;

import java.io.Serializable;

public class PesoDTO implements Serializable {

    private Integer id;
    private String dataPesagem;
    private float peso;

    public PesoDTO(Integer id, String dataPesagem, float peso) {
        this.id = id;
        this.dataPesagem = dataPesagem;
        this.peso = peso;
    }

    public PesoDTO(Peso obj) {
        this.id = obj.getId();
        this.dataPesagem = obj.getDataPesagem();
        this.peso = obj.getPeso();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataPesagem() {
        return dataPesagem;
    }

    public void setDataPesagem(String dataPesagem) {
        this.dataPesagem = dataPesagem;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}
