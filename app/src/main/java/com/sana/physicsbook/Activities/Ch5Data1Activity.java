package com.sana.physicsbook.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.text.LineBreaker;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.sana.physicsbook.R;

import java.util.Locale;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class Ch5Data1Activity extends AppCompatActivity {

    TextView ch5Data1DetailTv;
    private TextToSpeech mTTS;
    ImageButton ch5Data1PlayBtn, ch5Data1PauseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch5_data1);

        ch5Data1PlayBtn = findViewById(R.id.ch5Data1playBtnId);
        ch5Data1PauseBtn = findViewById(R.id.ch5Data1pauseBtnId);
        ch5Data1DetailTv = findViewById(R.id.ch5Data1DetailId);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            ch5Data1DetailTv.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }

        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(Locale.ENGLISH);
                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        ch5Data1PlayBtn.setSaveEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }


        });

        ch5Data1PlayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
                ch5Data1PauseBtn.setVisibility(View.VISIBLE);
                ch5Data1PlayBtn.setVisibility(View.INVISIBLE);
            }
        });

        ch5Data1PauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTTS.stop();
                ch5Data1PauseBtn.setVisibility(View.INVISIBLE);
                ch5Data1PlayBtn.setVisibility(View.VISIBLE);
            }
        });

    }

    private void speak() {

        String text = ch5Data1DetailTv.getText().toString();
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    protected void onDestroy() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }
        super.onDestroy();
    }


}