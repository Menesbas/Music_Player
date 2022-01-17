package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {
    private Button btnPlay, btnPause, btnStop;
    private MediaPlayer myMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        myMediaPlayer= MediaPlayer.create(this,R.raw.music);
        btnPlay = (Button) findViewById(R.id.button6);
        btnPause = (Button) findViewById(R.id.button5);
        btnStop = (Button) findViewById(R.id.button4);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!myMediaPlayer.isPlaying()){
                    myMediaPlayer.start();
                    Log.d("My Debug", "Media player playing");
                }

            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myMediaPlayer.isPlaying()){
                    myMediaPlayer.pause();
                    Log.d("My Debug", "Media player paused");
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myMediaPlayer.isPlaying()){
                    myMediaPlayer.stop();
                    Log.d("My Debug", "Media player stopped");
                }
            }
        });

    }

    private void getReady(){
        try{
            myMediaPlayer.prepare();
            Log.d("My debug","Media Player prepared");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
