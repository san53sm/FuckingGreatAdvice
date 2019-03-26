package com.example.fuckinggreatadvice.mvp.presenters;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.fuckinggreatadvice.FuckingGreatAdviceApplication;
import com.example.fuckinggreatadvice.database.AppDatabase;
import com.example.fuckinggreatadvice.mvp.model.AdviceViewModel;
import com.example.fuckinggreatadvice.mvp.view.FavoriteAdviceView;
import com.example.fuckinggreatadvice.pojo.Advice;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class FavoriteAdvicePresenter extends MvpPresenter<FavoriteAdviceView> {

    @Inject
    AppDatabase appDatabase;

    private FragmentActivity activity;
    private AdviceViewModel adviceViewModel;

    public FavoriteAdvicePresenter(FragmentActivity activity) {
        this.activity = activity;
        FuckingGreatAdviceApplication.getComponent().inject(this);
        adviceViewModel = ViewModelProviders.of(activity).get(AdviceViewModel.class);
    }

    @Override
    protected void onFirstViewAttach() {
        loadFavoriteAdvice();
    }

    private void loadFavoriteAdvice() {


        Completable.fromAction(() -> adviceViewModel.getAllAdvice().observe(activity, advice -> getViewState().updateAdviceList(advice)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                });
    }

    public void deleteAdvice(Advice advice) {
        Completable.fromAction(() -> appDatabase.adviceDao().delete(advice))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onComplete() {
                        getViewState().deletedAdviceSuccesfull();
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                });
    }
}
