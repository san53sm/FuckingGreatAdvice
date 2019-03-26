package com.example.fuckinggreatadvice.ui.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.fuckinggreatadvice.R;
import com.example.fuckinggreatadvice.adapters.FavoriteAdapter;
import com.example.fuckinggreatadvice.mvp.presenters.FavoriteAdvicePresenter;
import com.example.fuckinggreatadvice.mvp.view.FavoriteAdviceView;
import com.example.fuckinggreatadvice.pojo.Advice;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavoriteAdviceFragment extends MvpAppCompatFragment implements FavoriteAdviceView {

    @InjectPresenter
    FavoriteAdvicePresenter favoriteAdvicePresenter;

    @ProvidePresenter
    FavoriteAdvicePresenter provideFavoriteAdvicePresenter() {
        return new FavoriteAdvicePresenter(getActivity());
    }

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    FavoriteAdapter favoriteAdapter;

    public static FavoriteAdviceFragment newInstance() {
        Bundle args = new Bundle();

        FavoriteAdviceFragment fragment = new FavoriteAdviceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite_advice, container, false);
        ButterKnife.bind(this, view);

        favoriteAdapter = new FavoriteAdapter(getActivity(), advice -> favoriteAdvicePresenter.deleteAdvice(advice));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(favoriteAdapter);

        return view;
    }

    @Override
    public void updateAdviceList(List<Advice> advice) {
        favoriteAdapter.setAdviceList(advice);
    }

    @Override
    public void deletedAdviceSuccesfull() {
        Toast.makeText(getActivity(), R.string.advice_deleted_msg, Toast.LENGTH_SHORT).show();
    }
}
