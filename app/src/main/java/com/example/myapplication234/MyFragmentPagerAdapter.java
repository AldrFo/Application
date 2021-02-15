package com.example.myapplication234;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {

    PageFragment pageFragment;

    private Context context;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context){
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position){
        Log.d(PageFragment.LIFECYCLE_LOG,"======================");
        Log.d(PageFragment.LIFECYCLE_LOG,"getItem");
        pageFragment = PageFragment.newInstance(position);
        return pageFragment;
    }

    @Override
    public int getCount(){
        return 7;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return context.getResources().getString(R.string.pn);
            case 1:
                return context.getResources().getString(R.string.vt);
            case 2:
                return context.getResources().getString(R.string.sr);
            case 3:
                return context.getResources().getString(R.string.cht);
            case 4:
                return context.getResources().getString(R.string.pt);
            case 5:
                return context.getResources().getString(R.string.sb);
            case 6:
                return context.getResources().getString(R.string.vs);
            default:
                return "title";
        }
    }
}
