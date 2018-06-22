package com.example.songhongji.avtest.video;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.songhongji.avtest.R;

public class CameraPreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_preview);
        if (null == savedInstanceState) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, Camera2BasicFragment.newInstance()).commit();
        }
    }
}
