package com.example.fuckinggreatadvice;

import android.app.Application;

import com.example.fuckinggreatadvice.di.component.AppComponent;
import com.example.fuckinggreatadvice.di.component.DaggerAppComponent;
import com.example.fuckinggreatadvice.di.module.AppModule;

public class FuckingGreatAdviceApplication extends Application {

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getComponent() {
        return component;
    }
}
