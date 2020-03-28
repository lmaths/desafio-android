package com.rightside.tembicimatheuslima.ws;
import com.rightside.tembicimatheuslima.model.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiREST {


    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @GET("search/repositories?q=language:Java&sort=stars")
    Call<Response> response(@Query("page") int page);






}
