package com.alious.rxjava.library;

import rx.Observable;

/**
 * Created by aliouswang on 16/9/26.
 */

public class SomeType {

    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public Observable<String> valueObservable() {
        return Observable.just(value);
    }

}
