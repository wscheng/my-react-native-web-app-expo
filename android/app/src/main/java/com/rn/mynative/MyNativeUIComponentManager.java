package com.rn.mynative;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;

import androidx.annotation.NonNull;

public class MyNativeUIComponentManager extends ViewGroupManager<MyNativeUIComponent> {

    public static final String REACT_CLASS = "RCTMyNativeUIComponent";
    ReactApplicationContext mCallerContext;


    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public MyNativeUIComponentManager(ReactApplicationContext reactContext) {
        mCallerContext = reactContext;
    }

    @NonNull
    @Override
    protected MyNativeUIComponent createViewInstance(@NonNull ThemedReactContext reactContext) {
        //return new MyNativeComponent(mCallerContext);
        // ReactImageView
        return new MyNativeUIComponent(reactContext);
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
