package com.example.fuckinggreatadvice.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.fuckinggreatadvice.R;
import com.example.fuckinggreatadvice.ui.fragment.FavoriteAdviceFragment;
import com.example.fuckinggreatadvice.ui.fragment.RandomAdviceFragment;

public class MainActivityAdapter extends FragmentPagerAdapter {

    private final static int RANDOM_FRAGMENT_POSITION = 0;
    private final static int FAVORITE_FRAGMENT_POSITION = 1;

    private String tabTitles[];
    RandomAdviceFragment randomAdviceFragment;
    FavoriteAdviceFragment favoriteAdviceFragment;

    public MainActivityAdapter(FragmentManager fm, Context context) {
        super(fm);
        tabTitles = new String[]{context.getString(R.string.tab_title_random_advice),
                context.getString(R.string.tab_title_favorite_advices)};
        randomAdviceFragment = RandomAdviceFragment.newInstance();
        favoriteAdviceFragment = FavoriteAdviceFragment.newInstance();
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case RANDOM_FRAGMENT_POSITION:
                return randomAdviceFragment;
            case FAVORITE_FRAGMENT_POSITION:
                return favoriteAdviceFragment;
            default:
                throw new RuntimeException("MainActivityAdapter.getItem(): No Fragment for this index!");
        }
    }


    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
