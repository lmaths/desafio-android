package com.rightside.tembicimatheuslima.model;

import com.google.gson.annotations.SerializedName;

public class Owner {
    @SerializedName("login")
    private String nome;
    @SerializedName("avatar_url")
    private String linkFoto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }
}
