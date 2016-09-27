package com.alious.rxjava.library.operator;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by aliouswang on 16/9/27.
 */

public class GroupByOperator {

    public static void main(String[] args) {

        Observable<List<String>> listObservable = Observable.create(new Observable.OnSubscribe<List<String>>() {
            @Override
            public void call(Subscriber<? super List<String>> subscriber) {
                ArrayList<String> list = new ArrayList<String>();
                list.add("1");
                list.add("2");
                list.add("3");
                list.add("4");
                subscriber.onNext(list);
            }
        });
        
        listObservable.flatMap(new Func1<List<String>, Observable<String>>() {
            @Override
            public Observable<String> call(List<String> strings) {
                return Observable.from(strings);
            }
        }).map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s + s;
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        });
        
    }
    
}
