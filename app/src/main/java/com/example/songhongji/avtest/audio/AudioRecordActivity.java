package com.example.songhongji.avtest.audio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.songhongji.avtest.R;

public class AudioRecordActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView startAudioRecord;
    private TextView pauseAudioRecord;
    private TextView stopAudioRecord;
    private TextView startAudioPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_record);

        startAudioRecord = (TextView) findViewById(R.id.audio_record_start);
        pauseAudioRecord = (TextView) findViewById(R.id.audio_record_pause);
        stopAudioRecord = (TextView) findViewById(R.id.audio_record_stop);
        startAudioPlay = (TextView) findViewById(R.id.audio_record_play);

        stopAudioRecord.setOnClickListener(this);
        pauseAudioRecord.setOnClickListener(this);
        stopAudioRecord.setOnClickListener(this);
        startAudioPlay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.audio_record_start:

                break;
            case R.id.audio_record_pause:

                break;
            case R.id.audio_record_stop:

                break;
            case R.id.audio_record_play:

                break;
            default:
                break;
        }
    }
}
