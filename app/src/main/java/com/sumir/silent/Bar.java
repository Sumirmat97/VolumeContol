package com.sumir.silent;

import android.media.AudioManager;
import android.widget.SeekBar;

/**
 * Created by Sumir on 27-05-2017.
 */

public class Bar {
    private Bar(){}

    static void intiBar(final AudioManager audioManager, SeekBar seekBar, final int stream)
    {
        seekBar.setMax(audioManager.getStreamMaxVolume(stream));
        seekBar.setProgress(audioManager.getStreamVolume(stream));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(stream,i,AudioManager.FLAG_PLAY_SOUND);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}
