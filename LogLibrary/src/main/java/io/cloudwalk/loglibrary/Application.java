package io.cloudwalk.loglibrary;

import android.content.Context;

public class Application extends android.app.Application {
    private static final String
            TAG = Application.class.getSimpleName();

    private static Context
            sPackageContext = null;

    public static Context getPackageContext() {
        // Log.d(TAG, "getPackageContext");

        return Application.sPackageContext;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate");

        super.onCreate();

        Application.sPackageContext = getApplicationContext();
    }
}
