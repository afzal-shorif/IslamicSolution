package com.example.project_cse0318;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ListenSurah extends Fragment {

    Intent intent;
    public int index = -1;
    Surahs surahs;



    public ListenSurah() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.listen_surah, container, false);


        surahs = new Surahs();

        ListView listView = view.findViewById(R.id.surah_listView);

        ArrayAdapter adapter = new ArrayAdapter(getActivity().getApplicationContext(),R.layout.surah_list_item, R.id.surahName,surahs.getSurahList());

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(getActivity(),PlaySurah.class);
                intent.putExtra("index",position);
                startActivity(intent);
            }
        });


        return view;
    }

}
