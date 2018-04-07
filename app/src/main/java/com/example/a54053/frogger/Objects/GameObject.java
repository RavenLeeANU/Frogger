package com.example.a54053.frogger.Objects;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by 54053 on 2018/4/6.
 */

public class GameObject {

    protected Coordinate pos;
    protected int speed;
    protected int length;
    protected int width;
    protected int step;



    public GameObject(){

    }

    public void setPos(Coordinate pos) {
        this.pos = pos;

    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public void onDraw(Canvas canvas){
    }


    public void setRectLength(int length) {
        this.length = length;
    }

    public void setStep(int step){
        this.step = step;
    }
}
