package com.rightside.tembicimatheuslima.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {

    @SerializedName("total_count")
    private int contagemTotal;
    @SerializedName("incomplete_results")
    private boolean resultadosIncompletos;
    @SerializedName("items")
    private List<Repository> itens;

    public int getContagemTotal() {
        return contagemTotal;
    }

    public void setContagemTotal(int contagemTotal) {
        this.contagemTotal = contagemTotal;
    }

    public boolean isResultadosIncompletos() {
        return resultadosIncompletos;
    }

    public void setResultadosIncompletos(boolean resultadosIncompletos) {
        this.resultadosIncompletos = resultadosIncompletos;
    }

    public List<Repository> getItens() {
        return itens;
    }

    public void setItens(List<Repository> itens) {
        this.itens = itens;
    }


}
