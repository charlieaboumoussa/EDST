package com.cbm.edst.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitManager {

    public final static String BASE_URL = "";
    public final static String IMAGE_URL_API = "";

    private static RetrofitManager mInstance;
    private Retrofit mRetrofit;
    private Api mApi;

    private RetrofitManager(){
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        mApi = mRetrofit.create(Api.class);
    }

    public static Api getService(){
        if(mInstance == null){
            mInstance = new RetrofitManager();
        }
        return mInstance.mApi;
    }

    public static Retrofit getRetrofit(){
        if(mInstance == null){
            mInstance = new RetrofitManager();
        }
        return mInstance.mRetrofit;
    }

    public static RetrofitManager getInstance(){
        if(mInstance == null){
            mInstance = new RetrofitManager();
        }
        return mInstance;
    }

}
