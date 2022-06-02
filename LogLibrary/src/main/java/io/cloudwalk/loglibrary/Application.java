package io.cloudwalk.loglibrary;

import android.annotation.SuppressLint;
import android.content.Context;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.atomic.AtomicReference;

public class Application extends android.app.Application {
    private static final String
            TAG = Application.class.getSimpleName();

    @SuppressLint("StaticFieldLeak")
    private static AtomicReference<android.app.Application>
            sInstance = null;

    public static android.app.Application getInstance() {
        // Log.d(TAG, "getInstance");

        return sInstance.get();
    }

    public static Context getContext() {
        // Log.d(TAG, "getContext");

        android.app.Application instance = sInstance.get();

        return (instance != null) ? instance.getApplicationContext() : null;
    }

    /**
     * Alternative for those which can't extend {@link io.cloudwalk.loglibrary.Application} instead
     * of {@link android.app.Application} and will replace the `android:name` attribute on their
     * `AndroidManifest.xml` anyway.
     *
     * @param instance {@link android.app.Application}
     */
    public static void setInstance(@NotNull android.app.Application instance) {
        // Log.d(TAG, "setInstance");

        sInstance.set(instance);
    }

    /**
     * @deprecated As of release 1.1.4, replaced by {@link Application#getContext()}.
     */
    @Deprecated
    public static Context getPackageContext() {
        Log.e(TAG, "`Application#getPackageContext()` is deprecated. Prefer `Application#getContext()`");

        return io.cloudwalk.loglibrary.Application.getContext();
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate");

        super.onCreate();

        sInstance.set(this);
    }
}
