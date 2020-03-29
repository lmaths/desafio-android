package com.rightside.tembicimatheuslima.model;

import com.google.gson.annotations.SerializedName;

public class Repository {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("description")
    private String description;
    @SerializedName("forks")
    private int forks;
    @SerializedName("stargazers_count")
    private int stars;
    @SerializedName("owner")
    private Owner creator;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Owner getCreator() {
        return creator;
    }

    public void setCreator(Owner creator) {
        this.creator = creator;
    }


    public boolean contain(String text) {
        return getName().toLowerCase().contains(text.toLowerCase());
    }

}
