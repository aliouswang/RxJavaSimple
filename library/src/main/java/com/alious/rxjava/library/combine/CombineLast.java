package com.alious.rxjava.library.combine;

import rx.Observable;

/**
 * Created by aliouswang on 16/9/28.
 */

public class CombineLast {

    public static void main(String[] args) {
        Observable<Integer> observable1 =
                Observable.from(new Integer[] {1,2,3,4,5});

        Observable<Integer> observable2 =
                Observable.from(new Integer[] {3,4,5,6,7});

    }

}
