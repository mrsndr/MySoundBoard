package com.example.mysoundboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {
    // Sounds from: https://www.pacdv.com/sounds/people_sounds.html
    public static final int REQUEST_AUDIO_PERMISSION_CODE = 1;

    public Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    boolean mpr1, mpr2, mpr3, mpr4, mpr5, mpr6, mpr7, mpr8, mpr9; // Stores player ready states
    MediaPlayer mp1, mp2, mp3, mp4, mp5, mp6, mp7, mp8, mp9;
    String[] soundToPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the buttons
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);

        mpr1 = mpr2 = mpr3 = mpr4 = mpr5 = mpr6 = mpr7 = mpr8 = mpr9 = true; // Set playback to the ready state


        mp4 = new MediaPlayer(); mp5 = new MediaPlayer(); mp6 = new MediaPlayer();
        //getPlayerReady(mp4,R.raw.come_on); getPlayerReady(mp5,R.raw.come_on); getPlayerReady(mp6,R.raw.come_on);

        soundToPlay = new String[10];
        //soundToPlay[4] = R.raw.come_on; soundToPlay[5] = R.raw.come_on; soundToPlay[6] = R.raw.come_on;


        btn5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (soundToPlay[5] != "") {
                    btn5.setText(R.string.blankButton);
                    soundToPlay[5] = "";
                }
                return true;
            }
        });



    }

    public boolean CheckPermissions() {
        int resultExternalStorage = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int resultRecordAudio = ContextCompat.checkSelfPermission(getApplicationContext(), RECORD_AUDIO);
        return ( resultExternalStorage == PackageManager.PERMISSION_GRANTED &&
                resultRecordAudio == PackageManager.PERMISSION_GRANTED );
    }

    public void RequestPermissions() {
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{RECORD_AUDIO, WRITE_EXTERNAL_STORAGE},
                REQUEST_AUDIO_PERMISSION_CODE);
    }




    public void pressedButton1 (View v) {
        //for preloaded sounds
        if (mpr1) {
            MediaPlayer mPlayer = new MediaPlayer();
                mPlayer = MediaPlayer.create(this, R.raw.crowd);
                mPlayer.setLooping(false);
                mPlayer.seekTo(0);
                mPlayer.setVolume(0.5f, 0.5f);
            mPlayer.start();
            mpr1 = false; // Set to the not ready state
            btn1.setBackgroundColor(getResources().getColor(R.color.button_active_color));

            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mPlayer) {
                    mPlayer.release();
                    btn1.setBackgroundColor(getResources().getColor(R.color.button_resting_color));
                    mpr1 = true; // Set to the ready state
                }
            });
        }
    }

    public void pressedButton2 (View v) {
        //for preloaded sounds
        if (mpr2) {
            MediaPlayer mPlayer = new MediaPlayer();
                mPlayer = MediaPlayer.create(this, R.raw.laugh_2);
                mPlayer.setLooping(false);
                mPlayer.seekTo(0);
                mPlayer.setVolume(0.5f, 0.5f);
            mPlayer.start();
            mpr2 = false;
            btn2.setBackgroundColor(getResources().getColor(R.color.button_active_color));

            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mPlayer) {
                    mPlayer.release();
                    btn2.setBackgroundColor(getResources().getColor(R.color.button_resting_color));
                    mpr2 = true;
                }
            });
        }
    }

    public void pressedButton3 (View v) {
        //for preloaded sounds
        if (mpr3) {
            MediaPlayer mPlayer = new MediaPlayer();
            mPlayer = MediaPlayer.create(this, R.raw.clearing_throat_3);
            mPlayer.setLooping(false);
            mPlayer.seekTo(0);
            mPlayer.setVolume(0.5f, 0.5f);
            mPlayer.start();
            mpr3 = false;
            btn3.setBackgroundColor(getResources().getColor(R.color.button_active_color));

            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mPlayer) {
                    mPlayer.release();
                    btn3.setBackgroundColor(getResources().getColor(R.color.button_resting_color));
                    mpr3 = true;
                }
            });
        }
    }

    public void pressedButton4 (View v) {
        // Check if a sound has been assigned
        if (soundToPlay[4] != "") {
            // Check if the player is ready
            if (mpr4) {


            }
        }
    }

    public void pressedButton5 (View v) {





        // Check if the player is ready
        if (mpr5) {



        }


    }









}