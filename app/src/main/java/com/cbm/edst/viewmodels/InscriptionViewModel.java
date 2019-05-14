package com.cbm.edst.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class InscriptionViewModel extends AndroidViewModel {

    //    private MutableLiveData<any object> mInstcriptionObject;

    public InscriptionViewModel(@NonNull Application application) {
        super(application);
//        mInstcriptionObject = new MutableLiveData<any object>();
    }


    private void callInscription(){
        //todo send callback to insert Inscription
    }

}
