package com.example.project_cse0318;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Surahs {

    ArrayList<String> surahName;
    Map< String,Integer> surahId;
    Surahs(){
        surahName = new ArrayList<String>();
        surahId = new HashMap< String,Integer>();
        init();
    }

    void init(){


        surahName.add("Al-Fatihah");
        surahName.add("Al-Fiyl");
        surahName.add("Quraysh");
        surahName.add("Al-Maa‘oun");
        surahName.add("Al-Kawthar");
        surahName.add("Al-Kaafiroun");
        surahName.add("An-Nasr");
        surahName.add("Al-Masad");
        surahName.add("Al-Ikhlaas");
        surahName.add("Al-Falaq");
        surahName.add("An-Naas");


        surahId.put("Al-Fatihah",new Integer(R.raw.fatiha));
        surahId.put("Al-Fiyl",new Integer(R.raw.fil));
        surahId.put("Al-Masad",new Integer(R.raw.masad));
        surahId.put("Al-Falaq",new Integer(R.raw.falaq));
        surahId.put("Al-Ikhlaas",new Integer(R.raw.ikhlas));
        surahId.put("Al-Kaafiroun",new Integer(R.raw.kafirun));
        surahId.put("Al-Kawthar",new Integer(R.raw.kauthar));
        surahId.put("Al-Maa‘oun",new Integer(R.raw.maun));
        surahId.put("An-Naas",new Integer(R.raw.nas));
        surahId.put("An-Nasr",new Integer(R.raw.nasr));
        surahId.put("Quraysh",new Integer(R.raw.quraysh));
    }


    public  ArrayList<String> getSurahList(){ return surahName; }

    public int getSurahId(String name) { return surahId.get(name); }

}
