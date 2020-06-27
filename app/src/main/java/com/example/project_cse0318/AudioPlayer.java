package com.example.project_cse0318;

import android.content.Context;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.widget.Button;

import static android.media.ToneGenerator.MAX_VOLUME;

public class AudioPlayer {

    private static SoundPool soundPool;
    public static boolean isplayingAudio = false;
    public static int isThisId = -1;
    public static int length;
    public static boolean isPause = false;
    public static String activityName;

    public static MediaPlayer mediaPlayer;

    static void playAudio(Context context,int audioId) {


        mediaPlayer = MediaPlayer.create(context, audioId);

        soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);

        if(!mediaPlayer.isPlaying())
        {
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            isplayingAudio = true;
            isPause = false;
            mediaPlayer.start();
        }else {
            mediaPlayer.release();
            mediaPlayer = null;
        }

    }

    public static void stopAudio(){
        isplayingAudio = false;
        mediaPlayer.stop();
        mediaPlayer = null;
        isPause = false;
        length = 0;
        activityName = null;
    }

    public static void pause(){
        mediaPlayer.pause();
        length = mediaPlayer.getCurrentPosition();
        isPause = true;
        isplayingAudio = false;
    }

    public static void resume(){
        mediaPlayer.seekTo(length);
        mediaPlayer.start();
        isplayingAudio = true;
        isPause = false;
    }

}
