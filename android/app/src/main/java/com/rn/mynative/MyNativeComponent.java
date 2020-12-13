package com.rn.mynative;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;


public class MyNativeComponent extends LinearLayout {

    private String mValue;
    private EditText mEditText;

    public MyNativeComponent(Context context) {
        super(context);
        LayoutInflater mInflater = LayoutInflater.from(context);
        View myView = mInflater.inflate(R.layout.my_native_component, null);
        EditText mEditText = myView.findViewById(R.id.my_edit_text);
        addView(myView);
    }

    /* package */ void setValue(String value) {
        mValue = value;
        mEditText.setText(value);
    }
}
