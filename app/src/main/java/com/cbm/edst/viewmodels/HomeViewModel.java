package com.cbm.edst.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class HomeViewModel extends AndroidViewModel {

//    private MutableLiveData<List<any object>> homeItems;

    public HomeViewModel(@NonNull Application application) {
        super(application);
//        homeItems = new MutableLiveData<List<any object>>();
    }

    private void initHome(){
        //todo init homeItems from data model
    }
}
