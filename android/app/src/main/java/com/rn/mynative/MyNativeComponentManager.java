package com.rn.mynative;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;

import androidx.annotation.NonNull;

public class MyNativeComponentManager extends SimpleViewManager<MyNativeComponent> {

    public static final String REACT_CLASS = "RCTMyNativeComponent";
    ReactApplicationContext mCallerContext;


    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public MyNativeComponentManager(ReactApplicationContext reactContext) {
        mCallerContext = reactContext;
    }

    @NonNull
    @Override
    protected MyNativeComponent createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new MyNativeComponent(mCallerContext);
    }

    @ReactProp(name = ViewProps.ENABLED, defaultBoolean = true)
    public void setEnabled(MyNativeComponent view, boolean enabled) {
        view.setEnabled(enabled);
    }

    @ReactProp(name = "value")
    public void setValue(MyNativeComponent view, String value) {
        view.setValue(value);
    }
}
