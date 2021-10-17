package com.projetointegrado.gerenciamentobolvino.dtos;

import com.projetointegrado.gerenciamentobolvino.domain.Usuario;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {

    private Integer id;

    private String nome;
    private String usuario;
    private String senha;
    private String dataCriacao;

    public UsuarioDTO(Integer id, String nome, String usuario, String senha, String dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
    }

    public UsuarioDTO(Usuario obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.usuario = obj.getUsuario();
        this.senha = obj.getSenha();
        this.dataCriacao = obj.getDataCriacao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
