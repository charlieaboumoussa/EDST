package com.cbm.edst.common.retrofit;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCallback implements Callback<String> {

    private interface OnApiCallbackHandler {
        void onRequestSuccess(JsonElement jsonElement, String serviceName);
        void onRequestFail(String serviceName);
    }

    private OnApiCallbackHandler mHandler;
    private String mServiceName;

    public ApiCallback(OnApiCallbackHandler onApiCallbackHandler, String serviceName) {
        mHandler = onApiCallbackHandler;
        mServiceName = serviceName;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        //todo check internet connectivity
        if (response.isSuccessful() && response.body() != null) {
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(response.body());
            if (mHandler != null) {
                mHandler.onRequestSuccess(element, mServiceName);
            }
        } else {
        //todo public server error
            if (mHandler != null) {
                mHandler.onRequestFail(mServiceName);
            }
        }

    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        //todo public server error
        if(mHandler != null){
            mHandler.onRequestFail(mServiceName);
        }
    }
}
