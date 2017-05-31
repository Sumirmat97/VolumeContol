package com.sumir.silent;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView loud;
    ImageView vibrate;
    ImageView silent;

    SeekBar voice;
    SeekBar music;
    SeekBar ring;
    SeekBar alarm;

    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        loud = (ImageView) findViewById(R.id.ringer_on);
        vibrate = (ImageView) findViewById(R.id.ringer_vibrate);
        silent = (ImageView) findViewById(R.id.ringer_off);

        voice = (SeekBar) findViewById(R.id.voiceControl);
        music = (SeekBar) findViewById(R.id.musicControl);
        ring = (SeekBar) findViewById(R.id.ringerControl);
        alarm = (SeekBar) findViewById(R.id.alarmControl);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        Images.createListener(audioManager,loud,"normal",ring);
        Images.createListener(audioManager,vibrate,"vibrate",ring);
        Images.createListener(audioManager,silent,"silent",ring);


/*
        vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                ring.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_RING));
                Toast.makeText(MainActivity.this,"Now in Vibrate Mode",
                        Toast.LENGTH_LONG).show();
            }
        });

        loud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                ring.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_RING));
                Toast.makeText(MainActivity.this,"Now in Ringing Mode",
                        Toast.LENGTH_LONG).show();
            }
        });

        silent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                //ring.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_RING));
                Toast.makeText(MainActivity.this,"Now in silent Mode",
                        Toast.LENGTH_LONG).show();
            }
        });*/
        Bar.intiBar(audioManager,alarm,AudioManager.STREAM_ALARM);
        Bar.intiBar(audioManager,music,AudioManager.STREAM_MUSIC);
        Bar.intiBar(audioManager,ring,AudioManager.STREAM_RING);
        Bar.intiBar(audioManager,voice,AudioManager.STREAM_VOICE_CALL);
    }

}

