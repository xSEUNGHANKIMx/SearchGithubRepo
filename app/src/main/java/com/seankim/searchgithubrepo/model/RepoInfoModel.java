package com.seankim.searchgithubrepo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RepoInfoModel {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("node_id")
    @Expose
    private String node_id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("full_name")
    @Expose
    private String fullName;

    @SerializedName("owner")
    @Expose
    private RepoOwnerModel owner;

    @SerializedName("private")
    @Expose
    private Boolean _private;

    @SerializedName("html_url")
    @Expose
    private String html_url;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("fork")
    @Expose
    private Boolean fork;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("created_at")
    @Expose
    private String created_at;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @SerializedName("pushed_at")
    @Expose
    private String pushed_at;

    @SerializedName("homepage")
    @Expose
    private String homepage;

    @SerializedName("size")
    @Expose
    private Integer size;

    @SerializedName("stargazers_count")
    @Expose
    private Integer stargazersCount;

    @SerializedName("watchers_count")
    @Expose
    private Integer watchers_count;

    @SerializedName("language")
    @Expose
    private String language;

    @SerializedName("forks_count")
    @Expose
    private Integer forks_count;

    @SerializedName("open_issues_count")
    @Expose
    private Integer open_issues_count;

    @SerializedName("score")
    @Expose
    private Double score;

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

    public RepoOwnerModel getOwner() {
        return owner;
    }

    public void setOwner(RepoOwnerModel owner) {
        this.owner = owner;
    }

    public Boolean get_private() {
        return _private;
    }

    public void set_private(Boolean _private) {
        this._private = _private;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFork() {
        return fork;
    }

    public void setFork(Boolean fork) {
        this.fork = fork;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPushed_at() {
        return pushed_at;
    }

    public void setPushed_at(String pushed_at) {
        this.pushed_at = pushed_at;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getStargazersCount() {
        return stargazersCount;
    }

    public void setStargazersCount(Integer stargazersCount) {
        this.stargazersCount = stargazersCount;
    }

    public Integer getWatchers_count() {
        return watchers_count;
    }

    public void setWatchers_count(Integer watchers_count) {
        this.watchers_count = watchers_count;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getForks_count() {
        return forks_count;
    }

    public void setForks_count(Integer forks_count) {
        this.forks_count = forks_count;
    }

    public Integer getOpen_issues_count() {
        return open_issues_count;
    }

    public void setOpen_issues_count(Integer open_issues_count) {
        this.open_issues_count = open_issues_count;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
