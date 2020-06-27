package com.example.project_cse0318;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Qibla extends Fragment implements SensorEventListener {

    ImageView qibla_icon;

    private SensorManager sensorManager;
    private Sensor sensor;
    int current;

    public Qibla() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.qibla, container, false);
        qibla_icon = view.findViewById(R.id.qibla_icon);


        sensorManager = (SensorManager)getActivity().getSystemService(Context.SENSOR_SERVICE);


        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);

        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);

        return view;
    }


    @Override
    public void onResume(){
        super.onResume();
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }


    @Override
    public void onPause(){
        super.onPause();
        sensorManager.unregisterListener(this);
    }



    @Override
    public void onSensorChanged(SensorEvent event) {
        int degree = Math.round(event.values[0]);
        degree += 45;

        RotateAnimation animation = new RotateAnimation(current, -degree,Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF,0.5f);

        animation.setDuration(500);
        animation.setFillAfter(true);

        qibla_icon.setAnimation(animation);
        current = - degree;

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


}
