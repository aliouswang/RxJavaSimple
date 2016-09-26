package com.alious.rxjava.library;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class MyClass {

    public static void main(String[] args) {
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                 subscriber.onNext("");
            }
        });
        observable.map(new Func1() {
            @Override
            public Object call(Object o) {
                return "";
            }
        });
    }

}
