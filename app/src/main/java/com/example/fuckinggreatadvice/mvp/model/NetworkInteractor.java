package com.example.fuckinggreatadvice.mvp.model;

import com.example.fuckinggreatadvice.interfaces.FuckingGreatAdviceAPI;
import com.example.fuckinggreatadvice.pojo.Advice;
import com.example.fuckinggreatadvice.utils.RxSchedulersAbs;

import io.reactivex.Single;
import retrofit2.HttpException;
import retrofit2.Response;

public class NetworkInteractor {

    FuckingGreatAdviceAPI fuckingGreatAdviceAPI;

    public NetworkInteractor(FuckingGreatAdviceAPI fuckingGreatAdviceAPI) {
        this.fuckingGreatAdviceAPI = fuckingGreatAdviceAPI;
    }

    public Single<Response<Advice>> loadRandomAdvice() {
        return fuckingGreatAdviceAPI.getRandomAdvice()
                .map(this::handleBasicResponse)
                .compose(RxSchedulersAbs.getIOToMainTransformer());
    }

    private <T> Response<T> handleBasicResponse(Response<T> response) throws HttpException {
        if (response.isSuccessful()) return response;
        else throw new HttpException(response);
    }
}
