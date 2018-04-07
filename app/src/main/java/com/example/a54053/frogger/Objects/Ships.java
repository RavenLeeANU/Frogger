package com.example.a54053.frogger.Objects;

import android.graphics.Canvas;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 54053 on 2018/4/6.
 */

public class Ships {

    List<Ship> ships = new ArrayList<>();

    Coordinate []generatePoints;
    Canvas canvas;
    Random random = new Random();

    public Ships(){

        //init start pos
        generatePoints = new Coordinate[4];
        for(int i = 0;i<generatePoints.length;i++){
            if(i%2==0) generatePoints[i] = new Coordinate(-5,i+1);
            else generatePoints[i] = new Coordinate(10,i+1);
        }

    }

    public Ship shipGenerate(){
        Coordinate pos= generatePoints[random.nextInt(4)];
        int length = (random.nextInt(5)+1);
        Ship ship = new Ship();
        ship.setRectLength(length);
        ship.setPos(pos);
        return ship;
    }

    public void shipDestory(){

    }



}
