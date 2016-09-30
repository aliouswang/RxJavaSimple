package com.alious.rxjava.library.operator;

import com.alious.rxjava.library.Log;

import java.util.Collections;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by aliouswang on 16/9/30.
 */

public class MapperOperator {

    public static void main(String[] args) {
        Observable.from(new String[] {"This", "is", "RxJava"})
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        Log.log("map data", s);
                        return s.toUpperCase();
                    }
                }).toList()
                .map(new Func1<List<String>, List<String>>() {
                    @Override
                    public List<String> call(List<String> strings) {
                        Log.log("reverse list ", strings.toString());
                        Collections.reverse(strings);
                        return strings;
                    }
                }).subscribeOn(Schedulers.io()).subscribe(new Action1<List<String>>() {
            @Override
            public void call(List<String> strings) {
                System.out.println(strings.toString());
                Log.log("result ", strings.toString());
            }
        });
    }


}
