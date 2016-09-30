package com.alious.rxjava.library.error;

import java.util.Scanner;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by aliouswang on 16/9/29.
 */

public class ErrorOperator {

    public static void main(String[] args) {

        Observable<String> observable =
                Observable.create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("first");
                        subscriber.onNext("second");
//                        subscriber.onError(new RuntimeException());
                        subscriber.onNext("third");
                        subscriber.onCompleted();
                    }
                });

        observable.subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError");
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(s);
                    }
                });


        Scanner scanner = new Scanner(System.in);
        scanner.next();

    }

}
