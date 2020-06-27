package com.example.project_cse0318;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class MyFragmentPagerAdapterForFajr extends FragmentStatePagerAdapter {


    public MyFragmentPagerAdapterForFajr(FragmentManager fm) {
        super(fm);

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new Salah_2_rakat();
            case 1:
                return new Salah_2_rakat();
            default:
                return null;
        }

    }

    @Override
    public int getCount() { return 2; }


    @Override
    public CharSequence getPageTitle(int position) {

        if(position==0){
            return "SUNNAH 2";
        }else{
            return "FARZ 2";
        }
    }
}
