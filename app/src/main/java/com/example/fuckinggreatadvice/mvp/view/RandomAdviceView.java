package com.example.fuckinggreatadvice.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.fuckinggreatadvice.pojo.Advice;

public interface RandomAdviceView extends MvpView {
    @StateStrategyType(SingleStateStrategy.class)
    void showAdvice(Advice advice);

    @StateStrategyType(SingleStateStrategy.class)
    void showErrorLoadingAdvice();
}
