package com.projetointegrado.gerenciamentobolvino.dtos;

import com.projetointegrado.gerenciamentobolvino.domain.HistoricoMedicacao;

import java.io.Serializable;

public class HistoricoMedicacaoDTO implements Serializable {

    private Integer id;
    private String dataAplicacao;
    private float dosagem;

    public HistoricoMedicacaoDTO(Integer id, String dataAplicacao, float dosagem) {
        this.id = id;
        this.dataAplicacao = dataAplicacao;
        this.dosagem = dosagem;
    }

    public HistoricoMedicacaoDTO(HistoricoMedicacao obj) {
        this.id = obj.getId();
        this.dataAplicacao = obj.getDataAplicacao();
        this.dosagem = obj.getDosagem();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(String dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public float getDosagem() {
        return dosagem;
    }

    public void setDosagem(float dosagem) {
        this.dosagem = dosagem;
    }
}
