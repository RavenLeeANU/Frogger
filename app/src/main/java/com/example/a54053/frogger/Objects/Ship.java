package com.example.a54053.frogger.Objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by 54053 on 2018/4/6.
 */

public class Ship  {

    private float length;
    private float width;
    private Coordinate coordinate;
    private Canvas canvas;


    public Ship(Canvas canvas,Coordinate coordinate,float length){
        this.coordinate = coordinate;
        this.canvas = canvas;
        this.length = length;
        this.width = canvas.getWidth()/5;
        onDraw();
    }


    public void onDraw(){
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        this.canvas.drawRect((int)coordinate.getX(),(int)coordinate.getY(),(int)(coordinate.getX()+length),(int)(coordinate.getY()+width),paint);

    }
}
