package com.projetointegrado.gerenciamentobolvino.dtos;

import com.projetointegrado.gerenciamentobolvino.domain.Animal;

import java.io.Serializable;

public class AnimalDTO implements Serializable {

    private Integer id;
    private String brinco;
    private String raca;

    public AnimalDTO(Integer id, String brinco, String raca) {
        this.id = id;
        this.brinco = brinco;
        this.raca = raca;
    }

    public AnimalDTO(Animal obj) {
        this.id = obj.getId();
        this.brinco = obj.getBrinco();
        this.raca = obj.getRaca();
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
}
