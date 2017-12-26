package com.yyz.gogoplay.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by yyz on 2017/12/25.
 */

public class MainPagerAdapter  extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private String [] titles;

    public MainPagerAdapter(List<Fragment> fragmentList,String [] titles,FragmentManager fm) {
        super(fm);
        this.fragmentList=fragmentList;
        this.titles=titles;

    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
