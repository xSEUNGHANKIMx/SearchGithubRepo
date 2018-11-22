package com.seankim.searchgithubrepo.Net;

import com.seankim.searchgithubrepo.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface GithubAPI {
    @GET("search/repositories")
    @Headers({"Accept: application/vnd.github.mercy-preview+json"})
    Call<ResponseModel> reponse(
            @Query("q") String term,
            @Query("sort") String sort,
            @Query("order") String order
    );
}
