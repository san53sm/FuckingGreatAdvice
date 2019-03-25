package com.example.fuckinggreatadvice.utils;

import io.reactivex.FlowableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class RxSchedulersAbs {

    public static Scheduler getMainThreadScheduler() {
        return AndroidSchedulers.mainThread();
    }

    public static Scheduler getIOScheduler() {
        return Schedulers.io();
    }

    public static <T> SingleTransformer<T, T> getIOToMainTransformer() {
        return objectObservable -> objectObservable
                .subscribeOn(getIOScheduler())
                .observeOn(getMainThreadScheduler());
    }
}
