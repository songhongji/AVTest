package com.example.songhongji.avtest.audio;

import android.media.AudioRecord;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.songhongji.avtest.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AudioRecordActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView startAudioRecord;
    private TextView pauseAudioRecord;
    private TextView stopAudioRecord;
    private TextView startAudioPlay;
    private AudioRecorder audioRecorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_record);

        audioRecorder = AudioRecorder.getInstance();
        startAudioRecord = (TextView) findViewById(R.id.audio_record_start);
        pauseAudioRecord = (TextView) findViewById(R.id.audio_record_pause);
        stopAudioRecord = (TextView) findViewById(R.id.audio_record_stop);
        startAudioPlay = (TextView) findViewById(R.id.audio_record_play);

        startAudioRecord.setOnClickListener(this);
        pauseAudioRecord.setOnClickListener(this);
        stopAudioRecord.setOnClickListener(this);
        startAudioPlay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.audio_record_start:
                if (audioRecorder.getStatus() == AudioRecorder.Status.STATUS_NO_READY) {
                    //初始化录音
                    String fileName = new SimpleDateFormat("yyyyMMddhhmmss", Locale.CHINA).format(new Date());
                    audioRecorder.createDefaultAudio(fileName);
                    audioRecorder.startRecord(null);
                    Toast.makeText(this, "开始录音", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "已经开始录音", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.audio_record_pause:
                if (audioRecorder.getStatus() == AudioRecorder.Status.STATUS_START) {
                    audioRecorder.pauseRecord();
                    Toast.makeText(this, "暂停录音", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "未开始录音", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.audio_record_stop:
                if (audioRecorder.getStatus() == AudioRecorder.Status.STATUS_START || audioRecorder.getStatus() == AudioRecorder.Status.STATUS_PAUSE) {
                    audioRecorder.stopRecord();
                    Toast.makeText(this, "停止录音", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "未开始录音", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.audio_record_play:

                break;
            default:
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (audioRecorder.getStatus() == AudioRecorder.Status.STATUS_START) {
            audioRecorder.pauseRecord();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (audioRecorder != null) {
            audioRecorder.release();
        }
    }
}
