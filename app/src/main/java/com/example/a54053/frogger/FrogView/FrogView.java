package com.example.a54053.frogger.FrogView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.a54053.frogger.Objects.Coordinate;
import com.example.a54053.frogger.Objects.Frog;
import com.example.a54053.frogger.Objects.Ship;
import com.example.a54053.frogger.Objects.Ships;

/**
 * Created by 54053 on 2018/4/6.
 */


//
public class FrogView extends View{

    private Paint mPaint = new Paint();
    private float canvasWidth ;
    private float canvasHeight ;



    public FrogView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

        this.drawBackground(canvas,mPaint);
        this.drawShips(canvas,mPaint);
        this.drawVehicles(canvas,mPaint);
        this.drawFrog(canvas,mPaint);


    }

    private void drawShips(Canvas canvas, Paint mPaint) {
        Ships ships = new Ships(canvas);
        ships.shipGenerate();
        Ship ship = new Ship(canvas,new Coordinate(canvas.getWidth()/2,canvas.getHeight()/2),canvas.getWidth()/5);
    }

    private void drawVehicles(Canvas canvas, Paint mPaint) {


    }

    private void drawFrog(Canvas canvas,Paint mPaint){
        Frog frog = new Frog(canvas,(int)canvasWidth/2,(int)canvasHeight/2);

    }

    private void drawBackground(Canvas canvas,Paint mPaint) {
        //draw blocks
        float desBot = canvasHeight/ 10;
        float riverBot = 4* canvasHeight/10;
        float midBot = 5* canvasHeight/10;
        float roadBot = 8 * canvasHeight/10;

        mPaint.setColor(Color.GRAY);
        Rect des = new Rect(0,0,(int)canvasWidth,(int)desBot);
        canvas.drawRect(des,mPaint);

        mPaint.setColor(Color.BLUE);
        Rect river = new Rect(0,(int)desBot,(int)canvasWidth,(int)riverBot);
        canvas.drawRect(river,mPaint);

        mPaint.setColor(Color.GRAY);
        Rect mid = new Rect(0,(int)riverBot,(int)canvasWidth,(int)midBot);
        canvas.drawRect(mid,mPaint);

        mPaint.setColor(Color.GREEN);
        Rect road = new Rect(0,(int)midBot,(int)canvasWidth,(int)roadBot);
        canvas.drawRect(road,mPaint);

        mPaint.setColor(Color.GRAY);
        Rect start = new Rect(0,(int)roadBot,(int)canvasWidth,(int)canvasHeight);
        canvas.drawRect(start,mPaint);

    }
}
