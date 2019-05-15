package com.cbm.edst.ui.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cbm.edst.R;
import com.cbm.edst.common.views.SelectionEditText;
import com.cbm.edst.common.views.SelectionModel;

import java.util.ArrayList;

public class Registration1Fragment extends Fragment {

    private SelectionModel mTypeOfReservation;
    public Registration1Fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registration1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SelectionEditText typeOfReservation = view.findViewById(R.id.setTypeOfReservation_reg);
        typeOfReservation.setDialogTitle("Select type of reservation:");
        mTypeOfReservation = new SelectionModel(new ArrayList<Pair<Long, String>>() {{
            add(new Pair<Long, String>(0L, "Test1"));
            add(new Pair<Long, String>(1L, "Test2"));
            add(new Pair<Long, String>(2L, "Test3"));
        }}, new MutableLiveData<>());
        typeOfReservation.setSelectionModel(mTypeOfReservation);
    }
}
