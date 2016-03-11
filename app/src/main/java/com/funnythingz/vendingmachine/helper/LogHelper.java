package com.funnythingz.vendingmachine.helper;

import android.util.Log;

import com.funnythingz.vendingmachine.BuildConfig;

import java.util.regex.Pattern;

public class LogHelper {

    public static void d(String msg) {
        if (!BuildConfig.DEBUG) return;
        Log.d(getTag(), msg);
    }

    public static void e(String msg) {
        Log.e(getTag(), msg);
    }

    public static void e(String msg, Throwable t) {
        Log.e(getTag(), msg, t);
    }

    private static String getTag() {

        final StackTraceElement trace = Thread.currentThread().getStackTrace()[4];
        final String cla = trace.getClassName();
        Pattern pattern = Pattern.compile("[\\.]+");
        final String[] splitedStr = pattern.split(cla);
        final String simpleClass = splitedStr[splitedStr.length - 1];

        final String mthd = trace.getMethodName();
        final int line = trace.getLineNumber();
        final String tag = simpleClass + "#" + mthd + ":" + line;

        return tag;
    }
}
