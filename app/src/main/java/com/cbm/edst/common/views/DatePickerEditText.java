package com.cbm.edst.common.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DatePickerEditText extends TextInputEditText {

    private DatePickerDialog mDialog;
    private @StyleRes
    int mDialogStyle;
    private String mDatePattern;
    private Locale mLocale;
    private Object mMainParent;

    public DatePickerEditText(Context context) {
        super(context);
        init();
    }

    public DatePickerEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DatePickerEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mDialog = null;
        mDatePattern = "dd/MM/yyyy";
        mLocale = Locale.US;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                performClick();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public boolean performClick() {
        if (mDialog == null) {
            Calendar calendar = Calendar.getInstance();
            mDialog = DatePickerDialog.newInstance(new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                    calendar.set(Calendar.YEAR, year);
                    calendar.set(Calendar.MONTH, monthOfYear);
                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    SimpleDateFormat formatter = new SimpleDateFormat(mDatePattern, mLocale);
                    String dateString = formatter.format(calendar.getTime());
                    setText(dateString);
                }
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        }
        if(mMainParent != null) {
            if(mMainParent instanceof Fragment) {
                mDialog.show(((Fragment) mMainParent).getChildFragmentManager(), "Dialog");
            }else if(mMainParent instanceof AppCompatActivity){
                mDialog.show(((AppCompatActivity) mMainParent).getSupportFragmentManager(), "Dialog");
            }
        }
        return super.performClick();
    }

    public void setDialogStyle(@StyleRes int dialogStyle) {
        mDialogStyle = dialogStyle;
    }

    public @StyleRes
    int getDialogStyle() {
        return mDialogStyle;
    }

    public void setDatePattern(String datePattern) {
        mDatePattern = datePattern;
    }

    public String getDatePattern() {
        return mDatePattern;
    }

    public void setLocale(Locale locale) {
        mLocale = locale;
    }

    public Locale getLocale() {
        return mLocale;
    }

    public void setMainParent(Object parent){
        mMainParent = parent;
    }

    public Object getMainParent(){
        return mMainParent;
    }


}
