package com.example.fuckinggreatadvice.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.example.fuckinggreatadvice.R;

import butterknife.ButterKnife;

public class RandomAdviceFragment extends MvpAppCompatFragment {

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
}
