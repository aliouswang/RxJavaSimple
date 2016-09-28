package com.alious.rxjava.library.filter;

import com.alious.rxjava.library.operator.Constant;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by aliouswang on 16/9/28.
 */

public class Debounce {

    static Observable mObservable;

    public static void main(String[] args) {
        mObservable = Observable.from(Constant.countries)
                .distinct()
                .skipLast(1)
                .take(3)
        .skip(1)
        ;
        mObservable.
                subscribe(new Subscriber<String>() {
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
