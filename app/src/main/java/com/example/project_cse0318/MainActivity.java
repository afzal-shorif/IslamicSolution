package com.example.project_cse0318;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new Home()).commit();
                        break;
                    case R.id.salah: if(getSupportFragmentManager().getBackStackEntryCount()==0){
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new Offer_Salahs()).addToBackStack(null).commit();
                        }else{
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new Offer_Salahs()).commit();
                        }
                        break;
                    case R.id.arabicLetter:
                        if(getSupportFragmentManager().getBackStackEntryCount()==0){
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                    new ArabicLetter()).addToBackStack(null).commit();
                        }else{
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                    new ArabicLetter()).commit();
                        }
                        break;

                    case R.id.Listen_surah: if(getSupportFragmentManager().getBackStackEntryCount()==0){
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new ListenSurah()).addToBackStack(null).commit();
                        }else{
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new ListenSurah()).commit();
                        }

                        break;

                    case R.id.ListenAzan: if(getSupportFragmentManager().getBackStackEntryCount()==0){
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new ListenAzan()).addToBackStack(null).commit();
                        }else{
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new ListenAzan()).commit();
                        }

                        break;

//                    case R.id.rulesOfSalah: if(getSupportFragmentManager().getBackStackEntryCount()==0){
//                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                                new ListenAzan()).addToBackStack(null).commit();
//                    }else{
//                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                                new ListenAzan()).commit();
//                    }
//
//                        break;

                    case R.id.qibla:if(getSupportFragmentManager().getBackStackEntryCount()==0){
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new Qibla()).addToBackStack(null).commit();
                        }else{
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                    new Qibla()).commit();
                        }
                        break;
                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_navigation,R.string.close_navigation);
        toggle.syncState();


        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Home()).commit();
            navigationView.setCheckedItem(R.id.home);
        }


    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();

        }

    }

    @Override
    public void onPause(){
        super.onPause();
    }



    @Override
    public void onResume(){
        super.onResume();

    }


}
