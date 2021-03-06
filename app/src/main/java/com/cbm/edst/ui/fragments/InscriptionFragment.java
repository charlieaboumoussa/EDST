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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InscriptionFragment extends Fragment {

    private SelectionModel mSpecializationModel, mCategoryModel, mCourseNameModel;

    public InscriptionFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_inscription, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SelectionEditText category = view.findViewById(R.id.setCategory_ins);
        SelectionEditText specialization = view.findViewById(R.id.setSpecialization_ins);
        SelectionEditText courseName = view.findViewById(R.id.setCourseName_ins);

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

        mCourseNameModel = new SelectionModel(new ArrayList<Pair<Long, String>>() {{
            add(new Pair<Long, String>(0L, "Test1"));
            add(new Pair<Long, String>(1L, "Test2"));
            add(new Pair<Long, String>(2L, "Test3"));
        }}, new MutableLiveData<>());

        category.setSelectionModel(mCategoryModel);
        specialization.setSelectionModel(mSpecializationModel);
        courseName.setSelectionModel(mCourseNameModel);
    }

    public boolean isEmailValid(String email) {
        String regExpn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches())
            return true;
        else
            return false;
    }
}
