package com.example.fuckinggreatadvice.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.fuckinggreatadvice.R;
import com.example.fuckinggreatadvice.mvp.presenters.RandomAdvicePresenter;
import com.example.fuckinggreatadvice.mvp.view.RandomAdviceView;
import com.example.fuckinggreatadvice.pojo.Advice;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RandomAdviceFragment extends MvpAppCompatFragment implements RandomAdviceView {

    @InjectPresenter
    RandomAdvicePresenter randomAdvicePresenter;

    @BindView(R.id.tv_advice)
    TextView tvAdvice;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.button_save_to_favorite)
    Button buttonSaveToFavorite;

    @BindView(R.id.button_next_advice)
    Button buttonNextAdvice;

    @BindView(R.id.button_reload)
    Button buttonReload;

    public static RandomAdviceFragment newInstance() {
        Bundle args = new Bundle();

        RandomAdviceFragment fragment = new RandomAdviceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_random_advice, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void showAdvice(Advice advice) {
        progressBar.setVisibility(View.GONE);
        buttonSaveToFavorite.setVisibility(View.VISIBLE);
        buttonNextAdvice.setVisibility(View.VISIBLE);
        tvAdvice.setVisibility(View.VISIBLE);
        tvAdvice.setText(advice.getText());
    }

    @Override
    public void showErrorLoadingAdvice() {
        progressBar.setVisibility(View.GONE);
        buttonReload.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSavedAdviceCompletable(Advice advice) {
        Toast.makeText(getActivity(), getActivity().getString(R.string.advice_saved_msg), Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void onSavedAdviceError() {
        Toast.makeText(getActivity(), getActivity().getString(R.string.advice_error_saved_msg), Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void onErrorSaveDublicateAdvice() {
        Toast.makeText(getActivity(), getActivity().getString(R.string.duplicate_advice_error_saved_msg), Toast.LENGTH_SHORT)
                .show();
    }

    @OnClick(R.id.button_save_to_favorite)
    public void onClickButtonSaveToFavorite() {
        randomAdvicePresenter.saveToFavoriteCurrentAdvice();
    }

    @OnClick(R.id.button_next_advice)
    public void onClickButtonNextAdvice() {
        reload();
    }

    @OnClick(R.id.button_reload)
    public void onClickButtonReload() {
        reload();
    }

    private void reload() {
        buttonNextAdvice.setVisibility(View.GONE);
        buttonSaveToFavorite.setVisibility(View.GONE);
        buttonReload.setVisibility(View.GONE);
        tvAdvice.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        randomAdvicePresenter.loadAdvice();
    }
}
