package com.example.songhongji.avtest.picture;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class PictureSurfaceView extends SurfaceView implements SurfaceHolder.Callback{
    public PictureSurfaceView(Context context) {
        super(context);
    }

    public PictureSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PictureSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
