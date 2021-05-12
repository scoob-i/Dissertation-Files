package com.gaapp;

import android.util.Log;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.Map;
import java.util.HashMap;

public class GAModule extends ReactContextBaseJavaModule {
    private static ReactApplicationContext reactContext;

    @ReactMethod
    public void runGen() throws InterruptedException {
        Log.i("GAting","ahhh");
        MyGA.runGA();
        Log.i("GAting","ahhh eeeeeee");
    }

    @Override
    public String getName() {
        return "GAModule";  // Name of the Native Modules.
    }



    GAModule(ReactApplicationContext context) {
        super(context);
        reactContext = context;
    }
}