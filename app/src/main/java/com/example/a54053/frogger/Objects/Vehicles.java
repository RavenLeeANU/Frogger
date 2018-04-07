package com.example.a54053.frogger.Objects;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 54053 on 2018/4/6.
 */

public class Vehicles {

    List<Vehicle> vehicles = new ArrayList<>();

    Coordinate []generatePoints;

    Random random = new Random();

    public Vehicles(){

        //init start pos
        generatePoints = new Coordinate[4];
        for(int i = 0;i<generatePoints.length;i++){
            if(i%2==0) generatePoints[i] = new Coordinate(-5,i+12);
            else generatePoints[i] = new Coordinate(10,i+12);
        }


    }

    public Vehicle vehicleGenerate(){
        Coordinate pos= generatePoints[random.nextInt(4)];
        int length = (random.nextInt(5)+1);
        Vehicle vehicle = new Vehicle();
        vehicle.setRectLength(length);
        vehicle.setPos(pos);
        return vehicle;
    }

    public void vehicleDestory(){

    }

}
