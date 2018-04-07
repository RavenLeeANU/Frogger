package com.example.a54053.frogger.Objects;

import android.graphics.Canvas;
import android.util.Log;

import com.example.a54053.frogger.Enums.Directions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 54053 on 2018/4/6.
 */

public class Ships {

    List<Ship> ships = new ArrayList<>();

    Coordinate []generatePoints;
    int []speedManager;
    Random random = new Random();

    public Ships(){

        //init start pos
        generatePoints = new Coordinate[8];
        for(int i = 0;i<generatePoints.length;i++){
            //random generate
            generatePoints[i] = new Coordinate(-5 + random.nextInt(15),i+2);
        }

    }

    public Ship shipGenerate(){
        Coordinate pos= generatePoints[random.nextInt(6)];
        int length = (random.nextInt(5)+1);
        Ship ship = new Ship();
        ship.setRect(length,1);
        ship.setPos(pos);
        return ship;
    }

    public Ship[] shipGenerateGroup(){
        Ship ship[]= new Ship[6];
        // set ships
        for(int i = 0; i<ship.length;i++){
            ship[i] = new Ship();
            int rectLength = random.nextInt(3)+1;
            int speed = random.nextInt(2)+1;
            ship[i].setRect(rectLength,1);
            ship[i].setPos(generatePoints[i]);
            ship[i].speed = speed;
            if(i%2==0)ship[i].directions = Directions.EAST;
            else ship[i].directions = Directions.WEST;
        }
        return ship;
    }






}
