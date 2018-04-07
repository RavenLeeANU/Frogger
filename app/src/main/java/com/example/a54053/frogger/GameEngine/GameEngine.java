package com.example.a54053.frogger.GameEngine;

import android.graphics.Canvas;
import android.util.Log;

import com.example.a54053.frogger.Enums.Directions;
import com.example.a54053.frogger.Enums.GameState;
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
    private int score = 0;
    private int life;
    private boolean frogDead = false;
    private GameState gameState;
    private boolean inWater = false;

    public void init(){
        frog = new Frog();
        frog.setPos(new Coordinate(5,19));
        life = 3;
        gameState = GameState.Running;

        Ships ships = new Ships();
        Ship []shipsgroup = ships.shipGenerateGroup();
        for(int i =0;i<shipsgroup.length;i++){
            gameObjects.add(shipsgroup[i]);

        }


        Vehicles vehicles = new Vehicles();
        Vehicle []vehiclesgroup = vehicles.vehicleGenerateGroup();

        for(int i =0;i<vehiclesgroup.length;i++){
            gameObjects.add(vehiclesgroup[i]);

        }
    }

    public void update(){
        // update gameobjects
        for (GameObject g:gameObjects) {
            if(g.getDirections()== Directions.EAST)
                g.setPos(new Coordinate(g.getPos().getX()+g.getSpeed(),g.getPos().getY()));
            else if(g.getDirections()==Directions.WEST)
                g.setPos(new Coordinate(g.getPos().getX()-g.getSpeed(),g.getPos().getY()));

            if(g.getPos().getX()>15 || g.getPos().getX()<-5){
                g.resetPos();
            }
        }
        // update frog
        checkFrogLoc();
        onCollision();
        reSetFrog();
    }

    private void checkFrogLoc() {
        if(frog.getPos().getX()>10||frog.getPos().getX()<0||frog.getPos().getY()>20||frog.getPos().getX()<0){
            frogDead = true;
        }else if( frog.getPos().getY()<8&&frog.getPos().getY()>=2){
            Log.d("Loc","in water"+ frog.getPos().getX()+";"+frog.getPos().getY());
            inWater = true;
        }else if(frog.getPos().getY()>0&&frog.getPos().getY()<2){
            Log.d("Loc", "win");
            reSetFrog();
        }



    }

    private void reSetFrog(){


        if(frogDead && life>0){
            frog.setPos(new Coordinate(5,19));
            life--;
            frogDead = false;
        }

        if(life<=0){
            gameState = GameState.Losing;
        }
    }


    private void onCollision() {
        // check frog and vehicles
        Coordinate frogPos = frog.getPos();
        boolean onShip = false;
        for (GameObject g:gameObjects) {
            if( g instanceof Vehicle){
                int len = g.getLength();
                for(int i =0;i<len;i++){
                    if (frogPos.getX() == g.getPos().getX()+i && frogPos.getY()==g.getPos().getY()){
                        Log.d("Collsion","With Vehicle");
                        frogDead = true;
                        // game over
                    }
                }
            }
            else if ( g instanceof Ship){
                int len = g.getLength();
                for(int i =0;i<len;i++){
                    if (frogPos.getX() == g.getPos().getX()+i && frogPos.getY()==g.getPos().getY()){
                        if(g.getDirections()==Directions.EAST) frog.setPos(new Coordinate(frog.getPos().getX()+g.getSpeed(),frog.getPos().getY()));
                        else if(g.getDirections()==Directions.WEST) frog.setPos(new Coordinate(frog.getPos().getX()-g.getSpeed(),frog.getPos().getY()));
                        Log.d("Collsion","With Ship");
                        onShip = true;
                    }
                }
            }


        }

        if (inWater && !onShip){
            inWater = false;
            frogDead =true;

        }
    }

    public List<GameObject> getGameObjects(){
        return gameObjects;
    }

    public Frog getFrog() {
        return frog;
    }

    public GameState getGameState() {
        return gameState;
    }
}
