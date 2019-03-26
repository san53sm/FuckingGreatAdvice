package com.example.fuckinggreatadvice.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.fuckinggreatadvice.R;
import com.example.fuckinggreatadvice.adapters.MainActivityAdapter;
import com.example.fuckinggreatadvice.mvp.presenters.MainPresenter;
import com.example.fuckinggreatadvice.mvp.view.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter mainPresenter;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MainActivityAdapter mainActivityAdapter =
                new MainActivityAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(mainActivityAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
