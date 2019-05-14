package com.cbm.edst.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class RegistrationViewModel extends AndroidViewModel {

    //    private MutableLiveData<RegistrationObject> mRegistrationObject;

    public RegistrationViewModel(@NonNull Application application) {
        super(application);
    }

    private void callRegistration(){
        //todo send callback to insert Registration
    }

}
