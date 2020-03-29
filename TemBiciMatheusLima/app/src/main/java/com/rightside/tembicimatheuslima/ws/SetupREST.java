package com.rightside.tembicimatheuslima.ws;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.lifecycle.MutableLiveData;

import com.rightside.tembicimatheuslima.model.Owner;
import com.rightside.tembicimatheuslima.model.Pull;
import com.rightside.tembicimatheuslima.model.Response;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SetupREST {

    private MutableLiveData<Response> mutableLiveDataResponse = new MutableLiveData<>();
    private MutableLiveData<List<Pull>> mutableLiveDataPullRequest = new MutableLiveData<>();

    public static final ApiREST apiREST;


    static {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

         apiREST = retrofit.create(ApiREST.class);

    }

    public MutableLiveData<Response> getResponse(int page) {
        SetupREST.apiREST.response(page).enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                mutableLiveDataResponse.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
        return mutableLiveDataResponse;
    }


    public MutableLiveData<List<Pull>> getPullRequest(String ownerName, String repoName) {
        SetupREST.apiREST.pull(ownerName, repoName).enqueue(new Callback<List<Pull>>() {
            @Override
            public void onResponse(Call<List<Pull>> call, retrofit2.Response<List<Pull>> response) {
                    mutableLiveDataPullRequest.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Pull>> call, Throwable t) {
            }
        });
        return mutableLiveDataPullRequest;
    }
    
}
