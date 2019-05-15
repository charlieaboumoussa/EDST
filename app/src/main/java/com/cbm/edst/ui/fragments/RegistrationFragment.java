package com.cbm.edst.ui.fragments;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.Navigation;

import com.cbm.edst.R;
import com.cbm.edst.common.views.SelectionEditText;
import com.cbm.edst.common.views.SelectionModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class RegistrationFragment extends Fragment {

    private SelectionModel mCategoryModel, mSpecializationModel;

    public RegistrationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SelectionEditText category = view.findViewById(R.id.setCategory_reg);
        SelectionEditText specialization = view.findViewById(R.id.setSpecialization_reg);

        category.setDialogTitle("Select category:");
        specialization.setDialogTitle("Select specialization:");
        mCategoryModel = new SelectionModel(new ArrayList<Pair<Long, String>>() {{
            add(new Pair<Long, String>(0L, "Test1"));
            add(new Pair<Long, String>(1L, "Test2"));
            add(new Pair<Long, String>(2L, "Test3"));
        }}, new MutableLiveData<>());
        mSpecializationModel = new SelectionModel(new ArrayList<Pair<Long, String>>() {{
            add(new Pair<Long, String>(0L, "Test1"));
            add(new Pair<Long, String>(1L, "Test2"));
            add(new Pair<Long, String>(2L, "Test3"));
        }}, new MutableLiveData<>());

        category.setSelectionModel(mCategoryModel);
        specialization.setSelectionModel(mSpecializationModel);

        Button next = view.findViewById(R.id.next_reg);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo check fields and handle erros
                //if fields are valid
                //add args to save the registration object in next fragment
                Navigation.findNavController(view).navigate(R.id.RegistrationToRegistration1);
            }
        });
    }

    private boolean isEmpty(TextInputEditText textInputEditText) {
        if (textInputEditText.getText().toString().trim().length() <= 0 || textInputEditText.getText().toString() == "") {
            return true;
        }
        return false;
    }
}
