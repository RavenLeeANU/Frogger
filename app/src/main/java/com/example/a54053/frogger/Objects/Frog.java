package com.example.a54053.frogger.Objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by 54053 on 2018/4/6.
 */

public class Frog extends GameObject {
    
    float radiate;
    
    
    public Frog(Canvas canvas,int posX, int posY) {
        super(canvas,posX, posY);
        onDraw();
    }

    @Override
    public void onDraw(){
        radiate = this.canvas.getHeight()/(20*2);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        this.canvas.drawCircle(posX,posY,radiate,paint);
    }
}
