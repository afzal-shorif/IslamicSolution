package com.example.project_cse0318;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Salah_3_rakat extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener, MediaPlayer.OnCompletionListener  {

    Button playButton;
    Surahs surahs;
    ArrayList<String> list;
    int playList[];
    int FirstSpinnerFlag,SecondSpinnerFlag,ThirdSpinnerFlag;
    String firstSurahName,secondSurahName,thirdSurahName;
    int index = 0;
    int size = 40;


    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {

        @Override
        public void onAudioFocusChange(int focusChange) {
            switch (focusChange) {
                case AudioManager.AUDIOFOCUS_GAIN:
                    AudioPlayer.resume();
                    playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_pause, 0, 0, 0);

                    //restart/resume your sound
                    break;
                case AudioManager.AUDIOFOCUS_LOSS:
                    AudioPlayer.stopAudio();
                    releaseAudioFocus(getActivity());
                    playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play_arrow, 0, 0, 0);

                    //Loss of audio focus for a long time
                    //Stop playing the sound

                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                    AudioPlayer.pause();
                    playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play_arrow, 0, 0, 0);
                    //Loss of audio focus for a short time
                    //Pause playing the sound
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play_arrow, 0, 0, 0);
                    AudioPlayer.pause();
                    //Loss of audio focus for a short time.
                    //But one can duck. Lower the volume of playing the sound
                    break;

                default: ;
            }
        }
    };




    public Salah_3_rakat() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.salah_3_rakat, container, false);

        Spinner surahFirst = (Spinner) view.findViewById(R.id.F_surah);
        Spinner surahSecond = (Spinner) view.findViewById(R.id.S_surah);
        Spinner surahThird = (Spinner) view.findViewById(R.id.Th_surah);

        playButton = (Button) view.findViewById(R.id.playSalah);

        surahs = new Surahs();

        list = surahs.getSurahList();
        list.remove(0);


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item_selected, list);
        dataAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        surahFirst.setAdapter(dataAdapter);
        surahSecond.setAdapter(dataAdapter);
        surahThird.setAdapter(dataAdapter);



        playList = new int[50];
        initPlaylist();
        FirstSpinnerFlag = 0;
        SecondSpinnerFlag = 0;
        ThirdSpinnerFlag = 0;
        firstSurahName = list.get(0);
        secondSurahName = list.get(0);
        thirdSurahName = list.get(0);


        playList[3] = surahs.getSurahId("Al-Fiyl");
        playList[21] = surahs.getSurahId("Al-Fiyl");
        //playList[21] = surahs.getSurahId("Al-Fiyl");
        //playList[21] = surahs.getSurahId("Al-Fiyl");

        surahFirst.setOnItemSelectedListener(this);
        surahSecond.setOnItemSelectedListener(this);
        surahThird.setOnItemSelectedListener(this);

        playButton.setOnClickListener(this);
        playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play_black, 0, 0, 0);
        playButton.setEnabled(false);

        return view;

    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        index++;
        if(index<size){
            onClick(playButton);
        }else{
            playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play_arrow, 0, 0, 0);
            playButton.setEnabled(true);
            index = 0;
            AudioPlayer.stopAudio();
            AudioPlayer.activityName = null;
            releaseAudioFocus(getActivity());
        }
    }

    @Override
    public void onClick(View v) {
        if(AudioPlayer.mediaPlayer == null){
            boolean focus = requestAudioFocus(getActivity());

            if(focus){
                AudioPlayer.playAudio(getActivity().getApplicationContext(),playList[index]);
                AudioPlayer.activityName = "Salah";
                playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_pause_black, 0, 0, 0);
                playButton.setEnabled(false);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
            }
        }else{

            AudioPlayer.stopAudio();
            AudioPlayer.playAudio(getActivity().getApplicationContext(),playList[index]);
            AudioPlayer.activityName = "Salah";
            playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_pause_black, 0, 0, 0);
            playButton.setEnabled(false);
            AudioPlayer.mediaPlayer.setOnCompletionListener(this);

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast toast;

        switch (parent.getId()){


            case R.id.F_surah: if(FirstSpinnerFlag==1){
                firstSurahName = list.get(position);

                if(!check()){
                    toast = Toast.makeText(getActivity().getApplicationContext(),"Please Select Another Surah",Toast.LENGTH_SHORT);
                    toast.show();
                    playList[3] = surahs.getSurahId(firstSurahName);
                }else {
                    playList[3] = surahs.getSurahId(firstSurahName);

                }
            }else FirstSpinnerFlag = 1;

                break;
            case R.id.S_surah: if(SecondSpinnerFlag==1){
                secondSurahName = list.get(position);

                if(!check()){
                    toast = Toast.makeText(getActivity().getApplicationContext(),"Please Select Another Surah",Toast.LENGTH_SHORT);
                    toast.show();
                    playList[21] = surahs.getSurahId(secondSurahName);
                }else{
                    playList[21] = surahs.getSurahId(secondSurahName);
                }

            }else SecondSpinnerFlag = 1;
                break;
            case R.id.Th_surah: if(ThirdSpinnerFlag==1){
                thirdSurahName = list.get(position);

                if(!check()){
                    toast = Toast.makeText(getActivity().getApplicationContext(),"Please Select Another Surah",Toast.LENGTH_SHORT);
                    toast.show();
                    playList[21] = surahs.getSurahId(thirdSurahName);
                }else{
                    playList[21] = surahs.getSurahId(thirdSurahName);
                }

            }else ThirdSpinnerFlag = 1;
                break;

            default:
        }

        if(check()){
            playButton.setEnabled(true);
            playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play_arrow, 0, 0, 0);
        }else{
            playButton.setEnabled(false);
            playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play_black, 0, 0, 0);

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public boolean check(){
        if((firstSurahName == secondSurahName) || (firstSurahName == thirdSurahName)
                || (secondSurahName == thirdSurahName)){
            return false;
        }
        return true;
    }


    public void initPlaylist(){

        playList[0] = R.raw.salah01;        ///allah hu akbar
        playList[1] = R.raw.salah02;        /// sana
        playList[2] = R.raw.fatiha;         /// fatiha
        /// playList[3] select by user
        playList[4] = R.raw.salah01;        /// allah hu akbar

        playList[5] = R.raw.salah06;        ///subhana rabbiyal azeem
        playList[6] = R.raw.salah06;        ///subhana rabbiyal azeem
        playList[7] = R.raw.salah06;        ///subhana rabbiyal azeem

        playList[8] = R.raw.salah07;        ///
        playList[9] = R.raw.salah08;        ///
        playList[10] = R.raw.salah01;       ///allah hu akbar

        playList[11] = R.raw.salah09;       ///subhana rabbiyal a'la
        playList[12] = R.raw.salah09;       ///subhana rabbiyal a'la
        playList[13] = R.raw.salah09;       ///subhana rabbiyal a'la

        playList[14] = R.raw.salah01;       ///allah hu akbar
        playList[15] = R.raw.salah01;       ///allah hu akbar

        playList[16] = R.raw.salah09;       ///subhana rabbiyal a'la
        playList[17] = R.raw.salah09;       ///subhana rabbiyal a'la
        playList[18] = R.raw.salah09;       ///subhana rabbiyal a'la

        playList[19] = R.raw.salah01;       ///allah hu akbar

        playList[20] = R.raw.fatiha;         /// fatiha
        //playList[21]   select by user

        playList[22] = R.raw.salah01;        /// allah hu akbar

        playList[23] = R.raw.salah06;        ///subhana rabbiyal azeem
        playList[24] = R.raw.salah06;        ///subhana rabbiyal azeem
        playList[25] = R.raw.salah06;        ///subhana rabbiyal azeem

        playList[26] = R.raw.salah07;        ///
        playList[27] = R.raw.salah08;        ///
        playList[28] = R.raw.salah01;       ///allah hu akbar

        playList[29] = R.raw.salah09;       ///subhana rabbiyal a'la
        playList[30] = R.raw.salah09;       ///subhana rabbiyal a'la
        playList[31] = R.raw.salah09;       ///subhana rabbiyal a'la

        playList[32] = R.raw.salah01;       ///allah hu akbar
        playList[33] = R.raw.salah01;       ///allah hu akbar

        playList[34] = R.raw.salah09;       ///subhana rabbiyal a'la
        playList[35] = R.raw.salah09;       ///subhana rabbiyal a'la
        playList[36] = R.raw.salah09;       ///subhana rabbiyal a'la

        playList[37] = R.raw.salah01;       ///allah hu akbar

        playList[38] = R.raw.salah11;       ///attahiyat
        playList[39] = R.raw.salah01;       ///allah hu akbar
        playList[40] = R.raw.fatiha;         /// fatiha
        //playList[41] = /// by user         /// fatiha




        playList[39] = R.raw.salah12;       ///durood sharif
        playList[40] = R.raw.salah13;       ///dua masura

    }

    public boolean requestAudioFocus(final Context context) {

        AudioManager am = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);

        int result = am.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

            return true;
        } else {

            return false;
        }

    }


    void releaseAudioFocus(final Context context) {
        AudioManager am = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
        am.abandonAudioFocus(mOnAudioFocusChangeListener);
    }


}
