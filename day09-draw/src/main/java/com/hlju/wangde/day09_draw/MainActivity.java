package com.hlju.wangde.day09_draw;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private int startX;
    private int startY;
    private Bitmap bmSrc;
    private Paint paint;
    private Canvas canvas;
    private ImageView iv;
    private Bitmap bmCopy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bmSrc = BitmapFactory.decodeResource(getResources(), R.drawable.bb);

        bmCopy = Bitmap.createBitmap(bmSrc.getWidth(), bmSrc.getHeight(), bmSrc.getConfig());

        paint = new Paint();

        canvas = new Canvas(bmCopy);
        canvas.drawBitmap(bmSrc, new Matrix(), paint);


        iv = (ImageView) findViewById(R.id.imageView);
        iv.setImageBitmap(bmCopy);
        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //触摸事件中包含手指触摸坐标
                        startX = (int) event.getX();
                        startY = (int) event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int newX = (int) event.getX();
                        int newY = (int) event.getY();
                        canvas.drawLine(startX, startY, newX, newY, paint);
                        iv.setImageBitmap(bmCopy);
                        startX = newX;
                        startY = newY;
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return true;
            }
        });
    }
}
