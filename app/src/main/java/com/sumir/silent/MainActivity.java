package com.sumir.silent;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

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

        Bar.intiBar(audioManager,alarm,AudioManager.STREAM_ALARM);
        Bar.intiBar(audioManager,music,AudioManager.STREAM_MUSIC);
        Bar.intiBar(audioManager,ring,AudioManager.STREAM_RING);
        Bar.intiBar(audioManager,voice,AudioManager.STREAM_VOICE_CALL);
    }

}

