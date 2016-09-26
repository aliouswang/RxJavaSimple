package com.alious.rxjava.library;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by aliouswang on 16/9/26.
 */

public class DeferSimple {

    public static void main(String[] args) {
        SomeType instance = new SomeType();
        Observable<String> value = instance.valueObservable();
        instance.setValue("Some value");
        value.subscribe(new Subscriber<String>() {
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

        Observable.error(new RuntimeException()).subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onNext(Object s) {
                System.out.println("onNext");
            }
        });
    }

}
