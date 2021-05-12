package com.example.gatest;

import androidx.annotation.NonNull;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "com.flutter.ga/ga";

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
                .setMethodCallHandler(
                        (call, result) -> {
                            if (call.method.equals("printy")) {
                                result.success("Hello");
                                try {
                                    runGA();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                result.error("Error","Connection to native module failed", null);
                            }

                        }
                );
    }

    public void runGA() throws InterruptedException {
        MyGA GA = new MyGA();
        GA.main(null);
    }
}