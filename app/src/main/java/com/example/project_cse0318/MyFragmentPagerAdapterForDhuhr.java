package com.example.project_cse0318;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MyFragmentPagerAdapterForDhuhr extends FragmentStatePagerAdapter {

    public MyFragmentPagerAdapterForDhuhr(FragmentManager fm) {
        super(fm);

    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Salah_4_rakat();
            case 1:
                return new Salah_4_rakat();
            case 2:
                return new Salah_2_rakat();
            default:
                return null;
        }
    }

    public CharSequence getPageTitle(int position) {

        if(position==0){
            return "SUNNAH 4";
        }else if(position==1){
            return "FARZ 4";
        }else{
            return "SUNNAH 2";
        }
    }


    @Override
    public int getCount() {
        return 3;
    }
}
