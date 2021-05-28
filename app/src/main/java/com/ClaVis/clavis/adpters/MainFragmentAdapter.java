package com.ClaVis.clavis.adpters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ClaVis.clavis.fracments.Activity2_2fragment;

public class MainFragmentAdapter extends FragmentPagerAdapter {

    private static final String[] titles = {"Текст 1 "," Текст 2 "};

    public MainFragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return Activity2_2fragment.getInstance("t,kfy");
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "лай";
    }
}
