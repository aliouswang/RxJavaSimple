package com.alious.rxjava.library.operator;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by aliouswang on 16/9/27.
 */

public class BufferOperator {

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
        listObservable.subscribe(new Subscriber<List<String>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<String> strings) {
                for (String str : strings) {
                    System.out.println(str);
                }
            }
        });

    }

}
