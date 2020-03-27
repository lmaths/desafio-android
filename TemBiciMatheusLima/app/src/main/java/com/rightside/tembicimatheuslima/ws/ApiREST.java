package com.rightside.tembicimatheuslima.ws;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiREST {


    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @GET("search/repositories?q=language:Java&sort=stars&page={page}/")
    Call<List<Repositorio>> listaRepositorio(@Path("page") int page);











}
