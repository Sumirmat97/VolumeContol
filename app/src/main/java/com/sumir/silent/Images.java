package com.sumir.silent;

import android.media.AudioManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

/**
 * Created by Sumir on 27-05-2017.
 */

public class Images {
    private Images() {
    }

    static void createListener(final AudioManager audioManager, final ImageView imageView, final String mode, final SeekBar seekBar) {

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (mode) {
                    case "normal":
                        audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                        seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_RING));
                        break;
                    case "silent":
                        audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                        break;

                    case "vibrate":
                        audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                        seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_RING));
                        break;
                }


            }
        });
    }
}
