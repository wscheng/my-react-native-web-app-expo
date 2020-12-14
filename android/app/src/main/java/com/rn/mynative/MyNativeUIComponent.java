package com.rn.mynative;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;


public class MyNativeUIComponent extends LinearLayout {

    private String mValue;
    private EditText mEditText;

    public MyNativeUIComponent(Context context) {
        super(context);
        LayoutInflater mInflater = LayoutInflater.from(context);
        View myView = mInflater.inflate(R.layout.my_native_component, null);
       // EditText mEditText = myView.findViewById(R.id.my_edit_text);
        addView(myView);
    }

    /* package */ void setValue(String value) {
        mValue = value;
        mEditText.setText(value);
    }

    // to realize the wrap content in view , need to trigger requestLayout and re-layout by yourself
    // https://github.com/facebook/react-native/issues/4990
//    @Override
//    public void requestLayout() {
//        super.requestLayout();
//
//        // The spinner relies on a measure + layout pass happening after it calls requestLayout().
//        // Without this, the widget never actually changes the selection and doesn't call the
//        // appropriate listeners. Since we override onLayout in our ViewGroups, a layout pass never
//        // happens after a call to requestLayout, so we simulate one here.
//        post(measureAndLayout);
//    }
//
//    private final Runnable measureAndLayout = new Runnable() {
//        @Override
//        public void run() {
//            measure(
//                    MeasureSpec.makeMeasureSpec(getWidth(), MeasureSpec.EXACTLY),
//                    MeasureSpec.makeMeasureSpec(getHeight(), MeasureSpec.EXACTLY));
//            layout(getLeft(), getTop(), getRight(), getBottom());
//        }
//    };

}
