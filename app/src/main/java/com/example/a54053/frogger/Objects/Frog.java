package com.example.a54053.frogger.Objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import static java.lang.Math.min;

/**
 * Created by 54053 on 2018/4/6.
 */

public class Frog extends GameObject {

    public Frog() {
        super();

    }

    @Override
    public void onDraw(Canvas canvas){

        float positionX =pos.getX() * canvas.getWidth()/10;
        float positionY =pos.getY() * canvas.getHeight()/20;
        float radiate = Math.min(canvas.getWidth()/10,canvas.getWidth()/10) /2;

        Paint paint = new Paint();
        paint.setColor(Color.RED);

        canvas.drawCircle(positionX-canvas.getWidth()/20,positionY-canvas.getHeight()/40,radiate,paint);
    }
}
