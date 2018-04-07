package com.example.a54053.frogger.Objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by 54053 on 2018/4/6.
 */

public class Ship extends GameObject {

    public Ship(){
        super();

    }

    public void shipReset(){

    }

    @Override
    public void onDraw(Canvas canvas){

        int positionX = (int)(pos.getX()* canvas.getWidth()/10);
        int positionY = (int)(pos.getY()* canvas.getHeight()/20);


        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        canvas.drawRect(positionX,positionY,positionX+length*canvas.getWidth()/10,positionY+width*canvas.getHeight()/20,paint);

    }
}
