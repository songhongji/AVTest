package com.example.songhongji.avtest.audio;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
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
    private AudioHelper audioHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_record);

        audioHelper = AudioHelper.getInstance();
        startAudioRecord = (TextView) findViewById(R.id.audio_record_start);
        pauseAudioRecord = (TextView) findViewById(R.id.audio_record_pause);
        stopAudioRecord = (TextView) findViewById(R.id.audio_record_stop);
        startAudioPlay = (TextView) findViewById(R.id.audio_record_play);

        startAudioRecord.setText("开始录音");
        pauseAudioRecord.setText("暂停录音");
        stopAudioRecord.setText("停止录音");
        startAudioPlay.setText("开始播放");

        startAudioRecord.setOnClickListener(this);
        pauseAudioRecord.setOnClickListener(this);
        stopAudioRecord.setOnClickListener(this);
        startAudioPlay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.audio_record_start:

                if (audioHelper.getStatus() == AudioHelper.Status.STATUS_NO_READY) {
                    //初始化录音
                    String fileName = new SimpleDateFormat("yyyyMMddhhmmss", Locale.CHINA).format(new Date());
                    audioHelper.createDefaultAudio("test");
                    audioHelper.startRecord(null);
                    Toast.makeText(this, "开始录音", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "已经开始录音", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.audio_record_pause:
                if (audioHelper.getStatus() == AudioHelper.Status.STATUS_START) {
                    audioHelper.pauseRecord();
                    Toast.makeText(this, "暂停录音", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "未开始录音", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.audio_record_stop:
                if (audioHelper.getStatus() == AudioHelper.Status.STATUS_START || audioHelper.getStatus() == AudioHelper.Status.STATUS_PAUSE) {
                    audioHelper.stopRecord();
                    Toast.makeText(this, "停止录音", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "未开始录音", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.audio_record_play:
                audioHelper.startPlay();
                Toast.makeText(this, "开始播放", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (audioHelper.getStatus() == AudioHelper.Status.STATUS_START) {
            audioHelper.pauseRecord();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (audioHelper != null) {
            audioHelper.release();
        }
    }
}
