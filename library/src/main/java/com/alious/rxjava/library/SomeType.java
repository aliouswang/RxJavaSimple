package com.alious.rxjava.library;

import rx.Observable;
import rx.functions.Func0;

/**
 * Created by aliouswang on 16/9/26.
 */

public class SomeType {

    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public Observable<String> valueObservable() {
        return Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                return Observable.just(value);
            }
        });
    }

}
