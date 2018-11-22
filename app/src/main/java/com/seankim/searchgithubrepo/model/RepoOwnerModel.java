package com.seankim.searchgithubrepo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RepoOwnerModel {
    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("node_id")
    @Expose
    private String node_id;

    @SerializedName("avatar_url")
    @Expose
    private String avatar_url;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("received_events_url")
    @Expose
    private String received_events_url;

    @SerializedName("type")
    @Expose
    private String type;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getReceived_events_url() {
        return received_events_url;
    }

    public void setReceived_events_url(String received_events_url) {
        this.received_events_url = received_events_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
