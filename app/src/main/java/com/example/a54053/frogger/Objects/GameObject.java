package com.example.a54053.frogger.Objects;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.a54053.frogger.Enums.Directions;

/**
 * Created by 54053 on 2018/4/6.
 */

public class GameObject {

    protected Coordinate pos;
    protected int speed;
    protected int length;
    protected int width;
    protected int step;
    protected Directions directions;


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


    public void setRect(int length,int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setStep(int step){
        this.step = step;
    }

    public Coordinate getPos() {
        return pos;
    }

    public int getSpeed() {
        return speed;
    }

    public Directions getDirections() {
        return directions;
    }

    public void resetPos() {
        if(directions == Directions.EAST){
            this.setPos(new Coordinate(-5,this.pos.getY()));
        }else if(directions == Directions.WEST){
            this.setPos(new Coordinate(10,this.pos.getY()));
        }

    }
}
