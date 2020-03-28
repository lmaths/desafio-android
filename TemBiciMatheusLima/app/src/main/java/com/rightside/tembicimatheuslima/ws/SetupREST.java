package com.rightside.tembicimatheuslima.ws;

import androidx.lifecycle.MutableLiveData;

import com.rightside.tembicimatheuslima.model.Response;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SetupREST {

    private MutableLiveData<Response> mutableLiveDataResponse = new MutableLiveData<>();

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
}
