package com.example.songhongji.avtest.picture;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.songhongji.avtest.R;

public class CustomTxtView extends View {
    private Shader shader;
    private Paint paint;
    public CustomTxtView(Context context) {
        this(context, null);
    }

    public CustomTxtView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTxtView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        shader = new LinearGradient(100, 100, 500, 500, Color.BLUE, Color.BLACK, Shader.TileMode.CLAMP);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setShader(shader);
        canvas.drawCircle(300, 300, 200, paint);

        // 直接设置颜色
        paint.setColor(Color.RED);
        paint.setColor(Color.RED);
        paint.setARGB(0, 0, 0, 0);

        //【设置Shader】着色器
        // LinearGradient 线性渐变
        // LinearGradient(float x0, float y0, float x1, float y1, int color0, int color1, Shader.TileMode tile)
//        Shader shader = new LinearGradient(0, 0, 500, 500, Color.RED, Color.BLACK, Shader.TileMode.CLAMP);
//        paint.setShader(shader);
//        canvas.drawCircle(300, 300, 200, paint);

        //【RadialGradient】辐射渐变
        // RadialGradient(float centerX, float centerY, float radius, int centerColor, int edgeColor, TileMode tileMode)
//        Shader shader = new RadialGradient(300, 300, 200, Color.RED, Color.BLACK, Shader.TileMode.CLAMP);
//        paint.setShader(shader);
//        canvas.drawCircle(300, 300, 200, paint);


        //【SweepGradient】扫描渐变
        // SweepGradient(float cx, float cy, int color0, int color1)
//        Shader shader = new SweepGradient(300, 300, Color.RED, Color.BLUE);
//        paint.setShader(shader);
//        canvas.drawCircle(300, 300, 200, paint);

        //【BitmapShader】
        // BitmapShader(Bitmap bitmap, Shader.TileMode tileX, Shader.TileMode tileY)
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test_img);
//        Shader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
//        paint.setShader(shader);
//        canvas.drawCircle(300, 300, 200, paint);

        //【ComposeShader】混合着色器
        // ComposeShader(Shader shaderA, Shader shaderB, PorterDuff.Mode mode)
//        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.test_img);
//        Shader shader1 = new BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
//
//        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.test_img2);
//        Shader shader2 = new BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
//
//        // ComposeShader：结合两个 Shader
//        Shader shader = new ComposeShader(shader1, shader2, PorterDuff.Mode.SRC_OVER);
//        paint.setShader(shader);
//        canvas.drawCircle(300, 300, 300, paint);



    }
}
