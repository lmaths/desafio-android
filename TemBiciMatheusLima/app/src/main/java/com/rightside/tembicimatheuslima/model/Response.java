package com.rightside.tembicimatheuslima.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable {

    @SerializedName("total_count")
    private int totalCount;
    @SerializedName("incomplete_results")
    private boolean incompletedResults;
    @SerializedName("items")
    private List<Repository> itens;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isIncompletedResults() {
        return incompletedResults;
    }

    public void setIncompletedResults(boolean incompletedResults) {
        this.incompletedResults = incompletedResults;
    }

    public List<Repository> getItens() {
        return itens;
    }

    public void setItens(List<Repository> itens) {
        this.itens = itens;
    }


}
