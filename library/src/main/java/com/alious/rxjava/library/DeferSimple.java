package com.alious.rxjava.library;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by aliouswang on 16/9/26.
 */

public class DeferSimple {

    static long count = 0;

    public static void main(String[] args) {
//        SomeType instance = new SomeType();
//        Observable<String> value = instance.valueObservable();
//        instance.setValue("Some value");
//        value.subscribe(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                System.out.println(s);
//            }
//        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                Observable.interval(1, TimeUnit.SECONDS).subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("interval onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        count = aLong;
                        System.out.println("interval onNext");
                    }
                });
            }
        }).start();

        while(count < 10) {
            Thread.yield();
        }

    }

}
