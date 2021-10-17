package com.projetointegrado.gerenciamentobolvino.dtos;

import com.projetointegrado.gerenciamentobolvino.domain.Venda;

import java.io.Serializable;

public class VendaDTO implements Serializable {

    private Integer id;
    private float valorArroba;
    private String dataVenda;
    private String registroComprador;
    private float valorLote;

    public VendaDTO(Integer id, float valorArroba, String dataVenda, String registroComprador, float valorLote) {
        this.id = id;
        this.valorArroba = valorArroba;
        this.dataVenda = dataVenda;
        this.registroComprador = registroComprador;
        this.valorLote = valorLote;
    }

    public VendaDTO(Venda obj) {
        this.id = obj.getId();
        this.valorArroba = obj.getValorArroba();
        this.dataVenda = obj.getDataVenda();
        this.registroComprador = obj.getRegistroComprador();
        this.valorLote = obj.getValorLote();
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
}
