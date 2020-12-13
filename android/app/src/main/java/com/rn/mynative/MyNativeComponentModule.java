package com.rn.mynative;

import android.os.AsyncTask;
import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyNativeComponentModule extends ReactContextBaseJavaModule {
    private static final String CLASS_NAME = "MyNativeComponentModule";

    private static Integer mMySetTimes = 0;
    ReactApplicationContext mReactContext;

    MyNativeComponentModule(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
        mReactContext = reactContext;
    }

    @NonNull
    @Override
    public String getName() {
        return CLASS_NAME;
    }

    @ReactMethod
    public void setMyCustomName(String name, Callback failureCallback, Callback successCallback) {
        Log.d(CLASS_NAME, "set MyCustomName: " + name);
        mMySetTimes++;
        if (mMySetTimes >= 10) {
            failureCallback.invoke(mMySetTimes);
        } else {
            successCallback.invoke(mMySetTimes);
        }
    }

    @ReactMethod
    public void setMyCustomNameAsync(String name, Promise promise) {
        Log.d(CLASS_NAME, "set MyCustomName: " + name);
        mMySetTimes++;
        if (mMySetTimes >= 10) {
            promise.reject("promise error code",
                    new Exception("exception times:" + mMySetTimes));
            // js side output: get exception: [Error: exception times:13]
            // promise.reject("promise error code", "promise error message",
            //        new Exception("exception times:" + mMySetTimes));
            // js side output: get exception: [Error: promise error message]
        } else {
            promise.resolve(mMySetTimes);
        }
    }


    @ReactMethod
    public void setMyCustomNameWithRealAsyncTask(String name) {
        Log.d(CLASS_NAME, "set MyCustomName: " + name);
        mMySetTimes++;
        new MyAsyncTask(mReactContext, mMySetTimes).execute();
    }

    private static final class MyAsyncTask extends AsyncTask<Void, Void, Integer> {
        ReactContext mReactContext;
        Integer mTimes;
        MyAsyncTask(ReactContext  reactContext, Integer times) {
            mReactContext = reactContext;
            mTimes = times;
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            return mMySetTimes + 3000;
        }

        protected void onPostExecute(Integer resultNumber) {
            super.onPostExecute(resultNumber);
            WritableMap params = Arguments.createMap();
            params.putString("eventProperty", "someValue");
            params.putInt("eventProperty2", mMySetTimes);
            sendEvent(mReactContext, "EventReminder", params);
        }

        private void sendEvent(ReactContext reactContext,
                String eventName,
                @Nullable WritableMap params) {
            reactContext
                    .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                    .emit(eventName, params);
        }
    }

}
