package com.example.songhongji.avtest.picture;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.songhongji.avtest.R;

public class PictureActivity extends AppCompatActivity {

    private LinearLayout rootView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        rootView = (LinearLayout) findViewById(R.id.root_fl);

        addImageView();
        addSurfaceView();
        addCustomView();
        addCustomTxtView();
    }

    private void addImageView() {
        ImageView imageView = new ImageView(this);
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.test_img);
        imageView.setImageBitmap(bitmap);
        rootView.addView(imageView);
    }

    private void addSurfaceView() {
        SurfaceView surfaceView = new SurfaceView(this);
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if (holder == null) {
                    return;
                }

                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.STROKE);
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test_img);
                Canvas canvas = holder.lockCanvas();
                canvas.drawBitmap(bitmap, 0, 0, paint);
                holder.unlockCanvasAndPost(canvas);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });

        rootView.addView(surfaceView, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 200));
    }

    private void addCustomView() {
        CustomPicView customPicView = new CustomPicView(this);
        rootView.addView(customPicView);
    }

    private void addCustomTxtView() {
        CustomTxtView customTxtView = new CustomTxtView(this);
        rootView.addView(customTxtView);
    }

}


