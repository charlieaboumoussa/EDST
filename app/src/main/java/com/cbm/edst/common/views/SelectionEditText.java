package com.cbm.edst.common.views;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.cbm.edst.R;
import com.google.android.material.textfield.TextInputEditText;

public class SelectionEditText extends TextInputEditText {

    private SelectionModel mModel;
    private String mDialogTitle;
    private boolean mOpen;

    public SelectionEditText(Context context) {
        super(context);
    }

    public SelectionEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SelectionEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setSelectionModel(SelectionModel model){
        mModel = model;
        this.setFocusable(false);
        this.setText(model.selectedValue.getValue().second);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_UP:
                performClick();
                break;
        }
        return true;
    }

    @Override
    public boolean performClick() {
        if(!mOpen) {
            AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                    .setSingleChoiceItems(mModel.getSequences(), mModel.selectionValues.indexOf(mModel.selectedValue.getValue()), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            mModel.selectedValue.setValue(mModel.selectionValues.get(i));
                            setText(mModel.selectedValue.getValue().second);
                            dialogInterface.dismiss();
                        }
                    })
                    .setNegativeButton(R.string.cancel, null)
                    .setTitle(mDialogTitle)
                    .create();

            alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    mOpen = false;
                }
            });
            alertDialog.show();
            mOpen = true;
        }
        return super.performClick();
    }

    public void setDialogTitle(String title){
        mDialogTitle = title;
    }

    public void setDialogTitle(int stringRes){
        mDialogTitle = getContext().getString(stringRes);
    }

    public SelectionModel getSelectionModel(){
        return mModel;
    }
}
