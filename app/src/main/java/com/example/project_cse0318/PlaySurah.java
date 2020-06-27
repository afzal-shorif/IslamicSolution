package com.example.project_cse0318;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class PlaySurah extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnCompletionListener {


    TextView arabicTextView;
    TextView banglaTextView;
    SeekBar fontSize,surahSeekBar;
    Button playButton;

    Surahs surahs;
    SurahLyric surahLyric;
    int index;
    boolean flag;

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
                    releaseAudioFocus(PlaySurah.this);
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
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_surah);

        Intent intent = getIntent();
        index = intent.getIntExtra("index", -1);

        //// objects define
        arabicTextView = findViewById(R.id.arabicLyric);
        banglaTextView = findViewById(R.id.banglaLyric);
        fontSize = findViewById(R.id.textSize);
        surahSeekBar = findViewById(R.id.surahTime);
        playButton = findViewById(R.id.SurahPlayButton);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        surahs = new Surahs();
        surahLyric = new SurahLyric();

        /// initialize
        flag = false;
        fontSize.setMax(50);
        surahSeekBar.setProgress(0);
        arabicTextView.setTextSize(30);
        banglaTextView.setTextSize(30);
        playButton.setOnClickListener(this);

        arabicTextView.setText(surahLyric.getArabicLyric(index));
        arabicTextView.setMovementMethod(new ScrollingMovementMethod());

        banglaTextView.setText(surahLyric.getBanglaLyric(index));
        banglaTextView.setMovementMethod(new ScrollingMovementMethod());


        //// front size controller
        fontSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                banglaTextView.setTextSize(progress+25);
                arabicTextView.setTextSize(progress+25);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        /// seekbar audio control

        surahSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                if(AudioPlayer.mediaPlayer == null){
                    boolean focus = requestAudioFocus(PlaySurah.this);

                    if(focus){
                        flag = false;
                        AudioPlayer.playAudio(getApplicationContext(),surahs.getSurahId(surahLyric.getSurahName(index)));
                        AudioPlayer.pause();
                        AudioPlayer.isThisId = index;
                        AudioPlayer.activityName = "PlaySurah";
                        surahSeekBar.setMax(AudioPlayer.mediaPlayer.getDuration()/1000);
                    }

                }else{

                    if(AudioPlayer.activityName =="PlaySurah" && AudioPlayer.isThisId==index){

                        if(AudioPlayer.isPause){
                            flag = false;
                        }else{
                            flag = true;
                        }
                    }else{
                        flag = false;
                    }

                    AudioPlayer.stopAudio();
                    AudioPlayer.playAudio(getApplicationContext(),surahs.getSurahId(surahLyric.getSurahName(index)));
                    AudioPlayer.pause();
                    AudioPlayer.isThisId = index;
                    AudioPlayer.activityName = "PlaySurah";
                    surahSeekBar.setMax(AudioPlayer.mediaPlayer.getDuration()/1000);
                    playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play_arrow, 0, 0, 0);
                }



            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                AudioPlayer.length = seekBar.getProgress()*1000;

                if(flag){
                    //AudioPlayer.resume();
                    playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_pause, 0, 0, 0);
                    onClick(playButton);
                }else{
                    AudioPlayer.mediaPlayer.seekTo(AudioPlayer.length);
                }

                //if(!AudioPlayer.isPause){

                    //AudioPlayer.isPause = true;
                    //AudioPlayer.length = seekBar.getProgress()*1000;
                    //onClick(playButton);
                //}else{
                    //AudioPlayer.isPause = true;
                    //AudioPlayer.length = seekBar.getProgress()*1000;
                //}
            }
        });



        /// audio control

        if(AudioPlayer.isThisId == index && AudioPlayer.isPause == false && AudioPlayer.activityName == "PlaySurah"){
            //flag = true;
            playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_pause, 0, 0, 0);
            surahSeekBar.setMax(AudioPlayer.mediaPlayer.getDuration()/1000);
            surahSeekBar.setProgress(AudioPlayer.mediaPlayer.getCurrentPosition()/1000);
            AudioPlayer.mediaPlayer.setOnCompletionListener(this);
        }else if(AudioPlayer.isThisId == index && AudioPlayer.isPause==true && AudioPlayer.activityName == "PlaySurah"){
            //flag = false;
            playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play_arrow, 0, 0, 0);
            surahSeekBar.setMax(AudioPlayer.mediaPlayer.getDuration()/1000);
            surahSeekBar.setProgress(AudioPlayer.length);
            AudioPlayer.mediaPlayer.setOnCompletionListener(this);
        }else{
            playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play_arrow, 0, 0, 0);
        }




        /// update seekbar in every 1 second ot
        /// refresh activity to update seekbar

        final Handler mHandler = new Handler();
        PlaySurah.this.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                if(AudioPlayer.mediaPlayer != null){
                    if(AudioPlayer.activityName == "PlaySurah" && AudioPlayer.isThisId == index){
                        int mCurrentPosition = AudioPlayer.mediaPlayer.getCurrentPosition() / 1000;
                        surahSeekBar.setProgress(mCurrentPosition);
                    }

                }
                mHandler.postDelayed(this, 1000);
            }
        });


        //playButton.setTextColor(Color.BLACK);

        /// toolbar title
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(surahLyric.getSurahName(index));


    }


    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }




    @Override
    public void onClick(View v) {



        if(AudioPlayer.mediaPlayer==null){

            boolean focus = requestAudioFocus(PlaySurah.this);

            if(focus){

                Toast toast = Toast.makeText(getApplicationContext(),""+focus,Toast.LENGTH_SHORT);
                toast.show();

                AudioPlayer.playAudio(getApplicationContext(),surahs.getSurahId(surahLyric.getSurahName(index)));
                AudioPlayer.activityName = "PlaySurah";
                AudioPlayer.isThisId = index;
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_pause, 0, 0, 0);
                surahSeekBar.setMax(AudioPlayer.mediaPlayer.getDuration()/1000);
            }

        }else{

            if(AudioPlayer.activityName == "PlaySurah"){

                if(AudioPlayer.isThisId == index){

                    if(AudioPlayer.isPause){
                        surahSeekBar.setMax(AudioPlayer.mediaPlayer.getDuration()/1000);
                        surahSeekBar.setProgress(AudioPlayer.length/1000);
                        playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_pause, 0, 0, 0);
                        AudioPlayer.resume();
                        AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                    }else{
                        AudioPlayer.pause();
                        playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play_arrow, 0, 0, 0);
                    }

                }else{
                    AudioPlayer.stopAudio();
                    AudioPlayer.playAudio(getApplicationContext(),surahs.getSurahId(surahLyric.getSurahName(index)));
                    AudioPlayer.activityName = "PlaySurah";
                    AudioPlayer.isThisId = index;
                    AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                    playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_pause, 0, 0, 0);
                    surahSeekBar.setMax(AudioPlayer.mediaPlayer.getDuration()/1000);
                }

            }else{
                AudioPlayer.stopAudio();
                AudioPlayer.playAudio(getApplicationContext(),surahs.getSurahId(surahLyric.getSurahName(index)));
                AudioPlayer.activityName = "PlaySurah";
                AudioPlayer.isThisId = index;
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_pause, 0, 0, 0);
                surahSeekBar.setMax(AudioPlayer.mediaPlayer.getDuration()/1000);
            }

        }

    }


    @Override
    public void onCompletion(MediaPlayer mp) {
        AudioPlayer.stopAudio();
        AudioPlayer.activityName = null;
        playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play_arrow, 0, 0, 0);
        surahSeekBar.setProgress(0);
        releaseAudioFocus(PlaySurah.this);
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

