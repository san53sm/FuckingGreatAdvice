package com.example.fuckinggreatadvice.mvp.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.fuckinggreatadvice.FuckingGreatAdviceApplication;
import com.example.fuckinggreatadvice.database.AppDatabase;
import com.example.fuckinggreatadvice.pojo.Advice;

import java.util.List;

import javax.inject.Inject;

public class AdviceViewModel extends AndroidViewModel {
    @Inject
    AppDatabase appDatabase;

    public AdviceViewModel(@NonNull Application application) {
        super(application);
        FuckingGreatAdviceApplication.getComponent().inject(this);
    }

    public LiveData<List<Advice>> getAllAdvice() {
        return appDatabase.adviceDao().getAll();
    }
}
