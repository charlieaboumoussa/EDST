package com.cbm.edst.common.views;

import android.util.Pair;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class SelectionModel {
    public MutableLiveData<Pair<Long, String>> selectedValue;
    public List<Pair<Long,String>> selectionValues;

    public SelectionModel(List<Pair<Long,String>> selections){
        selectionValues = selections;
        selectedValue = new MutableLiveData<>();
        if(selections.size() > 0) {
            selectedValue.setValue(selections.get(0));
        }
    }

    public SelectionModel(List<Pair<Long, String>> selections, MutableLiveData<Pair<Long,String>> liveData){
        selectionValues = selections;
        selectedValue = liveData;
        selectedValue.setValue(selections.get(0));
    }

    public CharSequence[] getSequences(){
        CharSequence[] sequences = new CharSequence[selectionValues.size()];
        int i = 0;
        for(Pair<Long,String> choice : selectionValues){
            sequences[i] = choice.second;
            i++;
        }
        return sequences;
    }
}
