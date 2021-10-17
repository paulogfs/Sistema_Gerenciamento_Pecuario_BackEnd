package com.projetointegrado.gerenciamentobolvino.dtos;

import com.projetointegrado.gerenciamentobolvino.domain.Medicacao;

import java.io.Serializable;

public class MedicacaoDTO implements Serializable {

    private Integer id;
    private String periodicidade;
    private String produtoUtilizado;
    private String loteMedicacao;

    public MedicacaoDTO(Integer id, String periodicidade, String produtoUtilizado, String loteMedicacao) {
        this.id = id;
        this.periodicidade = periodicidade;
        this.produtoUtilizado = produtoUtilizado;
        this.loteMedicacao = loteMedicacao;
    }

    public MedicacaoDTO(Medicacao obj) {
        this.id = obj.getId();
        this.periodicidade = obj.getPeriodicidade();
        this.produtoUtilizado = obj.getProdutoUtilizado();
        this.loteMedicacao = obj.getLoteMedicacao();
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
}
