package com.example.mysoundboard;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import java.io.IOException;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {
    // Sounds from: https://www.pacdv.com/sounds/people_sounds.html
    public static final int REQUEST_AUDIO_PERMISSION_CODE = 1;
    private static final String LOG_TAG = "AudioRecording";

    private boolean recording = false;

    private int[] mpr; // Stores player states,
    private MediaPlayer[] mPlayer;
    private MediaRecorder[] mRecorder;
    private Button[] btn;

    private static String mFilePath = null;
    private String[] mFileName = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Show the icon on the AppBar
        ActionBar actionBar= getSupportActionBar();
        actionBar.setIcon(R.drawable.ic_dots);
        actionBar.setDisplayShowHomeEnabled(true);

        // Set up the arrays
        mpr = new int[13]; // State: 0 Ready to record(empty) -- 1 Recording -- 2 Ready to play/re-record -- 3 Playing
        mRecorder = new MediaRecorder[13];
        mPlayer = new MediaPlayer[13];
        btn = new Button[13];

        // Initialize all the possible recorders and players and set the states to Ready to record(empty)
        for (int i = 0; i < 13; i++) {
            mpr[i] = 0;
            mPlayer[i] = new MediaPlayer();
            mPlayer[i] = null;
        }

        // Set the pre-recorded buttons to ready state
        for (int i = 0; i < 4; i++) {
            mpr[i] = 2;
        }

        // Find the buttons and load into array
        btn[1] = findViewById(R.id.button1);
        btn[2] = findViewById(R.id.button2);
        btn[3] = findViewById(R.id.button3);
        btn[4] = findViewById(R.id.button4);
        btn[5] = findViewById(R.id.button5);
        btn[6] = findViewById(R.id.button6);
        btn[7] = findViewById(R.id.button7);
        btn[8] = findViewById(R.id.button8);
        btn[9] = findViewById(R.id.button9);
        btn[10] = findViewById(R.id.button10);
        btn[11] = findViewById(R.id.button11);
        btn[12] = findViewById(R.id.button12);

        // Preset sound button color to playable
        btn[1].setBackgroundColor(getResources().getColor(R.color.button_resting_color));
        btn[2].setBackgroundColor(getResources().getColor(R.color.button_resting_color));
        btn[3].setBackgroundColor(getResources().getColor(R.color.button_resting_color));

        // Set up file directory for recording
        mFilePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        mFileName = new String[13];

        // Long press listeners for the recording buttons
        btn[4].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longPress(4, btn[4]);
                return true;
            }
        });
        btn[5].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longPress(5, btn[5]);
                return true;
            }
        });
        btn[6].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longPress(6, btn[6]);
                return true;
            }
        });
        btn[7].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longPress(7, btn[7]);
                return true;
            }
        });
        btn[8].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longPress(8, btn[8]);
                return true;
            }
        });
        btn[9].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longPress(9, btn[9]);
                return true;
            }
        });
        btn[10].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longPress(10, btn[10]);
                return true;
            }
        });
        btn[11].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longPress(11, btn[11]);
                return true;
            }
        });
        btn[12].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longPress(12, btn[12]);
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



    // Pre-Recorded Buttons
    public void pressedButton1 (View v) {
        //for preloaded sounds
        pressPreSelectedSound(1,R.raw.crowd);
    }

    public void pressedButton2 (View v) {
        //for preloaded sounds
        pressPreSelectedSound(2,R.raw.laugh_2);
    }

    public void pressedButton3 (View v) {
        //for preloaded sounds
        pressPreSelectedSound(3,R.raw.clearing_throat_3);
    }




    // Recordable Buttons
    public void pressedButton4 (View v) {
        shortPress(4);
    }

    public void pressedButton5 (View v) {
        shortPress(5);
    }

    public void pressedButton6 (View v) {
        shortPress(6);
    }

    public void pressedButton7 (View v) {
        shortPress(7);
    }

    public void pressedButton8 (View v) {
        shortPress(8);
    }

    public void pressedButton9 (View v) {
        shortPress(9);
    }

    public void pressedButton10 (View v) {
        shortPress(10);
    }

    public void pressedButton11 (View v) {
        shortPress(11);
    }

    public void pressedButton12 (View v) {
        shortPress(12);
    }



    public void pressPreSelectedSound (int buttonNumber, int sound) {
        // Check State: 0 Ready to record(empty) -- 1 Recording -- 2 Ready to play/re-record -- 3 Playing
        switch (mpr[buttonNumber]) {
            case 2:
                // State: Ready to play
                mPlayer[buttonNumber] = MediaPlayer.create(this, sound);
                mPlayer[buttonNumber].setLooping(false);
                mPlayer[buttonNumber].seekTo(0);
                mPlayer[buttonNumber].setVolume(0.5f, 0.5f);
                mPlayer[buttonNumber].start();
                mpr[buttonNumber] = 3; // Playing
                btn[buttonNumber].setBackgroundColor(getResources().getColor(R.color.button_active_color));

                mPlayer[buttonNumber].setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mPlayer) {
                        mPlayer.release();
                        btn[buttonNumber].setBackgroundColor(getResources().getColor(R.color.button_resting_color));
                        mpr[buttonNumber] = 2; // Ready to play
                    }
                });
                break;
            case 3:
                // State: Playing
                mPlayer[buttonNumber].release();
                //btn[buttonNumber].setText(getResources().getText(R.string.buttonReadyToPlay));
                btn[buttonNumber].setBackgroundColor(getResources().getColor(R.color.button_resting_color));
                mpr[buttonNumber] = 2; // Ready to play/re-record
                break;
            default:
        }
    }

    public void shortPress (int buttonNumber) {
        // Check State: 0 Ready to record(empty) -- 1 Recording -- 2 Ready to play/re-record -- 3 Playing
        switch (mpr[buttonNumber]) {
            case 1:
                // State: Recording
                mpr[buttonNumber] = 2; // Ready to play/re-record
                btn[buttonNumber].setText(getResources().getText(R.string.buttonReadyToPlay));
                btn[buttonNumber].setBackgroundColor(getResources().getColor(R.color.button_resting_color));
                mRecorder[buttonNumber].stop();
                mRecorder[buttonNumber].release();
                mRecorder[buttonNumber] = null;
                recording = false; // Allow another recording
                break;

            case 2:
                // State: Ready to play/re-record
                mpr[buttonNumber] = 3; // Playing
                btn[buttonNumber].setText(getResources().getText(R.string.buttonPlaying));
                btn[buttonNumber].setBackgroundColor(getResources().getColor(R.color.button_active_color));

                if (mPlayer[buttonNumber] != null) {
                    mPlayer[buttonNumber].release();
                    mPlayer[buttonNumber] = null;
                }
                mPlayer[buttonNumber] = new MediaPlayer();
                try {
                    mPlayer[buttonNumber].setDataSource(mFileName[buttonNumber]);
                    mPlayer[buttonNumber].prepare();
                    mPlayer[buttonNumber].start();
                } catch (IOException e) {
                    e.printStackTrace();
                    mPlayer[buttonNumber].release();
                    mPlayer[buttonNumber] = null;
                }

                mPlayer[buttonNumber].setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mPlayer) {
                        mPlayer.release();
                        btn[buttonNumber].setText(getResources().getText(R.string.buttonReadyToPlay));
                        btn[buttonNumber].setBackgroundColor(getResources().getColor(R.color.button_resting_color));
                        mpr[buttonNumber] = 2; // Ready to play/re-record
                    }
                });
                break;
            case 3:
                // State: Playing
                mPlayer[buttonNumber].release();
                btn[buttonNumber].setText(getResources().getText(R.string.buttonReadyToPlay));
                btn[buttonNumber].setBackgroundColor(getResources().getColor(R.color.button_resting_color));
                mpr[buttonNumber] = 2; // Ready to play/re-record
                break;
            default:
        }
    }

    public void longPress(int soundNumber, Button btn) {

        // Check State: 0 Ready to record(empty) -- 1 Recording -- 2 Ready to play/re-record -- 3 Playing
        switch (mpr[soundNumber]) {
            case 0:
                // State: Ready to record(empty)
                if (!recording) {
                    recording = true; // prevent double recording
                    mpr[soundNumber] = 1;
                    mFileName[soundNumber] = mFilePath + "/Recording" + soundNumber + ".3gp";
                    if (CheckPermissions()) {

                        mRecorder[soundNumber] = new MediaRecorder();
                        mRecorder[soundNumber].setAudioSource(MediaRecorder.AudioSource.MIC);
                        mRecorder[soundNumber].setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                        mRecorder[soundNumber].setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                        mRecorder[soundNumber].setOutputFile(mFileName[soundNumber]);
                        try {
                            mRecorder[soundNumber].prepare();
                        } catch (IOException e) {
                            Log.e(LOG_TAG, "prepare() failed");
                        }
                        btn.setText(getResources().getText(R.string.buttonRecording));
                        btn.setBackgroundColor(getResources().getColor(R.color.button_recording_color));
                        mRecorder[soundNumber].start();
                    } else {
                        RequestPermissions();
                    }
                }
                break;
            case 2:
                // State: 0 Ready to record(empty) -- 1 Recording -- 2 Ready to play/re-record -- 3 Playing
                mpr[soundNumber] = 0;
                mFileName[soundNumber] = null;
                btn.setText(getResources().getText(R.string.blankButton));
                btn.setBackgroundColor(getResources().getColor(R.color.button_empty_color));
                break;
            default:
        }
    }



}