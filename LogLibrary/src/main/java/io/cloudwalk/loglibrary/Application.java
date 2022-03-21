package io.cloudwalk.loglibrary;

import android.annotation.SuppressLint;
import android.content.Context;

public class Application extends android.app.Application {
    private static final String
            TAG = Application.class.getSimpleName();

    @SuppressLint("StaticFieldLeak")
    private static Context
            sContext = null;

    public static Context getContext() {
        // Log.d(TAG, "getContext");

        return Application.sContext;
    }

    /**
     * @deprecated As of release 1.1.4, replaced by {@link Application#getContext()}.
     */
    @Deprecated
    public static Context getPackageContext() {
        Log.e(TAG, "`Application#getPackageContext()` is deprecated. Prefer `Application#getContext()`");

        return Application.sContext;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate");

        super.onCreate();

        Application.sContext = getApplicationContext();
    }
}
