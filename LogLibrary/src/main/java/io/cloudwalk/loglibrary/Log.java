package io.cloudwalk.loglibrary;

import static java.util.Locale.US;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Log {
    private static final String
            TAG =  Log.class.getSimpleName();

    public static final int
            ASSERT  = android.util.Log.ASSERT;

    public static final int
            DEBUG   = android.util.Log.DEBUG;

    public static final int
            ERROR   = android.util.Log.ERROR;

    public static final int
            INFO    = android.util.Log.INFO;

    public static final int
            VERBOSE = android.util.Log.VERBOSE;

    public static final int
            WARN    = android.util.Log.WARN;

    private Log() {
        /* Nothing to do */
    }

    public static int d(String tag, String msg, Throwable tr) {
        return android.util.Log.d(tag, msg, tr);
    }

    public static int d(String tag, String msg) {
        return android.util.Log.d(tag, msg);
    }

    public static int e(String tag, String msg) {
        return android.util.Log.e(tag, msg);
    }

    public static int e(String tag, String msg, Throwable tr) {
        return android.util.Log.e(tag, msg, tr);
    }

    public static File[] export() {
        return Sniffer.export();
    }

    public static String getByteTraceString(byte[] input, int length) {
        StringBuilder[] msg = { new StringBuilder(), new StringBuilder(), new StringBuilder() };

        for (int i = 0; i < length; i++) {
            try {
                byte b = input[i];

                msg[0].append(String.format(US, "%02X ", b));

                msg[1].append((b > 0x20 && b < 0x7F) ? (char) b : '.');

                if ((msg[1].length() % 16) != 0 && (i + 1) >= length) {
                    int ceil;

                    ceil = 48 - (msg[0].length() % 48);

                    for (int j = 0; j < ceil; j += 3) {
                        msg[0].append(".. ");
                    }

                    ceil = 16 - (msg[1].length() % 16);

                    for (int j = 0; j < ceil; j++) {
                        msg[1].append(".");
                    }
                }

                if ((i > 0 && msg[1].length() % 16 == 0) || (i + 1) >= length) {
                    msg[0].append(msg[1]);

                    msg[2].append("\n").append(msg[0]);

                    msg[0].delete(0, msg[0].length());

                    msg[1].delete(0, msg[1].length());
                }
            } catch (Exception exception) {
                e(TAG, getStackTraceString(exception));

                break;
            }
        }

        return (msg[2].length() > 0) ? msg[2].substring(1) : msg[2].substring(0);
    }

    public static String getStackTraceString(Throwable tr) {
        return android.util.Log.getStackTraceString(tr);
    }

    public static void h(String tag, byte[] input, int length) {
        if (length <= 0) { return; }

        String[] msg = getByteTraceString(input, length).split("\n");

        for (String slice : msg) { android.util.Log.d(tag, slice); }
    }

    public static int i(String tag, String msg, Throwable tr) {
        return android.util.Log.i(tag, msg, tr);
    }

    public static int i(String tag, String msg) {
        return android.util.Log.i(tag, msg);
    }

    public static boolean isLoggable(String tag, int level) {
        return android.util.Log.isLoggable(tag, level);
    }

    public static int println(int priority, String tag, String msg) {
        return android.util.Log.println(priority, tag, msg);
    }

    public static void s(int priority, String tag, String msg) {
        switch (priority) {
            case DEBUG:     Log.d(tag, msg); break;
            case ERROR:     Log.e(tag, msg); break;
            case INFO:      Log.i(tag, msg); break;
            case VERBOSE:   Log.v(tag, msg); break;
            case WARN:      Log.w(tag, msg); break;

            default:
                println(priority, tag, msg);
                break;
        }

        Sniffer.write(tag, msg);
    }

    public static void s(int priority, String tag, String msg, Throwable tr) {
        if (msg == null) { msg = ""; }

        StringWriter sw = new StringWriter();
        PrintWriter  pw = new PrintWriter(sw);

        tr.printStackTrace(pw);

        String trace = sw.toString();

        if (!msg.isEmpty() && !trace.isEmpty()) { msg += "\r\n"; }

        s(priority, tag, msg);
    }

    public static int v(String tag, String msg) {
        return android.util.Log.v(tag, msg);
    }

    public static int v(String tag, String msg, Throwable tr) {
        return android.util.Log.v(tag, msg, tr);
    }

    public static int w(String tag, Throwable tr) {
        return android.util.Log.w(tag, tr);
    }

    public static int w(String tag, String msg, Throwable tr) {
        return android.util.Log.w(tag, msg, tr);
    }

    public static int w(String tag, String msg) {
        return android.util.Log.w(tag, msg);
    }

    public static int wtf(String tag, String msg) {
        return android.util.Log.wtf(tag, msg);
    }

    public static int wtf(String tag, Throwable tr) {
        return android.util.Log.wtf(tag, tr);
    }

    public static int wtf(String tag, String msg, Throwable tr) {
        return android.util.Log.wtf(tag, msg, tr);
    }
}
