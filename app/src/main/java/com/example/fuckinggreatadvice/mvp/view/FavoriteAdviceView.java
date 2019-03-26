package com.example.fuckinggreatadvice.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.fuckinggreatadvice.pojo.Advice;

import java.util.List;

public interface FavoriteAdviceView extends MvpView {
    @StateStrategyType(SingleStateStrategy.class)
    void updateAdviceList(List<Advice> advice);

    @StateStrategyType(SkipStrategy.class)
    void deletedAdviceSuccesfull();
}
