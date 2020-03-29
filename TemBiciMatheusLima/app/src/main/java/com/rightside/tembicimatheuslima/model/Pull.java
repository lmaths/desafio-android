package com.rightside.tembicimatheuslima.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Pull {

    @SerializedName("title")
    private String name;
    @SerializedName("created_at")
    private Date date;
    @SerializedName("body")
    private String body;

    @SerializedName("repos_url")
    private String repositoryUrl;

    @SerializedName("user")
    private User user;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }
}
