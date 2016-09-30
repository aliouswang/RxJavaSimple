package com.alious.rxjava.library;

/**
 * Created by aliouswang on 16/9/30.
 */

public class Log {

    public static void log(String tag, String message) {
        System.out.println(tag + "," + message + "," + Thread.currentThread().getName());
    }

}
