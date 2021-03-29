package com.example.mysoundboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class recordingActivity extends AppCompatActivity{

    public int recordingNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording);

        //String buttonVariable = getIntent().getStringExtra("EXTRA_BUTTON_NAME");
        recordingNumber = Integer.getInteger(getIntent().getStringExtra("EXTRA_RECORDING_NUMBER"));

        //TextView txt1 = findViewById(R.id.textView1);
        TextView txt2 = findViewById(R.id.textView2);

        //txt1.setText(buttonVariable);


        //Button thisbutton = findViewById(Integer.parseInt(buttonVariable));

        saveButtonPressed();

    }






    public static String getMyString(){

        return "Purple";
    }

    private void saveButtonPressed(){
        //super.buttonNames[recordingNumber] = "purple";
        //super.buttonNames[6] = "purple";
        //MainActivity.setButtonNames( "purple", recordingNumber);

    }





}