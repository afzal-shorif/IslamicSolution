package com.example.project_cse0318;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SalahAsr extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener, MediaPlayer.OnCompletionListener {

    Button playButton;
    Surahs surahs;
    ArrayList<String> list;
    int playList[];
    int FirstSpinnerFlag,SecondSpinnerFlag;
    String firstSurahName,secondSurahName;
    int index = 0;
    int size = 41;

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
                    releaseAudioFocus(SalahAsr.this);
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salah_asr);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Salah Asr");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Spinner surahFirst = (Spinner) findViewById(R.id.F_surah);
        Spinner surahSecond = (Spinner) findViewById(R.id.S_surah);
        playButton = (Button) findViewById(R.id.playSalah);

        surahs = new Surahs();

        list = surahs.getSurahList();
        list.remove(0);


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item_selected, list);
        dataAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        surahFirst.setAdapter(dataAdapter);
        surahSecond.setAdapter(dataAdapter);

        playList = new int[50];
        initPlaylist();

        FirstSpinnerFlag = 0;
        SecondSpinnerFlag = 0;
        firstSurahName = list.get(0);
        secondSurahName = list.get(0);
        playList[3] = surahs.getSurahId("Al-Fiyl");
        playList[21] = surahs.getSurahId("Al-Fiyl");

        surahFirst.setOnItemSelectedListener(this);
        surahSecond.setOnItemSelectedListener(this);
        playButton.setOnClickListener(this);
        playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play_arrow, 0, 0, 0);
        playButton.setEnabled(false);

    }

    @Override
    public void onClick(View v) {
        if(AudioPlayer.mediaPlayer == null){
            boolean focus = requestAudioFocus(SalahAsr.this);

            if(focus){
                AudioPlayer.playAudio(getApplicationContext(),playList[index]);
                AudioPlayer.activityName = "Salah";
                playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_pause_black, 0, 0, 0);
                playButton.setEnabled(false);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
            }
        }else{

            AudioPlayer.stopAudio();
            AudioPlayer.playAudio(getApplicationContext(),playList[index]);
            AudioPlayer.activityName = "Salah";
            playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_pause_black, 0, 0, 0);
            playButton.setEnabled(false);
            AudioPlayer.mediaPlayer.setOnCompletionListener(this);

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast toast;
        if(parent.getId()==R.id.F_surah){

            if(FirstSpinnerFlag==1){
                firstSurahName = list.get(position);
                if(firstSurahName == secondSurahName){
                    toast = Toast.makeText(getApplicationContext(),"Please Select Another Surah",Toast.LENGTH_SHORT);
                    toast.show();
                    playList[3] = surahs.getSurahId(firstSurahName);
                }else {
                    playList[3] = surahs.getSurahId(firstSurahName);

                }
            }else FirstSpinnerFlag = 1;

        }else{
            if(SecondSpinnerFlag==1){
                secondSurahName = list.get(position);

                if(firstSurahName == secondSurahName){
                    toast = Toast.makeText(getApplicationContext(),"Please Select Another Surah",Toast.LENGTH_SHORT);
                    toast.show();
                    playList[21] = surahs.getSurahId(secondSurahName);
                }else{
                    playList[21] = surahs.getSurahId(secondSurahName);
                }

            }else SecondSpinnerFlag = 1;
        }

        if(firstSurahName != secondSurahName){
            playButton.setEnabled(true);
            playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play_arrow, 0, 0, 0);
        }else{
            playButton.setEnabled(false);
            playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play_black, 0, 0, 0);

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent){

    }


    @Override
    public boolean onSupportNavigateUp() {

        //if(AudioPlayer.isplayingAudio && AudioPlayer.activityName == "Salah"){
            //AudioPlayer.stopAudio();
            //AudioPlayer.activityName = null;
        //}
        onBackPressed();


        return true;
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
            releaseAudioFocus(SalahAsr.this);
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(AudioPlayer.isplayingAudio && AudioPlayer.activityName == "Salah"){
            AudioPlayer.stopAudio();
            AudioPlayer.activityName = null;
            releaseAudioFocus(SalahAsr.this);
        }
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
        playList[39] = R.raw.salah12;       ///durood sharif
        playList[40] = R.raw.salah13;       ///dua masura

    }

}
