package com.example.fuckinggreatadvice.di.component;

import com.example.fuckinggreatadvice.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
}
