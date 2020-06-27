package com.example.project_cse0318;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class ListenAzan extends Fragment implements View.OnClickListener, MediaPlayer.OnCompletionListener  {
    TextView arabicTextView;
    TextView banglaTextView;
    SeekBar fontSize;
    Button playButton;

    String arabic = "الله أكبر، الله أكبر\n" +
            "أشهد أن لا إله إلا الله\n" +
            "أشهد أن لا إله إلا الله\n" +
            "أشهد أن محمدًا رسولُ الله\n" +
            "أشهد أن محمدًا رسولُ الله\n" +
            "حيَّ على الصلاة\n" +
            "حيَّ على الصلاة\n" +
            "حيَّ على الفلاح\n" +
            "حيَّ على الفلاح\n" +
            "الله أكبر، الله أكبر\n" +
            "لا إله إلا الله";
    String bangla = "আল্লাহ সর্বশক্তিমান, আল্লাহ সর্বশক্তিমান \n" +
            "আমি সাক্ষ্য দিচ্ছি যে, আল্লাহ্ ছাড়া অন্য কোন মাবুদ নেই\n" +
            "আমি সাক্ষ্য দিচ্ছি যে, আল্লাহ্ ছাড়া অন্য কোন মাবুদ নেই\n" +
            "আমি সাক্ষ্য দিচ্ছি যে, মুহাম্মদ (স) আল্লাহর প্রেরিত দূত\n" +
            "আমি সাক্ষ্য দিচ্ছি যে, মুহাম্মদ (স) আল্লাহর প্রেরিত দূত\n" +
            "নামাজের জন্য এসো\n" +
            "নামাজের জন্য এসো\n" +
            "সাফল্যের জন্য এসো\n" +
            "সাফল্যের জন্য এসো\n" +
            "আল্লাহ্ মহান, আল্লাহ্ মহান\n" +
            "আল্লাহ্ ছাড়া অন্য কোন উপাস্য নেই";


    public ListenAzan() {
        // Required empty public constructor
    }

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {

        @Override
        public void onAudioFocusChange(int focusChange) {
            switch (focusChange) {
                case AudioManager.AUDIOFOCUS_GAIN:
                    //restart/resume your sound
                    AudioPlayer.resume();
                    playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_pause, 0, 0, 0);
                    break;
                case AudioManager.AUDIOFOCUS_LOSS:
                    AudioPlayer.stopAudio();
                    releaseAudioFocus(getActivity());
                    playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play_arrow, 0, 0, 0);
                    //Loss of audio focus for a long time
                    //Stop playing the sound
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                    playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play_arrow, 0, 0, 0);
                    AudioPlayer.pause();
                    //Loss of audio focus for a short time
                    //Pause playing the sound
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    AudioPlayer.pause();
                    playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play_arrow, 0, 0, 0);

                    //Loss of audio focus for a short time.
                    //But one can duck. Lower the volume of playing the sound

                    break;

                default:
            }
        }
    };











    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.listen_azan, container, false);

        arabicTextView = view.findViewById(R.id.arabicLyric);
        banglaTextView = view.findViewById(R.id.banglaLyric);
        fontSize = view.findViewById(R.id.textSize);
        playButton = view.findViewById(R.id.SurahPlayButton);
        final Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);


        fontSize.setMax(50);
        arabicTextView.setTextSize(30);
        banglaTextView.setTextSize(30);
        playButton.setOnClickListener(this);

        arabicTextView.setText(arabic);
        arabicTextView.setMovementMethod(new ScrollingMovementMethod());

        banglaTextView.setText(bangla);
        banglaTextView.setMovementMethod(new ScrollingMovementMethod());

        if(AudioPlayer.activityName == "Azan" && AudioPlayer.isplayingAudio){
            playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_pause, 0, 0, 0);
        }else{
            playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play_arrow, 0, 0, 0);
        }



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

        return view;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play_arrow, 0, 0, 0);
        AudioPlayer.stopAudio();
        releaseAudioFocus(getActivity());
    }

    @Override
    public void onClick(View v) {

        if(AudioPlayer.mediaPlayer==null){

            boolean focus = requestAudioFocus(getActivity());

            if(focus){
                AudioPlayer.playAudio(getActivity().getApplicationContext(),R.raw.azan2);
                AudioPlayer.activityName = "Azan";
                playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_pause, 0, 0, 0);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
            }

        }else{

            if(AudioPlayer.activityName == "Azan" && AudioPlayer.isplayingAudio){
                AudioPlayer.pause();
                playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_play_arrow, 0, 0, 0);

            }else if(AudioPlayer.activityName == "Azan" && AudioPlayer.isPause){
                AudioPlayer.resume();
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_pause, 0, 0, 0);

            }else{
                AudioPlayer.stopAudio();
                AudioPlayer.playAudio(getActivity().getApplicationContext(),R.raw.azan2);
                AudioPlayer.activityName = "Azan";
                playButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_pause, 0, 0, 0);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
            }

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






}
