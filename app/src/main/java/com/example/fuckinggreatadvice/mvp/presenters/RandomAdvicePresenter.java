package com.example.fuckinggreatadvice.mvp.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.fuckinggreatadvice.FuckingGreatAdviceApplication;
import com.example.fuckinggreatadvice.mvp.model.NetworkInteractor;
import com.example.fuckinggreatadvice.mvp.view.RandomAdviceView;
import com.example.fuckinggreatadvice.pojo.Advice;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

@InjectViewState
public class RandomAdvicePresenter extends MvpPresenter<RandomAdviceView> {

    @Inject
    NetworkInteractor networkInteractor;

    Advice advice;

    @Override
    protected void onFirstViewAttach() {
        FuckingGreatAdviceApplication.getComponent().inject(this);
        loadAdvice();
    }

    private void showAdvice(Advice advice) {
        getViewState().showAdvice(advice);
    }

    private void showError() {
        getViewState().showErrorLoadingAdvice();
    }

    public void loadAdvice() {
        networkInteractor.loadRandomAdvice()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Response<Advice>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(Response<Advice> response) {
                        advice = response.body();
                        showAdvice(advice);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("myLog", "RandomAdvicePresenter.onFirstViewAttach() : " + e.getMessage());
                        showError();
                    }
                });
    }

    public void saveToFavoriteCurrentAdvice() {
        //TODO save to DB this.advice
    }
}
