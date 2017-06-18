package com.hlju.wangde.day09_createcopy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bitmap bmSrc = BitmapFactory.decodeResource(getResources(), R.drawable.xydt1111);
        //创建副本
        //创建了一个与原图一抹一样大小的bitmap对象，没有内容
        Bitmap bmCopy = Bitmap.createBitmap(bmSrc.getWidth(), bmSrc.getHeight(), bmSrc.getConfig());
        Paint paint = new Paint();
        Canvas canvas = new Canvas(bmCopy);
        canvas.drawBitmap(bmSrc, new Matrix(), paint);
        ImageView iv_src = (ImageView) findViewById(R.id.iv_src);
        iv_src.setImageBitmap(bmSrc);
        ImageView iv_copy = (ImageView) findViewById(R.id.iv_copy);
        iv_copy.setImageBitmap(bmCopy);


    }
}
