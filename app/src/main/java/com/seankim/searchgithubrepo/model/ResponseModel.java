package com.seankim.searchgithubrepo.model;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseModel {
    @Expose
    private Integer totalCount;

    @SerializedName("incomplete_results")
    @Expose
    private Boolean incompleteResults;

    @SerializedName("items")
    @Expose
    private List<RepoInfoModel> searchResults = null;

    public Integer getTotalCount() {
        return totalCount;
    }

    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    @Nullable
    public List<RepoInfoModel> getSearchResults() {
        return searchResults;
    }
}
