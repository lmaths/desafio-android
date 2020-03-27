package com.rightside.tembicimatheuslima.model;

import com.google.gson.annotations.SerializedName;

public class Repository {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String nome;
    @SerializedName("full_name")
    private String nomeCompleto;
    @SerializedName("description")
    private String descricao;
    @SerializedName("forks")
    private int bifurcacoes;
    @SerializedName("stargazers_count")
    private int estrelas;
    @SerializedName("owner")
    private Owner criador;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getBifurcacoes() {
        return bifurcacoes;
    }

    public void setBifurcacoes(int bifurcacoes) {
        this.bifurcacoes = bifurcacoes;
    }

    public int getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(int estrelas) {
        this.estrelas = estrelas;
    }

    public Owner getCriador() {
        return criador;
    }

    public void setCriador(Owner criador) {
        this.criador = criador;
    }

}
