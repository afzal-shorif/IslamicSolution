package com.example.project_cse0318;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class SalahTabContainer extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    int num;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salah_tab_container);

        Intent intent = getIntent();
        num = intent.getIntExtra("num", -1);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        switch (num){
            case 1: name = "Salah Fajr";
            break;
            case 2: name = "Salah Dhuhr";
                break;
            case 4: name = "Salah Maghrib";
                break;
            case 5: name = "Salah Isha";
                break;
                default: name = "Something Wrong";
        }
        getSupportActionBar().setTitle(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        setPagerAdapter();
        //setTabLayout();
    }


    private void setPagerAdapter(){

        if(num==1){
            viewPager.setAdapter(new MyFragmentPagerAdapterForFajr(getSupportFragmentManager()));
        }else if(num==2) {
            viewPager.setAdapter(new MyFragmentPagerAdapterForDhuhr(getSupportFragmentManager()));
        }else if(num==4){
            viewPager.setAdapter(new MyFragmentPagerAdapterForMaghrib(getSupportFragmentManager()));
        }else if(num==5){
            viewPager.setAdapter(new MyFragmentPagerAdapterForIsha(getSupportFragmentManager()));
        }

    }

    private void setTabLayout() {
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("First");
        tabLayout.getTabAt(1).setText("Second");
    }

    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        if(AudioPlayer.isplayingAudio && AudioPlayer.activityName == "Salah"){
            AudioPlayer.pause();
            AudioPlayer.activityName = null;
        }

        return true;
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(AudioPlayer.isplayingAudio && AudioPlayer.activityName == "Salah"){
            AudioPlayer.pause();
            AudioPlayer.activityName = null;

        }
    }


}
