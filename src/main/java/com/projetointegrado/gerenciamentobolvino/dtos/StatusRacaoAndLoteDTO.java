package com.projetointegrado.gerenciamentobolvino.dtos;

import com.projetointegrado.gerenciamentobolvino.domain.StatusRacaoAndLote;

import java.io.Serializable;

public class StatusRacaoAndLoteDTO implements Serializable {

    private Integer id;
    private String tempoInicial;
    private String tempoFinal;

    public StatusRacaoAndLoteDTO(Integer id, String tempoInicial, String tempoFinal) {
        this.id = id;
        this.tempoInicial = tempoInicial;
        this.tempoFinal = tempoFinal;
    }

    public StatusRacaoAndLoteDTO(StatusRacaoAndLote obj) {
        this.id = obj.getId();
        this.tempoInicial = obj.getTempoInicial();
        this.tempoFinal = obj.getTempoFinal();
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

}
