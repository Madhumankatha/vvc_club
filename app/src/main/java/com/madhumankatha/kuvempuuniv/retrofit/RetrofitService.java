package com.madhumankatha.kuvempuuniv.retrofit;

import com.madhumankatha.kuvempuuniv.utils.AppConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(AppConfig.AppUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static <S> S createService(Class<S> serviceClass){
        return retrofit.create(serviceClass);
    }
}
