package com.example.project_cse0318;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class ArabicLetter extends Fragment implements View.OnTouchListener, MediaPlayer.OnCompletionListener {

    View view;
    boolean focus;
    public ArabicLetter() {
        // Required empty public constructor
    }

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {

        @Override
        public void onAudioFocusChange(int focusChange) {
            switch (focusChange) {
                case AudioManager.AUDIOFOCUS_GAIN:
                    //restart/resume your sound
                    break;
                case AudioManager.AUDIOFOCUS_LOSS:

                    //Loss of audio focus for a long time
                    //Stop playing the sound

                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:

                    //Loss of audio focus for a short time
                    //Pause playing the sound
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:

                    //onClick(playButton);
                    //Loss of audio focus for a short time.
                    //But one can duck. Lower the volume of playing the sound

                    break;

                default:
            }
        }
    };


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.arabic_letter, container, false);
        TextView textView1 = view.findViewById(R.id.LetterView1);
        TextView textView2 = view.findViewById(R.id.LetterView2);
        TextView textView3 = view.findViewById(R.id.LetterView3);

        TextView textView4 = view.findViewById(R.id.LetterView4);
        TextView textView5 = view.findViewById(R.id.LetterView5);
        TextView textView6 = view.findViewById(R.id.LetterView6);
        TextView textView7 = view.findViewById(R.id.LetterView7);
        TextView textView8 = view.findViewById(R.id.LetterView8);
        TextView textView9 = view.findViewById(R.id.LetterView9);
        TextView textView10 = view.findViewById(R.id.LetterView10);
        TextView textView11 = view.findViewById(R.id.LetterView11);
        TextView textView12 = view.findViewById(R.id.LetterView12);
        TextView textView13 = view.findViewById(R.id.LetterView13);
        TextView textView14 = view.findViewById(R.id.LetterView14);
        TextView textView15 = view.findViewById(R.id.LetterView15);
        TextView textView16 = view.findViewById(R.id.LetterView16);
        TextView textView17 = view.findViewById(R.id.LetterView17);
        TextView textView18 = view.findViewById(R.id.LetterView18);
        TextView textView19 = view.findViewById(R.id.LetterView19);
        TextView textView20 = view.findViewById(R.id.LetterView20);
        TextView textView21 = view.findViewById(R.id.LetterView21);
        TextView textView22 = view.findViewById(R.id.LetterView22);
        TextView textView23 = view.findViewById(R.id.LetterView23);
        TextView textView24 = view.findViewById(R.id.LetterView24);
        TextView textView25 = view.findViewById(R.id.LetterView25);
        TextView textView26 = view.findViewById(R.id.LetterView26);
        TextView textView27 = view.findViewById(R.id.LetterView27);
        TextView textView28 = view.findViewById(R.id.LetterView28);
        TextView textView29 = view.findViewById(R.id.LetterView29);

        if(AudioPlayer.mediaPlayer==null)focus = false;
        else focus = true;

        textView1.setOnTouchListener(this);
        textView2.setOnTouchListener(this);
        textView3.setOnTouchListener(this);
        textView4.setOnTouchListener(this);
        textView5.setOnTouchListener(this);
        textView6.setOnTouchListener(this);
        textView7.setOnTouchListener(this);
        textView8.setOnTouchListener(this);
        textView9.setOnTouchListener(this);
        textView10.setOnTouchListener(this);
        textView11.setOnTouchListener(this);
        textView12.setOnTouchListener(this);
        textView13.setOnTouchListener(this);
        textView14.setOnTouchListener(this);
        textView15.setOnTouchListener(this);
        textView16.setOnTouchListener(this);
        textView17.setOnTouchListener(this);
        textView18.setOnTouchListener(this);
        textView19.setOnTouchListener(this);
        textView20.setOnTouchListener(this);
        textView21.setOnTouchListener(this);
        textView22.setOnTouchListener(this);
        textView23.setOnTouchListener(this);
        textView24.setOnTouchListener(this);
        textView25.setOnTouchListener(this);
        textView26.setOnTouchListener(this);
        textView27.setOnTouchListener(this);
        textView28.setOnTouchListener(this);
        textView29.setOnTouchListener(this);

        return view;
    }

    public void PlayLetter(int n){

        switch (n){

            case R.id.LetterView1:
                AudioPlayer.playAudio(getActivity(),R.raw.a1);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView2:
                AudioPlayer.playAudio(getActivity(),R.raw.a2);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView3:
                AudioPlayer.playAudio(getActivity(),R.raw.a3);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView4:
                AudioPlayer.playAudio(getActivity(),R.raw.a4);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView5:
                AudioPlayer.playAudio(getActivity(),R.raw.a5);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView6:
                AudioPlayer.playAudio(getActivity(),R.raw.a6);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView7:
                AudioPlayer.playAudio(getActivity(),R.raw.a7);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView8:
                AudioPlayer.playAudio(getActivity(),R.raw.a8);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView9:
                AudioPlayer.playAudio(getActivity(),R.raw.a9);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView10:
                AudioPlayer.playAudio(getActivity(),R.raw.a10);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView11:
                AudioPlayer.playAudio(getActivity(),R.raw.a11);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView12:
                AudioPlayer.playAudio(getActivity(),R.raw.a12);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView13:
                AudioPlayer.playAudio(getActivity(),R.raw.a13);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView14:
                AudioPlayer.playAudio(getActivity(),R.raw.a14);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView15:
                AudioPlayer.playAudio(getActivity(),R.raw.a15);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView16:
                AudioPlayer.playAudio(getActivity(),R.raw.a16);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView17:
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView18:
                AudioPlayer.playAudio(getActivity(),R.raw.a18);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView19:
                AudioPlayer.playAudio(getActivity(),R.raw.a19);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView20:
                AudioPlayer.playAudio(getActivity(),R.raw.a20);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView21:
                AudioPlayer.playAudio(getActivity(),R.raw.a21);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView22:
                AudioPlayer.playAudio(getActivity(),R.raw.a22);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView23:
                AudioPlayer.playAudio(getActivity(),R.raw.a23);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView24:
                AudioPlayer.playAudio(getActivity(),R.raw.a24);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView25:
                AudioPlayer.playAudio(getActivity(),R.raw.a25);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView26:
                AudioPlayer.playAudio(getActivity(),R.raw.a27);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView27:
                AudioPlayer.playAudio(getActivity(),R.raw.a26);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;

            case R.id.LetterView28:if(AudioPlayer.mediaPlayer==null)
                // AudioPlayer.playAudio(getContext(),R.raw.alif);
                break;

            case R.id.LetterView29:
                AudioPlayer.playAudio(getActivity(),R.raw.a28);
                AudioPlayer.mediaPlayer.setOnCompletionListener(this);
                break;
        }

    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if(AudioPlayer.mediaPlayer == null){
            focus = requestAudioFocus(getActivity());

            if(focus){
                PlayLetter(v.getId());
                AudioPlayer.activityName = "Letter";
            }
        }else{

            if(AudioPlayer.activityName != "Letter"){
                AudioPlayer.activityName = "Letter";
                AudioPlayer.stopAudio();
                PlayLetter(v.getId());
            }else{
                //return false;
            }

        }

        return true;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        AudioPlayer.stopAudio();
        releaseAudioFocus(getActivity());
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
