package com.example.a54053.frogger.GameEngine;

import android.graphics.Canvas;

import com.example.a54053.frogger.Objects.Coordinate;
import com.example.a54053.frogger.Objects.Frog;
import com.example.a54053.frogger.Objects.GameObject;
import com.example.a54053.frogger.Objects.Ship;
import com.example.a54053.frogger.Objects.Ships;
import com.example.a54053.frogger.Objects.Vehicle;
import com.example.a54053.frogger.Objects.Vehicles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 54053 on 2018/4/6.
 */

public class GameEngine {
    private List<GameObject> gameObjects = new ArrayList<>();
    private static final int GAMEWIDTH =10;
    private static final int GAMEHEIGHT =20;
    private Frog frog;


    public void init(){
        frog = new Frog();
        frog.setPos(new Coordinate(0,0));
        Ships ships = new Ships();
        gameObjects.add(ships.shipGenerate());

        Vehicles vehicles = new Vehicles();
        gameObjects.add(vehicles.vehicleGenerate());

    }

    public void update(){

    }

    public List<GameObject> getGameObjects(){
        return gameObjects;
    }

    public Frog getFrog() {
        return frog;
    }
}
