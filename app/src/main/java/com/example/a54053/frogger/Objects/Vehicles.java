package com.example.a54053.frogger.Objects;

import android.graphics.Canvas;

import com.example.a54053.frogger.Enums.Directions;

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
        generatePoints = new Coordinate[8];
        for(int i = 0;i<generatePoints.length;i++){
            generatePoints[i] = new Coordinate(-5 + random.nextInt(15),i+10);
        }


    }

    public Vehicle vehicleGenerate(){
        Coordinate pos= generatePoints[random.nextInt(8)];
        int length = (random.nextInt(5)+1);
        Vehicle vehicle = new Vehicle();
        vehicle.setRect(length,1);
        vehicle.setPos(pos);
        return vehicle;
    }

    public Vehicle[] vehicleGenerateGroup(){
        Vehicle vehicle[]= new Vehicle[8];

        for(int i = 0; i<vehicle.length;i++){
            vehicle[i] = new Vehicle();
            int rectLength = random.nextInt(3)+1;
            int speed = random.nextInt(2)+1;
            vehicle[i].setRect(rectLength,1);
            vehicle[i].setPos(generatePoints[i]);
            vehicle[i].speed = speed;
            if(i%2==0) vehicle[i].directions = Directions.EAST;
            else vehicle[i].directions = Directions.WEST;
        }

        return vehicle;
    }



}
