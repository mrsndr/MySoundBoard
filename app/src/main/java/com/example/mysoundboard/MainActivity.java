package com.example.mysoundboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Bundle;


import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {
    // Sounds from: https://www.pacdv.com/sounds/people_sounds.html
    public static final int REQUEST_AUDIO_PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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




}