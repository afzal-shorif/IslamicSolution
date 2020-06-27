package com.example.project_cse0318;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Offer_Salahs extends Fragment implements View.OnClickListener {

    Intent intent;
    int num;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.offer_salah, container, false);


        Button fajr     =    (Button) view.findViewById(R.id.fajr);
        Button dhuhr    =    (Button) view.findViewById(R.id.dhuhr);
        Button asr      =    (Button) view.findViewById(R.id.asr);
        Button maghrib  =    (Button) view.findViewById(R.id.maghrib);
        Button isha     =    (Button) view.findViewById(R.id.isha);

        fajr.setOnClickListener(this);
        dhuhr.setOnClickListener(this);
        asr.setOnClickListener(this);
        maghrib.setOnClickListener(this);
        isha.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.fajr: intent = new Intent(getActivity(), SalahTabContainer.class);
                intent.putExtra("num",1);
                break;
            case R.id.dhuhr: intent = new Intent(getActivity(), SalahTabContainer.class);
                intent.putExtra("num",2);
                break;
            case R.id.asr: intent = new Intent(getActivity(),SalahAsr.class);
                break;
            case R.id.maghrib: intent = new Intent(getActivity(), SalahTabContainer.class);
                intent.putExtra("num",4);
                break;
            case R.id.isha: intent = new Intent(getActivity(), SalahTabContainer.class);
                intent.putExtra("num",5);
                break;
        }

        startActivity(intent);
    }
}
