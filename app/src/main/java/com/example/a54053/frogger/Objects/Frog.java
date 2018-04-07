package com.example.a54053.frogger.Objects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.example.a54053.frogger.Enums.Directions;

import static java.lang.Math.min;

/**
 * Created by 54053 on 2018/4/6.
 */

public class Frog extends GameObject implements View.OnTouchListener{

    public Frog() {
        super();

    }

    @Override
    public void onDraw(Canvas canvas){

        float positionX =pos.getX() * canvas.getWidth()/10;
        float positionY =pos.getY() * canvas.getHeight()/20;
        float radiate = Math.min(canvas.getWidth()/10,canvas.getHeight()/20) /2;

        Paint paint = new Paint();
        paint.setColor(Color.RED);

        canvas.drawCircle(positionX+canvas.getWidth()/20,positionY+canvas.getHeight()/40,radiate,paint);
    }
    float prevX;
    float prevY;
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {


        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                prevX = motionEvent.getX();
                prevY = motionEvent.getY();
                break;
            case MotionEvent.ACTION_UP:

                float newX = motionEvent.getX();
                float newY = motionEvent.getY();

                if(Math.abs(newX - prevX)>Math.abs(newY -prevY)){
                    if(newX >prevX){
                        this.directions = Directions.EAST;
                        if(this.pos.getX()<10)
                        this.setPos(new Coordinate(this.pos.getX()+1,this.pos.getY()));
                    }else {
                        this.directions = Directions.WEST;
                        if(this.pos.getX()>0)
                        this.setPos(new Coordinate(this.pos.getX()-1,this.pos.getY()));
                    }
                }else {
                    if(newY <prevY){
                        this.directions = Directions.NORTH;
                        if(this.pos.getY()>1)
                        this.setPos(new Coordinate(this.pos.getX(),this.pos.getY()-1));
                    }
                }
                break;
        }

        return true;
    }
}
