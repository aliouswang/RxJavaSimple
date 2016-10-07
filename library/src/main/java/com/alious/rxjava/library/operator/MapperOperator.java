package com.alious.rxjava.library.operator;

import com.alious.rxjava.library.Log;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by aliouswang on 16/9/30.
 */

public class MapperOperator {

    public static void main(String[] args) {
//        Observable.from(new String[] {"This", "is", "RxJava"})
//                .map(new Func1<String, String>() {
//                    @Override
//                    public String call(String s) {
//                        Log.log("map data", s);
//                        return s.toUpperCase();
//                    }
//                }).toList()
//                .map(new Func1<List<String>, List<String>>() {
//                    @Override
//                    public List<String> call(List<String> strings) {
//                        Log.log("reverse list ", strings.toString());
//                        Collections.reverse(strings);
//                        return strings;
//                    }
//                }).subscribeOn(Schedulers.io())
//                .subscribe(new Action1<List<String>>() {
//            @Override
//            public void call(List<String> strings) {
//                System.out.println(strings.toString());
//                Log.log("result ", strings.toString());
//            }
//        });

        processUrlByMap();

        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }

    public static void processUrlByMap() {
        Observable.just("http://www.baidu.com",
                "http:?/www.google.com", "https://www.bing.com",
                "http://www.51jiabo.com",
                "http://www.sina.com", "http://www.qq.com")
                .flatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String s) {
                        return createIpObservable(s);
                    }
                }).subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {

                    }
                });
    }

    public static String getIpByUrl(String str) throws MalformedURLException, UnknownHostException {
        URL urls = new URL(str);
        String host = urls.getHost();
        String address = InetAddress.getByName(host).toString();
        int b = address.indexOf("/");
        return address.substring(b + 1);
    }

    public static Observable<String> createIpObservable(final String url) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    String ip = getIpByUrl(url);
                    Log.log("flatmap", url + " : " + ip);
                    subscriber.onNext(ip);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } finally {
                    subscriber.onCompleted();
                }
            }
        }).subscribeOn(Schedulers.io());
    }



}
