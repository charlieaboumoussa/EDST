package com.cbm.edst.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    //Example

    @GET("api/users")
    Call<String> getSomething(@Query("id") String argument);
}