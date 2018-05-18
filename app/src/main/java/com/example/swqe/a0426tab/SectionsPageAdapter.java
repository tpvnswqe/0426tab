package com.example.swqe.a0426tab;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.List;

public class SectionsPageAdapter extends FragmentPagerAdapter {

    private static final String TAG = "Section";
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    protected SparseArray<String> tags = new SparseArray<>();



    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    public SectionsPageAdapter(FragmentManager fm) {
        super(fm);
        Log.d(TAG, "SectionsPageAdapter");
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Log.d(TAG, "CharSequence getPageTitle");
        return mFragmentTitleList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        Log.d(TAG, "Fragment getItem");
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        Log.d(TAG, "getCount"+mFragmentList.size()+mFragmentTitleList.toString());


        return mFragmentList.size();
    }





}
