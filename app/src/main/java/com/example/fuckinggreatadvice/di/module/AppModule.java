package com.example.fuckinggreatadvice.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.fuckinggreatadvice.FuckingGreatAdviceApplication;
import com.example.fuckinggreatadvice.database.AppDatabase;
import com.example.fuckinggreatadvice.interfaces.FuckingGreatAdviceAPI;
import com.example.fuckinggreatadvice.mvp.model.NetworkInteractor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    private Application mApplication;

    public AppModule(Application application) { mApplication = application; }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        return new Retrofit.Builder()
                .baseUrl(FuckingGreatAdviceApplication.Config.API_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    NetworkInteractor provideNetworkInteractor(FuckingGreatAdviceAPI fuckingGreatAdviceAPI) {
        return new NetworkInteractor(fuckingGreatAdviceAPI);
    }

    @Provides
    FuckingGreatAdviceAPI provideFuckingGreatAdviceApi(Retrofit retrofit) {
        return retrofit.create(FuckingGreatAdviceAPI.class);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        return client.build();
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(Application application) {
        return Room.databaseBuilder(application.getApplicationContext(), AppDatabase.class, "database").build();
    }
}
