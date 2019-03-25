package com.example.fuckinggreatadvice.interfaces;

import com.example.fuckinggreatadvice.pojo.Advice;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;

public interface FuckingGreatAdviceAPI {
    @GET("/api/random")
    Single<Response<Advice>> getRandomAdvice();
}
