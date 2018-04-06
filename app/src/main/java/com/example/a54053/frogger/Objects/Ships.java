package com.example.a54053.frogger.Objects;

import android.graphics.Canvas;
import android.util.Log;

import java.util.Random;

/**
 * Created by 54053 on 2018/4/6.
 */

public class Ships {

    Coordinate []generatePoints;
    Canvas canvas;
    Random random = new Random();

    public Ships(Canvas canvas){
        this.canvas = canvas;

        generatePoints = new Coordinate[4];

        for(int i = 0;i<generatePoints.length;i++){

            if(i%2==0) generatePoints[i] = new Coordinate(-this.canvas.getWidth()/5+this.canvas.getWidth()/2,(i+2)*this.canvas.getHeight()/20);
            else generatePoints[i] = new Coordinate(this.canvas.getWidth()-this.canvas.getWidth()/2,(i+2)*this.canvas.getHeight()/20);
            Log.d("negerate",""+generatePoints);
        }

    }

    public void shipGenerate(){
        Coordinate pos= generatePoints[random.nextInt(4)];
        float length = (random.nextInt(5)+1)*canvas.getWidth()/25;
        Log.d("negerate",""+pos);
        Ship ship = new Ship(this.canvas,pos,length);


    }


}
