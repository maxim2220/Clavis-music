package com.ClaVis.clavis;

import android.content.Context;
import android.media.MediaPlayer;

public class PlayerSetMusic {
    public synchronized static MediaPlayer setMusic(Context context, Integer ind){
        MediaPlayer player = new MediaPlayer();;
        switch (ind){
            case R.id.bt1:
                player = MediaPlayer.create(context, R.raw.daaaaaaa);
                break;
            case R.id.bt2:
                player = MediaPlayer.create(context, R.raw.re);
                break;
            case R.id.bt3:
                player = MediaPlayer.create(context, R.raw.mi);
                break;
            case R.id.bt4:
                player = MediaPlayer.create(context, R.raw.fa);
                break;
            case R.id.bt5:
                player = MediaPlayer.create(context, R.raw.sol);
                break;
            case R.id.bt6:
                player = MediaPlayer.create(context, R.raw.lja);
                break;
            case R.id.bt7:
                player = MediaPlayer.create(context, R.raw.si);
                break;
        }
        return player;

    }
}
