package com.alious.rxjava.library.combine;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by aliouswang on 16/9/28.
 */

public class AndThenWhen {

    public static void main(String[] args) {
        Observable<Integer> observable1 =
                Observable.create(new Observable.OnSubscribe<Integer>() {
                    @Override
                    public void call(Subscriber<? super Integer> subscriber) {
                        subscriber.onNext(1);
                    }
                });


        Observable<Integer> observable2 =
                Observable.from(new Integer[] {3,4,5,6,7});

        observable1
                .map(new Func1<Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer) {
                        return integer + integer;
                    }
                })
                .flatMap(new Func1<Integer, Observable<Integer>>() {
                    @Override
                    public Observable<Integer> call(Integer integer) {
                        return Observable.just(integer * 2);
                    }
                })
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Integer>() {

                    @Override
                    public void onStart() {
                        super.onStart();
                        System.out.println("on start");
                    }

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(integer + "");
                    }
                });


    }

}
