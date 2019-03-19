package com.example.fuckinggreatadvice.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.example.fuckinggreatadvice.R;
import com.example.fuckinggreatadvice.adapters.MainActivityAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends MvpAppCompatActivity {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        viewPager.setAdapter(new MainActivityAdapter(getSupportFragmentManager(), this));
        tabLayout.setupWithViewPager(viewPager);
    }
}
