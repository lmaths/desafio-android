package com.rightside.tembicimatheuslima.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("login")
    private String name;
    @SerializedName("avatar_url")
    private String profilePictureUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }
}
